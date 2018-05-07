package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import offer.Offer;
import system.Application;
import user.Admin;
import user.Profile;
import user.RegisteredUser;
import views.AdminView;
import views.ChangeCardView;

public class ChangeCardController implements ActionListener {
	
	private Application app;
	private ChangeCardView view;
	
	public ChangeCardController(ChangeCardView view) {
		this.view = view;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()){
			case "Accept":
				String user = view.getUser();
				String pass = view.getPassword();
				String card = view.getCreditCard();
				if (user.equals("") || pass.equals("") || card.equals("")) {
					JOptionPane.showMessageDialog(null, "You didn't enter all the parameters. Please introduce all the parameters", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				
				Admin admin = app.getAdmin();
				if (admin == null) {
					JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				RegisteredUser reg = app.getUser(user, pass);
				if (reg == null) {
					JOptionPane.showMessageDialog(null, "The user doesn't exist", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				reg.unbanUser(card, admin);
				JOptionPane.showMessageDialog(null, "Credit Card Changed");
				if(reg.isHost()) {
					for(Profile p: reg.getProfile()) {
						if(p.isHost()) {
							for(Offer o: p.getOffers()) {
								o.payHost(admin);
							}
						}
					}
					JOptionPane.showMessageDialog(null, "If you had unpaid offers, they have been paid");
				}
				AdminView newView = new AdminView(admin);
				AdminController newController = new AdminController(newView);
				newView.setControlador(newController);
				view.setVisible(false);
				newView.setVisible(true);
				break;
			case "Cancel":
				Admin admin1 = app.getAdmin();
				AdminView newView1 = new AdminView(admin1);
				AdminController newController1 = new AdminController(newView1);
				newView1.setControlador(newController1);
				view.setVisible(false);
				newView1.setVisible(true);
				break;
		}

	}

}
