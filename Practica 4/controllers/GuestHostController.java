package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		case "Search Offers":
			//completar
			break;
		case "Your Houses":
			//completar
			break;
		case "Your Houses Offers":
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
				guestHost.setVisible(false);
				newView.setVisible(true);
				newView.setControlador(newControler);
				break;
			}
		}

	}

}
