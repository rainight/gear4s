package ts.utility

import java.io.Closeable
import java.io.IOException

/**
  * Created by liush on 05/06/2017.
  */
class HBaseHelper(configuration: Configuration) extends Closeable {
  private val connection = ConnectionFactory.createConnection(configuration)
  private val admin = connection.getAdmin

  @throws[IOException]
  override def close(): Unit = {
    connection.close()
  }

  def getConnection: Connection = connection

  def getConfiguration: Configuration = configuration

  def createNamespace(namespace: String): Unit = {
    try {
      val nd = NamespaceDescriptor.create(namespace).build
      admin.createNamespace(nd)
    } catch {
      case e: Exception =>
        System.err.println("Error: " + e.getMessage)
    }
  }
}
