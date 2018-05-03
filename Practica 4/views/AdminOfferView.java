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

public class AdminOfferView {
	private int firstOffer;
	private List<Offer> offers;
	private JFrame main;
	private List<JPanel> offerPanel;
	private List<JButton> seeOffers;
	private JPanel north;
	private JLabel adminOffer;
	private JLabel header;
	private JPanel center;
	private JPanel buttons;
	private JPanel view;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JLabel firma;
	
	public AdminOfferView(List<Offer> offers,int firstOffer) {
		this.offers = offers;
		this.firstOffer = firstOffer;
		
		main = new JFrame("Approve Offers");
		offerPanel = new ArrayList<>();
		seeOffers = new ArrayList<>();
		north = new JPanel(new BorderLayout());
		view = new JPanel(new BorderLayout());
		adminOffer = new JLabel("Approve offers");
		header = new JLabel("     House                                           Type                                Initial Date");
		center = new JPanel(new GridLayout(10,1,0,10));
		buttons = new JPanel(new FlowLayout());
		next = new JButton(">>>");
		previous = new JButton("<<<");
		back = new JButton("Back");
		
		int maxOffers = 10;
		if(offers.size() - firstOffer < 10) {
			maxOffers = offers.size() - firstOffer;
		}
		
		for (int i = 0; i < maxOffers;i++) {
			JPanel panel = new JPanel(new BorderLayout());
			JPanel datos,buttonsp;
			JLabel house,type,iniDate;
			JButton details;
			
			datos = new JPanel(new GridLayout(0,3));
			buttonsp = new JPanel(new GridLayout(0,1));
			
			house = new JLabel(offers.get(i + this.firstOffer).getHouse() + "");
			if(offers.get(i + this.firstOffer).isLiving()) {
				type = new JLabel("             Living");
			}else{
				type = new JLabel("             Vacational");
			}
			
			iniDate = new JLabel("" + offers.get(i + this.firstOffer).getStartingDate());
			
			datos.add(house);
			datos.add(type);
			datos.add(iniDate);
			
			details = new JButton("See details " + i);
			
			buttonsp.add(details);
			seeOffers.add(details);
			
			panel.add(datos,BorderLayout.CENTER);
			panel.add(buttonsp,BorderLayout.EAST);
			
			offerPanel.add(panel);
		}
		
		buttons.add(previous);
		buttons.add(next);
		buttons.add(back);
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		border.setVgap(20);
		border.setHgap(20);
		cont.setLayout(border);
		
		for(JPanel panel: offerPanel) {
			center.add(panel);
		}
		
		adminOffer.setFont(new Font("TimeRoman",30,30));
		header.setFont(new Font("TimeRoman",20,20));
		north.add(adminOffer,BorderLayout.NORTH);
		north.add(header,BorderLayout.SOUTH);
		
		view.add(center,BorderLayout.CENTER);
		view.add(north,BorderLayout.NORTH);		
		view.add(buttons, BorderLayout.SOUTH);		
		view.add(new JPanel(),BorderLayout.EAST);
		view.add(new JPanel(),BorderLayout.WEST);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		cont.add(view,BorderLayout.CENTER);
		cont.add(firma,BorderLayout.NORTH);
		
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
		for(JButton button: seeOffers) {
			button.addActionListener(c);
		}
		next.addActionListener(c);
		back.addActionListener(c);
		previous.addActionListener(c);
	}

	public List<Offer> getOffers() {
		return offers;
	}
}
