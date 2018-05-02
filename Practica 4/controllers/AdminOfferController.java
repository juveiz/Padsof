package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.Application;
import user.Admin;
import views.AdminOfferView;
import views.AdminView;

public class AdminOfferController implements ActionListener{
	private Application app;
	private AdminOfferView view;
	private int firstOffer;
	
	public AdminOfferController(AdminOfferView view,int firstOffer) {
		this.view = view;
		this.firstOffer = firstOffer;
		app = Application.getInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case ">>>":
			if (this.firstOffer + 10 >= view.getOffers().size()) {
				JOptionPane.showMessageDialog(null, "There are no more offers", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				AdminOfferView newView11 = new AdminOfferView(this.view.getOffers(),this.firstOffer + 10);
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
				AdminOfferView newView11 = new AdminOfferView(this.view.getOffers(),this.firstOffer - 10);
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
