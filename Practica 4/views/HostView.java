package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

// Vamos a a�adir las ofertas desde las casas que asi ees mas sencillo
import user.RegisteredUser;

public class HostView {
	private JFrame main;
	private JPanel buttons;
	private JButton houses;
	private JButton offers;
	private JButton logout;
	private JLabel welcome;
	private JLabel firma;
	private JPanel view;
	
	public HostView(RegisteredUser user) {
		main = new JFrame("Host");
		buttons = new JPanel();
		houses = new JButton("Your Houses");
		offers = new JButton("Your Offers");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + user.getName() + ". Choose an option.");
		view = new JPanel();
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		BorderLayout border2 = new BorderLayout();
		view.setLayout(border2);
		
		border.setVgap(100);
		border.setHgap(100);
		border2.setVgap(20);
		border2.setHgap(0);
		
		GridLayout grid = new GridLayout(3,1,0,10);
		buttons.setLayout(grid);
	
		buttons.add(houses);
		buttons.add(offers);
		buttons.add(logout);
		
		welcome.setFont(new Font("TimeRoman",30,30));
		welcome.setHorizontalAlignment(JTextField.LEFT);
		view.add(welcome,BorderLayout.NORTH);
		view.add(buttons,BorderLayout.CENTER);
		view.add(new JPanel(),BorderLayout.SOUTH);
		view.add(new JPanel(),BorderLayout.EAST);
		view.add(new JPanel(),BorderLayout.WEST);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		cont.add(view,BorderLayout.CENTER);
		cont.add(firma,BorderLayout.NORTH);
		cont.add(new JPanel(),BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.WEST);
		cont.add(new JPanel(),BorderLayout.EAST);
		
		
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
		houses.addActionListener(c);
		offers.addActionListener(c);
		logout.addActionListener(c);
	}
}
