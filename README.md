# Bigdata-CustomCounter

## Introduction
A Counter is generally used to keep track of occurrences of any events. In Hadoop Framework, whenever any MapReduce job gets executed, the Hadoop Framework initiates counters to keep track of the job statistics like number of rows read, number of rows written as output etc.These are built in counters in Hadoop Framework. Additionally, we can also create and use our own custom counters.
Typically some of the operations of Hadoop counters are:
* Number of mapper and reducer launched
* The number of bytes was read and written
* The number of tasks was launched and successfully ran
* The amount of CPU and memory consumed is appropriate or not for your job and cluster nodes

## Custom Counter
Apart from this Built-in counters in Mapreduce allows us to create our own set of counters which can be incremented as desired by the user in mapper or reducer for some statistical research.
Counters are defined by a Java enum, which serves to group related counters.
A job may define an N number of enums, each with an N number of fields. The name of the enum is the group name, and the enum’s fields are the counter names.Counters are global: the MapReduce framework aggregates them across all maps and reduces to produce a total at the end of the job. 


## Problem Statement
To understand the custom counter implement following things on the data set.
* To find the total records processed my mapper
* To find total records processed for each store location
* To find records where number of sales x product price 500 less than 500
* Total revenue for each store location for all products

## Installation
Clone the repository using HTTPS or SSH or download the zip file. Open the workspace in NetBeans/Eclipse/IntelliJ and make jar of the project manually.
* Open your VirtualMachine and try to run ``` jps ```
* If the hadoop processes are not running try to run them using the command ``` hadoop start-all.sh ```
* Run the jar ``` hadoop jar **jarname** **hdfs-input-path** **hdfs-output-path** ```
