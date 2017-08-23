package sl

import org.apache.hadoop.hbase.{CellUtil, HBaseConfiguration}
import org.apache.hadoop.hbase.client.{Get, HTable}
import org.apache.hadoop.hbase.util.Bytes

object decodingCDFObj {
  @throws[Exception]
  def main(args: Array[String]): Unit = {
    val zkquorum = "c149jub.int.westgroup.com,c321shu.int.westgroup.com,c167rvm.int.westgroup.com"
    val cf = Bytes.toBytes("d")

    val hconf = HBaseConfiguration.create()

    hconf.set("hbase.zookeeper.quorum", zkquorum)
    hconf.set("hbase.zookeeper.property.clientPort", "2181")

    val htable = new HTable(hconf, "ecpcicdf:CHANGE_LOG_OA")
    val rowkey = "00f47a94-571e-4e19-b41c-491aaae7b8dd"
    val qual = "ADDRESS_SNAPSHOT"

    val g = new Get(Bytes.toBytes(rowkey))
    g.addColumn(cf, Bytes.toBytes(qual))

    val r = htable.get(g)

    println(CellUtil.cloneValue(r.rawCells()(0)))
  }
}
