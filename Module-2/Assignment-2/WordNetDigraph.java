import java.util.*;
import java.io.*;
public class WordNetDigraph{
    // public static void parseSynsets(String syn) throws Exception{
    //     FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\synsets.txt");
    //     BufferedReader b=new BufferedReader(file);
    //     String i="";
    //     int v=0;
    //     while((i=b.readLine())!=null){
    //         String arr[]=i.split(",");
    //         v++;
    //     }
    //     System.out.println(v);
    // }

    static ArrayList<String> al=new ArrayList<String>();
    static ArrayList<String[]> sal=new ArrayList<String[]>();
    public static void parseHypernyms(String hyper) throws Exception{
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\hypernyms.txt");
        BufferedReader b=new BufferedReader(file);
        String i="";
        int x=0;
        while((i=b.readLine())!=null){
            String arr[]=i.split(",",2);
            if(arr.length>1){
                al.add(arr[0]);
                sal.add(arr[1].split(","));
            }else{
                al.add(arr[0]);
                sal.add(null);
            }
            x++;
        }
        System.out.println("Vertices---" +x);
    }
    public static void main(String[] args)throws Exception{
        //parseSynsets("synsets");
        parseHypernyms("hypernyms");
        Digraph di=new Digraph(al.size());
        int count=0;
        for(int i=0;i<al.size();i++){
            if(sal.get(i)!=null){
                for(int j=0;j<sal.get(i).length;j++){
                    int s=Integer.parseInt(al.get(i));
                    int r=Integer.parseInt(sal.get(i)[j]);
                    di.addEdge(s,r);
                    count++;
                }
             }
        }
        System.out.println("Edges----" +count);
        
    }
}