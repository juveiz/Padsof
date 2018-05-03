package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChangeCardView {
	
	private JFrame main;
	private JLabel changeCard;
	private JPanel add;
	private JPanel userPanel;
	private JTextField user;
	private JPanel passPanel;
	private JPasswordField pass;
	private JPanel cardPanel;
	private JTextField card;
	private JPanel buttons;
	private JButton accept;
	private JButton cancel;
	private JPanel view;
	private JLabel firma;
	
	public ChangeCardView() {
		main = new JFrame("Change Credit Card");
		changeCard = new JLabel("Change Credit Card");
		add = new JPanel(new GridLayout(3,1,0,5));
		userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		passPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cardPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		view = new JPanel();
		user = new JTextField(15);
		pass = new JPasswordField (15);
		card = new JTextField(15);
		buttons = new JPanel(new FlowLayout());
		accept = new JButton("Accept");
		cancel = new JButton("Cancel");
		
		changeCard.setFont(new Font("TimeRoman",30,30));
		
		userPanel.add(new JLabel("User:                      "));
		userPanel.add(user);
		
		passPanel.add(new JLabel("Password:            "));
		passPanel.add(pass);
		
		cardPanel.add(new JLabel("New Credit Card: "));
		cardPanel.add(card);
		
		add.add(userPanel);
		add.add(passPanel);
		add.add(cardPanel);
		
		buttons.add(accept);
		buttons.add(cancel);
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		border.setVgap(50);
		border.setHgap(100);
		cont.setLayout(border);
		
		view.setLayout(new BorderLayout());
		
		view.add(changeCard, BorderLayout.NORTH);
		view.add(add, BorderLayout.CENTER);
		view.add(buttons,BorderLayout.SOUTH);
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
		main.setSize(1000,500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean dec) {
		main.setVisible(dec);
	}
	
	public void setControlador(ActionListener c) {
		accept.addActionListener(c);
		cancel.addActionListener(c);
	}
	
	public String getUser() {
		return user.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return pass.getText();
	}
	
	public String getCreditCard() {
		return card.getText();
	}
}
