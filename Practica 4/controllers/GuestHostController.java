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
		case "Search offers":
			SearchZipView newView = new SearchZipView();
			SearchZipController newController = new SearchZipController(newView);
			guestHost.setVisible(false);
			newView.setVisible(true);
			newView.setControlador(newController);
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
				LoginView newView1 = new LoginView();
				LoginController newControler1 = new LoginController(newView1);
				guestHost.setVisible(false);
				newView1.setVisible(true);
				newView1.setControlador(newControler1);
				break;
			}
		}

	}

}
