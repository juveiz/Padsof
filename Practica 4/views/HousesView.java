package views;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
	private JPanel north;
	private JLabel title;
	private JLabel header;
	private JPanel center;
	private JPanel buttons;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JButton addHouse;

	public HousesView(List<House> houses,int firstHouse) {
		main = new JFrame("Houses");
		center = new JPanel();
		north = new JPanel(new BorderLayout());
		title = new JLabel("Houses");
		header = new JLabel("               City                         Zip                            Description");
		buttons = new JPanel(new FlowLayout());
		next = new JButton("Next");
		previous = new JButton("Previous");
		back = new JButton("Back");
		addHouse = new JButton("Add House");
		housePanel = new ArrayList<>();
		houseButtons = new ArrayList<>();
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
			
			datos = new JPanel(new GridLayout(0,3));
			buttonsp = new JPanel(new GridLayout(0,1));
			city = new JLabel(houses.get(i + this.firstHouse).getCity());
			zip = new JLabel(houses.get(i + this.firstHouse).getZip() + "");
			description = new JLabel(houses.get(i + this.firstHouse).getDescription());
			makeOffer = new JButton("Make Offer " + i);
			
			datos.add(city);
			datos.add(zip);
			datos.add(description);
			
			buttonsp.add(makeOffer);
			houseButtons.add(makeOffer);
			
			panel.add(datos,BorderLayout.CENTER);
			panel.add(buttonsp,BorderLayout.EAST);
			
			housePanel.add(panel);
		}
		Container cont = main.getContentPane();
		
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(50);
		border.setHgap(100);
		
		GridLayout grid = new GridLayout(10,1,0,10);
		center.setLayout(grid);
		for(JPanel panel: housePanel) {
			center.add(panel);
		}
		
		cont.add(center,BorderLayout.CENTER);
		
		buttons.add(addHouse);
		buttons.add(next);
		buttons.add(previous);
		buttons.add(back);
		
		title.setFont(new Font("TimeRoman",50,50));
		header.setFont(new Font("TimeRoman",25,25));
		north.add(title,BorderLayout.NORTH);
		north.add(header,BorderLayout.SOUTH);
		
		cont.add(buttons, BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.EAST);
		cont.add(new JPanel(),BorderLayout.WEST);
		cont.add(north,BorderLayout.NORTH);
		
		main.pack();
		main.setSize(1000,500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean dec) {
		main.setVisible(dec);
	}
	
	public void setControlador(ActionListener c) {
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
