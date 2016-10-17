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

    public class PageRankReducer extends Reducer<Text, Text, Text,Text> {


        public void reduce(Text key, Iterable<Text> values,                Context context) throws IOException, InterruptedException {
                float PR = 0 ;
        float sum = 0;
        String node=new String();
            for (Text value : values) {
                String[] buffer = value.toString().split(", ");
                if(buffer.length>1)
                {PR= Float.parseFloat(buffer[buffer.length-1]);
                sum =sum+PR;
                }
                else
                node = buffer[0];   
            }
            context.write(key,new Text(node+" "+String.valueOf(sum)));
	}
}
