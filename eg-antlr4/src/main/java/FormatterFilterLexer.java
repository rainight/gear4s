// Generated from FormatterFilter.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormatterFilterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LBRACE=3, RBRACE=4, LP=5, RP=6, DOT=7, COMMA=8, SEMICOLON=9, 
		IN=10, BOOLNOT=11, EQ=12, NE=13, BOOLAND=14, BOOLOR=15, DOTID=16, INTEGER=17, 
		STRING=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"WS", "COMMENT", "LBRACE", "RBRACE", "LP", "RP", "DOT", "COMMA", "SEMICOLON", 
		"IN", "BOOLNOT", "EQ", "NE", "BOOLAND", "BOOLOR", "DOTID", "INTEGER", 
		"STRING"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'['", "']'", "'('", "')'", "'.'", "','", "';'", "'in'", 
		"'!'", "'=='", "'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WS", "COMMENT", "LBRACE", "RBRACE", "LP", "RP", "DOT", "COMMA", 
		"SEMICOLON", "IN", "BOOLNOT", "EQ", "NE", "BOOLAND", "BOOLOR", "DOTID", 
		"INTEGER", "STRING"
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


	public FormatterFilterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FormatterFilter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0094\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\6\2)\n\2\r\2\16\2*\3\2\3\2\3\3\3\3\3\3\3\3\7\3\63"+
		"\n\3\f\3\16\3\66\13\3\3\3\3\3\3\3\3\3\3\3\7\3=\n\3\f\3\16\3@\13\3\3\3"+
		"\3\3\5\3D\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\7\21i\n\21\f\21\16\21l\13\21\3\22\3\22\3"+
		"\22\7\22q\n\22\f\22\16\22t\13\22\5\22v\n\22\3\22\5\22y\n\22\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u0081\n\23\f\23\16\23\u0084\13\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\7\23\u008d\n\23\f\23\16\23\u0090\13\23\3\23"+
		"\5\23\u0093\n\23\6\64>\u0082\u008e\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\n\5\2\13"+
		"\f\17\17\"\"\4\2\f\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\3\2\62;\b"+
		"\2FFHHNNffhhnn\4\2$$^^\2\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3(\3\2\2\2\5C\3\2\2\2\7G"+
		"\3\2\2\2\tI\3\2\2\2\13K\3\2\2\2\rM\3\2\2\2\17O\3\2\2\2\21Q\3\2\2\2\23"+
		"S\3\2\2\2\25U\3\2\2\2\27X\3\2\2\2\31Z\3\2\2\2\33]\3\2\2\2\35`\3\2\2\2"+
		"\37c\3\2\2\2!f\3\2\2\2#u\3\2\2\2%\u0092\3\2\2\2\')\t\2\2\2(\'\3\2\2\2"+
		")*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+,\3\2\2\2,-\b\2\2\2-\4\3\2\2\2./\7\61\2"+
		"\2/\60\7\61\2\2\60\64\3\2\2\2\61\63\13\2\2\2\62\61\3\2\2\2\63\66\3\2\2"+
		"\2\64\65\3\2\2\2\64\62\3\2\2\2\65\67\3\2\2\2\66\64\3\2\2\2\67D\t\3\2\2"+
		"89\7\61\2\29:\7,\2\2:>\3\2\2\2;=\13\2\2\2<;\3\2\2\2=@\3\2\2\2>?\3\2\2"+
		"\2><\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\7,\2\2BD\7\61\2\2C.\3\2\2\2C8\3\2\2"+
		"\2DE\3\2\2\2EF\b\3\2\2F\6\3\2\2\2GH\7]\2\2H\b\3\2\2\2IJ\7_\2\2J\n\3\2"+
		"\2\2KL\7*\2\2L\f\3\2\2\2MN\7+\2\2N\16\3\2\2\2OP\7\60\2\2P\20\3\2\2\2Q"+
		"R\7.\2\2R\22\3\2\2\2ST\7=\2\2T\24\3\2\2\2UV\7k\2\2VW\7p\2\2W\26\3\2\2"+
		"\2XY\7#\2\2Y\30\3\2\2\2Z[\7?\2\2[\\\7?\2\2\\\32\3\2\2\2]^\7#\2\2^_\7?"+
		"\2\2_\34\3\2\2\2`a\7(\2\2ab\7(\2\2b\36\3\2\2\2cd\7~\2\2de\7~\2\2e \3\2"+
		"\2\2fj\t\4\2\2gi\t\5\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\"\3"+
		"\2\2\2lj\3\2\2\2mv\7\62\2\2nr\t\6\2\2oq\t\7\2\2po\3\2\2\2qt\3\2\2\2rp"+
		"\3\2\2\2rs\3\2\2\2sv\3\2\2\2tr\3\2\2\2um\3\2\2\2un\3\2\2\2vx\3\2\2\2w"+
		"y\t\b\2\2xw\3\2\2\2xy\3\2\2\2y$\3\2\2\2z\u0082\7$\2\2{|\7^\2\2|\u0081"+
		"\7$\2\2}~\7^\2\2~\u0081\7^\2\2\177\u0081\n\t\2\2\u0080{\3\2\2\2\u0080"+
		"}\3\2\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0083\3\2\2\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0093\7$"+
		"\2\2\u0086\u008e\7)\2\2\u0087\u0088\7^\2\2\u0088\u008d\7)\2\2\u0089\u008a"+
		"\7^\2\2\u008a\u008d\7^\2\2\u008b\u008d\n\t\2\2\u008c\u0087\3\2\2\2\u008c"+
		"\u0089\3\2\2\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091"+
		"\u0093\7)\2\2\u0092z\3\2\2\2\u0092\u0086\3\2\2\2\u0093&\3\2\2\2\20\2*"+
		"\64>Cjrux\u0080\u0082\u008c\u008e\u0092\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}