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
import javax.swing.*;
import sun.audio.*;
import java.io.*;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class CarDriver extends JFrame
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
       
       JFrame frame = new JFrame("CarDriver");
       JFrame frame2 = new JFrame("CarDriverEnter");

       CarDriverPanel a = new CarDriverPanel();
       frame.getContentPane().add(new CarDriverPanel());
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       frame.setBounds(800, 800, 1200, 800);
       Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
       int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
       int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
       frame.setLocation(x, y);
       frame.setLayout(null);
       frame.setResizable(false);
       
       
       //second frame
       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame2.pack();
       frame2.setLocationRelativeTo(null);
       frame2.setVisible(true);
       frame2.setAlwaysOnTop(true);
       frame2.setBounds(500, 500, 600, 400);
       frame2.setLocation(x+250, y+190);
       frame2.setLayout(null);
       frame2.setResizable(false);

       JLabel label = new JLabel("      " + "Welcome to CarDriver");
       label.setBackground(Color.darkGray);
       label.setFont(new Font("Kristen ITC", Font.PLAIN, 40));
       label.setForeground(Color.red);
       frame2.add(label);
       label.setBorder(BorderFactory.createLineBorder(Color.black, 1)); // Line Border + Thickness of the Border
       
       frame2.setLayout(new GridLayout(3, 1));
       JButton enter = new JButton("Enter the CarDriver");
       enter.setBackground(Color.darkGray);
       enter.setFont(new Font("Kristen ITC", Font.PLAIN, 40));
       enter.setForeground(Color.RED);
       frame2.add(enter);
       enter.setBorder(BorderFactory.createLineBorder(Color.black, 1)); // Line Border + Thickness of the Border
       
       JButton exit = new JButton("Exit the Game");
       exit.setBackground(Color.darkGray);
       exit.setFont(new Font("Kristen ITC", Font.PLAIN, 40));
       exit.setForeground(Color.RED);
       frame2.add(exit);
       exit.setBorder(BorderFactory.createLineBorder(Color.black, 1)); // Line Border + Thickness of the Border
       /*Dimension size1 = enter.getPreferredSize();
       enter.setBounds(50, 50, size1.width*3, size1.height*3);
       Dimension size2 = exit.getPreferredSize();
       exit.setBounds(50, 130, size2.width*3+15, size2.height*3);*/
       music2();
       
       enter.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
             frame2.setVisible(false);
             frame.setVisible(true);
             music();
       }
       });
       exit.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
             frame2.setVisible(false);
             frame.setVisible(false);
             music2();
       }
       });
   }
   public static class AL implements ActionListener{
       public final void actionPerformed(ActionEvent e){
           music();
       }
   }
   public static void music(){
       AudioPlayer MGP = AudioPlayer.player;
       AudioStream BGM;
       AudioData MD;
       AudioDataStream loop = null;
       
       try{
       BGM = new AudioStream(new FileInputStream("car+start3.wav"));
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
       BGM = new AudioStream(new FileInputStream("car_door.wav"));
       MD = BGM.getData();
       loop = new AudioDataStream(MD);
       }catch(IOException error){}
       
       MGP.start(loop);
   }
}