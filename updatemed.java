import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class updatemed extends JFrame implements ActionListener{
JLabel jl6;
JTextField jtf1,jtf2,jtf3;
JFrame contentPane;

public updatemed(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("Product Name");
jl1.setBounds(200,155,350,50);
contentPane.add(jl1);
jtf1=new JTextField(25);
jtf1.setBounds(310,170,150,20);
contentPane.add(jtf1);

JLabel jl2=new JLabel("Update price");
jl2.setBounds(200,207,350,50);
contentPane.add(jl2);
jtf2=new JTextField(25);
jtf2.setBounds(310,222,150,20);
contentPane.add(jtf2);
/*
JLabel jl3=new JLabel("Update quantity");
jl3.setBounds(200,259,350,50);
contentPane.add(jl3);
jtf3=new JTextField(25);
jtf3.setBounds(310,274,150,20);
contentPane.add(jtf3);
*/                                      
JButton jb1=new JButton("Back");
jb1.addActionListener(this);
jb1.setBounds(155,530,100,50);
contentPane.add(jb1);
contentPane.setSize(790,500);
contentPane.setVisible(true);

JButton jb2=new JButton("Update");
jb2.addActionListener(this);
jb2.setBounds(600,530,100,50);
contentPane.add(jb2);
contentPane.setSize(790,500);
contentPane.setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
if(s.equals("Back"))
{
Medicines a=new Medicines("Medicines");
a.setSize(1500,900);
a.setVisible(true);
}
else if(s.equals("Update"))
{
String jl1=jtf1.getText();
String jl2=jtf2 .getText();
//String jl3=jtf3.getText();

try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="UPDATE Medicine SET price=(?) WHERE productname='jl1'";

System.out.println(jl1);
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,jl1);
//ps.setString(1,jl3);
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
updatemed um=new updatemed("updatemed");
um.setSize(1500,900);
um.setVisible(true);
}}