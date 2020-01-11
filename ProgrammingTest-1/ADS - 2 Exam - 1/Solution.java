
import java.util.Arrays;
import java.util.*;
import java.io.*;
public class Solution{
    static HashMap<Integer,String> hm=new HashMap<>();
    static HashMap<Integer,Integer> lo=new HashMap<>();
    static HashMap<Integer,Integer> as=new HashMap<>();
    static int[] w;
    
    public static void emailData(String data) throws Exception{
        FileReader file=new FileReader("D:\\ADS-2-2019501101\\ProgrammingTest-1\\ADS - 2 Exam - 1\\email-logs.txt");
        BufferedReader b=new BufferedReader(file);
        String i="";
        while((i=b.readLine())!=null){
            String arr[]=i.split(" ");
            String []a1=arr[1].split(",");
            int s=Integer.parseInt(a1[0]);
            int c=Integer.parseInt(arr[3]);
            // System.out.println(w.length + "," + c);
            w[c]++;
            lo.put(s,c);
            
            //System.out.println(arr1[0]+"  "+arr[3]);
        }
        for(int q=0;q<w.length;q++){
            as.put(w[q],q);
        }
        Arrays.sort(w);
        for(int g=w.length - 10;g<w.length;g++){
            // System.out.println(g);
            System.out.println(as.get(g));
        }
    }
    public static void emails(String mail) throws Exception{
        FileReader file=new FileReader("D:\\ADS-2-2019501101\\ProgrammingTest-1\\ADS - 2 Exam - 1\\emails.txt");
        BufferedReader b=new BufferedReader(file);
        String i="";
        while((i=b.readLine())!=null){
            String arr[]=i.split(";");
            int a=Integer.parseInt(arr[0]);
            hm.put(a,arr[1]);
            //System.out.println(arr[0]+"  "+arr[1]);
        }
        w=new int[hm.size()];
        for(int j=0;j<w.length;j++){
            w[j]=0;
        }
    }
    public static void main(String[] args) throws Exception{
        emails("emails");
        emailData("email-logs");
        // System.out.println(hm);
        // System.out.println(lo);
        
    }
}