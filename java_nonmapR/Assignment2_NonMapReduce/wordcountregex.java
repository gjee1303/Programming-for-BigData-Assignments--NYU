import java.util.regex.*;
import java.io.*;

public class wordcountregex{

public static void main(String[] args){
        try{
        FileInputStream fstream = new FileInputStream("/home/cloudera/Desktop/input.txt");
       DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        int count_dec=0,count_ch=0,count_ha=0,count_j=0;
        String name;
        while((strLine=br.readLine())!=null){
        Pattern pattern = Pattern.compile("Dec|Chicago|Hackathon|Java");
        Matcher matcher = pattern.matcher(strLine);
        while(matcher.find()){

                if(matcher.group().length()!=0){


                        if(matcher.group().equals("Dec")){
				count_dec++;
                        }
                        if(matcher.group().equals("Chicago")){
                                count_ch++;
                        }
                        if(matcher.group().equals("Hackathon")){
                                count_ha++;
                        }
                        if(matcher.group().equals("Java")){
                                count_j++;
                        }
                //      System.out.println(matcher.group().trim()+" "+count);

        }
        }
        }
                System.out.println("Dec"+" " +count_dec);
                System.out.println("Chicago"+" " +count_ch);
                System.out.println("Hackathon"+" " +count_ha);
                System.out.println("Java"+" " +count_j);



}catch(Exception e){;}
}
}



