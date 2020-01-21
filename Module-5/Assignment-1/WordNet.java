import java.util.HashMap;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Digraph;
public class WordNet{
    private HashMap<Integer,String> synd;
    private HashMap<String,ArrayList<Integer>> hyp;
    private Digraph dig;
    private SAP sap;
    public WordNet(String synsets,String hypernyms) {
        this.synd= new HashMap<Integer,String>();
        this.hyp=new HashMap<String,ArrayList<Integer>>();
        this.parseSynsets(synsets);
        this.dig=new Digraph(synd.size());
        this.parseHypernyms(hypernyms);
        this.sap=new SAP(dig);
    }
    private void parseSynsets(String synsets){
        In in=new In(synsets);
        while(in.hasNextLine()){
            String[] syn=in.readLine().split(",");
            String[] words=syn[1].split(" ");
            for(String s:words){
                synd.put(Integer.parseInt(syn[0]),syn[1]);
                if(!hyp.containsKey(s)){
                    ArrayList<Integer> al=new ArrayList<Integer>();
                    al.add(Integer.parseInt(syn[0]));
                    hyp.put(s,al);
                }else{
                    ArrayList<Integer> sal=hyp.get(s);
                    sal.add(Integer.parseInt(syn[0]));
                    hyp.put(s,sal);
                }
            }
        }
    }

    private void parseHypernyms(String hypernyms){
        In in=new In(hypernyms);
        while(in.hasNextLine()){
            String[] hyper=in.readLine().split(",");
            for(int i=1;i<hyper.length;i++){
                dig.addEdge(Integer.parseInt(hyper[0]),Integer.parseInt(hyper[i]));
            }
        }
        //Reading the file by using file reader and bufferedreader.
        // FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\hypernyms.txt");
        // BufferedReader b=new BufferedReader(file);
        // String i="";
        // int x=0;
        // while((i=b.readLine())!=null){
        //     //Splitting the data in to two parts.
        //     String arr[]=i.split(",",2);
        //     //Array length is greater than 1 then add the first index into al and other line in to second index and split by comma.
        //     if(arr.length>1){
        //         al.add(arr[0]);
        //         sal.add(arr[1].split(","));
        //     //If the length is less than 1,then add null to the sal.
        //     }else{
        //         al.add(arr[0]);
        //         sal.add(null);
        //     }
        //     x++;
        // }
        // //printing the no.of vertices.
        // System.out.println("Vertices---" +x);
    }
    public Iterable<String> nouns(){
        return hyp.keySet();
    }
    public boolean isNoun(String word){
        return hyp.containsKey(word);
    }
    public int distance(String nounA,String nounB){
        if(!this.isNoun(nounA)||!this.isNoun(nounB)){
            throw new IllegalArgumentException();
        }
        //Integer idforA=parseInteger(hyp.get(nounA));
        //Integer idforB=parseInteger(hyp.get(nounB));
        return sap.length(hyp.get(nounA),hyp.get(nounB));
    }
    public String sap(String nounA,String nounB){
        if(!this.isNoun(nounA)||!this.isNoun(nounB)){
            throw new IllegalArgumentException();
        }
        //Integer idforA=parseInteger(hyp.get(nounA));
        //Integer idforB=parseInteger(hyp.get(nounB));
        int sapId=sap.ancestor(hyp.get(nounA),hyp.get(nounB));
        return synd.get(sapId);
    }
    public static void main(String[] args) {
    //     //parseSynsets("synsets");
    //     parseHypernyms("hypernyms");
    //     //craeting object for digraph
    //     Digraph di=new Digraph(al.size());
    //     int count=0;
        
        
    //     for(int i=0;i<al.size();i++){
    //         if(sal.get(i)!=null){
    //             for(int j=0;j<sal.get(i).length;j++){
    //                 //converting the string in to the integer type.
    //                 int s=Integer.parseInt(al.get(i));
    //                 int r=Integer.parseInt(sal.get(i)[j]);
    //                 //adding the edges.
    //                 di.addEdge(s,r);
    //                 count++;
    //             }
    //          }
    //     }
    //     //printing the count of no.of edges.
    //     System.out.println("Edges----" +count);
    //     //Here creating objects for In,SAP,Digraph.In digraph pass in and SAP pass digraph//
    //     In in=new In("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\digraph1.txt");
    //     Digraph dg=new Digraph(in);
    //     SAP sap = new SAP(dg);
    //     //Printing the length and ancestor of the given vertices//
    //     System.out.println("Length is-----"+sap.length(3,11)+ ", and Ancestor is--"+sap.ancestor(3,11));
    //     System.out.println("Length is-----"+sap.length(9,12)+ ",and Ancestor is--"+sap.ancestor(9,12));
    //     System.out.println("Length is----"+sap.length(7,2)+ ", and Ancestor is--"+sap.ancestor(7,2));
    //     System.out.println("Length is ="+sap.length(1,6)+ ",and Ancestor is--"+sap.ancestor(1,6));
     }
}