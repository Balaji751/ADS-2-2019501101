import java.util.*;
import java.io.*;
public class WordNet{
    //creating arraylist of string type.
    static ArrayList<String> al=new ArrayList<String>();
    //creating arraylist of string array type.
    static ArrayList<String[]> sal=new ArrayList<String[]>();
    /**
     * Creating method parseHypernyms which gives the output no.of vertices.
     * @param hyper
     * @throws Exception
     */
    public static void parseHypernyms(String hyper) throws Exception{
        //Reading the file by using file reader and bufferedreader.
        FileReader file=new FileReader("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\hypernyms.txt");
        BufferedReader b=new BufferedReader(file);
        String i="";
        int x=0;
        while((i=b.readLine())!=null){
            //Splitting the data in to two parts.
            String arr[]=i.split(",",2);
            //Array length is greater than 1 then add the first index into al and other line in to second index and split by comma.
            if(arr.length>1){
                al.add(arr[0]);
                sal.add(arr[1].split(","));
            //If the length is less than 1,then add null to the sal.
            }else{
                al.add(arr[0]);
                sal.add(null);
            }
            x++;
        }
        //printing the no.of vertices.
        System.out.println("Vertices---" +x);
    }
    public Iterable<String> nouns(){
        return this.nounTable;
    }
    public boolean isNoun(String word){
        return this.nounTable.contains(word);
    }
    public int distance(String nounA,String nounB){
        if(!this.isNoun(nounA)||!this.isNoun(nounB)){
            throw new IllegalArgumentException();
        }
        Integer idforA=nounTable.get(nounA);
        Integer idforB=nounTable.get(nounB);
        return sap.length(idforA,idforB);
    }
    public String sap(String nounA,String nounB){
        if(!this.isNoun(NounA)||!this.isNoun(nounB)){
            throw new IllegalArgumentException();
        }
        Integer idforA=nounTable.get(nounA);
        Integer idforB=nounTable.get(nounB);
        int sapId=sap.ancestor(idforA,idforB);
        return synset.get(sapId);
    }
    public static void main(String[] args)throws Exception{
        //parseSynsets("synsets");
        parseHypernyms("hypernyms");
        //craeting object for digraph
        Digraph di=new Digraph(al.size());
        int count=0;
        
        
        for(int i=0;i<al.size();i++){
            if(sal.get(i)!=null){
                for(int j=0;j<sal.get(i).length;j++){
                    //converting the string in to the integer type.
                    int s=Integer.parseInt(al.get(i));
                    int r=Integer.parseInt(sal.get(i)[j]);
                    //adding the edges.
                    di.addEdge(s,r);
                    count++;
                }
             }
        }
        //printing the count of no.of edges.
        System.out.println("Edges----" +count);
        //Here creating objects for In,SAP,Digraph.In digraph pass in and SAP pass digraph//
        In in=new In("C:\\Users\\SREE BALAJI\\Downloads\\wordnet\\digraph1.txt");
        Digraph dg=new Digraph(in);
        SAP sap = new SAP(dg);
        //Printing the length and ancestor of the given vertices//
        System.out.println("Length is-----"+sap.length(3,11)+ ", and Ancestor is--"+sap.ancestor(3,11));
        System.out.println("Length is-----"+sap.length(9,12)+ ",and Ancestor is--"+sap.ancestor(9,12));
        System.out.println("Length is----"+sap.length(7,2)+ ", and Ancestor is--"+sap.ancestor(7,2));
        System.out.println("Length is ="+sap.length(1,6)+ ",and Ancestor is--"+sap.ancestor(1,6));
    }
}