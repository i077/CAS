package com.i077CAS.lang;

import org.antlr.v4.runtime.tree.ParseTree;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * Implementation of a visitor that evaluates a given input.
 */
public class CASCalcVisitor extends CalcBaseVisitor<Number> {
    HashMap<String, Number> memStack = new HashMap<>();

    /**
     * Visit an input context and return its value.
     *
     * @param ctx   The context to visit
     * @return  The value that the context evaluates to
     */
    public Number visitInput(CalcParser.InputContext ctx) {
        switch (ctx.getRuleIndex()) {
            case 1:     // expression
                return visitExpression(ctx.expression());
        }
        return 0;
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
    public Number visitUnit(CalcParser.UnitContext ctx) {
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
        return 0;
    }

    /**
     * Visit a scientific number context and return its value.
     *
     * Scientific numbers are written as (num)(E)(num).
     *
     * @param ctx   The context to visit
     * @return  The value of the scientific number that the context represents
     */
    public Number visitScientific(CalcParser.ScientificContext ctx) {
        return new BigDecimal(ctx.getText());
    }

    /**
     * Visit a variable context and return its value if it exists in memory.
     * If not, return 0 instead.
     *
     * @param ctx   The context to visit
     * @return  The value of the variable the context represents if it exists in memStack, 0 if it doesn't.
     */
    public Number visitVar(CalcParser.VarContext ctx) {
        String id = ctx.id().getText();
        if (memStack.containsKey(id)) return memStack.get(id);
        return 0;
    }
}
