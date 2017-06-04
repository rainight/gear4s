package ts.converter

object textUtils {
  //split to small part, \x00abc => 00abc
  private def parseCombo(x: String): Array[Byte] = {
    x match {
      case _ if x.size < 2 => throw new IllegalStateException()
      case _ if x.size == 2 =>
        val abyte = Integer.parseInt(x, 16).toByte
        Array(abyte)
      case _ =>
        val abyte = Integer.parseInt(x.take(2), 16).toByte
        val other = x.toCharArray.drop(2).map(_.toByte)
        Array(abyte) ++ other
    }
  }

  // bytes present by ascii printable and hex non printable, like output from hbase shell
  def HexAscii2Bytes(bstr: String): Array[Byte] = {
    if(bstr.isEmpty) return Array.empty[Byte]

    val s = bstr.split("\\\\x")
    val sf = if(s.head.isEmpty) s.tail else s

    sf.flatMap(x => parseCombo(x))
  }

  def Bytes2HexAscii(b: Array[Byte]): String = {
    if(b.isEmpty) return ""

    val bs = b.map(x => if(x.compareTo(31.toByte) >0 && x.compareTo(127.toByte) < 0) x.toChar.toString else """\x""" + "%02X".format(x))

    bs.mkString
  }

  // bytes present by Hex like 00 BF
  def Hex2Bytes(hstr: String): Array[Byte] = {
    if(hstr.isEmpty) return Array.emptyByteArray

    hstr.replaceAll(" ", "").sliding(2, 2).toArray.map(Integer.parseInt(_, 16).toByte)
  }

  def Bytes2Hex(by: Array[Byte], format: Boolean = false): String = {
    val bstr = by.map(x => "%02X".format(x))
    format match {
      case false => bstr.mkString
      case _ => bstr.mkString(" ")
    }
  }
}
