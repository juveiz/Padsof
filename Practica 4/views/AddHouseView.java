package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddHouseView {
	
	private JFrame main;
	private JLabel addHouse;
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
	
	public AddHouseView() {
		main = new JFrame("Add House");
		addHouse = new JLabel("Add House");
		add = new JPanel(new GridLayout(3,1,0,10));
		cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cityField = new JTextField(10);
		zipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		zipField = new JTextField(10);
		descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		descriptionField = new JTextField(60);
		buttons = new JPanel(new FlowLayout());
		accept = new JButton("Accept");
		cancel = new JButton("Cancel");
		
		cityPanel.add(new JLabel("City:                "));
		cityPanel.add(cityField);
		
		zipPanel.add(new JLabel("Zip:                 "));
		zipPanel.add(zipField);
		
		descriptionPanel.add(new JLabel("Description: "));
		descriptionPanel.add(descriptionField);
		
		add.add(cityPanel);
		add.add(zipPanel);
		add.add(descriptionPanel);
		
		addHouse.setFont(new Font("TimeRoman",50,50));
		
		buttons.add(accept);
		buttons.add(cancel);
		
		Container cont = main.getContentPane();
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(50);
		border.setHgap(100);
		
		cont.add(addHouse, BorderLayout.NORTH);
		cont.add(add, BorderLayout.CENTER);
		cont.add(buttons,BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.WEST);
		cont.add(new JPanel(),BorderLayout.EAST);
		
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
	
	public String getCity() {
		return cityField.getText();
	}
	
	public String getZip() {
		return zipField.getText();
	}
	
	public String getDescription() {
		return descriptionField.getText();
	}
	
}
