import java.awt.Color;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Company extends JFrame implements ActionListener
{
JLabel jl1;
JButton complistBtn;
JButton insertcompBtn;
JButton deletecompBtn;
JButton updatecompBtn;
JButton backBtn;

public Company(String n)
    {
super(n);
Container contentPane=getContentPane();
contentPane.setLayout(null);

        JLabel jl1=new JLabel("COMPANY");
       jl1.setForeground(Color.black);
        jl1.setBounds(150,100,300,50);
        jl1.setFont(new Font("Bell MT",Font.BOLD,35));
           contentPane.add(jl1);

        complistBtn=new JButton("Company List");
        complistBtn.addActionListener(this);
         complistBtn.setBounds(500,200,300,50);
            contentPane.add(complistBtn);

            insertcompBtn=new JButton("Insert Company");
               insertcompBtn.addActionListener(this);
             insertcompBtn.setBounds(500,300,300,50);
         contentPane.add( insertcompBtn);

        deletecompBtn=new JButton("Delete Company");
        deletecompBtn.addActionListener(this);
           deletecompBtn.setBounds(500,400,300,50);
           contentPane.add(deletecompBtn);

             updatecompBtn=new JButton("Update Company");
           updatecompBtn.addActionListener(this);
            updatecompBtn.setBounds(500,500,300,50);
            contentPane.add(updatecompBtn);

             backBtn=new JButton("Back");
           backBtn.addActionListener(this);
            backBtn.setBounds(800,600,300,50);
            contentPane.add(backBtn);

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
Object source=ae.getSource();

if(source==complistBtn)
{
complist cl=new complist("COMPANY LIST");
}

else if (source==insertcompBtn)
{
insertcomp ic=new insertcomp("INSERT COMPANY");
ic.setExtendedState(JFrame.MAXIMIZED_BOTH);
ic.setVisible(true);
this.dispose();
}

else if(source==updatecompBtn)
{
updatecomp uc=new updatecomp("UPDATE COMPANY");
uc.setExtendedState(JFrame.MAXIMIZED_BOTH);
uc.setVisible(true);
this.dispose();
}

else if(source==deletecompBtn)
{
deletecomp dc=new deletecomp("DELETE COMPANY");
dc.setExtendedState(JFrame.MAXIMIZED_BOTH);
dc.setVisible(true);
this.dispose();
}

else if(source==backBtn)
{
home he=new home("HOME");
he.setExtendedState(JFrame.MAXIMIZED_BOTH);
he.setVisible(true);
this.dispose();
}
}

    public static void main(String args[]){
       Company obj=new Company("Company");
obj.setTitle("COMPANY");
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
obj.setVisible(true);
    }
}