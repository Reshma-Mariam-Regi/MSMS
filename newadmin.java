import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newadmin extends JFrame implements ActionListener{
JLabel jl1,jl2,jl3,jl4;
JTextField jtf1;
JPasswordField jtf2,jtf3;

public newadmin(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl4=new JLabel("Welcome...New Admin");
jl4.setBounds(200,100,450,50);
jl4.setFont(new Font("Lucida Handwriting",Font.ITALIC,30));
contentPane.add(jl4);

JLabel jl1=new JLabel("Username");
jl1.setBounds(500,207,350,50);
contentPane.add(jl1);
jtf1=new JTextField(25);
jtf1.setBounds(670,222,150,20);
contentPane.add(jtf1);

JLabel jl2=new JLabel("Password");
jl2.setBounds(500,259,350,50);
contentPane.add(jl2);
jtf2=new JPasswordField(25);
jtf2.setBounds(670,274,150,20);
contentPane.add(jtf2);

JLabel jl3=new JLabel("Confirm Password");
jl3.setBounds(500,311,350,50);
contentPane.add(jl3);
jtf3=new JPasswordField(25);
jtf3.setBounds(670,326,150,20);
contentPane.add(jtf3);

JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(420,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb3=new JButton("Delete");
jb3.addActionListener(this);
jb3.setBounds(610,530,100,50);
contentPane.add(jb3);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Add");
jb2.addActionListener(this);
jb2.setBounds(800,530,100,50);
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
String u=jtf2.getText();
String p=jtf3.getText();
if(s.equals("Add"))
{
if(u.equals(p))
{
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="INSERT INTO adminlogin1 VALUES(?,?)";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,jtf1.getText());
ps.setString(2,p);
ps.executeUpdate();
con.close();
JOptionPane.showMessageDialog(this,"Added successfully");
System.out.println("Added");
}
catch(Exception e)
{
System.out.println("Error"+e);
}}
else{
JOptionPane.showMessageDialog(this,"Passwords not equal");
}}

else if(s.equals("Delete")){
String d=jtf1.getText();
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="DELETE FROM adminlogin1 WHERE UserName=?";

PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,d);
ps.executeUpdate();
con.close();

JOptionPane.showMessageDialog(this,"Deleted Successfully");
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}

else if(s.equals("Back")){
home he=new home("HOME");
he.setExtendedState(JFrame.MAXIMIZED_BOTH);
he.setVisible(true);
this.dispose();
}}
public static void main(String args[])
{
newadmin n=new newadmin("NEW ADMIN");
n.setTitle("NEW ADMIN");
n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
n.setVisible(true);
}}