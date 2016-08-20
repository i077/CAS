package com.i077CAS.lang;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.util.HashMap;

/**
 * Implementation of a visitor that evaluates a given input.
 */
public class CASCalcVisitor extends CalcBaseVisitor<Apfloat> {
    private HashMap<String, Apfloat> memStack;

    public CASCalcVisitor(HashMap<String, Apfloat> currStack) {
        memStack = currStack;
    }

    /**
     * Visit an expression input context and return its value.
     *
     * @param ctx   The context to visit
     * @return  The value that the expression represented by the context evaluates to
     */
    @Override
    public Apfloat visitExprInput(CalcParser.ExprInputContext ctx) {
        return visitExpression(ctx.expression());
    }

    @Override
    public Apfloat visitEquInput(CalcParser.EquInputContext ctx) {
        return visitEquation(ctx.equation());
    }

    @Override
    public Apfloat visitAssignEquInput(CalcParser.AssignEquInputContext ctx) {
        return visitAssignEquation(ctx.assignEquation());
    }

    /**
     * Visit an assignment equation context and return the value being assigned.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression being assigned to the variable
     */
    public Apfloat visitAssignEquation(CalcParser.AssignEquationContext ctx) {
        String id = ctx.var().getText();
        Apfloat val = visit(ctx.expression());
        memStack.put(id, val);

        return val;
    }

    @Override
    public Apfloat visitEquation(CalcParser.EquationContext ctx) {
        Apfloat lValue = visit(ctx.expression(0));
        Apfloat rValue = visit(ctx.expression(1));

        boolean ret = false;
        switch (ctx.relop.getType()) {
            case CalcParser.EQ:
                ret = lValue.equals(rValue);
                break;
            case CalcParser.GT:
            case CalcParser.LT:
                ret = lValue.compareTo(rValue) == (ctx.relop.getType() == CalcParser.GT ? 1 : -1);
                break;
            case CalcParser.GTE:
            case CalcParser.LTE:
                ret = (lValue.compareTo(rValue) == (ctx.relop.getType() == CalcParser.GTE ? 1 : -1))
                        || lValue.equals(rValue);
                break;
        }

        return ret ? new Apfloat(1) : new Apfloat(0);
    }

    /**
     * Visit an expression context and evaluate it.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression represented by the context
     */
    @Override
    public Apfloat visitExpression(CalcParser.ExpressionContext ctx) {
        Apfloat lValue = visit(ctx.multExpression(0));
        if (ctx.op == null) return lValue;

        // If this line is reached, an operation is being performed here.
        Apfloat rValue = visit(ctx.multExpression(1));
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
    public Apfloat visitMultExpression(CalcParser.MultExpressionContext ctx) {
        Apfloat lValue = visit(ctx.powExpression(0));
        if (ctx.op == null) return lValue;

        // If this line is reached, an operation is being performed here.
        Apfloat rValue = visit(ctx.powExpression(1));
        return (ctx.op.getType() == CalcParser.MULT ?
                lValue.multiply(rValue) :
                lValue.divide(rValue));
    }

    /**
     * Visit an exponential expression context and evaluate it.
     *
     * @param ctx   The context to visit
     * @return  The value of the expression represented by the context
     */
    @Override
    public Apfloat visitPowExpression(CalcParser.PowExpressionContext ctx) {
        Apfloat base = visit(ctx.unit());
        Apfloat exp  = (ctx.multExpression() != null ? visit(ctx.multExpression()) : new Apfloat(1));

        return ApfloatMath.pow(base, exp);
    }

    /**
     * Visit the scientific notation alternative defined in the unit grammar rule.
     * Passes control to visitScientific().
     *
     * @param ctx   The context to visit
     * @return  The value of the number the context represents
     */
    @Override
    public Apfloat visitSciNotation(CalcParser.SciNotationContext ctx) {
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
    public Apfloat visitVariable(CalcParser.VariableContext ctx) {
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
    public Apfloat visitParenExpression(CalcParser.ParenExpressionContext ctx) {
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
    public Apfloat visitFunction(CalcParser.FunctionContext ctx) {
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
    public Apfloat visitScientific(CalcParser.ScientificContext ctx) {
        return new Apfloat(ctx.getText(), 32);
    }

    /**
     * Visit a variable context and return its value if it exists in memory.
     * If not, return 0 instead.
     *
     * @param ctx   The context to visit
     * @return  The value of the variable the context represents if it exists in memStack, <code>0</code> if it doesn't.
     */
    @Override
    public Apfloat visitVar(CalcParser.VarContext ctx) {
        String id = ctx.id().getText();
        if (memStack.containsKey(id)) return memStack.get(id);
        return new Apfloat(0);
    }
}
