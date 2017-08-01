/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.ImageIcon;

/**
 *
 * @author umut
 */
public class ECar1 extends EnemyCars implements Move{
    private ImageIcon image;
    private int x;
    private int y;
    
    public ECar1(String kind,ImageIcon image,int x,int y){
        super(kind);
        this.image = image;
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setImage(ImageIcon image){
        this.image = image;
    }
    public ImageIcon getImage(){
        return image;
    }
    public void Move(){
        if(getY() < 600){
            setY(getY()+15);
        }
        else{
            setY(-100);
        }
    }
}