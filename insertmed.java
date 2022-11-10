import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class insertmed extends JFrame implements ActionListener{
JLabel jl1,jl2,jl3,jl4,jl5,jl6;
JTextField jtf1,jtf2,jtf3,jtf4,jtf5;

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
jtf2=new JTextField(25);
jtf2.setBounds(670,222,150,20);
contentPane.add(jtf2);

JLabel jl4=new JLabel("Product Category");
jl4.setBounds(500,259,350,50);
contentPane.add(jl4);
jtf3=new JTextField(25);
jtf3.setBounds(670,274,150,20);
contentPane.add(jtf3);

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
}
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
if(s.equals("Insert"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="INSERT INTO Medicine VALUES(?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,jtf1.getText());
ps.setString(2,jtf2.getText());
ps.setString(3,jtf3.getText());
ps.setString(4,jtf4.getText());
ps.setString(5,jtf5.getText());
ps.executeUpdate();
con.close();
jtf1.setText("");
jtf2.setText("");
jtf3.setText("");
jtf4.setText("");
jtf5.setText("");

JOptionPane.showMessageDialog(this,"Added successfully");
System.out.println("Added");
}
catch(Exception e)
{
System.out.println("Error"+e);
}
}
else if(s.equals("Back")){
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




