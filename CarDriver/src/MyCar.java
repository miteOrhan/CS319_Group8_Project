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
public class MyCar {
    private ImageIcon image;
    private int x;
    private int y;
    private int live;
    private int score;
    
    public MyCar(ImageIcon image,int x,int y,int live,int score){
        this.image = image;
        this.x = x;
        this.y = y;
        this.live = live;
        this.score = score;
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
    public ImageIcon getImage(){
        return image;
    }
    public void setImage(ImageIcon image){
        this.image = image;
    }
    public int getLive(){
        return live;
    }
    public void setLive(int live){
        this.live = live;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
}