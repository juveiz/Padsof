package controllers;

import java.awt.event.*;
import javax.swing.*;
import system.Application;
import views.*;

public class HostController implements ActionListener {

	private Application app;
	private HostView host;

	public HostController(HostView host) {
		this.host = host;
		app = Application.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Your Houses":
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
				host.setVisible(false);
				newView.setVisible(true);
				newView.setControlador(newControler);
				break;
			}
		}

	}

}
