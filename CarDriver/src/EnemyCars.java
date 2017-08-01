
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
public class EnemyCars{
    private String kind;
    //image = new ImageIcon("car.png");
    public EnemyCars(String kind){
        this.kind = kind;
    }
    public String getKind(){
        return kind;
    }
    public void setKind(String kind){
        this.kind = kind;
    }
    public String toString(){
        return "Kind:  " + getKind();
    }

}
