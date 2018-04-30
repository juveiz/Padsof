package views;

import javax.swing.*;

import user.Admin;
import java.awt.*;
import java.awt.event.ActionListener;


public class AdminView {
	
	private JFrame main;
	private JPanel buttons;
	private JButton creditCard;
	private JButton offers;
	private JButton users;
	private JButton logout;
	private JLabel welcome;
	
	public AdminView(Admin admin) {
		main = new JFrame("Admin");
		buttons = new JPanel();
		creditCard = new JButton("Change Credit Card");
		offers = new JButton("Approve Offers");
		users = new JButton("Unban User");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + admin.getName());
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(100);
		border.setHgap(100);
		
		GridLayout grid = new GridLayout(4,1,0,10);
		buttons.setLayout(grid);
	
		buttons.add(creditCard);
		buttons.add(offers);
		buttons.add(users);
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
		creditCard.addActionListener(c);
		offers.addActionListener(c);
		users.addActionListener(c);
		logout.addActionListener(c);
	}

}
