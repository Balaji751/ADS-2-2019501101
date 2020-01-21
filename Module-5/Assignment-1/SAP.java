/**
 * This java file is used to find the Shortest ancestor path between the two vertices which we are passing.
 * @author Sri Balaji
 */
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
/**
 * Creating SAP class
 */
public class SAP{
    private Digraph dg;
    //constructor takes a digraph(not necessarily a dag)
    public SAP(Digraph G){
        this.dg=G;
        // BreadthFirstDirectedPaths[] bfs=new BreadthFirstDirectedPaths[this.dg.vertices()];
        // for(int i=0;i<G.vertices();i++){
        //     bfs[i]=new BreadthFirstDirectedPaths(dg,i);
        // }
    }
    //lenght of shortest ancestral path between v and w;-1 if no such path
    /**
     * length method gives the length between the two vertices we are passing
     */
    public int length(int v,int w){
        //Creating the objects for BreadthFirstDirectedPaths
        BreadthFirstDirectedPaths a=new BreadthFirstDirectedPaths(dg,v);
        BreadthFirstDirectedPaths b=new BreadthFirstDirectedPaths(dg,w);
        int length=Integer.MAX_VALUE;
        for(int i=0;i<dg.V();i++){
            if(a.hasPathTo(i) && b.hasPathTo(i)){
                int leng=a.distTo(i)+b.distTo(i);
                //here checking whether the new length leng is greater than previous length or not//
                if(length>leng){
                    length=leng;
                }
            }
        }
        //If the length is not changed,then return -1,else return length// 
        if(length==Integer.MAX_VALUE){
            return -1;
        }else{
            return length;
        }
    }
    //A common ancestor of v and w  that participates in a shortest ancestral path;-1 if no such path
    /**
     * This method is used to find the ancestor of the vertices what we are passing
     */
    public int ancestor(int v, int w){
        BreadthFirstDirectedPaths a=new BreadthFirstDirectedPaths(dg,v);
        BreadthFirstDirectedPaths b=new BreadthFirstDirectedPaths(dg,w);
        int length=Integer.MAX_VALUE;
        int ancestor=-1;
        for(int i=0;i<dg.V();i++){
            if(a.hasPathTo(i) && b.hasPathTo(i)){
                int leng=a.distTo(i)+b.distTo(i);
                if(length>leng){
                    length=leng;
                    ancestor=i;
                }
            }
        }
        return ancestor;
    }
    //length of shortest ancestoral path between any vertex in v and any vertex in w;-1 if no such path
    /**
     * This method is useful to find the length here passing parameters as the Iterable vertices of integer type and returns length
     */
    public int length(Iterable<Integer> v,Iterable<Integer>w){
        int length=Integer.MAX_VALUE;
        for(int i : v){
            for(int j : w){
                int l=length(i,j);
                if(l<length && l!=-1){
                    length=l;
                }
            }
        }
        //If the length is not changed,then return -1,else return length//
        if(length==Integer.MAX_VALUE){
            return -1;
        }else{
            return length;
        }
    }
    //A common ancestor that participates in shortest ancestral path;-1 if no such path
    /**
     * This method is also used to find the ancestor,and returns ancestor
     */
    public int ancestor(Iterable<Integer> v,Iterable<Integer>w){
        int length=Integer.MAX_VALUE;
        int ancestor=-1;
        for(int i:v){
            for(int j:w){
                int leng=length(i,j);
                if(leng!=1 && leng<length){
                    length=leng;
                    ancestor=ancestor(i,j);
                }
            }
        }
        return ancestor;
    }
}