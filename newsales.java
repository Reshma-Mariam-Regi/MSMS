import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newsales extends JFrame implements ActionListener,ItemListener
{
JTextField jtf2,jtf3,jtf4,jtf5,jtf6,jtf7;
JComboBox jtf1;
JTextArea jta,jta1,jta2,jta3,jta4;

public newsales(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("New Sales...");
jl1.setBounds(200,100,450,50);
jl1.setFont(new Font("Lucida Handwriting",Font.ITALIC,30));
contentPane.add(jl1);

JLabel jl2=new JLabel("Product Name");
jl2.setBounds(300,207,450,50);
contentPane.add(jl2);

try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select productname from Medicine");
Vector v=new Vector();
while(rs.next()){
String uf=rs.getString(1);
v.add(uf);
}
jtf1=new JComboBox(v);	
jtf1.setBounds(470,222,150,20);
add(jtf1);
jtf1.setSelectedIndex(-1);
jtf1.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}

JLabel jl3=new JLabel("Enter Quantity");
jl3.setBounds(300,259,350,50);
contentPane.add(jl3);
jtf2=new JTextField(25);
jtf2.setBounds(470,274,150,20);
contentPane.add(jtf2);

jtf4=new JTextField(25);
jtf4.setBounds(570,300,55,20);
//contentPane.add(jtf4);

jtf5=new JTextField(25);
jtf5.setBounds(770,300,55,20);
//contentPane.add(jtf5);

jtf6=new JTextField(25);
jtf6.setBounds(630,274,55,20);
jtf6.setText("$ ");
contentPane.add(jtf6);

jtf7=new JTextField(25);
jtf7.setBounds(630,300,50,20);
//contentPane.add(jtf7);

JButton jb1=new JButton("Add to Cart");
jb1.addActionListener(this);
jb1.setBounds(740,230,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Total");
jb2.addActionListener(this);
jb2.setBounds(950,235,80,30);
contentPane.add(jb2);
contentPane.setSize(790,500);
contentPane.setVisible(true);
jtf3=new JTextField(15);
jtf3.setBounds(1035,235,90,30);
contentPane.add(jtf3);

JButton jb3=new JButton("Print");
jb3.addActionListener(this);
jb3.setBounds(1000,600,100,50);
contentPane.add(jb3);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb4=new JButton("Back");
jb4.addActionListener(this);
jb4.setBounds(200,600,100,50);
contentPane.add(jb4);
contentPane.setSize(790,500);
contentPane.setVisible(true);

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
Date date=new Date();
JLabel dt=new JLabel(formatter.format(date));
dt.setBounds(1100,20,200,90);
dt.setFont(new Font("Serif",Font.BOLD,20));
contentPane.add(dt);

JLabel data=new JLabel("Product                                        "+"Company                                                       "+"Category               "+"Quantity"+"          Price");
data.setBounds(180,320,1000,50);
data.setFont(new Font("Serif",Font.BOLD,20));
contentPane.add(data);

jta=new JTextArea();
jta.setSize(260,170);
jta.setFont(new Font("Serif",Font.PLAIN,20));
jta.setLocation(170,370);
jta.setBackground(Color.pink);
jta.setLineWrap(true);
jta.setEditable(false);
contentPane.add(jta);

jta1=new JTextArea();
jta1.setSize(365,170);
jta1.setFont(new Font("Serif",Font.PLAIN,20));
jta1.setLocation(430,370);
jta1.setBackground(Color.pink);
jta1.setLineWrap(true);
jta1.setEditable(false);
contentPane.add(jta1);

jta2=new JTextArea();
jta2.setSize(150,170);
jta2.setFont(new Font("Serif",Font.PLAIN,20));
jta2.setLocation(795,370);
jta2.setBackground(Color.pink);
jta2.setLineWrap(true);
jta2.setEditable(false);
contentPane.add(jta2);

jta3=new JTextArea();
jta3.setSize(130,170);
jta3.setFont(new Font("Serif",Font.PLAIN,20));
jta3.setLocation(945,370);
jta3.setBackground(Color.pink);
jta3.setLineWrap(true);
jta3.setEditable(false);
contentPane.add(jta3);

jta4=new JTextArea();
jta4.setSize(70,170);
jta4.setFont(new Font("Serif",Font.PLAIN,20));
jta4.setLocation(1075,370);
jta4.setBackground(Color.pink);
jta4.setLineWrap(true);
jta4.setEditable(false);
contentPane.add(jta4);

setLayout(new BorderLayout());
JLabel img=new JLabel(new ImageIcon("D://download.jfif"));
//JLabel img=new JLabel(new ImageIcon("C://Users//hp//Downloads//download.jfif"));
img.setBounds(0,0,900,900);
contentPane.add(img);
img.setLayout(new FlowLayout());
}

public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==jtf1){
try{
String j=jtf1.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Medicine WHERE productname=\'"+j+"\';");
while(rs.next()){
jtf4.setText(rs.getString("companyname"));
jtf5.setText(rs.getString("productcategory"));
jtf2.setText(rs.getString("quantity"));
jtf6.setText("$  "+rs.getString("price"));
}
st.close();
rs.close();
}
catch(Exception e){
}
}}
	
public void actionPerformed(ActionEvent ae){

String s=ae.getActionCommand();
if(s.equals("Add to Cart")){

try
{
String j=jtf1.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
java.util.Date ddtt=new java.util.Date();
java.sql.Date sqlDate=new java.sql.Date(ddtt.getTime());

String st="INSERT INTO viewsalesrecord VALUES(?,?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
String st1="UPDATE Medicine SET quantity=quantity-? WHERE productname=?";
PreparedStatement ps1=con.prepareStatement(st1);
String st2="UPDATE viewsalesrecord SET price=price*? WHERE productname=?";
PreparedStatement ps2=con.prepareStatement(st2);

ps.setDate(1,sqlDate);
ps.setString(2,jtf1.getSelectedItem().toString());
ps.setString(3,jtf4.getText());
ps.setString(4,jtf5.getText());
ps.setString(5,jtf2.getText());
ps.setString(6,jtf6.getText());
ps.executeUpdate();

ps1.setString(1,jtf2.getText());
ps1.setString(2,j);
ps1.executeUpdate();

ps2.setString(1,jtf2.getText());
ps2.setString(2,j);
ps2.executeUpdate();

Statement st3=con.createStatement();
ResultSet rs=st3.executeQuery("select * from viewsalesrecord WHERE productname=\'"+j+"\';");
while(rs.next()){
jtf7.setText(rs.getString("price"));}

st3.close();
rs.close();
con.close();
}
catch(Exception e){
System.out.println("Error="+e);
}

try
{
String j=jtf1.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st4="INSERT INTO newsale VALUES(?,?)";
PreparedStatement ps3=con.prepareStatement(st4);

ps3.setString(1,jtf1.getSelectedItem().toString());
ps3.setString(2,jtf7.getText());
ps3.executeUpdate();
con.close();
}
catch(Exception e){
System.out.println("Error="+e);
}

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
jta.append("  "+jtf1.getSelectedItem().toString()+"\n");
jta1.append(jtf4.getText()+"\n");
jta2.append("   "+jtf5.getText()+"\n");
jta3.append("      "+jtf2.getText()+"\n");
jta4.append("  "+jtf7.getText()+"\n");

jtf1.setSelectedItem(null);
jtf2.setText("");
jtf6.setText("");

con.close();
System.out.println("done");
}
catch(Exception e){
System.out.println("Error="+e);
}
}

else if(s.equals("Back")){
home he=new home("HOME");
he.setExtendedState(JFrame.MAXIMIZED_BOTH);
he.setVisible(true);
this.dispose();
}

else if(s.equals("Total")){
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st=" SELECT SUM(total) FROM newsale";
Statement ps=con.createStatement();
ResultSet rs=ps.executeQuery(st);
while(rs.next()){
jtf3.setText(rs.getString(1));
}
ps.close();
rs.close();
}
catch(Exception e){
System.out.println("Error="+e);
}
}

else if(s.equals("Print"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="DELETE FROM newsale";
PreparedStatement ps=con.prepareStatement(st);
ps.executeUpdate();
jtf3.setText("");
jta.setText(null);
jta1.setText(null);
jta2.setText(null);
jta3.setText(null);
jta4.setText(null);
con.close();
JOptionPane.showMessageDialog(this,"Printing bill...");
}
catch(Exception e){
System.out.println("Error="+e);
}
}

}
public static void main(String args[]){
newsales ns=new newsales("NEW SALES");
ns.setTitle("NEW SALES");
ns.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ns.setVisible(true);
}}