package com.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProjectActivity extends JFrame {

	JLabel label_1, label_2,label_3,label_4;
	JTable table_1;
	JButton button_1,button_2,button_3,button_4;
	JTextField txt1,txt2,txt3,txt4;
	
	DefaultTableModel model;
	
	Connection cn;
	
	public void initComponents() {
		
		label_1 = new JLabel("CODE");
		label_1.setHorizontalAlignment(JLabel.CENTER);
		
		label_2 = new JLabel("NAME"); 
		label_2.setHorizontalAlignment(JLabel.CENTER);

		label_3 = new JLabel("SALARY");
		label_3.setHorizontalAlignment(JLabel.CENTER);
		
		label_4 = new JLabel("SEARCH BY NAME");
		
		model = new DefaultTableModel();
		
		model.addColumn("CODE");
		model.addColumn("NAME");
		model.addColumn("SALARY");
		
		table_1 = new JTable(model);
		table_1.setPreferredScrollableViewportSize(new Dimension(450,250)); //width and height
		
		button_1 = new JButton("Insert");
		button_2 = new JButton("Update");
		button_3 = new JButton("Delete");
		button_4 = new JButton("Report");
		
		txt1 = new JTextField(20); 
		txt1.setEditable(false);
		txt2 = new JTextField(20); 
		txt3 = new JTextField(20); 
		txt4 = new JTextField(20); 
		
		JPanel p1 = new JPanel(new GridLayout(3,3,5,5));
		p1.setBorder(BorderFactory.createTitledBorder("Operation Panel"));
		
		p1.add(label_1);
		p1.add(label_2);
		p1.add(label_3);

		
		p1.add(txt1);
		p1.add(txt2);
		p1.add(txt3);
		
		p1.add(button_1);
		p1.add(button_2);
		p1.add(button_3);
		
		
		JPanel p2 = new JPanel(new GridLayout(1,1,5,5));
		p2.setBorder(BorderFactory.createTitledBorder("Display Panel"));
		
		p2.add(new JScrollPane(table_1));
		
		JPanel p3 = new JPanel(new GridLayout(1,3,5,5));
		p3.setBorder(BorderFactory.createTitledBorder("Report Panel"));
		
		p3.add(label_4);
		p3.add(txt4);
		p3.add(button_4);
		
		this.getContentPane().add(BorderLayout.NORTH,p1);
		this.getContentPane().add(BorderLayout.CENTER,p2);
		this.getContentPane().add(BorderLayout.SOUTH,p3);
	}
	
	
	public void initEvent()
	{
		this.addWindowListener(new WindowAdapter() {
			
			public void windowOpened(WindowEvent e)
			{
				openConnection();
				showRecords("select * from employee");
			}
			
			public void windowClosing(WindowEvent e)
			{
				closeConnection();
			}
		});
		
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				insertEmployee();
				
			}
		});
		

		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updateEmployee();
				
			}
		});
		
		table_1.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e)
			{
				int row = table_1.getSelectedRow();
				
				String code = "" + table_1.getValueAt(row, 0);
				String name= "" + table_1.getValueAt(row, 1);
				String salary = "" + table_1.getValueAt(row, 2);

				txt1.setText(code);
				txt2.setText(name);
				txt3.setText(salary);

			}
		});
		
		button_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e)
			{
				deleteEmployee();
			}
		});
		
		
		txt4.addKeyListener(new KeyAdapter(){
			@Override
			 public void keyReleased(KeyEvent e)
			{
				String name = txt4.getText();
				String sql = "select * from employee where name like '%"+ name +"%'";
				showRecords(sql);
			}
		});
		
		button_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				reportGeneration("select * from employee");
			}
		
		});
		
	}
	
	
	public ProjectActivity() {

		this.initComponents();
		this.initEvent();
		this.setTitle("Dropdown Demo");
		this.setLocation(200,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();

	}
	
	public static void main(String args[])
	{
		ProjectActivity obj = new ProjectActivity();
	}
	
	public void openConnection()
	{
		try {
			String url = "jdbc:mysql://127.0.0.1/mlk?autoReconnect=true&useSSL=false";
			String username = "root";
			String password = "boot";
			cn = DriverManager.getConnection(url,username,password);
			
			if(!cn.isClosed())
			{
				
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Reason fo error::" + e.getMessage());
		}
	}
	
	public void closeConnection()
	{
		try {
			
			if(!cn.isClosed())
			{
				cn.close();
			}
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Reason fo error::" + e.getMessage());
		}
	}
	
	
	public void showRecords(String sql)
	{
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Vector colnames = new Vector();
			Vector records = new Vector();
			
			
			for(int i=1; i<=rs.getMetaData().getColumnCount(); i++)
			{
				colnames.add(rs.getMetaData().getColumnLabel(i));
			}
			
			
			while(rs.next())
			{
				Vector temp = new Vector();
				for(int i=1; i<=rs.getMetaData().getColumnCount(); i++)
				{
					temp.add(rs.getString(i));
				}
				
				records.add(temp);
			}
			
			model.setDataVector(records,colnames);
			table_1.setModel(model);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Reason fo error::" + e.getMessage());

		}
	}
	
	//insert method
	public void insertEmployee()
	{
		try {
			String name = txt2.getText();
			double salary = Double.parseDouble(txt3.getText());
			
			PreparedStatement ps = cn.prepareStatement("insert into employee(name,salary) values(?,?)");
			ps.setString(1, name);
			ps.setDouble(2, salary);
			
			int a = ps.executeUpdate();
			if(a>0)
			{
				showRecords("select * from employee");
				txt2.setText("");
				txt2.setText("");
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	//update method
	public void updateEmployee()
	{
		try {
			int code = Integer.parseInt(txt1.getText());
			String name = txt2.getText();
			double salary = Double.parseDouble(txt3.getText());

			
			PreparedStatement ps = cn.prepareStatement("update employee set name=?,salary=? where code=?");
			
			ps.setString(1, name);
			ps.setDouble(2, salary);
			ps.setInt(3, code);
			
			int a = ps.executeUpdate();
			if(a>0)
			{
				showRecords("select * from employee");
				txt2.setText("");
				txt3.setText("");
			}
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	//delete method
	public void deleteEmployee()
	{
		try {
			int code = Integer.parseInt(txt1.getText());
			
			PreparedStatement ps = cn.prepareStatement("delete from employee where code=?");
			ps.setInt(1, code);
			
			int a = ps.executeUpdate();
			if(a>0) {
				showRecords("select * from employee");
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	
	//report generation file
	
	public void reportGeneration(String sql)
	{
		try {
			
			PreparedStatement ps = cn.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			
			//converting in html
			
			String str="";
			
			str+="<html>";
			  str+="<body>";
			    
			     str+="<table cellpadding=10 width=70% bgcolor=lightyellow align=center>";
			     
			     str+="<tr bgcolor=blue>";
			     for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
			     {
			    	 str+="<th><font color=white>" + rs.getMetaData().getColumnLabel(i) + "</font></th>";
			    	 
			     }
		    	 str+="</tr>";

			     
			     while(rs.next())
			     {
			    	 str+="<tr>";
			    	 for(int i=1; i<=rs.getMetaData().getColumnCount();i++)
			    	 {
			    		 str+="<td>" + rs.getString(i) + "</td>";
			    	 }
			    	 str+="</tr>";
			     }
			  str+="</body>";

			str+="</html>";
			
			
			//Creating File to showing on web
			
			File file = new File("Report.html");
			
			OutputStream ous = new FileOutputStream(file);
			
			ous.write(str.getBytes());
			ous.close();
		    file.deleteOnExit();
		    
		    
		    Runtime r = Runtime.getRuntime();
		    
		    Process p = r.exec("C:\\Program Files\\Internet Explorer\\iexplore.exe " + file.getAbsolutePath());
			
			
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Reason for error:" + e.getMessage());
		}
	}


} 