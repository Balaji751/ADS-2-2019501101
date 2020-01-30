import java.awt.*;
/**
 * @author Balaji
 */
public class SeamCarver{
    Picture pictu;
    double[][] eT;
    int[][] xT;
    int width;
    int height;
    
    // create a seam carver object based on the given picture
    public  SeamCarver(Picture picture){
        pictu=new Picture(picture);
        width=pictu.width();
        height=pictu.height();
    }
    // current picture
    public Picture picture(){
        return pictu;
    }
    // height of current picture
    public int height(){
        return pictu.height();
    }
    // width of current picture
    public int width(){
        return pictu.width();
    }
    // energy of pixel at column x and row y
    public double energy(int x,int y){
        // if(x<0||x>=width()-1||y<0||y>=height()-1){
        //     throw new IndexOutOfBoundsException();
        // }
        if(x==0||y==0||x==width()-1||y==height()-1){
            return 1000;
        }
        
        double delta1=0.0, delta2=0.0;
        Color x1,x2,y1,y2;
        x1=pictu.get(x-1,y);
        x2=pictu.get(x+1,y);
        y1=pictu.get(x,y-1);
        y2=pictu.get(x,y+1);
        //Finding the difference of each color and squaring it
        delta1=Math.pow((x1.getRed()-x2.getRed()),2)+Math.pow((x1.getGreen()-x2.getGreen()),2)+Math.pow((x1.getBlue()-x2.getBlue()),2);
        delta2=Math.pow((y1.getRed()-y2.getRed()),2)+Math.pow((y1.getGreen()-y2.getGreen()),2)+Math.pow((y1.getBlue()-y2.getBlue()),2);
       //Returning the squrt for results of delta1 and 2 squaring them//
        return Math.sqrt(delta1+delta2);
    }
    public int[] findVerticalSeam(){
        eT=new double[width()][height()];
        xT=new int[width()][height()];
        for(int x=0;x<width();x++){
            for(int y=0;y<height();y++){
                eT[x][y]=Double.POSITIVE_INFINITY;
            }
        }
        for(int x=0;x<width();x++){
            eT[x][0]=1000;
        }
        for(int y=0;y<height()-1;y++){
            for(int x=0;x<width();x++){
                if(x>0){
                    relax(x,y,x-1,y+1);
                }
                relax(x,y,x,y+1);
                if(x<width()-1){
                    relax(x,y,x+1,y+1);
                }
            }
        }
        double minimumEnergy=Double.POSITIVE_INFINITY;
        int minEnergyx=-1;
        for(int a=0;a<width();a++){
            if((eT[a][height()-1])<minimumEnergy){
                minEnergyx=a;
                minimumEnergy=eT[a][height()-1];
            }
        }
        int[] seam=new int[height()];
        seam[height()-1]=minEnergyx;
        int pre=xT[minEnergyx][height()-1];
        for(int h=height()-2;h>=0;h--){
            seam[h]=pre;
            pre=xT[pre][h];
        }
        return seam;
    }
    private void relax(int x1,int y1,int x2,int y2){
        if(eT[x2][y2]>eT[x1][y1]+energy(x2,y2)){
            eT[x2][y2]=eT[x1][y1]+energy(x2,y2);
            xT[x2][y2]=x1;
        }
    }
    public int[] findHorizontalSeam(){
        Picture original = pictu;
        Picture transpose = new Picture(original.height(), original.width());
        for(int w=0;w<transpose.width();w++){
            for(int h=0;h<transpose.height();h++){
                transpose.set(w,h,original.get(h,w));
            }
        }
        this.pictu= transpose;
        int[] seam = findVerticalSeam();
        this.pictu = original;
        return seam;
    }
    
}