package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exception.HostException;
import system.Application;
import user.RegisteredUser;
import views.GuestHostView;
import views.HostView;
import views.HousesView;
import views.SelectOfferView;

public class SelectOfferController implements ActionListener {
	
	private Application app;
	private SelectOfferView view;
	
	public SelectOfferController(SelectOfferView view) {
		app = Application.getInstance();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Living offer":
			System.out.println("Living offer\n" + view.getHouse());
			break;
		case "Vacational Offer":
			System.out.println("Vacational offer\n" + view.getHouse());
			break;
		case "Cancel":
			HousesView newView11;
			try {
				newView11 = new HousesView(app.getLoggedUser().getHost().getHouses(),0);
				HousesController newController1 = new HousesController(newView11,0);
				view.setVisible(false);
				newView11.setVisible(true);
				newView11.setControlador(newController1);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "Back":
			RegisteredUser user = app.getLoggedUser();
			if (user == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(user.isGuest() == false) {
					HostView newView111 = new HostView(user);
					HostController newController11 = new HostController(newView111);
					newView111.setControlador(newController11);
					this.view.setVisible(false);
					newView111.setVisible(true);
				}else {
					GuestHostView newView111 = new GuestHostView(user);
					GuestHostController newController11 = new GuestHostController(newView111);
					newView111.setControlador(newController11);
					this.view.setVisible(false);
					newView111.setVisible(true);
				}
			}
			break;
		}
	}

}
