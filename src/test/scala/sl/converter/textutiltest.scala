package sl.converter

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class textutiltest extends FunSuite with Matchers with BeforeAndAfter {
  val ts = """\x00\x02\x02\x02\x80\x80\xCC\xCF\xF9\x9Ds\x02\x08NA02\x02\x08NA02\x02\xFF\xEF\xC7\x8F\xCC"""

  test ("HexAscii vs bytes") {
    val b = textUtils.HexAscii2Bytes(ts)

    val bs = textUtils.Bytes2HexAscii(b)

    bs should be (ts)
  }

  test ("Hex text vs bytes") {
    val b = textUtils.HexAscii2Bytes(ts)

    val bs = textUtils.Bytes2Hex(b, true)

    b should be (textUtils.Hex2Bytes(bs))
  }
}
