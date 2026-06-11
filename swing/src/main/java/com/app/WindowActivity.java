package com.app;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowActivity extends JFrame {

	JLabel label_1,label_2;
	JTextField txt1;
	JButton button_1;
	
	public void initComponent()
	{
		label_1 = new JLabel("Enter Name");
		label_2 = new JLabel(" ");
		
		txt1 = new JTextField(20);
		button_1 = new JButton("Say Hello");
		
		//Feb-9 work :: AddActionListener-> Perform print from TextField
		
		button_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String name = txt1.getText();
				label_2.setText("Hello..." + name);
			}
		});
		
		//Feb-9 Lecuture8
		JPanel p1 = new JPanel(new GridLayout(1,5,5,5));
		
		p1.setBorder(BorderFactory.createTitledBorder("My FirstActivity"));
		p1.add(label_1);
		p1.add(txt1);
		p1.add(button_1);
		p1.add(label_2);
		
		
		this.getContentPane().add(p1);
	}
	
	public WindowActivity()  //constructor-> sbse phle initialise hota hai ,islliye initComponent isme call hua hai ,saare tool execute hojaye
	{
		this.initComponent();
		this.setTitle("My First Window");
		this.setLocation(200,200);
		
		this.setVisible(true);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	public static void main(String args[])
	{
		WindowActivity obj = new WindowActivity();
	}
}
