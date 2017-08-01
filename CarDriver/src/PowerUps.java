
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author umut
 */
public class PowerUps implements PowerUpsMove{
    private String kind;
    private ImageIcon image;
    private int x;
    private int y;
    
    public PowerUps(String kind,ImageIcon image,int x,int y){
        this.kind = kind;
        this.image = image;
        this.x = x;
        this.y = y;
    }
    public String getKind(){
        return kind;
    }
    public ImageIcon getImage(){
        return image;
    }
    public void setImage(ImageIcon image){
        this.image = image;
    }
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x = x;
    }
    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y = y;
    }
    public void Move1(){
        if(getY() < 600){
            setY(getY()+20);
        }
        else{
            setY(-500);
            setX((int)(Math.random()*200+50));
        }
    }
    public void Move2(){
        if(getY() < 600){
            setY(getY()+20);
        }
        else{
            setY(-800);
            setX(-130 + (int)(Math.random()*350+10));
        }
    }
    
}
