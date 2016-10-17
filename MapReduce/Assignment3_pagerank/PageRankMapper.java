import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
 public class PageRankMapper extends Mapper<LongWritable, Text, Text, Text> {

        public int size=0,outbounds=0;
        private Text values;
        private Text keys;
          public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
         size = line.replace(" ","").length();
        outbounds= size-9;
        String node,node_master;
        int pair=1;
        float initial;
        float PR;
        initial = Float.parseFloat(line.replace(" ","").substring(outbounds+1,size));                                                           
        PR = initial/outbounds;
        node_master = line.replace(" ","").substring(0,1);
        for(int i =1; i<=outbounds+1; i++){
        if(i<=outbounds)
        {
        node = line.replace(" ","").substring(i,i+1);
        context.write(new Text(node),new Text(node_master+",  "+String.valueOf(PR)));

         }                                                                                                                                                       

        else
        {
                node = line.replace(" ","").substring(1,outbounds+1);
                context.write(new Text(node_master),new Text(node));
 	}
}
}
}
