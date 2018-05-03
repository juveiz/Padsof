package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;

import offer.Offer;

public class HouseOffersView {
	private int firstOffer;
	private List<Offer> offers;
	private JFrame main;
	private List<JPanel> offerPanel;
	private List<JButton> offerButtons;
	private JPanel north;
	private JLabel title;
	private JLabel header;
	private JPanel center;
	private JPanel buttons;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JLabel firma;
	
	public HouseOffersView(List<Offer> offers,int firstOffer) {
		this.offers = offers;
		this.firstOffer = firstOffer;
		
		main = new JFrame("Offers");
		center = new JPanel();
		north = new JPanel(new BorderLayout());
		title = new JLabel("Offers");
		header = new JLabel("House type state inidate");
		buttons = new JPanel(new FlowLayout());
		next = new JButton(">>>");
		previous = new JButton("<<<");
		back = new JButton("Back");
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		int maxOffers = 10;
		if(offers.size() - firstOffer < 10) {
			maxOffers = offers.size() - firstOffer;
		}
		
		for(int i = 0; i < maxOffers; i++) {
			JPanel panel = new JPanel(new BorderLayout());
			JPanel datos,buttonsp;
			JLabel house,type,state,iniDate;
			JButton seeDetails;
			
			datos = new JPanel(new GridLayout(0,4));
			buttonsp = new JPanel(new GridLayout(0,1));
			
		}
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (int) ((dimension.getWidth() - main.getWidth()) / 4);
	    int y = (int) ((dimension.getHeight() - main.getHeight()) / 4);
	    main.setLocation(x, y);
	    
		main.pack();
		main.setSize(1000,500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
