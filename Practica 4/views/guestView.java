package views;

import javax.swing.*;

import user.*;

import java.awt.*;

public class guestView {
	private JFrame main;
	private JPanel buttons;
	private JButton search;
	private JButton offers;
	private JButton logout;
	private JLabel welcome;
	
	public guestView(RegisteredUser user) {
		main = new JFrame("Guest");
		buttons = new JPanel();
		search = new JButton("Search");
		offers = new JButton("Offers");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + user.getName());
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(10);
		
		GridLayout grid = new GridLayout(3,1,0,10);
		buttons.setLayout(grid);
	
		buttons.add(search);
		buttons.add(offers);
		buttons.add(logout);
		
		
		
		welcome.setHorizontalAlignment(JTextField.CENTER);
		cont.add(welcome,BorderLayout.NORTH);
		cont.add(buttons,BorderLayout.CENTER);
		cont.add(new JPanel(),BorderLayout.WEST);
		
		main.pack();
		main.setSize(1000, 500);
		
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
