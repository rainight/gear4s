/**
  * Created by liush on 29/06/2017.
  */

class NodeValue(var value: Any) {
  if (!(isString || isInteger || isBool || isList)) throw new IllegalArgumentException

  def isString: Boolean = value.isInstanceOf[String]

  def asString: String = value.asInstanceOf[String]

  def isInteger: Boolean = value.isInstanceOf[Integer]

  def asInteger: Integer = value.asInstanceOf[Integer]

  def isBool: Boolean = value.isInstanceOf[Boolean]

  def asBool: Boolean = value.asInstanceOf[Boolean]

  def isList: Boolean = value.isInstanceOf[List[_]]

  def asListString: List[String] = value.asInstanceOf[List[String]]

  def asListInt: List[Integer] = value.asInstanceOf[List[Integer]]

  def equals(nval: NodeValue): Boolean = { // equals
    nval match {
      case _ if this.isString => this.asString == nval.asString
      case _ if this.isInteger => this.asInteger == nval.asInteger
      case _ if this.isBool => this.asBool == nval.asBool
      case _ => false
    }
  }

  override def toString: String = value.toString
}
