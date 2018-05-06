package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

import user.RegisteredUser;

public class GuestHostView {
	private JFrame main;
	private JPanel buttons;
	private JPanel view2;
	private JButton search;
	private JButton houses;
	private JButton houseOffers;
	private JButton offers;
	private JButton logout;
	private JLabel welcome;
	private JLabel firma;
	
	public GuestHostView(RegisteredUser user) {
		main = new JFrame("Guest and Host");
		buttons = new JPanel();
		view2 = new JPanel();
		search = new JButton("Search offers");
		houses = new JButton("Your Houses");
		houseOffers = new JButton("Your Houses Offers");
		offers = new JButton("Your Offers");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + user.getName() + ". Choose an option.");
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		BorderLayout border2 = new BorderLayout();
		cont.setLayout(border);
		view2.setLayout(border2);
		
		border.setVgap(70);
		border.setHgap(100);
		border2.setVgap(20);
		border2.setHgap(20);
		
		
		GridLayout grid = new GridLayout(5,1,0,10);
		buttons.setLayout(grid);

	
		welcome.setFont(new Font("Arial",30,30));
		welcome.setHorizontalAlignment(JTextField.LEFT);
		
		buttons.add(search);
		buttons.add(houses);
		buttons.add(houseOffers);
		buttons.add(offers);
		buttons.add(logout);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));

		view2.add(welcome,BorderLayout.NORTH);
		view2.add(buttons,BorderLayout.CENTER);
		
		cont.add(firma,BorderLayout.NORTH);
		cont.add(view2,BorderLayout.CENTER);
		cont.add(new JPanel(),BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.EAST);
		cont.add(new JPanel(),BorderLayout.WEST);
		
		/*This will center the JFrame*/
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - main.getWidth()) / 4);
	    int y = (int) ((dimension.getHeight() - main.getHeight()) / 4);
	    main.setLocation(x, y);
		
		main.pack();
		main.setSize(1000, 500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean dec) {
		main.setVisible(dec);
	}
	
	public void setControlador(ActionListener c) {
		search.addActionListener(c);
		houses.addActionListener(c);
		houseOffers.addActionListener(c);
		offers.addActionListener(c);
		logout.addActionListener(c);
	}
}
