package views;

import javax.swing.*;

import user.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class GuestView {
	private JFrame main;
	private JPanel buttons;
	private JButton search;
	private JButton offers;
	private JButton logout;
	private JLabel welcome;
	
	public GuestView(RegisteredUser user) {
		main = new JFrame("Guest");
		buttons = new JPanel();
		search = new JButton("Search offers");
		offers = new JButton("Your Offers");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + user.getName());
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(100);
		border.setHgap(100);
		
		GridLayout grid = new GridLayout(3,1,0,10);
		buttons.setLayout(grid);
	
		buttons.add(search);
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
	
	public void setControlador(ActionListener c) {
		search.addActionListener(c);
		offers.addActionListener(c);
		logout.addActionListener(c);
	}
}
