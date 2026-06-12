package com.app;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class RadioWindow extends JFrame {

	JLabel label_1,label_2;
	JRadioButton rdb1,rdb2;
	
	ButtonGroup bgroup;
	
	
	public void initComponent()
	{
		bgroup = new ButtonGroup();
		label_1 = new JLabel("Capital of India");
		label_2 = new JLabel("");
		
		rdb1 = new JRadioButton("Lucknow");
		rdb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if(rdb1.isSelected());
				label_2.setText("Wrong Anser");
					
			}
		});
		

		rdb2 = new JRadioButton("Delhi");
		rdb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e)
			{
				if(rdb2.isSelected());
				label_2.setText("Right Anser");
					
			}
		});
		bgroup.add(rdb1);
		bgroup.add(rdb2);
		
	
		
		JPanel p1 = new JPanel(new GridLayout(1,4,5,5));
		p1.setBorder(BorderFactory.createTitledBorder("Capital Panel"));
		
		p1.add(label_1);
		
		p1.add(rdb1);
		p1.add(rdb2);
		
		p1.add(label_2);
		
		this.getContentPane().add(p1);
		
	
	}
	
	public RadioWindow()
	{
		this.initComponent();
		this.setTitle("My Window");
		this.setLocation(200,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	
	public static void main(String args[])
	{
		RadioWindow obj = new RadioWindow();
	}
	
}
