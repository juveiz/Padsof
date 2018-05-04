package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import offer.Living;
import offer.Offer;
import offer.Vacational;

public class OfferGuestView {
	private Offer offer;
	private JFrame main;
	private JPanel view;
	
	private JPanel info;
	private JLabel house;
	private JLabel mark;
	private JLabel zip;
	private JLabel description;
	private JLabel date;
	private JLabel price;

	
	private JPanel comments;
	
	private JPanel buttons;
	private JButton buy;
	private JButton reserve;
	private JButton rate;
	private JButton comment;
	private JLabel firma;
	
	public OfferGuestView(Offer offer) {
		this.offer = offer;
		view = new JPanel();
		info = new JPanel();
		comments = new JPanel();
		buttons = new JPanel();
		
		
		BorderLayout border = new BorderLayout();
		Container cont = main.getContentPane();	
		cont.setLayout(border);
		border.setVgap(100);
		border.setHgap(100);
		
		BorderLayout border2 = new BorderLayout();
		view.setLayout(border);
		border2.setVgap(100);
		border2.setHgap(100);		
		
		info.setLayout(new GridLayout(4,1,20,20));
		house = new JLabel("House: " + offer.getHouse());
		mark = new JLabel("Mark: " + offer.getRate());
		/*zip = new JLabel("Zip: " + offer.getZ) obtener zip*/
		/*description = new JLabel("Description: " + offer.getD)  obtener descfripcion*/
		date = new JLabel("Date: " + offer.getStartingDate());
		price = new JLabel("Price: " + offer.getprice());
		info.add(house);
		info.add(mark);
		info.add(date);
		info.add(price);	
		
		comments.setLayout(new GridLayout(2,1,20,20));
		
		buttons.setLayout(new FlowLayout());
		buy = new JButton("Buy Offer");
		reserve = new JButton("Reserve Offer");
		rate = new JButton("Rate Offer");
		comment = new JButton("Comment Offer");		
		buttons.add(buy);
		buttons.add(reserve);
		buttons.add(rate);
		buttons.add(comment);
		
		view.add(info,BorderLayout.NORTH);
		view.add(comments,BorderLayout.CENTER);
		view.add(buttons,BorderLayout.SOUTH);
		
		firma = new JLabel("RentingJ&MA");
		firma.setFont(new Font("Brush Script MT",50,50));
		
		cont.add(firma,BorderLayout.NORTH);
		cont.add(view,BorderLayout.CENTER);
		cont.add(new JPanel(),BorderLayout.SOUTH);
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
		buy.addActionListener(c);
		reserve.addActionListener(c);
		rate.addActionListener(c);
		comment.addActionListener(c);
	}
	
	public Offer getOffer() {
		return offer;
	}
	
}