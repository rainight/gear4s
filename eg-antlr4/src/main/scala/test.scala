/**
  * Created by liush on 29/06/2017.
  */

import org.antlr.v4.runtime._

object test {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val is = "!(.f1.v == \"abc\" || .f2.a in [\"ab\", \"xy\", \"mn\"]) && .f3.v != 1234"
    val input = new ANTLRInputStream(is)
    val lexer = new FormatterFilterLexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new FormatterFilterParser(tokens)
    val tree = parser.prog
    // parse
    val eval = new EvalFilterVisitor
    eval.visit(tree)
  }
}
