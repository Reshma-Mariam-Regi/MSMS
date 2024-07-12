import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class insertmed extends JFrame implements ActionListener,ItemListener{
JLabel jl1,jl2,jl3,jl4,jl5,jl6;
JTextField jtf1,jtf4,jtf5;
JComboBox jtf2,jtf3;

public insertmed(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("Insert Medicines");
jl1.setBounds(200,45,400,76);
jl1.setFont(new Font("Lucida Handwriting",Font.BOLD,29));
contentPane.add(jl1);

JLabel jl2=new JLabel("Product Name");
jl2.setBounds(500,155,350,50);
contentPane.add(jl2);
jtf1=new JTextField(25);
jtf1.setBounds(670,170,150,20);
contentPane.add(jtf1);

JLabel jl3=new JLabel("Company Name");
jl3.setBounds(500,207,350,50);
contentPane.add(jl3);

try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select CompanyName from Company");
Vector v=new Vector();
while(rs.next()){
String us=rs.getString(1);
v.add(us);
}
jtf2=new JComboBox(v);	
jtf2.setBounds(670,222,150,20);
add(jtf2);
jtf2.setSelectedIndex(-1);
jtf2.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}

JLabel jl4=new JLabel("Product Category");
jl4.setBounds(500,259,350,50);
contentPane.add(jl4);

try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select productcategory from PC");
Vector v=new Vector();
while(rs.next()){
String us=rs.getString(1);
v.add(us);
}
jtf3=new JComboBox(v);	
jtf3.setBounds(670,274,150,20);
add(jtf3);
jtf3.setSelectedIndex(-1);
jtf3.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}

JLabel jl5=new JLabel("Product Quantity");
jl5.setBounds(500,311,350,50);
contentPane.add(jl5);
jtf4=new JTextField(25);
jtf4.setBounds(670,326,150,20);
contentPane.add(jtf4);

JLabel jl6=new JLabel("Product Price");
jl6.setBounds(500,363,350,50);
contentPane.add(jl6);
jtf5=new JTextField(25);
jtf5.setBounds(670,378,150,20);
contentPane.add(jtf5);

JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(420,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Insert");
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

public void itemStateChanged(ItemEvent ie){
if(ie.getSource()==jtf2){
try{
String j=jtf2.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Company WHERE CompanyName="+jtf2);
st.close();
rs.close();
}
catch(Exception e){
}
}
else if(ie.getSource()==jtf3){
try{
String j=jtf3.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from PC WHERE productcategory="+jtf3);
st.close();
rs.close();
}
catch(Exception e){
}
}}

public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
if(s.equals("Insert"))
{
String a=jtf2.getSelectedItem().toString();
String b=jtf3.getSelectedItem().toString();
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="INSERT INTO Medicine VALUES(?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,jtf1.getText());
ps.setString(2,a);
ps.setString(3,b);
ps.setString(4,jtf4.getText());
ps.setString(5,jtf5.getText());
ps.executeUpdate();
con.close();
JOptionPane.showMessageDialog(this,"Added successfully");
System.out.println("Added");
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
else if(s.equals("Back")){
Medicines med=new Medicines("MEDICINES");
med.setExtendedState(JFrame.MAXIMIZED_BOTH);
med.setVisible(true);
this.dispose();
}

}
public static void main(String args[])
{
insertmed a=new insertmed("INSERT MEDICINES");
a.setTitle("INSERT MEDICINES");
a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
a.setVisible(true);
}
}