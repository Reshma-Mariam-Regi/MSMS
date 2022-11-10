import java.awt.Color;
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class home extends JFrame implements ActionListener{

JLabel jl1;
JButton medicineBtn;
JButton companyBtn;
JButton viewsalesrecordBtn;
JButton newsalesBtn;
JButton ChangeBtn;
JButton newadminBtn;
JButton logoutBtn;

public home(String n)
{
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

JLabel jl1=new JLabel("MEDICAL STORE MANAGEMENT SYSTEM");
jl1.setForeground(Color.black);
jl1.setFont(new Font("serif",Font.BOLD,24));
jl1.setBounds(400,50,520,50);
contentPane.add(jl1);

medicineBtn=new JButton("MEDICINE");
medicineBtn.addActionListener(this);
medicineBtn.setBounds(400,200,180,50);
contentPane.add(medicineBtn);

companyBtn=new JButton("COMPANY");
companyBtn.addActionListener(this);
companyBtn.setBounds(700,200,180,50);
contentPane.add(companyBtn);

viewsalesrecordBtn=new JButton("VIEW SALES RECORD");
viewsalesrecordBtn.addActionListener(this);
viewsalesrecordBtn.setBounds(400,300,180,50);
contentPane.add(viewsalesrecordBtn);

newsalesBtn=new JButton("NEW SALES");
newsalesBtn.addActionListener(this);
newsalesBtn.setBounds(700,300,180,50);
contentPane.add(newsalesBtn);

ChangeBtn=new JButton("CHANGE PASSWORD");
ChangeBtn.addActionListener(this);
ChangeBtn.setBounds(550,400,180,50);
contentPane.add(ChangeBtn);

newadminBtn=new JButton("NEW ADMIN");
newadminBtn.addActionListener(this);
newadminBtn.setBounds(400,500,180,50);
contentPane.add(newadminBtn);

logoutBtn=new JButton("LOGOUT");
logoutBtn.addActionListener(this);
logoutBtn.setBounds(700,500,180,50);
contentPane.add(logoutBtn);

}
public void actionPerformed(ActionEvent ae)
{

Object source =ae.getSource();
if(source==medicineBtn)
{
Medicines med=new Medicines("MEDICINES");
med.setExtendedState(JFrame.MAXIMIZED_BOTH);
med.setVisible(true);
}

else if (source==companyBtn)
{
Company com=new Company("COMPANY");
com.setExtendedState(JFrame.MAXIMIZED_BOTH);
com.setVisible(true);
}

/*
else if(source==viewsalesrecordBtn)
{
viewsalesrecord.main(new String[]{});
contentPane.dispose();
}
*/
/*
else if(source==newsalesBtn)
{
newsales.main(new String[]{});
contentPane.dispose();
*/
else if(source==ChangeBtn)
{
changepw cp=new changepw("CHANGE PASSWORD");
cp.setExtendedState(JFrame.MAXIMIZED_BOTH);
cp.setVisible(true);
}

else if(source==newadminBtn)
{
newadmin na=new newadmin("NEW ADMIN");
na.setExtendedState(JFrame.MAXIMIZED_BOTH);
na.setVisible(true);
}

else if(source==logoutBtn)
{
this.dispose();
}


}
public static void main(String args[])
{
home h=new home("home");
h.setTitle("HOME");
h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
h.setVisible(true);
}
}





