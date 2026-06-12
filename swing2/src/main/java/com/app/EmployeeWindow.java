package com.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmployeeWindow extends JFrame {

	JLabel label_1,label_2,label_3;
	JButton button_1,button_2;
	JTextField txt1,txt2;
	
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
	
	public EmployeeWindow()
	{
		this.initComponents();
		this.setTitle(" Employee Window");
		this.setLocation(200,200);
		
		this.setVisible(true);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
	}
	
	public static void main(String args[])
	{
		EmployeeWindow obj = new EmployeeWindow();
	}
}
