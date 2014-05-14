#!/usr/bin/bash

export SHARK_HOME=/opt/mapr/shark/shark-0.9.0
export SPARK_HOME=/opt/mapr/spark/spark-0.9.1
export SCALA_HOME=/usr/share/java


export CLASSPATH


#first, use the JAR we care about
CLASSPATH+=target/scala-2.10/hbase_basics_2.10-0.1-SNAPSHOT.jar

# Add in the mapR FS jar

CLASSPATH+=:/opt/mapr/lib/maprfs-1.0.3-mapr-3.0.3.jar
#add in mapR hbase jar
CLASSPATH+=:/opt/mapr/hbase/hbase-0.94.17/hbase-0.94.17-mapr-1403-SNAPSHOT.jar




#next, grab jars from mapR spark + shark folders

for jar in `find $SPARK_HOME -name '*.jar'`; do
	CLASSPATH+=:$jar
done

# for jar in `find $SHARK_HOME/lib_managed -name '*.jar'`; do
# 	CLASSPATH+=:$jar
# done

#lastly, grab JARS from scala dir

for jar in `find $SCALA_HOME -name 'scala*.jar'`; do
	CLASSPATH+=:$jar
done

#finally, execute the code

/bin/java -cp $CLASSPATH org.apache.hadoop.hbase.basics.hbasics 