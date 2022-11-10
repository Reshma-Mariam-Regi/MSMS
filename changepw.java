import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class changepw extends JFrame implements ActionListener{
JLabel jl1,jl2,jl3,jl4,jl5;
JTextField jtf1;
JPasswordField jtf2,jtf3,jtf4;

public changepw(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl5=new JLabel("Change Your Password");
jl5.setBounds(200,100,450,50);
jl5.setFont(new Font("Lucida Handwriting",Font.ITALIC,30));
contentPane.add(jl5);

JLabel jl1=new JLabel("Username");
jl1.setBounds(500,207,350,50);
contentPane.add(jl1);
jtf1=new JTextField(25);
jtf1.setBounds(670,222,150,20);
contentPane.add(jtf1);

JLabel jl2=new JLabel("Current Password");
jl2.setBounds(500,259,350,50);
contentPane.add(jl2);
jtf2=new JPasswordField(25);
jtf2.setBounds(670,274,150,20);
contentPane.add(jtf2);

JLabel jl3=new JLabel("New Password");
jl3.setBounds(500,311,350,50);
contentPane.add(jl3);
jtf3=new JPasswordField(25);
jtf3.setBounds(670,326,150,20);
contentPane.add(jtf3);

JLabel jl4=new JLabel("Confirm Password");
jl4.setBounds(500,363,350,50);
contentPane.add(jl4);
jtf4=new JPasswordField(25);
jtf4.setBounds(670,378,150,20);
contentPane.add(jtf4);

JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(420,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Change Password");
jb2.addActionListener(this);
jb2.setBounds(650,530,250,50);
contentPane.add(jb2);
contentPane.setSize(790,500);
contentPane.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String u1="",p1="";
String s=ae.getActionCommand();
String u=jtf1.getText();
}
public static void main(String args[])
{
changepw c=new changepw("CHANGE PASSWORD");
c.setTitle("CHANGE PASSWORD");
c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.setVisible(true);

}}