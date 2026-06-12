package com.app;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SearchActivity extends JFrame {
	
	JComboBox cmb1;
	JLabel label1,label2;
	Connection cn;
	
	public void initComponents()
	{
		cmb1 = new JComboBox();
		cmb1.addItem("-selected employee name-");
		label1 = new JLabel("-Employee Name");
		label2 = new JLabel("-Employee Salary-");
		
		JPanel p1 = new JPanel(new GridLayout(1,3,5,5));
		p1.setBorder(BorderFactory.createTitledBorder("Search Panel"));
		
		p1.add(cmb1);
		p1.add(label1);
		p1.add(label2);
		
		this.getContentPane().add(p1);	
	}
	
	public void initEvent()
	{
		this.addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e)
			{
				openConnection();
			}
			public void windowClosing(WindowEvent e)
			{
				closeConnection();
			}
		});
		
		cmb1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e)
			{
				if(cmb1.getSelectedIndex() != 0)
					if(cmb1.getSelectedItem().equals(e.getItem()))
					{
						int code = Integer.parseInt("" + cmb1.getSelectedItem());
					     searchEmployee(code);
					}
			}
		});
	}
	
	public SearchActivity() 
	{
		this.initComponents();
		this.initEvent();
		this.setTitle("My Window");
		this.setLocation(200,200);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	
	public static void main(String args[])
	{
		 SearchActivity obj = new  SearchActivity ();
//		 obj.searchActivity();
	}
	
	public void openConnection()
	{
		try {
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mlk?autoReconnet=true&useSSL=false","root","boot");
			
			if(!cn.isClosed()) {
				
//				label1.setText("Database");
//				label2.setText("Connected");
			   
				PreparedStatement ps = cn.prepareStatement("select code from employee");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					cmb1.addItem(rs.getString(1));
				}
			}
		}catch(Exception e){
			}
	}
	
	public void closeConnection()
	{
		try {
			if(!cn.isClosed()) {
				cn.close();
			}
		}
		
		catch(Exception e) {
			}
	}
	
	public void searchEmployee(int code)
	{
		try {
			PreparedStatement ps = cn.prepareStatement("select * from employee where code=?");
			ps.setInt(1, code);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				label1.setText(rs.getString(2));
				label2.setText(rs.getString(3));
			}
		}
		
		catch(Exception e)
		{
		}
	}

}
