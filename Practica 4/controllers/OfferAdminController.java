package controllers;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import offer.Offer;
import system.Application;
import user.Admin;
import views.AdminOfferView;
import views.OfferAdminView;

public class OfferAdminController implements ActionListener{
	private Application app;
	private OfferAdminView view;
	private Offer offer;
	
	public OfferAdminController(OfferAdminView view,Offer offer) {
		this.view = view;
		this.offer = offer;
		app = Application.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Accept":
			Admin admin = app.getAdmin();
			if (admin == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (offer.getState() == 1) {
				JOptionPane.showMessageDialog(null, "The offer is already approved");
				break;
			}
			if (offer.getState() == -1) {
				JOptionPane.showMessageDialog(null, "The offer is already canceled");
				break;
			}
			if (offer.getState() == 2) {
				JOptionPane.showMessageDialog(null, "The offer is already asked for changes");
				break;
			}
			offer.approveOffer(admin);
			JOptionPane.showMessageDialog(null, "Offer Approved");
			
			AdminOfferView nV = new AdminOfferView(admin.getOffers(), 0);
			AdminOfferController nC = new AdminOfferController(nV, 0);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
			break;
		case "Cancel":
			Admin admin1 = app.getAdmin();
			if (admin1 == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (offer.getState() == 1) {
				JOptionPane.showMessageDialog(null, "The offer is already approved");
				break;
			}
			if (offer.getState() == -1) {
				JOptionPane.showMessageDialog(null, "The offer is already canceled");
				break;
			}
			if (offer.getState() == 2) {
				JOptionPane.showMessageDialog(null, "The offer is already asked for changes");
				break;
			}
			offer.denyOffer(admin1);
			JOptionPane.showMessageDialog(null, "Offer Canceled");
			
			AdminOfferView nV1 = new AdminOfferView(admin1.getOffers(), 0);
			AdminOfferController nC1 = new AdminOfferController(nV1, 0);
			nV1.setControlador(nC1);
			view.setVisible(false);
			nV1.setVisible(true);
			break;
		case "Ask for Changes":
			Admin admin11 = app.getAdmin();
			if (admin11 == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (offer.getState() == 1) {
				JOptionPane.showMessageDialog(null, "The offer is already approved");
				break;
			}
			if (offer.getState() == -1) {
				JOptionPane.showMessageDialog(null, "The offer is already canceled");
				break;
			}
			if (offer.getState() == 2) {
				JOptionPane.showMessageDialog(null, "The offer is already asked for changes");
				break;
			}
			String comment = JOptionPane.showInputDialog(null, "Introduce yout comment");
			offer.askForChanges(comment, admin11);
			
			AdminOfferView nV11 = new AdminOfferView(admin11.getOffers(), 0);
			AdminOfferController nC11 = new AdminOfferController(nV11, 0);
			nV11.setControlador(nC11);
			view.setVisible(false);
			nV11.setVisible(true);
			break;
		case "Back":
			AdminOfferView nV111 = new AdminOfferView(app.getAdminOffers(), 0);
			AdminOfferController nC111 = new AdminOfferController(nV111, 0);
			nV111.setControlador(nC111);
			view.setVisible(false);
			nV111.setVisible(true);
			break;
		}
		
	}
	
	
}
