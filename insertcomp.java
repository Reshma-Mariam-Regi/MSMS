import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class insertcomp extends JFrame implements ActionListener{
JLabel jl1,jl2,jl3,jl4,jl5,jl6;
JTextField jtf1,jtf2,jtf3,jtf4,jtf5;

public insertcomp(String n){
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("Insert Company");
jl1.setBounds(200,45,400,76);
jl1.setFont(new Font("Lucida Handwriting",Font.BOLD,29));
contentPane.add(jl1);

JLabel jl2=new JLabel("Company Name");
jl2.setBounds(500,155,350,50);
contentPane.add(jl2);
jtf1=new JTextField(25);
jtf1.setBounds(670,170,150,20);
contentPane.add(jtf1);

JLabel jl3=new JLabel("Country");
jl3.setBounds(500,207,350,50);
contentPane.add(jl3);
jtf2=new JTextField(25);
jtf2.setBounds(670,222,150,20);
contentPane.add(jtf2);

JLabel jl4=new JLabel("Email");
jl4.setBounds(500,259,350,50);
contentPane.add(jl4);
jtf3=new JTextField(25);
jtf3.setBounds(670,274,150,20);
contentPane.add(jtf3);

JLabel jl5=new JLabel("Contact no.");
jl5.setBounds(500,311,350,50);
contentPane.add(jl5);
jtf4=new JTextField(25);
jtf4.setBounds(670,326,150,20);
contentPane.add(jtf4);

JLabel jl6=new JLabel("Address");
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
public void actionPerformed(ActionEvent ae)
{
String s=ae.getActionCommand();
if(s.equals("Insert"))
{
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:MSMS","","");
String st="INSERT INTO Company VALUES(?,?,?,?,?)";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1,jtf1.getText());
ps.setString(2,jtf2.getText());
ps.setString(3,jtf3.getText());
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
Company com=new Company("COMPANY");
com.setExtendedState(JFrame.MAXIMIZED_BOTH);
com.setVisible(true);
this.dispose();
}

}
public static void main(String args[])
{
insertcomp a=new insertcomp("INSERT COMPANY");
a.setTitle("INSERT COMPANY");
a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
a.setVisible(true);
}
}