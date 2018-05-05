package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.Application;
import user.RegisteredUser;
import views.GuestHostView;
import views.HostView;
import views.ListOfferView;
import views.OfferView;

public class HostOfferController implements ActionListener {
	private Application app;
	private ListOfferView view;
	private int firstOffer;

	public HostOfferController(ListOfferView view, int firstOffer) {
		this.view = view;
		this.firstOffer = firstOffer;
		app = Application.getInstance();
	}

	private void aux(int i) {
		OfferView nV;
		OfferController nC;
		nV = new OfferView(view.getOffers().get(i + this.firstOffer),"Make Changes","Cancel Offer","Comment","See Comments");
		nC = new OfferController(nV);
		nV.setControlador(nC);
		view.setVisible(false);
		nV.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "See details 0":
			this.aux(0);
			break;
		case "See details 1":
			this.aux(1);
			break;
		case "See details 2":
			this.aux(2);
			break;
		case "See details 3":
			this.aux(3);
			break;
		case "See details 4":
			this.aux(4);
			break;
		case "See details 5":
			this.aux(5);
			break;
		case "See details 6":
			this.aux(6);
			break;
		case "See details 7":
			this.aux(7);
			break;
		case "See details 8":
			this.aux(8);
			break;
		case "See details 9":
			this.aux(9);
			break;
		case ">>>":
			if (this.firstOffer + 10 >= view.getOffers().size()) {
				JOptionPane.showMessageDialog(null, "There are no more offers", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				ListOfferView nV = new ListOfferView(view.getOffers(), this.firstOffer + 10, view.getLabel());
				HostOfferController nC = new HostOfferController(nV,this.firstOffer + 10);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		case "<<<":
			if (this.firstOffer - 10 < 0) {
				JOptionPane.showMessageDialog(null, "There are no more offers", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				ListOfferView nV = new ListOfferView(view.getOffers(), this.firstOffer - 10, view.getLabel());
				HostOfferController nC = new HostOfferController(nV,this.firstOffer - 10);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		case "Back":
			RegisteredUser user = app.getLoggedUser();
			if (user == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(user.isGuest() == false) {
					HostView newView11 = new HostView(user);
					HostController newController11 = new HostController(newView11);
					newView11.setControlador(newController11);
					this.view.setVisible(false);
					newView11.setVisible(true);
				}else {
					GuestHostView newView11 = new GuestHostView(user);
					GuestHostController newController11 = new GuestHostController(newView11);
					newView11.setControlador(newController11);
					this.view.setVisible(false);
					newView11.setVisible(true);
				}
			}
			break;
		}
	}
}
