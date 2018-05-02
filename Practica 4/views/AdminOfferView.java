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
	private JButton next;
	private JButton previous;
	private JButton back;
	
	public AdminOfferView(List<Offer> offers,int firstOffer) {
		this.offers = offers;
		this.firstOffer = firstOffer;
		
		main = new JFrame("Approve Offers");
		offerPanel = new ArrayList<>();
		seeOffers = new ArrayList<>();
		north = new JPanel(new BorderLayout());
		adminOffer = new JLabel("Approve offers");
		header = new JLabel("House Type Initial Date");
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
				type = new JLabel("Living");
			}else{
				type = new JLabel("Vacational");
			}
			
			iniDate = new JLabel("" + offers.get(i + this.firstOffer).getStartingDate());
			
			datos.add(house);
			datos.add(type);
			datos.add(iniDate);
			
			details = new JButton("See details");
			
			buttonsp.add(details);
			
			panel.add(datos,BorderLayout.CENTER);
			panel.add(buttonsp,BorderLayout.EAST);
			
			offerPanel.add(panel);
			
		}
	}
}
