package sl.utility

import sl.converter._
import org.scalatest.{FunSuite, Matchers}

class fileoperatortest extends FunSuite with Matchers {
  val fp = "src/test/resources"

  test("file operation") {
    val fn = s"$fp/testfile"
    val s = "I am your father!"
    FileOperator.WriteFile(fn, s)

    val ss = FileOperator.File2String(fn)

    ss should be (s)

    FileOperator.DeleteFile(fn)
  }

  test("binary file") {
    val fn = s"$fp/testfile"
    val s = textUtils.Hex2Bytes("0102 00EF")
    FileOperator.WriteFile(fn, s)

    val ss = FileOperator.File2Bytes(fn)

    ss should be (s)

    FileOperator.DeleteFile(fn)
  }
}
