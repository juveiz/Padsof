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

import offer.Living;
import offer.Offer;
import offer.Vacational;

public class OfferView {
	private Offer offer;
	private JFrame main;
	private JPanel north;
	private JPanel west;
	private JPanel east;
	private JPanel house;
	private JPanel carac;
	private JPanel rate;
	private JPanel buttons;
	private List<JButton> button;
	private JButton back;
	private JLabel firma;
	private JLabel header;
	
	public OfferView(Offer offer,String... buttones) {
		this.offer = offer;
		main = new JFrame("Offer");
		north = new JPanel(new BorderLayout());
		west = new JPanel(new BorderLayout());
		east = new JPanel(new BorderLayout());
		house = new JPanel(new BorderLayout());
		carac = new JPanel(new GridLayout(4,1,0,10));
		rate = new JPanel(new GridLayout(2,1));
		this.buttons = new JPanel(new FlowLayout());
		back = new JButton("Back");
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		border.setVgap(20);
		border.setHgap(20);
		cont.setLayout(border);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		header = new JLabel("      Offer");
		header.setFont(new Font("TimeRoman",40,40));
		
		north.add(firma, BorderLayout.NORTH);
		north.add(header,BorderLayout.CENTER);
		north.add(new JPanel(),BorderLayout.WEST);
		
		cont.add(north, BorderLayout.NORTH);
		
		house.add(new JLabel("HOUSE"),BorderLayout.NORTH);
		JTextArea desc = new JTextArea();
		desc.setText("CITY: " + offer.getHouse().getCity() + "\n\nZIP CODE: " + offer.getHouse().getZip() + "\n\nDESCRIPTION: " + offer.getHouse().getDescription());
		desc.setEditable(false);
		desc.setFont(new Font("TimeRoman",20,20));
		house.add(desc,BorderLayout.CENTER);
		house.add(new JPanel(),BorderLayout.EAST);
		house.add(new JPanel(),BorderLayout.WEST);
		
		cont.add(house,BorderLayout.CENTER);
		
		carac.add(new JLabel("INITIAL DATE: " + offer.getStartingDate()));
		if(offer.isLiving()) {
			carac.add(new JLabel("MONTHS: " + ((Living)offer).getMonths()));
		}else {
			carac.add(new JLabel("ENDING DATE: " + ((Vacational)offer).getEndingDate()));
		}
		carac.add(new JLabel("PRICE: " + offer.getprice()));
		String stt = "";
		if(offer.getState() == 0) {
			stt = "Pending of Approval";
		}else if (offer.getState() == 1) {
			stt = "Available";
		}else if(offer.getState() == -1) {
			stt = "Canceled";
		}else if(offer.getState() == 2) {
			stt = "Need Changes";
		}else if(offer.getState() == 3) {
			stt = "Reserved";
		}else {
			stt = "Bought";
		}
		carac.add(new JLabel("STATE: " + stt));
		
		east.add(carac, BorderLayout.CENTER);
		east.add(new JPanel(), BorderLayout.EAST);
		
		cont.add(east, BorderLayout.EAST);
		
		rate.add(new JLabel("RATE: "));
		rate.add(new JLabel(offer.getRate() +"/5.0"));
		
		west.add(rate, BorderLayout.CENTER);
		west.add(new JPanel(),BorderLayout.WEST);
		
		cont.add(west,BorderLayout.WEST);
		
		button = new ArrayList<>();
		for(String b: buttones) {
			JButton nButton = new JButton(b);
			button.add(nButton);
			this.buttons.add(nButton);
		}
		
		this.buttons.add(back);
		
		cont.add(this.buttons,BorderLayout.SOUTH);
		
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
		for(JButton button: this.button) {
			button.addActionListener(c);
		}
		back.addActionListener(c);
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	
	
}