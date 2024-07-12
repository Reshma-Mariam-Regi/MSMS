import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class updatemed extends JFrame implements ActionListener,ItemListener{

JTextField jtf2,jtf3;
JComboBox jtf1;

public updatemed(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl4=new JLabel("Update Medicines");
jl4.setBounds(200,100,450,50);
jl4.setFont(new Font("Lucida Handwriting",Font.ITALIC,30));
contentPane.add(jl4);

JLabel jl1=new JLabel("Product Name");
jl1.setBounds(500,207,450,50);
contentPane.add(jl1);

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
jtf1.setBounds(670,222,150,20);
add(jtf1);
jtf1.setSelectedIndex(-1);
jtf1.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}


JLabel jl2=new JLabel("Update quantity");
jl2.setBounds(500,259,350,50);
contentPane.add(jl2);
jtf2=new JTextField(25);
jtf2.setBounds(670,274,150,20);
contentPane.add(jtf2);

JLabel jl3=new JLabel("Update price");
jl3.setBounds(500,311,350,50);
contentPane.add(jl3);
jtf3=new JTextField(25);
jtf3.setBounds(670,326,150,20);
contentPane.add(jtf3);
                                
JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(420,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Update");
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
if(ie.getSource()==jtf1){
try{
String j=jtf1.getSelectedItem().toString();
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from Medicine WHERE productname=\'"+j+"\';");
while(rs.next()){
jtf2.setText(rs.getString("quantity"));
jtf3.setText(rs.getString("price"));
}
st.close();
rs.close();
}
catch(Exception e){
}
}}

public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
if(s.equals("Back"))
{
Medicines med=new Medicines("MEDICINES");
med.setExtendedState(JFrame.MAXIMIZED_BOTH);
med.setVisible(true);
this.dispose();
}
else if(s.equals("Update"))
{

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String j=jtf1.getSelectedItem().toString();
String st="UPDATE Medicine SET quantity=quantity+?,price=? WHERE productname=?";

PreparedStatement ps=con.prepareStatement(st);

ps.setString(1,jtf2.getText());
ps.setString(2,jtf3.getText());
ps.setString(3,j);
ps.executeUpdate();
con.close();
JOptionPane.showMessageDialog(this,"Updated Successfully");
}
catch(Exception e)
{
System.out.println("Error"+e);

}
}
}
public static void main(String args[])
{
updatemed um=new updatemed("UPDATE MEDICINES");
um.setTitle("UPDATE MEDICINES");
um.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
um.setVisible(true);
}}