package controllers;

import java.awt.event.*;
import javax.swing.*;

import exception.GuestException;
import system.Application;
import views.*;

public class GuestController implements ActionListener{
	private Application app;
	private GuestView guest;
	
	public GuestController(GuestView guest) {
		this.guest = guest;
		app = Application.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Search offers":
			SearchZipView newView = new SearchZipView();
			SearchZipController newController = new SearchZipController(newView);
			guest.setVisible(false);
			newView.setVisible(true);
			newView.setControlador(newController);
			break;
		case "Your Offers":
			try {
				ListOfferView nV = new ListOfferView(app.getGuestOffers(app.getLoggedUser()),0,"Your Offers");
				GuestOfferController nC = new GuestOfferController(nV,0);
				nV.setControlador(nC);
				guest.setVisible(false);
				nV.setVisible(true);
			} catch (GuestException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			break;
		case "Logout":
			if (app.logut() == false) {
				JOptionPane.showMessageDialog(null, "The logout went wrong", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				LoginView newView1 = new LoginView();
				LoginController newControler1 = new LoginController(newView1);
				guest.setVisible(false);
				newView1.setVisible(true);
				newView1.setControlador(newControler1);
				break;
			}
		}
		
	}
	
}
