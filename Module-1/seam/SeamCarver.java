import java.awt.*;
@author Sri Balaji
public class SeamCarver{
    private Picture pictu;
    private int width;
    private int height;
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
    public int height(){
        return height;
    }
    public int width(){
        return width;
    }
    public double energy(int x,int y){
        // if(x<0||x>=width()-1||y<0||y>=height()-1){
        //     throw new IndexOutOfBoundsException();
        // }
        if(x==0||y==0||x==width()-1||y==height()-1){
            return 0;
        }
        
        double delta1=0.0, delta2=0.0;
        Color x1,x2,y1,y2;
        x1=pictu.get(x-1,y);
        x2=pictu.get(x+1,y);
        y1=pictu.get(x,y-1);
        y2=pictu.get(x,y+1);
        delta1=Math.pow((x1.getRed()-x2.getRed()),2)+Math.pow((x1.getGreen()-x2.getGreen()),2)+Math.pow((x1.getBlue()-x2.getBlue()),2);
        delta2=Math.pow((y1.getRed()-y2.getRed()),2)+Math.pow((y1.getGreen()-y2.getGreen()),2)+Math.pow((y1.getBlue()-y2.getBlue()),2);
        return Math.sqrt(delta1+delta2);
    }

}