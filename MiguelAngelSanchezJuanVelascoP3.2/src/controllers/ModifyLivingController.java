package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exception.HostException;
import system.Application;
import views.ListOfferView;
import views.ModifyLivingView;

public class ModifyLivingController implements ActionListener{
	private Application app;
	private ModifyLivingView view;
	
	public ModifyLivingController(ModifyLivingView view) {
		this.view = view;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Accept":
			double price;
			LocalDate iniDate;
			int months;
			
			if(view.getIniDate() == "" || view.getMonths() == "" || view.getPrice() == "") {
				JOptionPane.showMessageDialog(null, "You didn't enter all the parameters. Please introduce all the parameters", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			try {
				iniDate = LocalDate.parse(view.getIniDate(), DateTimeFormatter.ISO_LOCAL_DATE);
			}catch(DateTimeParseException n) {
				JOptionPane.showMessageDialog(null, "Date format: YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			try{
				price = Double.parseDouble(view.getPrice());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The price is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			try{
				months = Integer.parseInt(view.getMonths());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The months is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			if(iniDate.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "The initial date is before the actual date", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			
			this.view.getOffer().modifyOffer(this.view.getOffer().getHouse(), iniDate, price, months);
			app.getAdmin().addOffer(this.view.getOffer());
			
			
			try {
				ListOfferView nV = new ListOfferView(app.getHostOffers(app.getLoggedUser()),0,"Your Offers");
				HostOfferController nC = new HostOfferController(nV,0);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			break;
		case "Cancel":
			try {
				ListOfferView nV = new ListOfferView(app.getHostOffers(app.getLoggedUser()),0,"Your Offers");
				HostOfferController nC = new HostOfferController(nV,0);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			break;
		}

	}
}
