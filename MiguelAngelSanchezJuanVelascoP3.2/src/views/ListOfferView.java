package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import offer.Offer;

public class ListOfferView {
	private int firstOffer;
	private List<Offer> offers;
	private JFrame main;
	private List<JPanel> offerPanel;
	private List<JButton> offerButtons;
	private JPanel north;
	private JLabel title;
	private JLabel header;
	private JPanel center;
	private JPanel view2;
	private JPanel buttons;
	private JButton next;
	private JButton previous;
	private JButton back;
	private JLabel firma;
	
	public ListOfferView(List<Offer> offers,int firstOffer,String label) {
		this.offers = offers;
		this.firstOffer = firstOffer;
		
		main = new JFrame("Offers");
		center = new JPanel();
		view2 = new JPanel();
		north = new JPanel(new BorderLayout());
		title = new JLabel(label);
		header = new JLabel(" House                              Type                    State                         Initial Date");
		buttons = new JPanel(new FlowLayout());
		next = new JButton(">>>");
		previous = new JButton("<<<");
		back = new JButton("Back");
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		offerPanel = new ArrayList<>();
		offerButtons = new ArrayList<>();
		
		int maxOffers = 10;
		if(offers.size() - firstOffer < 10) {
			maxOffers = offers.size() - firstOffer;
		}
		
		for(int i = 0; i < maxOffers; i++) {
			JPanel panel = new JPanel(new BorderLayout());
			JPanel datos,buttonsp;
			JLabel house,type,state,iniDate;
			JButton seeDetails;
			String stt = "";
			
			datos = new JPanel(new GridLayout(0,4));
			buttonsp = new JPanel(new GridLayout(0,1));
			
			house = new JLabel(offers.get(i + this.firstOffer).getHouse() + "");
			if(offers.get(i + this.firstOffer).isLiving()) {
				type = new JLabel("             Living");
			}else{
				type = new JLabel("             Vacational");
			}
			
			if(offers.get(i + this.firstOffer).getState() == 0) {
				stt = "Pending of Approval";
			}else if (offers.get(i + this.firstOffer).getState() == 1) {
				stt = "Available";
			}else if(offers.get(i + this.firstOffer).getState() == -1) {
				stt = "Canceled";
			}else if(offers.get(i + this.firstOffer).getState() == 2) {
				stt = "Need Changes";
			}else if(offers.get(i + this.firstOffer).getState() == 3) {
				stt = "Reserved";
			}else {
				stt = "Bought";
			}
			state = new JLabel(stt);
			iniDate = new JLabel("" + offers.get(i + this.firstOffer).getStartingDate());
			
			datos.add(house);
			datos.add(type);
			datos.add(state);
			datos.add(iniDate);
			
			seeDetails = new JButton("See details " + i);
			
			buttonsp.add(seeDetails);
			offerButtons.add(seeDetails);
			
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
		BorderLayout border2 = new BorderLayout();
		view2.setLayout(border2);
		
		GridLayout grid = new GridLayout(10,1,0,10);
		center.setLayout(grid);
		for(JPanel panel: offerPanel) {
			center.add(panel);
		}
		
		view2.add(center,BorderLayout.CENTER);
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
		cont.add(new JPanel(),BorderLayout.EAST);
		cont.add(new JPanel(),BorderLayout.WEST);
		
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
		for(JButton button: offerButtons) {
			button.addActionListener(c);
		}
		next.addActionListener(c);
		back.addActionListener(c);
		previous.addActionListener(c);
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
	
	public String getLabel() {
		return title.getText();
	}

}
