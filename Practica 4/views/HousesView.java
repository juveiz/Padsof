package views;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import offer.*;

public class HousesView {
	private int firstHouse;
	private List<House> houses;
	private JFrame main;
	private List<JPanel> housePanel;
	private List<JButton> houseButtons;
	private List<JComboBox<String>> houseTypes;
	private JPanel north;
	private JPanel view2;
	private JLabel title;
	private JLabel header;
	private JPanel center;
	private JPanel buttons;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JButton addHouse;
	private JLabel firma;

	public HousesView(List<House> houses,int firstHouse) {
		main = new JFrame("Houses");
		center = new JPanel();
		view2 = new JPanel();
		north = new JPanel(new BorderLayout());
		title = new JLabel("Houses");
		header = new JLabel("                  City                         Zip                          Description               Make an offer");
		buttons = new JPanel(new FlowLayout());
		next = new JButton(">>>");
		previous = new JButton("<<<");
		back = new JButton("Back");
		addHouse = new JButton("Add House");
		housePanel = new ArrayList<>();
		houseButtons = new ArrayList<>();
		houseTypes = new ArrayList<>();
		this.houses = houses;
		this.firstHouse = firstHouse;
		
		int maxHouses = 10;
		
		if(houses.size() - firstHouse < 10) {
			maxHouses = houses.size() - firstHouse;
		}
		
		for (int i = 0; i < maxHouses;i++) {
			JPanel panel = new JPanel(new BorderLayout());
			JPanel datos,buttonsp;
			JLabel city,zip,description;
			JButton makeOffer;
			JComboBox<String> type;
			
			datos = new JPanel(new GridLayout(0,3));
			buttonsp = new JPanel(new GridLayout(0,2));
			city = new JLabel(houses.get(i + this.firstHouse).getCity());
			zip = new JLabel(houses.get(i + this.firstHouse).getZip() + "");
			description = new JLabel(houses.get(i + this.firstHouse).getDescription());
			makeOffer = new JButton("Make Offer " + i);
			
			String[] types = {"Vacational", "Living"};
			type = new JComboBox<String>(types);
			
			datos.add(city);
			datos.add(zip);
			datos.add(description);
			
			buttonsp.add(makeOffer);
			buttonsp.add(type);
			houseButtons.add(makeOffer);
			houseTypes.add(type);
			
			panel.add(datos,BorderLayout.CENTER);
			panel.add(buttonsp,BorderLayout.EAST);
			
			housePanel.add(panel);
		}
		
		Container cont = main.getContentPane();
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		BorderLayout border2 = new BorderLayout();
		view2.setLayout(border2);
		
		border.setVgap(20);
		border.setHgap(20);
		border2.setVgap(10);
		border2.setHgap(100);
		
		GridLayout grid = new GridLayout(10,1,0,10);
		center.setLayout(grid);
		for(JPanel panel: housePanel) {
			center.add(panel);
		}
		
		view2.add(center,BorderLayout.CENTER);
		
		buttons.add(addHouse);
		buttons.add(previous);
		buttons.add(next);
		buttons.add(back);
		
		title.setFont(new Font("TimeRoman",30,30));
		header.setFont(new Font("TimeRoman",20,20));
		north.add(title,BorderLayout.NORTH);
		north.add(header,BorderLayout.SOUTH);
		
		view2.add(buttons, BorderLayout.SOUTH);
		view2.add(new JPanel(),BorderLayout.EAST);
		view2.add(new JPanel(),BorderLayout.WEST);
		view2.add(north,BorderLayout.NORTH);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		cont.add(view2,BorderLayout.CENTER);
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
		/*for(JComboBox<String> button: houseTypes) {
			button.addActionListener(c);
		}*/
		for(JButton button: houseButtons) {
			button.addActionListener(c);
		}
		next.addActionListener(c);
		back.addActionListener(c);
		previous.addActionListener(c);
		addHouse.addActionListener(c);
	}

	public List<House> getHouses() {
		return houses;
	}
}
