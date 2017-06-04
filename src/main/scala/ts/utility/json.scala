package ts.utility

import org.json4s._
import org.json4s.jackson.Json
import org.json4s.jackson.JsonMethods._

object json {
  def fromString(json: String): JValue = {
    parse(json)
  }

  def fromMapValue(m: Map[String, Any]): String = {
    Json(org.json4s.DefaultFormats).write(m)
  }

  def format(json: String, isPretty: Boolean = false): String = {
    val j = fromString(json)
    if(isPretty)
      pretty(render(j))
    else
      compact(render(j))
  }

  def xPath(jstruct: Map[String, Any], path: Array[String]): Any = {
    path.length match {
      case 1 =>
        jstruct.getOrElse(path.head, null)
      case _ =>
        if(jstruct.contains(path.head)) {
          val next = jstruct(path.head)
          next match {
            case x: Map[_, _] => xPath(x.asInstanceOf[Map[String, Any]], path.tail)
            case _ =>
              println("not a map string any")
              null
          }
        }
        else
          null
    }
  }

  def xPath(jstruct: Map[String, Any], xpath: String): Any = {
    xPath(jstruct, xpath.split("\\."))
  }
}
