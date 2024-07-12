import java.awt.event.*;
import java.lang.*;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.util.*;
public class complist extends JFrame{

JFrame f;
public complist(String n){
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
String sql="SELECT * FROM Company";
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
table.setBounds(1000,1000,1000,1000);
JScrollPane sp=new JScrollPane(table);
f.add(sp);
f.setExtendedState(JFrame.MAXIMIZED_BOTH);
f.setSize(1920,1080);
f.setVisible(true);
}
catch(Exception e)
{
System.out.println(e);
}}


public static void main(String args[]){
complist ml=new complist("COMPANY LIST");
}
}