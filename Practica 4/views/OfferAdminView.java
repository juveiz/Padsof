package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;


import offer.*;

public class OfferAdminView {
	private Offer offer;
	private JFrame main;
	private JLabel living;
	private JPanel center;
	private JLabel city;
	private JLabel zip;
	private JLabel description;
	private JLabel price;
	private JLabel iniDate;
	private JLabel aditional;
	private JPanel buttons;
	private JButton accept;
	private JButton cancel;
	private JButton afc;
	private JButton back;
	
	public OfferAdminView(Offer offer) {
		this.offer = offer;
		
		main = new JFrame("Approve Offers");
		living = new JLabel("Offer: ");
		center = new JPanel(new GridLayout(6,1,0,10));
		city = new JLabel("City: " + offer.getHouse().getCity());
		zip = new JLabel("Zip: " + offer.getHouse().getZip());
		description = new JLabel("Description : " + offer.getHouse().getDescription());
		price = new JLabel("Price + Deposit: " + offer.getprice() + " + " + offer.getDeposit());
		iniDate = new JLabel("Initial Date: " + offer.getStartingDate());
		if(offer.isLiving()) {
			aditional = new JLabel("Months: " + ((Living) offer).getMonths());
		}else {
			aditional = new JLabel("Ending Date: " + ((Vacational)offer).getEndingDate());
		}
		buttons = new JPanel(new FlowLayout());
		accept = new JButton("Accept");
		cancel = new JButton("Cancel");
		afc = new JButton("Ask for Changes");
		back = new JButton("Back");
		
		living.setFont(new Font("TimeRoman",30,30));
		
		center.add(city);
		center.add(zip);
		center.add(description);
		center.add(price);
		center.add(iniDate);
		center.add(aditional);
		
		buttons.add(accept);
		buttons.add(cancel);
		buttons.add(afc);
		buttons.add(back);
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		border.setVgap(20);
		border.setHgap(20);
		cont.setLayout(border);
		
		cont.add(living, BorderLayout.NORTH);
		cont.add(center, BorderLayout.CENTER);
		cont.add(buttons,BorderLayout.SOUTH);
		cont.add(new JPanel(), BorderLayout.EAST);
		cont.add(new JPanel(), BorderLayout.WEST);
		
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
	
	public Offer getOffer() {
		return offer;
	}
	
}
