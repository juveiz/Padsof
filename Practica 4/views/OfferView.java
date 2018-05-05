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
	private JPanel house;
	private JPanel carac;
	private JPanel rate;
	private JPanel buttons;
	private List<JButton> button;
	private JLabel firma;
	private JLabel header;
	
	public OfferView(Offer offer,String... buttons) {
		this.offer = offer;
		main = new JFrame("Offer");
		north = new JPanel(new BorderLayout());
		house = new JPanel(new BorderLayout());
		carac = new JPanel(new GridLayout(4,1,0,10));
		rate = new JPanel(new BorderLayout());
		this.buttons = new JPanel(new FlowLayout());
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		border.setVgap(20);
		border.setHgap(20);
		cont.setLayout(border);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		header = new JLabel("Offer");
		header.setFont(new Font("TimeRoman",20,20));
		
		north.add(firma, BorderLayout.NORTH);
		north.add(header,BorderLayout.SOUTH);
		
		cont.add(north, BorderLayout.NORTH);
		
		house.add(new JLabel("House"),BorderLayout.NORTH);
		JTextField desc = new JTextField();
		desc.setText(offer.getHouse().toString());
		desc.setEditable(false);
		house.add(desc,BorderLayout.CENTER);
		
		cont.add(house,BorderLayout.CENTER);
		
		
		
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
		
	}
	
	public Offer getOffer() {
		return offer;
	}
	
}