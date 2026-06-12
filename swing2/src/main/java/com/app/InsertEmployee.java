
package com.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertEmployee extends JFrame {

	JLabel label_1,label_2,label_3;
	JButton button_1,button_2;
	JTextField txt1,txt2;
	Connection cn;
	
	public void initComponents()
	{
		label_1 = new JLabel("Enter Name");
		label_2 = new JLabel("Enter Salary");
		
		label_3 = new JLabel("OUTPUT AREA");	
		label_3.setHorizontalAlignment(JLabel.CENTER);
		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		
		button_1 = new JButton("Insert");
		button_2 = new JButton("Reset");
		
		JPanel p1 = new JPanel(new GridLayout(3,2,5,5));
		p1.setBorder(BorderFactory.createTitledBorder("Insertion Panel"));
		
		p1.add(label_1);
		p1.add(txt1);
		
		p1.add(label_2);
		p1.add(txt2);
		
		p1.add(button_1);
     	p1.add(button_2);
     	
     	
     	
     	JPanel p2 = new JPanel(new GridLayout(1,1,5,5));
     	p2.setBorder(BorderFactory.createTitledBorder("Output panel"));
		
     	p2.add(label_3);
     	
     	
     	this.getContentPane().add(BorderLayout.NORTH,p1);
     	this.getContentPane().add(BorderLayout.SOUTH,p2);
		
	}
	
	
	public void initEvent()
	{
		this.addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent e) {
				openConnection();
			}
			
			public void windowClosing(WindowEvent e)
			{
				closingConnection();
			}
		});
		
		button_1.addActionListener(new ActionListener()
				{
			      public void actionPerformed(ActionEvent e)
			      {
			    	  insertEmployee();
			      }
				});
		button_2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						reset();
					}
				});
	}
	public InsertEmployee()
	{
		this.initComponents();
		this.initEvent();
		this.setTitle(" Employee Window");
		this.setLocation(200,200);
		
		this.setVisible(true);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public static void main(String args[])
	{
		InsertEmployee obj = new InsertEmployee();
	}
	
	
		public void openConnection()
		{
			try {
				 cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnect=true&useSSL=false","root","boot");
				
				if(!cn.isClosed())
				{
					label_3.setText("Database Connected");
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Reason for error::" + e.getMessage());
			}
		}
		
		public void closingConnection()
		{
			try {
				if(!cn.isClosed())
				{
					cn.close();
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Reason for error :: " + e.getMessage());
			}
		}
		
		public void insertEmployee() {
			try {
				if(txt1.getText().length() > 0 && txt2.getText().length() > 0)
				{
					String name = txt1.getText();
					double salary = Double.parseDouble(txt2.getText());
					
					PreparedStatement ps = cn.prepareStatement("insert into employee(name,salary) values(?,?)");
					ps.setString(1,name);
					ps.setDouble(2, salary);
					int a = ps.executeUpdate();
					if(a > 0)
					{
						label_3.setText("Record Inserted");
					}
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null,"Reason for error :: " + e.getMessage());
			}
		}
		
		public void reset()
		{
			txt1.setText(" ");
			txt2.setText(" ");
			label_3.setText("Insert Next");
		}
	}

