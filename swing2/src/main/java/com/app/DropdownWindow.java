package com.app;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DropdownWindow extends JFrame {

	JLabel label_1,label_2;
	JComboBox cmb1;
	
	public void initComponents()
	{
		label_1 = new JLabel("BIGGEST DEMOCRATIC");
		label_2 = new JLabel("");
		cmb1 = new JComboBox(new String[] {"-select country-","Srilanka","China","America","India","Australia","Russia"});
		
		cmb1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(cmb1.getSelectedIndex()!=0)
				{
					if(cmb1.getSelectedItem().equals(e.getItem() + ""))
					{
						//JOptionPane.showMessageDialog(null,"This selected Item::" + cmb1.getSelectedItem());
						
						if(cmb1.getSelectedItem().equals("India")) 
						 {
							label_2.setText("Right Answer");
						 }
						else {
							label_2.setText("Wrong Answer");
						}
					}
				}
			}
		});;
	
	
	JPanel p1 = new JPanel(new GridLayout(1,3,5,5));
	p1.setBorder(BorderFactory.createTitledBorder("Selection Panel"));
	p1.add(label_1);
	p1.add(cmb1);
	p1.add(label_2);
	
	this.getContentPane().add(p1);
	
	}
	public DropdownWindow() {
		
		this.initComponents();
		this.setTitle("Dropdown Demo");
		this.setLocation(200,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	public static void main(String args[])
	{
		DropdownWindow obj = new DropdownWindow();
	}
}
