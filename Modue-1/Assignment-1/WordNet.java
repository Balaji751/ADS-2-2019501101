import java.util.*;
import java.io.*;
public class WordNet{
    public static void hypernyms(String hyper) throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\"+hyper+".txt");
        BufferedReader b=new BufferedReader(file);
        String i="";
        while((i=b.readLine())!=null){
            String arr[]=i.split(",");
            // for(int k=0;k<arr.length;k++){
                System.out.println(arr[0]);
            // }
        }
    }
    public static void synsets(String syn) throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\"+syn+".txt");
        BufferedReader b=new BufferedReader(file);
        String i="";
        while((i=b.readLine())!=null){
            String arr[]=i.split(",");
            // for(int k=0;k<arr.length;k++){
                System.out.println(arr[0]);
            // }
        }
    }
    public static void main(String[] args)throws Exception{
        hypernyms("hypernyms");
        synsets("synsets");
    }
}