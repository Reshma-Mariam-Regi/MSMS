import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class deletecomp extends JFrame implements ActionListener{
JLabel jl6;
JTextField jtf1;
JPasswordField jtf2;
JFrame contentPane;

public deletecomp(String n){
super(n);
contentPane=new JFrame();
contentPane.setLayout(null);

JLabel jl1=new JLabel("Company Name");
jl1.setBounds(200,155,350,50);
contentPane.add(jl1);
jtf1=new JTextField(25);
jtf1.setBounds(310,170,150,20);
contentPane.add(jtf1);

JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(155,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Delete");
jb2.addActionListener(this);
jb2.setBounds(600,530,100,50);
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
new deletecomp("delete company");
}}