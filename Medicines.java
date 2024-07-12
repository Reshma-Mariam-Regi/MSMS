import java.awt.Color;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
 public class Medicines extends JFrame implements ActionListener
{
JLabel jl1;
JButton medlistBtn;
JButton insertmedBtn;
JButton deletemedBtn;
JButton updatemedBtn;
JButton backBtn;

public Medicines(String n)
    {
super (n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

       JLabel jl1=new JLabel("MEDICINE");
      jl1.setForeground(Color.black);
       jl1.setFont(new Font("Bell MT",Font.BOLD,35));
       jl1.setBounds(150,100,300,50);
       contentPane.add(jl1);

        medlistBtn=new JButton("Medicines List");
         medlistBtn.addActionListener(this);
         medlistBtn.setBounds(500,200,300,50);
          contentPane.add(medlistBtn);

        insertmedBtn=new JButton("Insert Medicines");
            insertmedBtn.addActionListener(this);
            insertmedBtn.setBounds(500,300,300,50);
         contentPane.add(insertmedBtn);

        deletemedBtn=new JButton("Delete Medicines");
            deletemedBtn.addActionListener(this);
            deletemedBtn.setBounds(500,400,300,50);
            contentPane.add(deletemedBtn);

     updatemedBtn=new JButton("Update Medicines");
            updatemedBtn.addActionListener(this);
            updatemedBtn.setBounds(500,500,300,50);
            contentPane.add(updatemedBtn);

     backBtn=new JButton("Back");
             backBtn.addActionListener(this);
             backBtn.setBounds(800,600,300,50);   
             contentPane.add(backBtn);

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date=new Date();
JLabel dt=new JLabel(formatter.format(date));
dt.setBounds(1100,20,200,90);
dt.setFont(new Font("Serif",Font.BOLD,20));
contentPane.add(dt);

setLayout(new BorderLayout());
JLabel img=new JLabel(new ImageIcon("D://download.jfif"));
//JLabel img=new JLabel(new ImageIcon("C://Users//hp//Downloads//download.jfif"));
img.setBounds(0,0,900,900);
contentPane.add(img);
img.setLayout(new FlowLayout());

    }
public void actionPerformed(ActionEvent ae)
{
Object source=ae.getSource();
if(source==medlistBtn)
{
medlist ml=new medlist("MEDICINES LIST");
}

else if (source==insertmedBtn)
{
insertmed im=new insertmed("INSERT MEDICINES");
im.setExtendedState(JFrame.MAXIMIZED_BOTH);
im.setVisible(true);
this.dispose();
}
     

else if(source==updatemedBtn)
{
updatemed um=new updatemed("UPDATE MEDICINES");
um.setExtendedState(JFrame.MAXIMIZED_BOTH);
um.setVisible(true);
this.dispose();
}

   
else if(source==deletemedBtn)
{
deletemed dm=new deletemed("DELETE MEDICINES");
dm.setExtendedState(JFrame.MAXIMIZED_BOTH);
dm.setVisible(true);
this.dispose();
}
  
else if(source==backBtn)
{
home he=new home("HOME");
he.setExtendedState(JFrame.MAXIMIZED_BOTH);
he.setVisible(true);
this.dispose();
}}
    public static void main(String args[]) {
      Medicines obj=  new Medicines("Medicines");
obj.setTitle("MEDICINES");
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj.setVisible(true);
}
}