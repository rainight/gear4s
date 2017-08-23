// Generated from FormatterFilter.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormatterFilterParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormatterFilterVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link FormatterFilterParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(FormatterFilterParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code str}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStr(FormatterFilterParser.StrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrStr}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrStr(FormatterFilterParser.ArrStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code not}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(FormatterFilterParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(FormatterFilterParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare(FormatterFilterParser.CompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code contain}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContain(FormatterFilterParser.ContainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FormatterFilterParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(FormatterFilterParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(FormatterFilterParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrInt}
	 * labeled alternative in {@link FormatterFilterParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrInt(FormatterFilterParser.ArrIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormatterFilterParser#arraystr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraystr(FormatterFilterParser.ArraystrContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormatterFilterParser#arrayint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayint(FormatterFilterParser.ArrayintContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormatterFilterParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(FormatterFilterParser.VariableContext ctx);
}