package views;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddHouseView {
	
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
	
	public AddHouseView() {
		main = new JFrame("Add House");
		addHouse = new JLabel("Add House");
		add = new JPanel(new GridLayout(3,1,0,5));
		cityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cityField = new JTextField(10);
		zipPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		zipField = new JTextField(10);
		descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		descriptionField = new JTextField(60);
		buttons = new JPanel(new FlowLayout());
		accept = new JButton("Accept");
		cancel = new JButton("Cancel");
		view2 = new JPanel();
		view3 = new JPanel();
		
		cityPanel.add(new JLabel("City:                "));
		cityPanel.add(cityField);
		
		zipPanel.add(new JLabel("Zip:                 "));
		zipPanel.add(zipField);
		
		descriptionPanel.add(new JLabel("Description: "));
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
