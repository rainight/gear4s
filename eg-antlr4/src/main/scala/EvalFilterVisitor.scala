/**
  * Created by liush on 29/06/2017.
  */

import java.util
import scala.collection.JavaConverters._

/**
  * Created by liush on 29/06/2017.
  */
class EvalFilterVisitor extends FormatterFilterBaseVisitor[NodeValue] {
  override def visitPrintExpr(ctx: FormatterFilterParser.PrintExprContext): NodeValue = {
    val nv = visit(ctx.expr(0))
    System.out.println(nv.toString)
    new NodeValue(0)
  }

  override def visitStr(ctx: FormatterFilterParser.StrContext): NodeValue = {
    val s = ctx.STRING.getText
    val nv = new NodeValue(s.substring(1, s.length - 1))
    System.out.println("str " + nv)
    nv
  }

  override def visitParens(ctx: FormatterFilterParser.ParensContext): NodeValue = {
    val nv = visit(ctx.expr)
    nv
  }

  override def visitNot(ctx: FormatterFilterParser.NotContext): NodeValue = {
    val nv = visit(ctx.expr)
    System.out.println(nv.toString)
    new NodeValue(!nv.asBool)
  }

  override def visitArrStr(ctx: FormatterFilterParser.ArrStrContext): NodeValue = {
    val nv = visit(ctx.arraystr)
    nv
  }

  override def visitCompare(ctx: FormatterFilterParser.CompareContext): NodeValue = {
    val lf = visit(ctx.expr(0))
    val rt = visit(ctx.expr(1))
    if (ctx.op.getType == FormatterFilterParser.EQ) {
      val p = lf.equals(rt)
      System.out.println(p + " : " + lf + " EQ " + rt)
      return new NodeValue(p)
    }
    val p = !(lf.equals(rt))
    System.out.println(p + " : " + lf + " NE " + rt)
    new NodeValue(p)
  }

  override def visitContain(ctx: FormatterFilterParser.ContainContext): NodeValue = {
    val lf = visit(ctx.expr(0))
    val rt = visit(ctx.expr(1))
    if (lf.isString) {
      val rts = rt.asListString
      val p = rts.contains(lf.asString)
      System.out.println(p + " : " + lf.asString + " in " + rts)
      return new NodeValue(p)
    }
    if (lf.isInteger) {
      val rti = rt.asListInt
      val p = rti.contains(lf.asInteger)
      System.out.println(p + " : " + lf.asInteger + " in " + rti)
      return new NodeValue(p)
    }
    new NodeValue(false)
  }

  override def visitBool(ctx: FormatterFilterParser.BoolContext): NodeValue = {
    val lf = visit(ctx.expr(0))
    val rt = visit(ctx.expr(1))
    if (ctx.op.getType == FormatterFilterParser.BOOLAND) {
      val p = lf.asBool && rt.asBool
      System.out.println(p + " : " + lf.asBool + " && " + rt.asBool)
      return new NodeValue(p)
    }
    val p = lf.asBool || rt.asBool
    System.out.println(p + " : " + lf.asBool + " || " + rt.asBool)
    new NodeValue(p)
  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitVar(ctx: FormatterFilterParser.VarContext): NodeValue = {
    val nv = visit(ctx.variable)
    nv
  }

  override def visitInt(ctx: FormatterFilterParser.IntContext): NodeValue = {
    val i = Integer.valueOf(ctx.INTEGER.getText)
    System.out.println("Int " + i)
    new NodeValue(i)
  }

  override def visitArrInt(ctx: FormatterFilterParser.ArrIntContext): NodeValue = {
    val nv = visit(ctx.arrayint)
    nv
  }

  override def visitArraystr(ctx: FormatterFilterParser.ArraystrContext): NodeValue = {
    val strNodes = ctx.STRING.asScala.map(x => x.getText)
    val r = strNodes.map(x => x.substring(1, x.length - 1)).toList;

    System.out.println("array str: " + r)
    new NodeValue(r)
  }

  override def visitArrayint(ctx: FormatterFilterParser.ArrayintContext): NodeValue = {
    val r = ctx.INTEGER.asScala.map(x => x.getText.toInt).toList;

    System.out.println("array int: " + r)
    new NodeValue(r)
  }

  override def visitVariable(ctx: FormatterFilterParser.VariableContext): NodeValue = {
    val p = ctx.getText

    val nv: NodeValue = p match {
      case ".f1.v" => new NodeValue("abc")
      case ".f2.a" => new NodeValue("cc")
      case ".f3.v" => new NodeValue(1234)
    }

    System.out.println("variable " + p + " " + nv.toString)
    nv
  }
}
