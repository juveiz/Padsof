package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exception.GuestException;
import exception.HostException;
import system.Application;
import views.*;

public class GuestHostController implements ActionListener {
	
	private Application app;
	private GuestHostView guestHost;
	
	public GuestHostController(GuestHostView guestHost) {
		app = Application.getInstance();
		this.guestHost = guestHost;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Search offers":
			SearchZipView newView = new SearchZipView();
			SearchZipController newController = new SearchZipController(newView);
			guestHost.setVisible(false);
			newView.setVisible(true);
			newView.setControlador(newController);
			break;
		case "Your Houses":
			HousesView newView1;
			try {
				newView1 = new HousesView(app.getLoggedUser().getHost().getHouses(),0);
				HousesController newController1 = new HousesController(newView1,0);
				guestHost.setVisible(false);
				newView1.setVisible(true);
				newView1.setControlador(newController1);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}	
			break;
		case "Your Houses Offers":
			try {
				ListOfferView nV = new ListOfferView(app.getHostOffers(app.getLoggedUser()),0,"Your Offers");
				HostOfferController nC = new HostOfferController(nV,0);
				nV.setControlador(nC);
				guestHost.setVisible(false);
				nV.setVisible(true);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			break;
		case "Your Offers":
			try {
				ListOfferView nV = new ListOfferView(app.getGuestOffers(app.getLoggedUser()),0,"Your Offers");
				GuestOfferController nC = new GuestOfferController(nV,0);
				nV.setControlador(nC);
				guestHost.setVisible(false);
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
				LoginView newView11 = new LoginView();
				LoginController newControler1 = new LoginController(newView11);
				guestHost.setVisible(false);
				newView11.setVisible(true);
				newView11.setControlador(newControler1);
				break;
			}
		}

	}

}
