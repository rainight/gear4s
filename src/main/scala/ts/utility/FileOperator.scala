package ts.utility

import java.io.{BufferedOutputStream, File, FileOutputStream, PrintWriter}

import scala.io.Source
import java.nio.file.{Files, Paths}

object FileOperator {
  def File2String(pathStr: String): String = {
    Source.fromFile(pathStr).mkString
  }

  def File2Bytes(pathStr: String): Array[Byte] = {
    Files.readAllBytes(Paths.get(pathStr))
  }

  def WriteFile(pathStr: String, content: String) = {
    new PrintWriter(pathStr) { write(content); close()}
  }

  def WriteFile(pathStr: String, content: Array[Byte]) = {
    val bos = new BufferedOutputStream(new FileOutputStream(pathStr))
    bos.write(content)
    bos.close()
  }

  def DeleteFile(pathStr: String) = {
    new File(pathStr).delete()
  }
}
