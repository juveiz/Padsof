package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.Application;
import user.Admin;
import views.AdminOfferView;
import views.AdminView;
import views.ListOfferView;
import views.OfferAdminView;

public class AdminOfferController implements ActionListener{
	private Application app;
	private ListOfferView view;
	private int firstOffer;
	
	public AdminOfferController(ListOfferView view,int firstOffer) {
		this.view = view;
		this.firstOffer = firstOffer;
		app = Application.getInstance();
	}
	
	private void aux(int i) {
		OfferAdminView nV = new OfferAdminView(view.getOffers().get(i + this.firstOffer));
		OfferAdminController nC = new OfferAdminController(nV,view.getOffers().get(i + this.firstOffer));
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
				ListOfferView newView11 = new ListOfferView(this.view.getOffers(),this.firstOffer + 10,"Approve Offers");
				AdminOfferController newControler = new AdminOfferController(newView11,this.firstOffer + 10);
				newView11.setControlador(newControler);
				this.view.setVisible(false);
				newView11.setVisible(true);
			}
			break;
		case "<<<":
			if (this.firstOffer - 10 < 0) {
				JOptionPane.showMessageDialog(null, "There are no more offers", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				ListOfferView newView11 = new ListOfferView(this.view.getOffers(),this.firstOffer - 10,"Approve Offers");
				AdminOfferController newControler = new AdminOfferController(newView11,this.firstOffer - 10);
				newView11.setControlador(newControler);
				this.view.setVisible(false);
				newView11.setVisible(true);
			}
			break;
		case "Back":
			Admin admin = app.getAdmin();
			if (admin == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			AdminView nView = new AdminView(admin);
			AdminController nController = new AdminController(nView);
			nView.setControlador(nController);
			view.setVisible(false);
			nView.setVisible(true);
		}
		
	}

}
