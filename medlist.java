import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class medlist extends JFrame{

JFrame f;
public medlist(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

f=new JFrame();
Vector colname=new Vector();
Vector data=new Vector();

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String sql="SELECT * FROM Medicine";
PreparedStatement ps=con.prepareStatement(sql);

ResultSet rs=ps.executeQuery();
ResultSetMetaData md=rs.getMetaData();

int col=md.getColumnCount();
for(int i=1;i<=col;i++)
{
colname.addElement(md.getColumnName(i));
}
while(rs.next())
{
Vector row=new Vector(col);
for(int i=1;i<=col;i++)
{
row.addElement(rs.getObject(i));
}
data.addElement(row);
}
JTable table=new JTable(data,colname);
table.setBounds(30,40,200,300);
JScrollPane sp=new JScrollPane(table);
f.add(sp);
f.setExtendedState(JFrame.MAXIMIZED_BOTH);
f.setVisible(true);
}
catch(Exception e)
{
System.out.println(e);
}}


public static void main(String args[]){
medlist ml=new medlist("MEDICINE LIST");
}
}
