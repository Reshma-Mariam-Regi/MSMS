import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class deletemed extends JFrame implements ActionListener,ItemListener{
JLabel jl1,jl2;
JComboBox jtf1;

public deletemed(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("Delete Medicines");
jl1.setBounds(200,45,400,76);
jl1.setFont(new Font("Lucida Handwriting",Font.BOLD,29));
contentPane.add(jl1);

JLabel jl2=new JLabel("Product Name");
jl2.setBounds(500,259,350,50);
contentPane.add(jl2);

try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select productname from Medicine");
Vector v=new Vector();
while(rs.next()){
String us=rs.getString(1);
v.add(us);
}
jtf1=new JComboBox(v);	
jtf1.setBounds(670,274,150,20);
add(jtf1);
jtf1.setSelectedIndex(-1);
jtf1.addItemListener(this);
st.close();
rs.close();
}
catch (Exception e){
}

JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(420,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Delete");
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
ResultSet rs=st.executeQuery("select * from Medicine WHERE productname="+jtf1);
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

else if(s.equals("Delete"))
{
String jl2=jtf1.getSelectedItem().toString();
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="DELETE FROM Medicine WHERE productname=?";

PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,jl2);
ps.executeUpdate();
con.close();

JOptionPane.showMessageDialog(this,"Deleted Successfully");
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
}
public static void main(String args[])
{
deletemed dm=new deletemed("DELETE MEDICINES");
dm.setTitle("DELETE MEDICINES");
dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
dm.setVisible(true);
}}