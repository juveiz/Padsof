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
	private JLabel addHouse;
	private JPanel view2;
	private JPanel view3;
	private JPanel add;
	private JPanel cityPanel;
	private JTextField cityField;
	private JPanel zipPanel;
	private JTextField zipField;
	private JPanel descriptionPanel;
	private JTextField descriptionField;
	private JPanel buttons;
	private JButton accept;
	private JButton cancel;
	private JLabel firma;
	
	public ChangeCardView() {
		main = new JFrame("Change card");
		addHouse = new JLabel("Change credit card");
		add = new JPanel(new GridLayout(3,1,0,5));
		cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cityField = new JTextField(10);
		zipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		zipField = new JPasswordField(10);
		descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		descriptionField = new JTextField(10);
		buttons = new JPanel(new FlowLayout());
		accept = new JButton("Accept");
		cancel = new JButton("Cancel");
		view2 = new JPanel();
		view3 = new JPanel();
		
		cityPanel.add(new JLabel("User:                              "));
		cityPanel.add(cityField);
		
		zipPanel.add(new JLabel("Password:                   "));
		zipPanel.add(zipField);
		
		descriptionPanel.add(new JLabel("New credit card:         "));
		descriptionPanel.add(descriptionField);
		
		add.add(cityPanel);
		add.add(zipPanel);
		add.add(descriptionPanel);
		
		addHouse.setFont(new Font("TimeRoman",30,30));
		
		buttons.add(accept);
		buttons.add(cancel);
		
		Container cont = main.getContentPane();
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		BorderLayout border2 = new BorderLayout();
		view2.setLayout(border2);
		BorderLayout border3 = new BorderLayout();
		view3.setLayout(border3);
		
		border.setVgap(50);
		border.setHgap(100);
		border2.setVgap(50);
		border2.setHgap(100);
		border3.setVgap(50);
		border3.setHgap(100);
		
		view3.add(addHouse, BorderLayout.NORTH);
		view3.add(add, BorderLayout.CENTER);		
		
		view2.add(view3, BorderLayout.CENTER);
		view2.add(buttons,BorderLayout.SOUTH);
		view2.add(new JPanel(),BorderLayout.WEST);
		view2.add(new JPanel(),BorderLayout.EAST);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(firma,BorderLayout.NORTH);
		cont.add(view2,BorderLayout.CENTER);
		
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
		return cityField.getText();
	}
	
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return zipField.getText();
	}
	
	public String getCreditCard() {
		return descriptionField.getText();
	}
}
