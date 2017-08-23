// Generated from FormatterFilter.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormatterFilterParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LBRACE=3, RBRACE=4, LP=5, RP=6, DOT=7, COMMA=8, SEMICOLON=9, 
		IN=10, BOOLNOT=11, EQ=12, NE=13, BOOLAND=14, BOOLOR=15, DOTID=16, INTEGER=17, 
		STRING=18;
	public static final int
		RULE_prog = 0, RULE_expr = 1, RULE_arraystr = 2, RULE_arrayint = 3, RULE_variable = 4;
	public static final String[] ruleNames = {
		"prog", "expr", "arraystr", "arrayint", "variable"
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

	@Override
	public String getGrammarFileName() { return "FormatterFilter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormatterFilterParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	 
		public ProgContext() { }
		public void copyFrom(ProgContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrintExprContext extends ProgContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrintExprContext(ProgContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			_localctx = new PrintExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				expr(0);
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << LP) | (1L << DOT) | (1L << BOOLNOT) | (1L << INTEGER) | (1L << STRING))) != 0) );
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StrContext extends ExprContext {
		public TerminalNode STRING() { return getToken(FormatterFilterParser.STRING, 0); }
		public StrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrStrContext extends ExprContext {
		public ArraystrContext arraystr() {
			return getRuleContext(ArraystrContext.class,0);
		}
		public ArrStrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitArrStr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotContext extends ExprContext {
		public TerminalNode BOOLNOT() { return getToken(FormatterFilterParser.BOOLNOT, 0); }
		public TerminalNode LP() { return getToken(FormatterFilterParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(FormatterFilterParser.RP, 0); }
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensContext extends ExprContext {
		public TerminalNode LP() { return getToken(FormatterFilterParser.LP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RP() { return getToken(FormatterFilterParser.RP, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CompareContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ() { return getToken(FormatterFilterParser.EQ, 0); }
		public TerminalNode NE() { return getToken(FormatterFilterParser.NE, 0); }
		public CompareContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitCompare(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContainContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IN() { return getToken(FormatterFilterParser.IN, 0); }
		public ContainContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitContain(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BOOLAND() { return getToken(FormatterFilterParser.BOOLAND, 0); }
		public TerminalNode BOOLOR() { return getToken(FormatterFilterParser.BOOLOR, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarContext extends ExprContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExprContext {
		public TerminalNode INTEGER() { return getToken(FormatterFilterParser.INTEGER, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrIntContext extends ExprContext {
		public ArrayintContext arrayint() {
			return getRuleContext(ArrayintContext.class,0);
		}
		public ArrIntContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitArrInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(16);
				match(BOOLNOT);
				setState(17);
				match(LP);
				setState(18);
				expr(0);
				setState(19);
				match(RP);
				}
				break;
			case 2:
				{
				_localctx = new StrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(STRING);
				}
				break;
			case 3:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(INTEGER);
				}
				break;
			case 4:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				variable();
				}
				break;
			case 5:
				{
				_localctx = new ArrStrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				arraystr();
				}
				break;
			case 6:
				{
				_localctx = new ArrIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				arrayint();
				}
				break;
			case 7:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(LP);
				setState(27);
				expr(0);
				setState(28);
				match(RP);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(41);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new CompareContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(32);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(33);
						((CompareContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NE) ) {
							((CompareContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(34);
						expr(11);
						}
						break;
					case 2:
						{
						_localctx = new ContainContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(35);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(36);
						match(IN);
						setState(37);
						expr(10);
						}
						break;
					case 3:
						{
						_localctx = new BoolContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(38);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(39);
						((BoolContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==BOOLAND || _la==BOOLOR) ) {
							((BoolContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(40);
						expr(9);
						}
						break;
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArraystrContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(FormatterFilterParser.LBRACE, 0); }
		public List<TerminalNode> STRING() { return getTokens(FormatterFilterParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormatterFilterParser.STRING, i);
		}
		public TerminalNode RBRACE() { return getToken(FormatterFilterParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FormatterFilterParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormatterFilterParser.COMMA, i);
		}
		public ArraystrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraystr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitArraystr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraystrContext arraystr() throws RecognitionException {
		ArraystrContext _localctx = new ArraystrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arraystr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(LBRACE);
			setState(47);
			match(STRING);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(48);
				match(COMMA);
				setState(49);
				match(STRING);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(RBRACE);
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

	public static class ArrayintContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(FormatterFilterParser.LBRACE, 0); }
		public List<TerminalNode> INTEGER() { return getTokens(FormatterFilterParser.INTEGER); }
		public TerminalNode INTEGER(int i) {
			return getToken(FormatterFilterParser.INTEGER, i);
		}
		public TerminalNode RBRACE() { return getToken(FormatterFilterParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FormatterFilterParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FormatterFilterParser.COMMA, i);
		}
		public ArrayintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitArrayint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayintContext arrayint() throws RecognitionException {
		ArrayintContext _localctx = new ArrayintContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arrayint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(LBRACE);
			setState(58);
			match(INTEGER);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(59);
				match(COMMA);
				setState(60);
				match(INTEGER);
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(RBRACE);
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

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(FormatterFilterParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(FormatterFilterParser.DOT, i);
		}
		public List<TerminalNode> DOTID() { return getTokens(FormatterFilterParser.DOTID); }
		public TerminalNode DOTID(int i) {
			return getToken(FormatterFilterParser.DOTID, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormatterFilterVisitor ) return ((FormatterFilterVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(DOT);
			setState(69);
			match(DOTID);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(70);
					match(DOT);
					setState(71);
					match(DOTID);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24P\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\16\n\2\r\2\16\2\17\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3!\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\4\3\4\3\4\3\4\7\4\65\n"+
		"\4\f\4\16\48\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5@\n\5\f\5\16\5C\13\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\7\6K\n\6\f\6\16\6N\13\6\3\6\2\3\4\7\2\4\6\b\n\2\4"+
		"\3\2\16\17\3\2\20\21\2W\2\r\3\2\2\2\4 \3\2\2\2\6\60\3\2\2\2\b;\3\2\2\2"+
		"\nF\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\17\3\2\2\2\17\r\3\2\2\2\17\20"+
		"\3\2\2\2\20\3\3\2\2\2\21\22\b\3\1\2\22\23\7\r\2\2\23\24\7\7\2\2\24\25"+
		"\5\4\3\2\25\26\7\b\2\2\26!\3\2\2\2\27!\7\24\2\2\30!\7\23\2\2\31!\5\n\6"+
		"\2\32!\5\6\4\2\33!\5\b\5\2\34\35\7\7\2\2\35\36\5\4\3\2\36\37\7\b\2\2\37"+
		"!\3\2\2\2 \21\3\2\2\2 \27\3\2\2\2 \30\3\2\2\2 \31\3\2\2\2 \32\3\2\2\2"+
		" \33\3\2\2\2 \34\3\2\2\2!-\3\2\2\2\"#\f\f\2\2#$\t\2\2\2$,\5\4\3\r%&\f"+
		"\13\2\2&\'\7\f\2\2\',\5\4\3\f()\f\n\2\2)*\t\3\2\2*,\5\4\3\13+\"\3\2\2"+
		"\2+%\3\2\2\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\5\3\2\2\2/-\3\2"+
		"\2\2\60\61\7\5\2\2\61\66\7\24\2\2\62\63\7\n\2\2\63\65\7\24\2\2\64\62\3"+
		"\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\2"+
		"9:\7\6\2\2:\7\3\2\2\2;<\7\5\2\2<A\7\23\2\2=>\7\n\2\2>@\7\23\2\2?=\3\2"+
		"\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\6\2\2E\t\3"+
		"\2\2\2FG\7\t\2\2GL\7\22\2\2HI\7\t\2\2IK\7\22\2\2JH\3\2\2\2KN\3\2\2\2L"+
		"J\3\2\2\2LM\3\2\2\2M\13\3\2\2\2NL\3\2\2\2\t\17 +-\66AL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}