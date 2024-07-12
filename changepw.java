import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class changepw extends JFrame implements ActionListener,ItemListener{
JLabel jl1,jl2,jl3,jl4,jl5;
JPasswordField jtf2,jtf3,jtf4;
JComboBox jtf1;

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

try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select UserName from adminlogin1");
Vector v=new Vector();
while(rs.next()){
String us=rs.getString(1);
v.add(us);
}
jtf1=new JComboBox(v);	
jtf1.setBounds(670,222,150,20);
add(jtf1);
jtf1.setSelectedIndex(-1);
jtf1.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}

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

public void itemStateChanged(ItemEvent ie){
if(ie.getSource()==jtf1){
try{
String j=jtf1.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from adminlogin1 WHERE UserName="+j);
st.close();
rs.close();
}
catch(Exception e){
}
}}

public void actionPerformed(ActionEvent ae)
{
String u2="",p2="";
String s=ae.getActionCommand();
String u1=jtf1.getSelectedItem().toString();
String p1=jtf2.getText();
String u=jtf3.getText();
String p=jtf4.getText();

if(s.equals("Back"))
{
this.dispose();
}
else if(s.equals("Change Password")){
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="Select*from adminlogin1 where UserName=?";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,u1);
ResultSet rs=ps.executeQuery();
while(rs.next()){
u2=rs.getString("UserName");
p2=rs.getString("Password");

if(u2.equals(u1)&&p2.equals(p1)){

if(u.equals(p)){
try
{
String s1=jtf1.getSelectedItem().toString();
String st1="UPDATE adminlogin1 SET Password=? WHERE UserName=?";

PreparedStatement ps1=con.prepareStatement(st1);

ps1.setString(1,jtf3.getText());
ps1.setString(2,jtf1.getSelectedItem().toString());
ps1.executeUpdate();
con.close();
JOptionPane.showMessageDialog(this,"Updated Successfully");
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
else{
JOptionPane.showMessageDialog(this,"Passwords not equal");}

}
else{
JOptionPane.showMessageDialog(this,"WRONG CURRENT PASSWORD");
}}}
catch(Exception e){
System.out.println("Error"+e);
}
}
}
public static void main(String args[])
{
changepw c=new changepw("CHANGE PASSWORD");
c.setTitle("CHANGE PASSWORD");
c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
c.setVisible(true);

}}