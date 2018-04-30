package controllers;

import java.awt.event.*;
import javax.swing.*;
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
		case "Search Offers":
			//completar
			break;
		case "Your Offers":
			//completar
			break;
		case "Logout":
			if (app.logut() == false) {
				JOptionPane.showMessageDialog(null, "The logout went wrong", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				LoginView newView = new LoginView();
				LoginController newControler = new LoginController(newView);
				guest.setVisible(false);
				newView.setVisible(true);
				newView.setControlador(newControler);
				break;
			}
		}
		
	}
	
}
