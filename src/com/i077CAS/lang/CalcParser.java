// Generated from C:/dev/CAS/src/com/i077CAS/lang\Calc.g4 by ANTLR 4.5.3
package com.i077CAS.lang;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LPAREN=2, RPAREN=3, PLUS=4, MINUS=5, MULT=6, DIV=7, POW=8, EQ=9, 
		GT=10, LT=11, GTE=12, LTE=13, POINT=14, E=15, COMMA=16, LETTER=17, DIGIT=18, 
		WS=19;
	public static final int
		RULE_input = 0, RULE_equation = 1, RULE_assignEquation = 2, RULE_expression = 3, 
		RULE_multExpression = 4, RULE_powExpression = 5, RULE_unit = 6, RULE_scientific = 7, 
		RULE_func = 8, RULE_num = 9, RULE_var = 10, RULE_id = 11;
	public static final String[] ruleNames = {
		"input", "equation", "assignEquation", "expression", "multExpression", 
		"powExpression", "unit", "scientific", "func", "num", "var", "id"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'let'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", "'='", 
		"'>'", "'<'", "'>='", "'<='", "'.'", null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "LPAREN", "RPAREN", "PLUS", "MINUS", "MULT", "DIV", "POW", 
		"EQ", "GT", "LT", "GTE", "LTE", "POINT", "E", "COMMA", "LETTER", "DIGIT", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class InputContext extends ParserRuleContext {
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
	 
		public InputContext() { }
		public void copyFrom(InputContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EquInputContext extends InputContext {
		public EquationContext equation() {
			return getRuleContext(EquationContext.class,0);
		}
		public EquInputContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitEquInput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignEquInputContext extends InputContext {
		public AssignEquationContext assignEquation() {
			return getRuleContext(AssignEquationContext.class,0);
		}
		public AssignEquInputContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitAssignEquInput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprInputContext extends InputContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprInputContext(InputContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitExprInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_input);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ExprInputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				expression();
				}
				break;
			case 2:
				_localctx = new EquInputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				equation();
				}
				break;
			case 3:
				_localctx = new AssignEquInputContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				assignEquation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EquationContext extends ParserRuleContext {
		public Token relop;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(CalcParser.EQ, 0); }
		public TerminalNode LT() { return getToken(CalcParser.LT, 0); }
		public TerminalNode GT() { return getToken(CalcParser.GT, 0); }
		public TerminalNode GTE() { return getToken(CalcParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(CalcParser.LTE, 0); }
		public EquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EquationContext equation() throws RecognitionException {
		EquationContext _localctx = new EquationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_equation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			expression();
			setState(30);
			((EquationContext)_localctx).relop = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << GT) | (1L << LT) | (1L << GTE) | (1L << LTE))) != 0)) ) {
				((EquationContext)_localctx).relop = (Token)_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(31);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignEquationContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode EQ() { return getToken(CalcParser.EQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignEquationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignEquation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitAssignEquation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignEquationContext assignEquation() throws RecognitionException {
		AssignEquationContext _localctx = new AssignEquationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignEquation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(T__0);
			setState(34);
			var();
			setState(35);
			match(EQ);
			setState(36);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Token op;
		public List<MultExpressionContext> multExpression() {
			return getRuleContexts(MultExpressionContext.class);
		}
		public MultExpressionContext multExpression(int i) {
			return getRuleContext(MultExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(CalcParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(CalcParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(CalcParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(CalcParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			multExpression();
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(39);
				((ExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(40);
				multExpression();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExpressionContext extends ParserRuleContext {
		public Token op;
		public List<PowExpressionContext> powExpression() {
			return getRuleContexts(PowExpressionContext.class);
		}
		public PowExpressionContext powExpression(int i) {
			return getRuleContext(PowExpressionContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(CalcParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(CalcParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(CalcParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CalcParser.DIV, i);
		}
		public MultExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitMultExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultExpressionContext multExpression() throws RecognitionException {
		MultExpressionContext _localctx = new MultExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_multExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			powExpression();
			setState(51);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					((MultExpressionContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==MULT || _la==DIV) ) {
						((MultExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(48);
					powExpression();
					}
					} 
				}
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowExpressionContext extends ParserRuleContext {
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TerminalNode POW() { return getToken(CalcParser.POW, 0); }
		public MultExpressionContext multExpression() {
			return getRuleContext(MultExpressionContext.class,0);
		}
		public PowExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitPowExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowExpressionContext powExpression() throws RecognitionException {
		PowExpressionContext _localctx = new PowExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_powExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			unit();
			setState(57);
			_la = _input.LA(1);
			if (_la==POW) {
				{
				setState(55);
				match(POW);
				setState(56);
				multExpression();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	 
		public UnitContext() { }
		public void copyFrom(UnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunctionContext extends UnitContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public FunctionContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends UnitContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VariableContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SciNotationContext extends UnitContext {
		public ScientificContext scientific() {
			return getRuleContext(ScientificContext.class,0);
		}
		public SciNotationContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitSciNotation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpressionContext extends UnitContext {
		public TerminalNode LPAREN() { return getToken(CalcParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(CalcParser.RPAREN, 0); }
		public ParenExpressionContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unit);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new SciNotationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				scientific();
				}
				break;
			case 2:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				var();
				}
				break;
			case 3:
				_localctx = new ParenExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				match(LPAREN);
				setState(62);
				expression();
				setState(63);
				match(RPAREN);
				}
				break;
			case 4:
				_localctx = new FunctionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				func();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScientificContext extends ParserRuleContext {
		public List<NumContext> num() {
			return getRuleContexts(NumContext.class);
		}
		public NumContext num(int i) {
			return getRuleContext(NumContext.class,i);
		}
		public TerminalNode E() { return getToken(CalcParser.E, 0); }
		public ScientificContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scientific; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitScientific(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScientificContext scientific() throws RecognitionException {
		ScientificContext _localctx = new ScientificContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scientific);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			num();
			setState(71);
			_la = _input.LA(1);
			if (_la==E) {
				{
				setState(69);
				match(E);
				setState(70);
				num();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(CalcParser.LPAREN, 0); }
		public List<InputContext> input() {
			return getRuleContexts(InputContext.class);
		}
		public InputContext input(int i) {
			return getRuleContext(InputContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(CalcParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(CalcParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CalcParser.COMMA, i);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			id();
			setState(74);
			match(LPAREN);
			setState(75);
			input();
			setState(82);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(76);
					match(COMMA);
					setState(77);
					input();
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==COMMA );
				}
			}

			setState(84);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(CalcParser.MINUS, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(CalcParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(CalcParser.DIGIT, i);
		}
		public TerminalNode POINT() { return getToken(CalcParser.POINT, 0); }
		public NumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_num; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitNum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumContext num() throws RecognitionException {
		NumContext _localctx = new NumContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_num);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(86);
				match(MINUS);
				}
			}

			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				match(DIGIT);
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(100);
			_la = _input.LA(1);
			if (_la==POINT) {
				{
				setState(94);
				match(POINT);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					match(DIGIT);
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(CalcParser.MINUS, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(102);
				match(MINUS);
				}
			}

			setState(105);
			id();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(CalcParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(CalcParser.LETTER, i);
		}
		public List<TerminalNode> E() { return getTokens(CalcParser.E); }
		public TerminalNode E(int i) {
			return getToken(CalcParser.E, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(CalcParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(CalcParser.DIGIT, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CalcVisitor ) return ((CalcVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(113);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << LETTER) | (1L << DIGIT))) != 0)) {
				{
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(108);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << LETTER) | (1L << DIGIT))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					}
					setState(111); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << LETTER) | (1L << DIGIT))) != 0) );
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25v\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\3\2\3\2\3\2\5\2\36\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\3\6\3\6\3\6\7\6\64\n\6\f\6\16"+
		"\6\67\13\6\3\7\3\7\3\7\5\7<\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bE\n\b\3"+
		"\t\3\t\3\t\5\tJ\n\t\3\n\3\n\3\n\3\n\3\n\6\nQ\n\n\r\n\16\nR\5\nU\n\n\3"+
		"\n\3\n\3\13\5\13Z\n\13\3\13\6\13]\n\13\r\13\16\13^\3\13\3\13\6\13c\n\13"+
		"\r\13\16\13d\5\13g\n\13\3\f\5\fj\n\f\3\f\3\f\3\r\3\r\6\rp\n\r\r\r\16\r"+
		"q\5\rt\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\7\3\2\13\17\3\2"+
		"\6\7\3\2\b\t\4\2\21\21\23\23\4\2\21\21\23\24{\2\35\3\2\2\2\4\37\3\2\2"+
		"\2\6#\3\2\2\2\b(\3\2\2\2\n\60\3\2\2\2\f8\3\2\2\2\16D\3\2\2\2\20F\3\2\2"+
		"\2\22K\3\2\2\2\24Y\3\2\2\2\26i\3\2\2\2\30m\3\2\2\2\32\36\5\b\5\2\33\36"+
		"\5\4\3\2\34\36\5\6\4\2\35\32\3\2\2\2\35\33\3\2\2\2\35\34\3\2\2\2\36\3"+
		"\3\2\2\2\37 \5\b\5\2 !\t\2\2\2!\"\5\b\5\2\"\5\3\2\2\2#$\7\3\2\2$%\5\26"+
		"\f\2%&\7\13\2\2&\'\5\b\5\2\'\7\3\2\2\2(-\5\n\6\2)*\t\3\2\2*,\5\n\6\2+"+
		")\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\t\3\2\2\2/-\3\2\2\2\60\65\5\f"+
		"\7\2\61\62\t\4\2\2\62\64\5\f\7\2\63\61\3\2\2\2\64\67\3\2\2\2\65\63\3\2"+
		"\2\2\65\66\3\2\2\2\66\13\3\2\2\2\67\65\3\2\2\28;\5\16\b\29:\7\n\2\2:<"+
		"\5\n\6\2;9\3\2\2\2;<\3\2\2\2<\r\3\2\2\2=E\5\20\t\2>E\5\26\f\2?@\7\4\2"+
		"\2@A\5\b\5\2AB\7\5\2\2BE\3\2\2\2CE\5\22\n\2D=\3\2\2\2D>\3\2\2\2D?\3\2"+
		"\2\2DC\3\2\2\2E\17\3\2\2\2FI\5\24\13\2GH\7\21\2\2HJ\5\24\13\2IG\3\2\2"+
		"\2IJ\3\2\2\2J\21\3\2\2\2KL\5\30\r\2LM\7\4\2\2MT\5\2\2\2NO\7\22\2\2OQ\5"+
		"\2\2\2PN\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2SU\3\2\2\2TP\3\2\2\2TU\3"+
		"\2\2\2UV\3\2\2\2VW\7\5\2\2W\23\3\2\2\2XZ\7\7\2\2YX\3\2\2\2YZ\3\2\2\2Z"+
		"\\\3\2\2\2[]\7\24\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_f\3\2"+
		"\2\2`b\7\20\2\2ac\7\24\2\2ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3"+
		"\2\2\2f`\3\2\2\2fg\3\2\2\2g\25\3\2\2\2hj\7\7\2\2ih\3\2\2\2ij\3\2\2\2j"+
		"k\3\2\2\2kl\5\30\r\2l\27\3\2\2\2ms\t\5\2\2np\t\6\2\2on\3\2\2\2pq\3\2\2"+
		"\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2so\3\2\2\2st\3\2\2\2t\31\3\2\2\2\21\35"+
		"-\65;DIRTY^dfiqs";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}