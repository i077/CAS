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
     * Visit an input context and return its value.
     *
     * @param ctx   The context to visit
     * @return  The value that the context evaluates to
     */
    public Apfloat visitInput(CalcParser.InputContext ctx) {
        return visit(ctx.expression());
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
        Apfloat rValue = (ctx.multExpression(1) != null ? visit(ctx.multExpression(1)) : new Apfloat(0));

        if (ctx.op == null) return lValue;

        return (ctx.op.getType() == CalcParser.PLUS ?
                lValue.add(rValue) :
                lValue.subtract(rValue));
    }

    /**
     * Visit a multiplicative expression context and evaluate it
     *
     * @param ctx   The context to visit
     * @return  The value of the expression represented by the context
     */
    @Override
    public Apfloat visitMultExpression(CalcParser.MultExpressionContext ctx) {
        Apfloat lValue = visit(ctx.powExpression(0));
        Apfloat rValue = (ctx.powExpression(1) != null ? visit(ctx.powExpression(1)) : new Apfloat(1));

        if (ctx.op == null) return lValue;

        return (ctx.op.getType() == CalcParser.MULT ?
                lValue.multiply(rValue) :
                lValue.divide(rValue));
    }

    @Override
    public Apfloat visitPowExpression(CalcParser.PowExpressionContext ctx) {
        Apfloat base = visit(ctx.unit());
        Apfloat exp  = (ctx.multExpression() != null ? visit(ctx.multExpression()) : new Apfloat(1));

        return ApfloatMath.pow(base, exp);
    }

    //    /**
//     * Visit a unit context and return its value.
//     *
//     * Units can be either: a number (written in scientific notation if needed),
//     *                      a variable (if undefined, evaluates to 0),
//     *                      an expression wrapped in parentheses, or
//     *                      a function call.
//     *
//     * @param ctx   The context to visit
//     * @return  The value of the unit that the context represents or evaluates to
//     */
//    public Apfloat visitUnit(CalcParser.UnitContext ctx) {
//        switch (ctx.getAltNumber()) {
//            case 1:     // Number in scientific notation
//                return visitScientific();
//            case 2:     // Variable
//                return visitVar(ctx.var());
//            case 3:     // Expression in parentheses
//                return visitExpression(ctx.expression());
//            case 4:     // Function call
//                return visitFunc(ctx.func());
//            case 5:     // Equation function call
//                return visitEqfunc(ctx.eqfunc());
//        }
//        return new Apfloat(0);
//    }

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
