package ts.utility

import org.json4s.JsonAST.JObject
import org.scalatest.{FunSuite, Matchers}

class jsontest extends FunSuite with Matchers {
  val js = """{
         "lotto":{
           "lotto-id":5,
           "winning-numbers":[2,45,34,23,7,5,3],
           "winners":[{
             "winner-id":23,
             "numbers":[2,45,34,23,3,5]
           }]
         }
       }"""

  test("json constructor") {
    val j = json.fromString(js).asInstanceOf[JObject]

    info(json.format(js))
    info(json.format(js, true))

    val jj = json.format(json.fromMapValue(j.values))

    jj should be (json.format(js))
  }
}
