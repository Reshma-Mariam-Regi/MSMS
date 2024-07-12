import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class welcome extends JFrame implements ActionListener{
JLabel jl1;
JButton jb1;
public welcome(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("MEDICAL STORE MANAGEMENT SYSTEM");
jl1.setBounds(270,200,850,50);
jl1.setFont(new Font("Serif",Font.BOLD,35));
contentPane.add(jl1);

JButton jb2=new JButton("ADMIN");
jb2.addActionListener(this);
jb2.setBounds(450,300,350,50);
contentPane.add(jb2);
contentPane.setSize(790,500);
contentPane.setVisible(true);

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
String s=ae.getActionCommand();
try{

adminlogin1 ad=new adminlogin1("ADMIN LOGIN");
ad.setVisible(true);
ad.setExtendedState(JFrame.MAXIMIZED_BOTH);
this.dispose();	

}
catch(Exception e)
{
System.out.println("Error"+e);
}}
public static void main(String args[])
{
welcome a=new welcome("LOGOUT");
a.setTitle("MEDICAL STORE MANAGEMENT SYSTEM");
a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
a.setVisible(true);
a.setExtendedState(JFrame.MAXIMIZED_BOTH);

}}