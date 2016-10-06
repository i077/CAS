package com.i077CAS.lang;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.List;

/**
 * Implementation of a visitor that evaluates a given input.
 */
public class CASCalcVisitor extends CalcBaseVisitor<BigDecimal> {
    private HashMap<String, BigDecimal> memStack;
    private HashMap<String, Method> funcLookupTable;
    private List<BigDecimal> resultStack;

    /**
     * Construct a new parse tree visitor with passed in memory and result stacks.
     *
     * @param currStack     The stack that stores variables and their values.
     * @param resultStack   The stack of results that the user inputs evaluate to.
     */
    public CASCalcVisitor(HashMap<String, BigDecimal> currStack, List<BigDecimal> resultStack, HashMap<String, Method> funcLookupTable) {
        this.memStack = currStack;
        this.resultStack = resultStack;
        this.funcLookupTable = funcLookupTable;
    }

    /**
     * Visit an expression input context and return its value.
     *
     * @param ctx   The context to visit
     * @return  The value that the expression represented by the context evaluates to
     */
    @Override
    public BigDecimal visitExprInput(CalcParser.ExprInputContext ctx) {
        return visitExpression(ctx.expression());
    }

    /**
     * Visit an equation input context and return its truth value.
     *     * @param ctx   The context to visit
     * @return  1 if the equation evaluates to true, 0 if false.
     */
    @Override
    public BigDecimal visitEquInput(CalcParser.EquInputContext ctx) {
        return visitEquation(ctx.equation());
    }

    @Override
    public BigDecimal visitAssignEquInput(CalcParser.AssignEquInputContext ctx) {
        return visitAssignEquation(ctx.assignEquation());
    }

    /**
     * Visit an assignment equation context and return the value being assigned.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression being assigned to the variable
     */
    public BigDecimal visitAssignEquation(CalcParser.AssignEquationContext ctx) {
        String id = ctx.var().getText();
        BigDecimal val = visit(ctx.expression());
        memStack.put(id, val);

        return val;
    }

    /**
     * Visit a function call context and return the resulting value.
     *
     * @param ctx   The context to visit
     * @return  The return value of the function
     */
    @Override
    public BigDecimal visitFunc(CalcParser.FuncContext ctx) {
        String id = ctx.id().getText();
        BigDecimal res = new BigDecimal(0);
        BigDecimal arg = visit(ctx.input(0));
        if (funcLookupTable.containsKey(id)) {
            try {
                // invoke method using reflection
                Object obj = funcLookupTable.get(id).invoke(null, arg);
                res = (BigDecimal) obj;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * Visit an equation context and return the truth value of the equation.
     *
     * @param ctx   The context to visit
     * @return  The truth value of the equation, which depends on the relative operator used
     */
    @Override
    public BigDecimal visitEquation(CalcParser.EquationContext ctx) {
        BigDecimal lValue = visit(ctx.expression(0));
        BigDecimal rValue = visit(ctx.expression(1));

        boolean truthValue = false;
        switch (ctx.relop.getType()) {
            case CalcParser.EQ:
                truthValue = lValue.equals(rValue);
                break;
            case CalcParser.GT:
            case CalcParser.LT:
                truthValue = lValue.compareTo(rValue) == (ctx.relop.getType() == CalcParser.GT ? 1 : -1);
                break;
            case CalcParser.GTE:
            case CalcParser.LTE:
                truthValue = (lValue.compareTo(rValue) == (ctx.relop.getType() == CalcParser.GTE ? 1 : -1))
                        || lValue.equals(rValue);
                break;
        }

        return truthValue ? new BigDecimal(1) : new BigDecimal(0);
    }

    /**
     * Visit an expression context and evaluate it.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression represented by the context
     */
    @Override
    public BigDecimal visitExpression(CalcParser.ExpressionContext ctx) {
        BigDecimal lValue = visit(ctx.multExpression(0));
        if (ctx.op == null) return lValue;

        // If this line is reached, an operation is being performed here.
        BigDecimal rValue = visit(ctx.multExpression(1));
        return (ctx.op.getType() == CalcParser.PLUS ?
                lValue.add(rValue) :
                lValue.subtract(rValue));
    }

    /**
     * Visit a multiplicative expression context and evaluate it.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression represented by the context
     */
    @Override
    public BigDecimal visitMultExpression(CalcParser.MultExpressionContext ctx) {
        BigDecimal lValue = visit(ctx.powExpression(0));
        if (ctx.op == null) return lValue;

        // If this line is reached, an operation is being performed here.
        BigDecimal rValue = visit(ctx.powExpression(1));
        return (ctx.op.getType() == CalcParser.MULT ?
                lValue.multiply(rValue) :
                lValue.divide(rValue, MathContext.DECIMAL64));
    }

    /**
     * Visit an exponential expression context and evaluate it.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression represented by the context
     */
    @Override
    public BigDecimal visitPowExpression(CalcParser.PowExpressionContext ctx) {
        BigDecimal base = visit(ctx.unit());
        BigDecimal exp  = (ctx.multExpression() != null ? visit(ctx.multExpression()) : new BigDecimal(1));

        return base.pow(exp.intValue());
    }

    /**
     * Visit the scientific notation alternative defined in the unit grammar rule.
     * Passes control to visitScientific().
     *
     * @param ctx   The context to visit
     * @return  The value of the number the context represents
     */
    @Override
    public BigDecimal visitSciNotation(CalcParser.SciNotationContext ctx) {
        return visit(ctx.scientific());
    }

    /**
     * Visit the variable alternative defined in the unit grammar rule.
     * Passes control to visitVar().
     *
     * @param ctx   The context to visit
     * @return  The value of the variable the context represents if it exists, otherwise <code>0</code>
     */
    @Override
    public BigDecimal visitVariable(CalcParser.VariableContext ctx) {
        return visit(ctx.var());
    }

    /**
     * Visit the parenthetical expression alternative defined in the unit grammar rule.
     * Passes control to visitExpression().
     *
     * @param ctx   The context to visit
     * @return  The value of the expression the context represents
     */
    @Override
    public BigDecimal visitParenExpression(CalcParser.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    /**
     * Visit the function call alternative defined in the unit grammar rule.
     * Passes control to visitFunction().
     *
     * @param ctx   The context to visit
     * @return  The value of the number the context represents
     */
    @Override
    public BigDecimal visitFunction(CalcParser.FunctionContext ctx) {
        return visit(ctx.func());
    }

    /**
     * Visit a scientific number context and return its value.
     *
     * Scientific numbers are written as:   <code>num ('e'|'E' num)</code>
     *
     * @param ctx   The context to visit
     * @return  The value of the scientific number that the context represents
     */
    @Override
    public BigDecimal visitScientific(CalcParser.ScientificContext ctx) {
        return new BigDecimal(ctx.getText(), MathContext.UNLIMITED);
    }

    /**
     * Visit a variable context and return its value if it exists in memory.
     * If not, return 0 instead.
     *
     * @param ctx   The context to visit
     * @return  The value of the variable the context represents if it exists in memStack, <code>0</code> if it doesn't.
     */
    @Override
    public BigDecimal visitVar(CalcParser.VarContext ctx) {
        String id = ctx.id().getText();
        if (memStack.containsKey(id)) return memStack.get(id);
        return new BigDecimal(0);
    }

    /**
     * Visit a last result context and return the last result in the result stack.
     * @param ctx   The context to visit
     * @return  The last result if it exists, otherwise {@code 0}.
     */
    @Override
    public BigDecimal visitLastResult(CalcParser.LastResultContext ctx) {
        return resultStack.size() > 0 ? resultStack.get(resultStack.size() - 1) : new BigDecimal(0);
    }
}
