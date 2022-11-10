import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

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

}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
try{

adminlogin1 ad=new adminlogin1("ADMIN LOGIN");
ad.setExtendedState(JFrame.MAXIMIZED_BOTH);
ad.setVisible(true);	
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

