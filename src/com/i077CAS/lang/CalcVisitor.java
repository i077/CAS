// Generated from C:/Users/imran/Google Drive/CAS/src/com/i077CAS/lang\Calc.g4 by ANTLR 4.5.3
package com.i077CAS.lang;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalcParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(CalcParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#equation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquation(CalcParser.EquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#assignEquation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignEquation(CalcParser.AssignEquationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(CalcParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#multExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultExpression(CalcParser.MultExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#powExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpression(CalcParser.PowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(CalcParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#scientific}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScientific(CalcParser.ScientificContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(CalcParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#eqfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqfunc(CalcParser.EqfuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#num}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum(CalcParser.NumContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(CalcParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(CalcParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalcParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(CalcParser.RelopContext ctx);
}