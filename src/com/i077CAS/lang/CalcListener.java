// Generated from C:/Users/imran/Google Drive/CAS/src/com/i077CAS/lang\Calc.g4 by ANTLR 4.5.3
package com.i077CAS.lang;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(CalcParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(CalcParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#equation}.
	 * @param ctx the parse tree
	 */
	void enterEquation(CalcParser.EquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#equation}.
	 * @param ctx the parse tree
	 */
	void exitEquation(CalcParser.EquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#assignEquation}.
	 * @param ctx the parse tree
	 */
	void enterAssignEquation(CalcParser.AssignEquationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#assignEquation}.
	 * @param ctx the parse tree
	 */
	void exitAssignEquation(CalcParser.AssignEquationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalcParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalcParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#multExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultExpression(CalcParser.MultExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#multExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultExpression(CalcParser.MultExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(CalcParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#powExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(CalcParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(CalcParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(CalcParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#scientific}.
	 * @param ctx the parse tree
	 */
	void enterScientific(CalcParser.ScientificContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#scientific}.
	 * @param ctx the parse tree
	 */
	void exitScientific(CalcParser.ScientificContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(CalcParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(CalcParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#eqfunc}.
	 * @param ctx the parse tree
	 */
	void enterEqfunc(CalcParser.EqfuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#eqfunc}.
	 * @param ctx the parse tree
	 */
	void exitEqfunc(CalcParser.EqfuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNum(CalcParser.NumContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNum(CalcParser.NumContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(CalcParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(CalcParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(CalcParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(CalcParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(CalcParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(CalcParser.RelopContext ctx);
}