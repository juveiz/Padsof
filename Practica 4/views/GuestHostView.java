package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import user.RegisteredUser;

public class GuestHostView {
	private JFrame main;
	private JPanel buttons;
	private JButton search;
	private JButton houses;
	private JButton offers;
	private JButton logout;
	private JLabel welcome;
	
	public GuestHostView(RegisteredUser user) {
		main = new JFrame("Guest and Host");
		buttons = new JPanel();
		search = new JButton("Search");
		houses = new JButton("Houses");
		offers = new JButton("Offers");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + user.getName());
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(100);
		border.setHgap(100);
		
		GridLayout grid = new GridLayout(4,1,0,10);
		buttons.setLayout(grid);
	
		buttons.add(search);
		buttons.add(houses);
		buttons.add(offers);
		buttons.add(logout);
		
		
		welcome.setFont(new Font("TimeRoman",50,50));
		welcome.setHorizontalAlignment(JTextField.CENTER);
		cont.add(welcome,BorderLayout.NORTH);
		cont.add(buttons,BorderLayout.CENTER);
		cont.add(new JPanel(),BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.EAST);
		cont.add(new JPanel(),BorderLayout.WEST);
		
		main.pack();
		main.setSize(1000, 500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean dec) {
		main.setVisible(dec);
	}
}
