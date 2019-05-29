
package com.neu.store_customcounter;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 *
 * @author nilan
 */
public class Driver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
       Configuration conf = new Configuration();
       Job job = new Job(conf, "Counters");
       job.setJarByClass(Driver.class);
       
       job.setMapperClass(CounterMapper.class);
       job.setReducerClass(CounterReducer.class);
       
       job.setMapOutputKeyClass(Text.class);
       job.setMapOutputValueClass(Text.class);
       
       FileInputFormat.addInputPath(job, new Path(args[0]));
       FileOutputFormat.setOutputPath(job, new Path(args[1]));
              
       job.setOutputKeyClass(Text.class);
       job.setOutputValueClass(IntWritable.class);
       
       System.exit(job.waitForCompletion(true) ? 0 : 1); 
    }
    
}
