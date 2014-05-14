name := "hbase_basics"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
    "org.apache.hadoop" % "hadoop-core" % "0.20.2",
    "org.apache.hbase" % "hbase" % "0.94.17"
)

resolvers += "Apache HBase" at "http://repository.mapr.com"

resolvers += "Thrift" at "http://people.apache.org/~rawson/repo/"