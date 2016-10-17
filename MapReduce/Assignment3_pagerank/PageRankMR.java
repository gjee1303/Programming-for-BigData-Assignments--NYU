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


public class PageRankMR {
public static void main(String[] rawArgs) throws Exception {
                GenericOptionsParser parser = new GenericOptionsParser(rawArgs);
                 Configuration conf = parser.getConfiguration();
                 String[] args = parser.getRemainingArgs();
                 Job job = new Job(conf, "PageRank");
                 job.setJarByClass(PageRankMR.class);
                 job.setMapOutputKeyClass(Text.class);
                 job.setMapOutputValueClass(Text.class);
                 job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);                                                                                       
                 job.setMapperClass(PageRankMapper.class);
                 job.setCombinerClass(PageRankReducer.class);
                 job.setReducerClass(PageRankReducer.class);
                 job.setOutputFormatClass(TextOutputFormat.class);

                FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
                                                                                                                                                                          job.waitForCompletion(true);
                                                                                                                                                                                }

}

                }
















