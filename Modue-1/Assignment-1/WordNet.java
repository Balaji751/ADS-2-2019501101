import java.util.*;
import java.io.*;
public class WordNet{
    public static void hypernyms() throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\hypernyms.txt");
        BufferedReader br=new BufferedReader(file);
        String i="";
        while((i=br.readLine())!=null){
            String[] arr=i.split(" ,");
            for(int k=0;k<arr.length;k++){
                System.out.println(arr[k]);
            }
        }
    }
    public static void synsets() throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\synsets.txt");
        BufferedReader br=new BufferedReader(file);
        String i="";
        while((i=br.readLine())!=null){
            String[] arr=i.split(" ,");
            for(int k=0;k<arr.length;k++){
                System.out.println(arr[k]);
            }
        }
    }
    public static void main(String[] args)throws Exception{
        hypernyms();
        synsets();
    }
}