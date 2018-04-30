package views;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import offer.*;

public class HousesView {
	private List<House> houses;
	private JFrame main;
	private List<JPanel> housePanel;
	private JPanel buttons;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JButton addHouse;

	public HousesView(List<House> houses) {
		main = new JFrame("Houses");
		buttons = new JPanel(new FlowLayout());
		next = new JButton("Next");
		previous = new JButton("Previous");
		back = new JButton("Back");
		addHouse = new JButton("Add House");
		
		this.houses = houses;
		housePanel = new ArrayList<>();
		
		for (House house : houses) {
			JPanel panel = new JPanel(new BorderLayout());
			JPanel datos,buttonsp;
			JLabel city,zip,description;
			JButton makeOffer;
			
			datos = new JPanel(new GridLayout(0,3));
			buttonsp = new JPanel(new GridLayout(0,1));
			city = new JLabel(house.getCity());
			zip = new JLabel(house.getZip() + "");
			description = new JLabel(house.getDescription());
			makeOffer = new JButton("Make Offer");
			
			datos.add(city);
			datos.add(zip);
			datos.add(description);
			
			buttonsp.add(makeOffer);
			
			panel.add(datos,BorderLayout.CENTER);
			panel.add(buttonsp,BorderLayout.EAST);
		}
		Container cont = main.getContentPane();
	}
}
