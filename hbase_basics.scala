/* stolen from http://wiki.apache.org/hadoop/Hbase/Scala

*/

package org.apache.hadoop.hbase.basics


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;


//import org.apache.hadoop.hbase.HBaseConfiguration
//import org.apache.hadoop.hbase.client.{HBaseAdmin,HTable,Put,Get}
//import org.apache.hadoop.hbase.util.Bytes

object hbasics {

	def main(args: Array[String]){

		println("i'm doing stuff")

		val conf = new HBaseConfiguration()
		val admin = new HBaseAdmin(conf)

		// list the tables
		//val listtables=admin.listTables() 
		//listtables.foreach(println)

		// let's insert some data in 'mytable' and get the row

		val table = new HTable(conf, "/mapr/shark/tables/mytable")

		val theput= new Put(Bytes.toBytes("rowkey1"))

		theput.add(Bytes.toBytes("ids"),Bytes.toBytes("id1"),Bytes.toBytes("one"))
		table.put(theput)

		val theget= new Get(Bytes.toBytes("rowkey1"))
		val result=table.get(theget)
		val value=result.value()

		println(Bytes.toString(value))

	}
}