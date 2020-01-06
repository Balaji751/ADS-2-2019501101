import java.util.*;
import java.io.*;
public class hypernyms{
    public static void main(String[] args) throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\hypernyms.txt");
        BufferedReader s=new BufferedReader(file);
        String i = "";
        int j=0;
        // System.out.println(file.read());
        while((i=s.readLine())!=null && j<5){
            String[] str=i.split(",");
            for(int k=0;k<str.length;k++) {
                System.out.println(str[k]);
            }
            j++;
        }

    }
}