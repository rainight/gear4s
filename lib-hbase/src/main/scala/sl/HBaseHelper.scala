package sl

import java.io.Closeable
import java.io.IOException
import java.util
import java.util.{ArrayList, List, Random}

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.Cell
import org.apache.hadoop.hbase.HColumnDescriptor
import org.apache.hadoop.hbase.HTableDescriptor
import org.apache.hadoop.hbase.NamespaceDescriptor
import org.apache.hadoop.hbase.TableName
import org.apache.hadoop.hbase.client.Admin
import org.apache.hadoop.hbase.client.Connection
import org.apache.hadoop.hbase.client.ConnectionFactory
import org.apache.hadoop.hbase.client.Get
import org.apache.hadoop.hbase.client.Put
import org.apache.hadoop.hbase.client.Result
import org.apache.hadoop.hbase.client.Table
import org.apache.hadoop.hbase.util.Bytes

/**
  * Created by liush on 05/06/2017.
  * forked from https://github.com/larsgeorge/hbase-book/blob/master/common/src/main/java/util/HBaseHelper.java
  */
class HBaseHelper(configuration: Configuration) extends Closeable {
  private val connection = ConnectionFactory.createConnection(configuration)
  private val admin = connection.getAdmin

  @throws[IOException]
  override def close(): Unit = {
    connection.close()
  }

  def getTable(tableName: TableName): Table = connection.getTable(tableName)

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

  def dropNamespace(namespace: String, force: Boolean): Unit = {
    try
        if (force) {
          val tableNames: Array[TableName] = admin.listTableNamesByNamespace(namespace)
          for (name <- tableNames) {
            admin.disableTable(name)
            admin.deleteTable(name)
          }
        }
    catch {
      case e: Exception =>

      // ignore
    }
    try
      admin.deleteNamespace(namespace)
    catch {
      case e: IOException =>
        System.err.println("Error: " + e.getMessage)
    }
  }

  @throws[IOException]
  def existsTable(table: String): Boolean = existsTable(TableName.valueOf(table))

  @throws[IOException]
  def existsTable(table: TableName): Boolean = admin.tableExists(table)

  @throws[IOException]
  def createTable(table: String, colfams: String*): Unit = {
    createTable(TableName.valueOf(table), 1, null, colfams: _*)
  }

  @throws[IOException]
  def createTable(table: TableName, colfams: String*): Unit = {
    createTable(table, 1, null, colfams: _*)
  }

  @throws[IOException]
  def createTable(table: String, maxVersions: Int, colfams: String*): Unit = {
    createTable(TableName.valueOf(table), maxVersions, null, colfams: _*)
  }

  @throws[IOException]
  def createTable(table: TableName, maxVersions: Int, colfams: String*): Unit = {
    createTable(table, maxVersions, null, colfams: _*)
  }

  @throws[IOException]
  def createTable(table: String, splitKeys: Array[Array[Byte]], colfams: String*): Unit = {
    createTable(TableName.valueOf(table), 1, splitKeys, colfams: _*)
  }

  @throws[IOException]
  def createTable(table: TableName, maxVersions: Int, splitKeys: Array[Array[Byte]], colfams: String*): Unit = {
    val desc: HTableDescriptor = new HTableDescriptor(table)
    for (cf <- colfams) {
      val coldef: HColumnDescriptor = new HColumnDescriptor(cf)
      coldef.setMaxVersions(maxVersions)
      desc.addFamily(coldef)
    }
    if (splitKeys != null) admin.createTable(desc, splitKeys)
    else admin.createTable(desc)
  }

  @throws[IOException]
  def disableTable(table: String): Unit = {
    disableTable(TableName.valueOf(table))
  }

  @throws[IOException]
  def disableTable(table: TableName): Unit = {
    admin.disableTable(table)
  }

  @throws[IOException]
  def dropTable(table: String): Unit = {
    dropTable(TableName.valueOf(table))
  }

  @throws[IOException]
  def dropTable(table: TableName): Unit = {
    if (existsTable(table)) {
      if (admin.isTableEnabled(table)) disableTable(table)
      admin.deleteTable(table)
    }
  }

  @throws[IOException]
  def fillTable(table: String, startRow: Int, endRow: Int, numCols: Int, colfams: String*): Unit = {
    fillTable(TableName.valueOf(table), startRow, endRow, numCols, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: TableName, startRow: Int, endRow: Int, numCols: Int, colfams: String*): Unit = {
    fillTable(table, startRow, endRow, numCols, -1, false, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: String, startRow: Int, endRow: Int, numCols: Int, setTimestamp: Boolean, colfams: String*): Unit = {
    fillTable(TableName.valueOf(table), startRow, endRow, numCols, -1, setTimestamp, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: TableName, startRow: Int, endRow: Int, numCols: Int, setTimestamp: Boolean, colfams: String*): Unit = {
    fillTable(table, startRow, endRow, numCols, -1, setTimestamp, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: String, startRow: Int, endRow: Int, numCols: Int, pad: Int, setTimestamp: Boolean, colfams: String*): Unit = {
    fillTable(TableName.valueOf(table), startRow, endRow, numCols, pad, setTimestamp, false, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: TableName, startRow: Int, endRow: Int, numCols: Int, pad: Int, setTimestamp: Boolean, colfams: String*): Unit = {
    fillTable(table, startRow, endRow, numCols, pad, setTimestamp, false, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: String, startRow: Int, endRow: Int, numCols: Int, pad: Int, setTimestamp: Boolean, random: Boolean, colfams: String*): Unit = {
    fillTable(TableName.valueOf(table), startRow, endRow, numCols, pad, setTimestamp, random, colfams: _*)
  }

  @throws[IOException]
  def fillTable(table: TableName, startRow: Int, endRow: Int, numCols: Int, pad: Int, setTimestamp: Boolean, random: Boolean, colfams: String*): Unit = {
    val tbl: Table = connection.getTable(table)
    val rnd: Random = new Random
    var row: Int = startRow
    while ( {
      row <= endRow
    }) {
      var col: Int = 1
      while ( {
        col <= numCols
      }) {
        val put: Put = new Put(Bytes.toBytes("row-" + padNum(row, pad)))
        for (cf <- colfams) {
          val colName: String = "col-" + padNum(col, pad)
          val `val`: String = "val-" + (if (random) Integer.toString(rnd.nextInt(numCols))
          else padNum(row, pad) + "." + padNum(col, pad))
          if (setTimestamp) put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(colName), col, Bytes.toBytes(`val`))
          else put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(colName), Bytes.toBytes(`val`))
        }
        tbl.put(put)

        {
          col += 1; col - 1
        }
      }

      {
        row += 1; row - 1
      }
    }
    tbl.close()
  }

  @throws[IOException]
  def fillTableRandom(table: String, minRow: Int, maxRow: Int, padRow: Int, minCol: Int, maxCol: Int, padCol: Int, minVal: Int, maxVal: Int, padVal: Int, setTimestamp: Boolean, colfams: String*): Unit = {
    fillTableRandom(TableName.valueOf(table), minRow, maxRow, padRow, minCol, maxCol, padCol, minVal, maxVal, padVal, setTimestamp, colfams: _*)
  }

  @throws[IOException]
  def fillTableRandom(table: TableName, minRow: Int, maxRow: Int, padRow: Int, minCol: Int, maxCol: Int, padCol: Int, minVal: Int, maxVal: Int, padVal: Int, setTimestamp: Boolean, colfams: String*): Unit = {
    val tbl: Table = connection.getTable(table)
    val rnd: Random = new Random
    val maxRows: Int = minRow + rnd.nextInt(maxRow - minRow)
    var row: Int = 0
    while ( {
      row < maxRows
    }) {
      val maxCols: Int = minCol + rnd.nextInt(maxCol - minCol)
      var col: Int = 0
      while ( {
        col < maxCols
      }) {
        val rowNum: Int = rnd.nextInt(maxRow - minRow + 1)
        val put: Put = new Put(Bytes.toBytes("row-" + padNum(rowNum, padRow)))
        for (cf <- colfams) {
          val colNum: Int = rnd.nextInt(maxCol - minCol + 1)
          val colName: String = "col-" + padNum(colNum, padCol)
          val valNum: Int = rnd.nextInt(maxVal - minVal + 1)
          val `val`: String = "val-" + padNum(valNum, padCol)
          if (setTimestamp) put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(colName), col, Bytes.toBytes(`val`))
          else put.addColumn(Bytes.toBytes(cf), Bytes.toBytes(colName), Bytes.toBytes(`val`))
        }
        tbl.put(put)

        {
          col += 1; col - 1
        }
      }

      {
        row += 1; row - 1
      }
    }
    tbl.close()
  }

  def padNum(num: Int, pad: Int): String = {
    var res: String = Integer.toString(num)
    if (pad > 0) while ( {
      res.length < pad
    }) res = "0" + res
    res
  }

  @throws[IOException]
  def put(table: String, row: String, fam: String, qual: String, `val`: String): Unit = {
    put(TableName.valueOf(table), row, fam, qual, `val`)
  }

  @throws[IOException]
  def put(table: TableName, row: String, fam: String, qual: String, `val`: String): Unit = {
    val tbl: Table = connection.getTable(table)
    val put: Put = new Put(Bytes.toBytes(row))
    put.addColumn(Bytes.toBytes(fam), Bytes.toBytes(qual), Bytes.toBytes(`val`))
    tbl.put(put)
    tbl.close()
  }

  @throws[IOException]
  def put(table: String, row: String, fam: String, qual: String, ts: Long, `val`: String): Unit = {
    put(TableName.valueOf(table), row, fam, qual, ts, `val`)
  }

  @throws[IOException]
  def put(table: TableName, row: String, fam: String, qual: String, ts: Long, `val`: String): Unit = {
    val tbl: Table = connection.getTable(table)
    val put: Put = new Put(Bytes.toBytes(row))
    put.addColumn(Bytes.toBytes(fam), Bytes.toBytes(qual), ts, Bytes.toBytes(`val`))
    tbl.put(put)
    tbl.close()
  }

  @throws[IOException]
  def put(table: String, rows: Array[String], fams: Array[String], quals: Array[String], ts: Array[Long], vals: Array[String]): Unit = {
    put(TableName.valueOf(table), rows, fams, quals, ts, vals)
  }

  @throws[IOException]
  def put(table: TableName, rows: Array[String], fams: Array[String], quals: Array[String], ts: Array[Long], vals: Array[String]): Unit = {
    val tbl: Table = connection.getTable(table)
    for (row <- rows) {
      val put: Put = new Put(Bytes.toBytes(row))
      for (fam <- fams) {
        var v: Int = 0
        for (qual <- quals) {
          val `val`: String = vals(if (v < vals.length) v
          else vals.length - 1)
          val t: Long = ts(if (v < ts.length) v
          else ts.length - 1)
          System.out.println("Adding: " + row + " " + fam + " " + qual + " " + t + " " + `val`)
          put.addColumn(Bytes.toBytes(fam), Bytes.toBytes(qual), t, Bytes.toBytes(`val`))
          v += 1
        }
      }
      tbl.put(put)
    }
    tbl.close()
  }

  @throws[IOException]
  def dump(table: String, rows: Array[String], fams: Array[String], quals: Array[String]): Unit = {
    dump(TableName.valueOf(table), rows, fams, quals)
  }

  @throws[IOException]
  def dump(table: TableName, rows: Array[String], fams: Array[String], quals: Array[String]): Unit = {
    val tbl: Table = connection.getTable(table)
    val gets: util.List[Get] = new util.ArrayList[Get]
    for (row <- rows) {
      val get: Get = new Get(Bytes.toBytes(row))
      get.setMaxVersions
      if (fams != null) for (fam <- fams) {
        for (qual <- quals) {
          get.addColumn(Bytes.toBytes(fam), Bytes.toBytes(qual))
        }
      }
      gets.add(get)
    }
    val results: Array[Result] = tbl.get(gets)
    for (result <- results) {
      for (cell <- result.rawCells) {
        System.out.println("Cell: " + cell + ", Value: " + Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength))
      }
    }
    tbl.close()
  }
}
