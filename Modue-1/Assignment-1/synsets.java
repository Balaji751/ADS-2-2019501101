import java.util.*;
import java.io.*;
public class synsets{
    public static void main(String[] args) throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\synsets.txt");
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