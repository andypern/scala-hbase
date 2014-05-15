/* stolen from http://wiki.apache.org/hadoop/Hbase/Scala

*/

package org.apache.hadoop.hbase.basics


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.{HBaseConfiguration, HTableDescriptor}
import org.apache.hadoop.hbase.client.{HBaseAdmin,HTable,Put,Get}
import org.apache.hadoop.hbase.util.Bytes

object hbasics {

	def main(args: Array[String]){


		//val conf = new HBaseConfiguration.create()
		val conf = HBaseConfiguration.create()
		
		val admin = new HBaseAdmin(conf)

		println("I made it past conf/admin instantiation")
		// list the tables
		//val listtables=admin.listTables() 
		//listtables.foreach(println)

		// let's insert some data in 'mytable' and get the row


	    if(!admin.isTableAvailable("/tables/mytable")) {
	    	println("Table doesn't exist..quitting")
	      System.exit(1)
	      //admin.createTable(tableDesc)
	    }

		val table = new HTable(conf, "/tables/mytable")

		println("i made it past htable instantiation")

		val theput= new Put(Bytes.toBytes("rowkey1"))

		theput.add(Bytes.toBytes("cf1"),Bytes.toBytes("id1"),Bytes.toBytes("one"))
		table.put(theput)

		val theget= new Get(Bytes.toBytes("rowkey1"))
		val result=table.get(theget)
		val value=result.value()

		println(Bytes.toString(value))

	}
}