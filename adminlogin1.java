import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class adminlogin1 extends JFrame implements ActionListener,ItemListener{
JLabel jl1,jl2,jl3,jl4,jl5;
JPasswordField jtf2;
JButton jb1;
JComboBox jtf1;

public adminlogin1(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("MEDICAL STORE MANAGEMENT SYSTEM");
jl1.setBounds(335,100,700,50);
jl1.setFont(new Font("Serif",Font.BOLD,30));
contentPane.add(jl1);

JLabel jl2=new JLabel("...WELCOME...");
jl2.setBounds(575,170,450,50);
jl2.setFont(new Font("Lucida Handwriting",Font.ITALIC,20));
contentPane.add(jl2);

JLabel jl3=new JLabel("UserName");
jl3.setBounds(500,245,350,70);
jl3.setFont(new Font("SansSerif",Font.BOLD,15));
contentPane.add(jl3);



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
jtf1.setBounds(590,271,150,20);
add(jtf1);
jtf1.setSelectedIndex(-1);
jtf1.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}






JLabel jl4=new JLabel("Password");
jl4.setBounds (500,285,250,70);
jl4.setFont(new Font("SansSerif",Font.BOLD,15));
contentPane.add(jl4);
jtf2=new JPasswordField(15);
jtf2.setBounds(590,311,150,20);
contentPane.add(jtf2);

JLabel jl5=new JLabel("wrong password:");
jl5.setBounds(300,80,300,55);
contentPane.add(jl5);
jl5.setVisible(false);

JButton jb1=new JButton("Login");
jb1.addActionListener(this);
jb1.setBounds(850,450,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Exit");
jb2.addActionListener(this);
jb2.setBounds(420,450,100,50);
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
ResultSet rs=st.executeQuery("select * from adminlogin1 WHERE UserName="+jtf1);
st.close();
rs.close();
}
catch(Exception e){
}
}}

public void actionPerformed(ActionEvent ae){
String u1="",p1="";
String s=ae.getActionCommand();
String j=jtf1.getSelectedItem().toString();
String p=jtf2.getText();

if(s.equals("Login")){
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="Select*from adminlogin1 where UserName=?";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,j);
ResultSet rs=ps.executeQuery();
while(rs.next()){
u1=rs.getString("UserName");
p1=rs.getString("Password");

if(u1.equals(j)&&p1.equals(p)){
JOptionPane.showMessageDialog(this,"LOGIN SUCCESSFULLY");
home he=new home("HOME");
he.setExtendedState(JFrame.MAXIMIZED_BOTH);
he.setVisible(true);
this.dispose();
}
else{
JOptionPane.showMessageDialog(this,"WRONG PASSWORD");
}}}
catch(Exception e){
System.out.println("Error"+e);
}
}
else if(s.equals("Exit")){
this.dispose();}
}

public static void main(String args[])
{
adminlogin1 a=new adminlogin1("LOGIN");
a.setTitle("ADMIN LOGIN");
a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
a.setVisible(true);
}
}