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
	private JButton logout;
	private JLabel welcome;
	private JPanel view;
	private JLabel firma;
	
	public AdminView(Admin admin) {
		main = new JFrame("Admin");
		buttons = new JPanel();
		creditCard = new JButton("Change Credit Card");
		offers = new JButton("Approve Offers");
		logout = new JButton("Logout");
		welcome = new JLabel("Welcome " + admin.getName());
		view = new JPanel();
		
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(100);
		border.setHgap(100);
		
		GridLayout grid = new GridLayout(4,1,0,10);
		buttons.setLayout(grid);
		buttons.add(creditCard);
		buttons.add(offers);
		buttons.add(logout);
		
		welcome.setFont(new Font("TimeRoman",50,50));
		welcome.setHorizontalAlignment(JTextField.CENTER);
		
		view.setLayout(new BorderLayout());
		
		view.add(welcome,BorderLayout.NORTH);
		view.add(buttons,BorderLayout.CENTER);
		view.add(new JPanel(),BorderLayout.SOUTH);
		view.add(new JPanel(),BorderLayout.EAST);
		view.add(new JPanel(),BorderLayout.WEST);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		cont.add(view,BorderLayout.CENTER);
		cont.add(firma,BorderLayout.NORTH);
		
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
		creditCard.addActionListener(c);
		offers.addActionListener(c);
		logout.addActionListener(c);
	}

}
