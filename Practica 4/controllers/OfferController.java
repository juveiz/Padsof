package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exception.GuestException;
import exception.HostException;
import offer.Reserve;
import system.Application;
import user.RegisteredUser;
import views.GuestHostView;
import views.ListOfferView;
import views.ModifyLivingView;
import views.ModifyVacationalView;
import views.OfferView;
import views.SearchDate2View;
import views.SearchDateView;

public class OfferController implements ActionListener{
	
	private Application app;
	private OfferView view;
	
	public OfferController(OfferView view) {
		app = Application.getInstance();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Buy":
			RegisteredUser user = app.getLoggedUser();
			String subject = JOptionPane.showInputDialog(null, "Introduce the subject");
			if (subject == null) {
				break;
			}
			if(view.getOffer().getState() == 4) {
				JOptionPane.showMessageDialog(null, "The offer is already bought", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if(user.isGuest()) {
				try {
					int res = view.getOffer().buyOffer(user, subject, false);
					if (res == -1) {
						JOptionPane.showMessageDialog(null, "Your credit card is false. You're user is now banned. Contact with the admin", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}else if(res == -2) {
						JOptionPane.showMessageDialog(null, "The internet connection failed. Please, try again later", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}else if(res == -3) {
						JOptionPane.showMessageDialog(null, "The order was rejected. Please, try again later", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}else if(res == -4) {
						JOptionPane.showMessageDialog(null, "The offer is already reserved by another user", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}else {
						JOptionPane.showMessageDialog(null, "You have buy the offer");
						//Volver atras
						break;
					}
				} catch (GuestException e1) {
					JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
			break;
		case "Reserve":
			RegisteredUser user1 = app.getLoggedUser();
			if(user1.isGuest()) {
				boolean reserved;
				try {
					reserved = view.getOffer().reserveOffer(user1);
					if (reserved) {
						JOptionPane.showMessageDialog(null, "You have reserved the offer");
						break;
					}else {
						JOptionPane.showMessageDialog(null, "The offer is already reserved by another user", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
				} catch (GuestException e1) {
					JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
			}
			break;
		case "Comment":
			String comment = JOptionPane.showInputDialog(null, "Introduce the comment");
			if (comment == "") {
				JOptionPane.showMessageDialog(null, "Please, introduce a comment", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (comment == null) {
				break;
			}
			try {
				view.getOffer().commentOffer(app.getLoggedUser(), comment);
				JOptionPane.showMessageDialog(null, "You have comment the offer");
				break;
			} catch (GuestException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
		case "Rate":
			String rate = JOptionPane.showInputDialog(null, "Introduce the rate between 0.0 and 5.0");
			if(rate == null) {
				break;
			}
			try {
				view.getOffer().rateOffer(app.getLoggedUser(), Double.parseDouble(rate));
				JOptionPane.showMessageDialog(null, "You have rate the offer");
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Please, introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			} catch (GuestException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			break;
		case "See Comments":
			// a implementar
			break;
		case "Cancel Reserve":
			RegisteredUser user2 = app.getLoggedUser();
			if(user2.isGuest()) {
				Reserve res = view.getOffer().getReserve();
				if (res != null) {
					if(res.getGuest().equals(user2)) {
						view.getOffer().setReserve(null);
					}else {
						JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
						break;
					}
				}
				JOptionPane.showMessageDialog(null, "You have canceled the reserve");
			}
			break;
		case "Cancel Offer":
			RegisteredUser user3 = app.getLoggedUser();
			if(user3.isHost()) {
				view.getOffer().denyOffer(null);
				JOptionPane.showMessageDialog(null, "You have canceled the offer");
			}
			break;
		case "Make Changes":
			RegisteredUser user4 = app.getLoggedUser();
			if(user4.isHost()) {
				if(this.view.getOffer().getState() != 2) {
					JOptionPane.showMessageDialog(null, "The offer doesn't need changes", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				JOptionPane.showMessageDialog(null, "The admin says: \n" + view.getOffer().getChanges());
				if (this.view.getOffer().isLiving()) {
					ModifyLivingView nV = new ModifyLivingView(this.view.getOffer());
					ModifyLivingController nC = new ModifyLivingController(nV);
					nV.setControlador(nC);
					this.view.setVisible(false);
					nV.setVisible(true);
				}else {
					ModifyVacationalView nV = new ModifyVacationalView(this.view.getOffer());
					ModifyVacationalController nC = new ModifyVacationalController(nV);
					nV.setControlador(nC);
					this.view.setVisible(false);
					nV.setVisible(true);
				}
			}
			break;
		case "Back":
			RegisteredUser user5 = app.getLoggedUser();
			if (user5 == null) {
				SearchDate2View nV = new SearchDate2View();
				SearchDate2Controller nC = new SearchDate2Controller(nV);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			} else if (user5.isGuest() == true && user5.isHost() == false) {
				SearchDateView nV = new SearchDateView();
				SearchDateController nC = new SearchDateController(nV);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			} else if(user5.isGuest() == false && user5.isHost() == true) {
				try {
					ListOfferView nV = new ListOfferView(app.getHostOffers(app.getLoggedUser()),0,"Your Offers");
					HostOfferController nC = new HostOfferController(nV,0);
					nV.setControlador(nC);
					JOptionPane.showMessageDialog(null, "Remember: You can only have onr type of offer per house");
					view.setVisible(false);
					nV.setVisible(true);
				} catch (HostException e1) {
					JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				break;
			} else {
				GuestHostView newView11 = new GuestHostView(app.getLoggedUser());
				GuestHostController newController11 = new GuestHostController(newView11);
				newView11.setControlador(newController11);
				this.view.setVisible(false);
				newView11.setVisible(true);
			}
			break;
		}
		
	}

}
