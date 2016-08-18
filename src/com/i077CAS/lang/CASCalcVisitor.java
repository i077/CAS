package com.i077CAS.lang;

import org.apfloat.Apfloat;
import org.apfloat.Apfloat;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Implementation of a visitor that evaluates a given input.
 */
public class CASCalcVisitor extends CalcBaseVisitor<Apfloat> {
    private HashMap<String, Apfloat> memStack = new HashMap<>();

    /**
     * Visit an input context and return its value.
     *
     * @param ctx   The context to visit
     * @return  The value that the context evaluates to
     */
    public Apfloat visitInput(CalcParser.InputContext ctx) {
        switch (ctx.getRuleIndex()) {
            case 1:     // expression
                return visitExpression(ctx.expression());
        }
        return new Apfloat(0);
    }

    /**
     * Visit a unit context and return its value.
     *
     * Units can be either: a number (written in scientific notation if needed),
     *                      a variable (if undefined, evaluates to 0),
     *                      an expression wrapped in parentheses, or
     *                      a function call.
     *
     * @param ctx   The context to visit
     * @return  The value of the unit that the context represents or evaluates to
     */
    public Apfloat visitUnit(CalcParser.UnitContext ctx) {
        switch (ctx.getRuleIndex()) {
            case 1:     // Number in scientific notation
                return visitScientific(ctx.scientific());
            case 2:     // Variable
                return visitVar(ctx.var());
            case 3:     // Expression in parentheses
                return visitExpression(ctx.expression());
            case 4:     // Function call
                return visitFunc(ctx.func());
            case 5:     // Equation function call
                return visitEqfunc(ctx.eqfunc());
        }
        return new Apfloat(0);
    }

    /**
     * Visit a scientific number context and return its value.
     *
     * Scientific numbers are written as:   <code>num ('e'|'E' num)</code>
     *
     * @param ctx   The context to visit
     * @return  The value of the scientific number that the context represents
     */
    public Apfloat visitScientific(CalcParser.ScientificContext ctx) {
        return new Apfloat(ctx.getText());
    }

    /**
     * Visit a variable context and return its value if it exists in memory.
     * If not, return 0 instead.
     *
     * @param ctx   The context to visit
     * @return  The value of the variable the context represents if it exists in memStack, 0 if it doesn't.
     */
    public Apfloat visitVar(CalcParser.VarContext ctx) {
        String id = ctx.id().getText();
        if (memStack.containsKey(id)) return memStack.get(id);
        return new Apfloat(0);
    }
}
