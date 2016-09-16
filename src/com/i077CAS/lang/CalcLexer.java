// Generated from C:/dev/CAS/src/com/i077CAS/lang\Calc.g4 by ANTLR 4.5.3
package com.i077CAS.lang;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CalcLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, ANS=2, LPAREN=3, RPAREN=4, PLUS=5, MINUS=6, MULT=7, DIV=8, POW=9, 
		EQ=10, GT=11, LT=12, GTE=13, LTE=14, POINT=15, E=16, COMMA=17, LETTER=18, 
		DIGIT=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "ANS", "LPAREN", "RPAREN", "PLUS", "MINUS", "MULT", "DIV", "POW", 
		"EQ", "GT", "LT", "GTE", "LTE", "POINT", "E", "COMMA", "LETTER", "DIGIT", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'let'", "'ans'", "'('", "')'", "'+'", "'-'", "'*'", "'/'", "'^'", 
		"'='", "'>'", "'<'", "'>='", "'<='", "'.'", null, "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "ANS", "LPAREN", "RPAREN", "PLUS", "MINUS", "MULT", "DIV", 
		"POW", "EQ", "GT", "LT", "GTE", "LTE", "POINT", "E", "COMMA", "LETTER", 
		"DIGIT", "WS"
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


	public CalcLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Calc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26_\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\5\23U\n\23\3\24\3\24\3\25\6\25Z\n\25\r\25\16\25[\3\25\3\25\2\2\26\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26\3\2\5\4\2GGgg\4\2C\\c|\5\2\13\f\17\17\"\"_\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5/\3\2\2\2\7\63\3\2\2\2\t"+
		"\65\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2\21=\3\2\2\2\23?\3\2\2"+
		"\2\25A\3\2\2\2\27C\3\2\2\2\31E\3\2\2\2\33G\3\2\2\2\35J\3\2\2\2\37M\3\2"+
		"\2\2!O\3\2\2\2#Q\3\2\2\2%T\3\2\2\2\'V\3\2\2\2)Y\3\2\2\2+,\7n\2\2,-\7g"+
		"\2\2-.\7v\2\2.\4\3\2\2\2/\60\7c\2\2\60\61\7p\2\2\61\62\7u\2\2\62\6\3\2"+
		"\2\2\63\64\7*\2\2\64\b\3\2\2\2\65\66\7+\2\2\66\n\3\2\2\2\678\7-\2\28\f"+
		"\3\2\2\29:\7/\2\2:\16\3\2\2\2;<\7,\2\2<\20\3\2\2\2=>\7\61\2\2>\22\3\2"+
		"\2\2?@\7`\2\2@\24\3\2\2\2AB\7?\2\2B\26\3\2\2\2CD\7@\2\2D\30\3\2\2\2EF"+
		"\7>\2\2F\32\3\2\2\2GH\7@\2\2HI\7?\2\2I\34\3\2\2\2JK\7>\2\2KL\7?\2\2L\36"+
		"\3\2\2\2MN\7\60\2\2N \3\2\2\2OP\t\2\2\2P\"\3\2\2\2QR\7.\2\2R$\3\2\2\2"+
		"SU\t\3\2\2TS\3\2\2\2U&\3\2\2\2VW\4\62;\2W(\3\2\2\2XZ\t\4\2\2YX\3\2\2\2"+
		"Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\b\25\2\2^*\3\2\2\2\5\2T["+
		"\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}