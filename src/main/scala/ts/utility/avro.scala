package ts.utility

import java.io.ByteArrayOutputStream

import org.apache.avro.Schema
import org.apache.avro.generic.{GenericData, GenericDatumReader, GenericDatumWriter, GenericRecord}
import org.apache.avro.io._

object avro {
  def Json2Schema(json: String): Schema = {
    new Schema.Parser().parse(json)
  }

  def xpath(record: GenericRecord, pathStr: String): Any = {
    val pathArray = pathStr.split("\\.")

    var r: GenericRecord = record
    for (step <- pathArray) {
      r = r.get(step).asInstanceOf[GenericRecord]
    }

    r
  }

  def Encode(record: GenericRecord, schema: Schema): Array[Byte] = {
    if(record == null || schema == null) return Array.emptyByteArray

    val out = new ByteArrayOutputStream
    val writer = new GenericDatumWriter[GenericRecord](schema)
    val encoder = EncoderFactory.get.binaryEncoder(out, null)
    writer.write(record, encoder)
    encoder.flush()
    out.flush()

    out.toByteArray
  }

  def Decode(schema: Schema, bytes: Array[Byte]): GenericData.Record = {
    val record = Decode(schema, schema, bytes)
    record
  }

  def Decode(schema: Schema, bytes: Array[Byte], offset: Int, length: Int): GenericData.Record = {
    val record = DecodeWithExtendSchema(schema, schema, bytes, offset, length)
    record
  }

  def Decode(recordSchema: Schema, extendSchema: Schema, bytes: Array[Byte]): GenericData.Record = {
    val record = DecodeWithExtendSchema(recordSchema, extendSchema, bytes, 0, bytes.length)
    record
  }

  def DecodeWithExtendSchema(recordSchema: Schema, extendSchema: Schema, bytes: Array[Byte], offset: Int, length: Int): GenericData.Record = {
    val reader = new GenericDatumReader[GenericRecord](recordSchema, extendSchema)
    val record = new GenericData.Record(extendSchema)
    if (length > 0) {
      val decoder = DecoderFactory.get.binaryDecoder(bytes, offset, length, null)
      reader.read(record, decoder)
    }
    record
  }
}
