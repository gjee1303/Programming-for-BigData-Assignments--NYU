import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;
 public class wordcountMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

        final static Pattern WORD_PATTERN = Pattern.compile("Dec|Chicago|Hackathon|Java");


        private final static LongWritable ONE = new LongWritable(1L);


        private Text word = new Text();
//      private Text word_nomatch=new Text();

       
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException { 
            Matcher matcher = WORD_PATTERN.matcher(value.toString());
            while (matcher.find()) { 
                word.set(matcher.group());
 		context.write(word,ONE);
                }

                }

}


