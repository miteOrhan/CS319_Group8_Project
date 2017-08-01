/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;
import sun.audio.AudioData;
import sun.audio.AudioDataStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class CarDriverPanel extends JPanel{
    
    private JLabel label,label2;
    private JButton start,pause;
    private int y,y2;
    private Timer timer1,timer2;
    private JPanel p1,p2;
    private ImageIcon image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,image11,image12;
    private ImageIcon image13,image14,image15,image16;
    private double X,Y,velX,velY;
    private ECar1 ec1;
    private ECar2 ec2;
    private ECar3 ec3;
    private ECar4 ec4;
    private MyCar mycar;
    private boolean check = false;
    private boolean checkTimer1 = false;
    private boolean checkTimer2 = false;
    private PowerUps jg;
    //private PowerUps jg2;
    private Presents pr1,pr2;
    private long tStart;
    private long tEnd;
    private long tDelta;
    private double elapsedSeconds;
    private long tStart2;
    private long tEnd2;
    private long tDelta2;
    private double elapsedSeconds2;
    
    
    public CarDriverPanel(){
        
        image1 = new ImageIcon("/src/car1.png");
        image2 = new ImageIcon("car2.png");
        image3 = new ImageIcon("car3.png");
        image4 = new ImageIcon("car4.png");
        image5 = new ImageIcon("car5.png");
        image6 = new ImageIcon("pow.png");
        image7 = new ImageIcon("juggernaut.png");
        image8 = new ImageIcon("start.png");
        image9 = new ImageIcon("finish.png");
        image10 = new ImageIcon("two.png");
        image11 = new ImageIcon("three.png");
        image12 = new ImageIcon("iron.png");
        
        image13 = new ImageIcon("Truck2.png");
        image14 = new ImageIcon("Redcar2.png");
        image15 = new ImageIcon("Police2.png");
        image16 = new ImageIcon("Ambulance.png");
        
        ec1 = new ECar1("Ambulance",image1,0,0);
        ec2 = new ECar2("Truck",image2,0,0);
        ec3 = new ECar3("Taxi",image3,0,0);
        ec4 = new ECar4("Bike",image4,0,0);
        mycar = new MyCar(image5,0,350,350,0);
        jg =  new PowerUps("JuggerNaut",image7,0,0);
        //jg2 = new PowerUps("JuggerNaut2",image12,0,0);
        pr1 = new Presents("Plus100",image10,0,0);
        pr2 = new Presents("Ten",image11,0,0);
        
        //for ways
        y2 = -10;
        //for driver moving
        X=0;
        Y=0;
        velX = 0;
        velY = 0;
        
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(1200,1200));
        p1.setBackground(Color.darkGray);
        add(p1);
        p1.setLayout(null);
        
                
        label = new JLabel("Score: " + mycar.getScore());
        label.setFont(new java.awt.Font("Kristen ITC", 1, 30));
        label.setBorder(BorderFactory.createLineBorder(Color.black, 6)); // Line Border + Thickness of the Border
        //label.setSize(50, 60);
        //label.setLocation(100, 200);
        //Dimension d = label.getPreferredSize();
        label.setBackground(Color.RED);
        label.setForeground(new java.awt.Color(255, 255,255 ));
        label.setOpaque(true);
        //p1.add(label);
        p1.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(940,450, size.width+112, size.height);
        
        label2 = new JLabel();
        label.setOpaque(true);
        label2.setFont(new java.awt.Font("Kristen ITC", 1, 80));
        //label.setSize(50, 60);
        //label.setLocation(100, 200);
        //Dimension d = label.getPreferredSize();
        label2.setBackground(Color.darkGray);
        label2.setForeground(new java.awt.Color(255, 255,255 ));
        label2.setOpaque(true);
        //p1.add(label);
        p1.add(label2);
        Dimension size4 = label2.getPreferredSize();
        label2.setBounds(1000,550, size.width, size.height*2);
        
        start = new JButton("start");
        pause = new JButton("pause");
        start.setForeground(new java.awt.Color(255, 255,255 ));
        start.setBorder(BorderFactory.createLineBorder(Color.black, 6)); // Line Border + Thickness of the Border
        pause.setForeground(new java.awt.Color(255, 255,255 ));
        pause.setBorder(BorderFactory.createLineBorder(Color.black, 6)); // Line Border + Thickness of the Border
        start.setBackground(Color.RED);
        pause.setBackground(Color.RED);
        start.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        pause.setFont(new Font("Kristen ITC", Font.PLAIN, 20));
        
        p1.add(start);
        p1.add(pause);
        Dimension size2 = start.getPreferredSize();
        start.setBounds(990, 120, size2.width*2+23, size2.height);
        Dimension size3 = pause.getPreferredSize();
        pause.setBounds(990, 323, size3.width*2+20, size3.height);
        
        start.addActionListener(new DisplayListener());
        start.addKeyListener (new DirectionListener());
        pause.addActionListener(new DisplayListener());
        pause.addKeyListener(new DirectionListener());
        
        timer1 = new Timer(100,new DisplayListener());
        timer2 = new Timer(40,new DisplayListener());

    }
    public static void music(){
       AudioPlayer MGP = AudioPlayer.player;
       AudioStream BGM;
       AudioData MD;
       AudioDataStream loop = null;
       
       try{
       BGM = new AudioStream(new FileInputStream("formula+1.wav"));
       MD = BGM.getData();
       loop = new AudioDataStream(MD);
       }catch(IOException error){}
       
       MGP.start(loop);
   }
    public static void music2(){
       AudioPlayer MGP = AudioPlayer.player;
       AudioStream BGM;
       AudioData MD;
       AudioDataStream loop = null;
       
       try{
       BGM = new AudioStream(new FileInputStream("car_crash_01.wav"));
       MD = BGM.getData();
       loop = new AudioDataStream(MD);
       }catch(IOException error){}
       
       MGP.start(loop);
   }
    private class DisplayListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Object source = e.getSource();
            if(source == start){
                timer1.start();
                timer2.start();
            }
            else{
                music();
                checkCollision();
                MoveCar();
                MoveTape();
                repaint();
                checkTimer1 = true;
            }
            if(!check){
                mycar.setScore(mycar.getScore() + 1);
                label.setText("Score:  " + mycar.getScore());
            }
            if(source == pause && checkTimer1 == true){
                music2();
                timer1.stop();
                timer2.stop();
            }
        }
    }
    public void MoveCar(){
       ec1.Move();
       ec2.Move();
       ec3.Move();
       ec4.Move();
       jg.Move1();
       //jg2.Move2();
       pr1.Move1();
       pr2.Move2();
    }
    public void MoveTape(){
        if(y2 < -25){
            y2 = y2+20;
        }
        else{
            y2 = -100;
        }
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        //right way
        g.drawRect(230, y2, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2, 30, 60);

        g.drawRect(230, y2+100, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+100, 30, 60);
        
        g.drawRect(230, y2+200, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+200, 30, 60);
        
        g.drawRect(230, y2+300, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+300, 30, 60);
        
        g.drawRect(230, y2+400, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+400, 30, 60);
        
        g.drawRect(230, y2+500, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+500, 30, 60);
        
        g.drawRect(230, y2+600, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+600, 30, 60);
        
        g.drawRect(230, y2+700, 30, 60);
        g.setColor(Color.white);
        g.fillRect(230, y2+700, 30, 60);
        
        //left way
        g.drawRect(700, y2, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2, 30, 60);

        g.drawRect(700, y2+100, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+100, 30, 60);
        
        g.drawRect(700, y2+200, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+200, 30, 60);
        
        g.drawRect(700, y2+300, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+300, 30, 60);
        
        g.drawRect(700, y2+400, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+400, 30, 60);
        
        g.drawRect(700, y2+500, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+500, 30, 60);
        
        g.drawRect(700, y2+600, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+600, 30, 60);
        
        g.drawRect(700, y2+700, 30, 60);
        g.setColor(Color.white);
        g.fillRect(700, y2+700, 30, 60);
       
        g.drawRect(30, 10, 3, 1100);
        g.setColor(Color.yellow);
        g.fillRect(30, 10, 3, 1100);
        
        g.drawRect(450, 10, 3, 1100);
        g.setColor(Color.yellow);
        g.fillRect(450, 10, 3, 1100);
        
        g.drawRect(490, 10, 3, 1100);
        g.setColor(Color.yellow);
        g.fillRect(490, 10, 3, 1100);
        
        g.drawRect(940, 10, 3, 1100);
        g.setColor(Color.yellow);
        g.fillRect(940, 10, 3, 1100);
        
        ec1.getImage().paintIcon (this, g, ec1.getX()+50, ec1.getY()+10);
        ec2.getImage().paintIcon(this,g,ec2.getX()+250,ec2.getY()+10);
        ec3.getImage().paintIcon(this, g, ec3.getX()+300, ec3.getY()+400);
        ec4.getImage().paintIcon(this, g,ec4.getX()+500,ec4.getY()+600);
        mycar.getImage().paintIcon(this,g,mycar.getX()+150,400);
        image8.paintIcon(this,g,1000,10);
        image9.paintIcon(this,g,1005,200);
        
        if(100 < mycar.getScore() && mycar.getScore() < 5000 || 9000 < mycar.getScore() && mycar.getScore() < 16000){
            image11.paintIcon(this,g,pr2.getX()+20,pr2.getY()+20);
        }
        
        if(150 < mycar.getScore() && mycar.getScore() < 3000){
            image10.paintIcon(this,g,pr1.getX()+20,pr1.getY()+20);
        }
        /*if(150 < mycar.getScore() && mycar.getScore() < 3000){
            jg2.getImage().paintIcon(this,g,jg2.getX()+20,jg2.getY()+20);
        }*/
        
        if( 100 < mycar.getScore() && mycar.getScore() < 800 || 1500 < mycar.getScore() && mycar.getScore() < 150000){
            jg.getImage().paintIcon(this,g,jg.getX()+500,jg.getY()+20);
        }
        //System.out.println(ec1.getY()+10);
        //System.out.println(ec1.getX()+50);
        //System.out.println("Mycar" + mycar.getY());
        //System.out.println("mycar" + mycar.getX()+150);
        //System.out.println("pr "+ pr1.getY()+400);
        //System.out.println("pr" + pr1.getX()+500);
 
    }
   private class DirectionListener implements KeyListener
   {
      //--------------------------------------------------------------
      //  Responds to the user pressing arrow keys by adjusting the
      //  image and image location accordingly.
      //--------------------------------------------------------------
      public void keyPressed (KeyEvent event)
      {
         switch (event.getKeyCode())
         {
            case KeyEvent.VK_UP:
               break;
            case KeyEvent.VK_DOWN:
               break;
            case KeyEvent.VK_LEFT:
                mycar.setX(mycar.getX()-20);
               break;
            case KeyEvent.VK_RIGHT:
                mycar.setX(mycar.getX()+20);
               break;
         }
         repaint();
      }

      //--------------------------------------------------------------
      //  Provide empty definitions for unused event methods.
      //--------------------------------------------------------------
      public void keyTyped (KeyEvent event) {}
      public void keyReleased (KeyEvent event) {}
   }
    public void checkCollision(){
       if((ec1.getX()+50)+40 >= mycar.getX()+150 && (ec1.getX()+50) <= mycar.getX()+180 && (ec1.getY()+10)+40 >= mycar.getY() && (ec1.getY()+10) <= mycar.getY()){
           if(checkTimer2 == false){
                timer1.stop();
                timer2.stop();
                mycar.setImage(image6);
                //System.out.println("umut");
                check = true;
                label.setFont(new java.awt.Font("Kristen ITC", 1, 50));
                Dimension size = label.getPreferredSize();
                label.setBounds(285,0, size.width+70, size.height);
                label.setBackground(Color.YELLOW);
                label.setForeground(new java.awt.Color(0, 0,0 ));
           }
       }
       else if((ec2.getX()+250)+40 >= mycar.getX()+150 && (ec2.getX()+250) <= mycar.getX()+180 && (ec2.getY()+10)+40 >= mycar.getY() && (ec2.getY()+10) <= mycar.getY()){
           if(checkTimer2 == false){
                timer1.stop();
                timer2.stop();
                mycar.setImage(image6);
                //System.out.println("umut");
                check = true;
                label.setFont(new java.awt.Font("Kristen ITC", 1, 50));
                Dimension size = label.getPreferredSize();
                label.setBounds(285,0, size.width+70, size.height);
                label.setBackground(Color.YELLOW);
                label.setForeground(new java.awt.Color(0,0,0 ));
           }
       }
       else if((ec3.getX()+300)+40 >= mycar.getX()+150 && (ec3.getX()+300) <= mycar.getX()+180 && (ec3.getY()+400)+40 >= mycar.getY() && (ec3.getY()+400) <= mycar.getY()){
           if(checkTimer2 == false){
                timer1.stop();
                timer2.stop();
                mycar.setImage(image6);
                //System.out.println("umut");
                check = true;
                label.setFont(new java.awt.Font("Kristen ITC", 1, 50));
                Dimension size = label.getPreferredSize();
                label.setBounds(285,0, size.width+70, size.height);
                label.setBackground(Color.YELLOW);
                label.setForeground(new java.awt.Color(0, 0,0 ));
           }
       }
       else if((ec4.getX()+500)+40 >= mycar.getX()+150 && (ec4.getX()+500) <= mycar.getX()+180 && (ec4.getY()+600)+40 >= mycar.getY() && (ec4.getY()+600) <= mycar.getY()){
           if(checkTimer2 == false){
                timer1.stop();
                timer2.stop();
                mycar.setImage(image6);
                //System.out.println("umut");
                check = true;
                label.setFont(new java.awt.Font("Kristen ITC", 1, 50));
                Dimension size = label.getPreferredSize();
                label.setBounds(285,0, size.width+70, size.height);
                label.setBackground(Color.YELLOW);
                label.setForeground(new java.awt.Color(0, 0,0 ));
           }
       }
       else if((pr1.getX()+20)+15 >= mycar.getX()+150 && (pr1.getX()+20) <= mycar.getX()+180 && (pr1.getY()+20)+15 >= mycar.getY() && (pr1.getY()+20) <= mycar.getY()){
           mycar.setScore(mycar.getScore()*2);
       }
       else if((pr2.getX())+15 >= mycar.getX()+150 && (pr2.getX()) <= mycar.getX()+180 && (pr2.getY())+15 >= mycar.getY() && (pr2.getY()) <= mycar.getY()){
           mycar.setScore(mycar.getScore()*3);
       }
      /*else if((jg2.getX()+20)+15 >= mycar.getX()+150 && (jg2.getX()+20) <= mycar.getX()+180 && (jg2.getY()+20)+15 >= mycar.getY() && (jg2.getY()+20) <= mycar.getY()){
           
           mycar.setScore(mycar.getScore() + 200);
           checkTimer2 = true;
           //System.out.println("irem");
           ec1.setImage(image13);
           ec2.setImage(image14);
           ec3.setImage(image15);
           ec4.setImage(image16);
           tStart = System.currentTimeMillis();
           
       }
       else if((jg2.getX()+20)+15 < mycar.getX()+150 || (jg2.getX()+20) > mycar.getX()+180 || (jg2.getY()+20)+15 < mycar.getY() || (jg2.getY()+20) > mycar.getY()){
           int i = 0;
           checkTimer2 = true;
           //System.out.println("irem");
           tEnd = System.currentTimeMillis();
           tDelta = tEnd - tStart;
           elapsedSeconds = tDelta / 1000.0;
           //System.out.println(elapsedSeconds);
       
           if(5 < elapsedSeconds && elapsedSeconds < 6){
               label2.setText("0");
               label2.setText(" ");
           }
           if(4<elapsedSeconds && elapsedSeconds <5){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 120));
               label2.setText("1");
           }
           if(3<elapsedSeconds && elapsedSeconds<4){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 100));
               label2.setText("2");
           }
           if(2<elapsedSeconds && elapsedSeconds<3){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 80));
               label2.setText("3");
           }
           if(1<elapsedSeconds && elapsedSeconds<2){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 70));
               label2.setText("4");
           }
           if(0<elapsedSeconds && elapsedSeconds<1){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 50));
               label2.setText("5");
           }
       
           if(elapsedSeconds > 7){
           ec1.setImage(image1);
           ec2.setImage(image2);
           ec3.setImage(image3);
           ec4.setImage(image4);
           checkTimer2 = false;
           }
       }*/
       else if((jg.getX()+500)+40 >= mycar.getX()+150 && (jg.getX()+500) <= mycar.getX()+180 && (jg.getY()+20)+40 >= mycar.getY() && (jg.getY()+20) <= mycar.getY()){
           
           mycar.setScore(mycar.getScore() + 200);
           checkTimer2 = true;
           //System.out.println("irem");
           ec1.setImage(image6);
           ec2.setImage(image6);
           ec3.setImage(image6);
           ec4.setImage(image6);
           tStart = System.currentTimeMillis();
           
       }
       else if((jg.getX()+500)+40 < mycar.getX()+150 || (jg.getX()+500) > mycar.getX()+180 || (jg.getY()+20)+40 < mycar.getY() || (jg.getY()+20) > mycar.getY()){
           int i = 0;
           checkTimer2 = true;
           //System.out.println("irem");
           tEnd = System.currentTimeMillis();
           tDelta = tEnd - tStart;
           elapsedSeconds = tDelta / 1000.0;
           System.out.println(elapsedSeconds);
           
           
           if(5 < elapsedSeconds && elapsedSeconds < 6){
               label2.setText("0");
               label2.setText(" ");
           }
           if(4<elapsedSeconds && elapsedSeconds <5){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 120));
               label2.setText("1");
           }
           if(3<elapsedSeconds && elapsedSeconds<4){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 100));
               label2.setText("2");
           }
           if(2<elapsedSeconds && elapsedSeconds<3){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 80));
               label2.setText("3");
           }
           if(1<elapsedSeconds && elapsedSeconds<2){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 70));
               label2.setText("4");
           }
           if(0<elapsedSeconds && elapsedSeconds<1){
               label2.setFont(new java.awt.Font("Kristen ITC", 1, 50));
               label2.setText("5");
           }
           
           
           if(elapsedSeconds > 6){
           ec1.setImage(image1);
           ec2.setImage(image2);
           ec3.setImage(image3);
           ec4.setImage(image4);
           checkTimer2 = false;
           }
       }
    }
}

