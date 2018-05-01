package views;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import offer.House;

public class SelectOfferView {
	
	private JFrame main;
	private JLabel addOffer;
	private JPanel buttons;
	private JButton living;
	private JButton vacational;
	private JButton cancel;
	private House house;
	
	public SelectOfferView(House house) {
		this.house = house;
		
		main = new JFrame("Add Offer");
		addOffer = new JLabel("Add Offer");
		buttons = new JPanel();
		living = new JButton("Living offer");
		vacational = new JButton("Vacational Offer");
		cancel  = new JButton("Cancel");
		
		GridLayout grid = new GridLayout(5,1,0,10);
		buttons.setLayout(grid);
		
		buttons.add(living);
		buttons.add(vacational);
		
		addOffer.setFont(new Font("TimeRoman",50,50));
		
		Container cont = main.getContentPane();
		BorderLayout border = new BorderLayout();
		cont.setLayout(border);
		
		border.setVgap(100);
		border.setHgap(100);
		
		cont.add(addOffer, BorderLayout.NORTH);
		cont.add(buttons, BorderLayout.CENTER);
		cont.add(cancel,BorderLayout.SOUTH);
		cont.add(new JPanel(),BorderLayout.EAST);
		cont.add(new JPanel(),BorderLayout.WEST);
		
		main.pack();
		main.setSize(1000, 500);
		
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setVisible(boolean dec) {
		main.setVisible(dec);
	}
	
	public void setControlador(ActionListener c) {
		living.addActionListener(c);
		vacational.addActionListener(c);
		cancel.addActionListener(c);
	}
	public House getHouse() {
		return house;
	}

}
