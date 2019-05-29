
package com.neu.store_customcounter;

import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CounterReducer extends Reducer<Text, Text, Text, IntWritable>{
    
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
        int totalRevenue = 0;
        Iterator<Text> valuesItr = values.iterator();
        while(valuesItr.hasNext()){
            String[] data = valuesItr.next().toString().split(",");
            
            int price = Integer.parseInt(data[0]);
            int sales = Integer.parseInt(data[1]);
            
            totalRevenue+= (price*sales);
            
        }
        
        context.write(key, new IntWritable(totalRevenue));
        
        
    }
    
}
