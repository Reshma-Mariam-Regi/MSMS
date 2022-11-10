import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class deletemed extends JFrame implements ActionListener{
JLabel jl1,jl2;
JTextField jtf1;

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
jtf1=new JTextField(25);
jtf1.setBounds(670,274,150,20);
contentPane.add(jtf1);

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
}

public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
if(s.equals("Back"))
{
this.dispose();
}

else if(s.equals("Delete"))
{
String jl2=jtf1.getText();
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