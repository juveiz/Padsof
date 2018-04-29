package controllers;

import java.awt.event.*;
import javax.swing.*;

import exception.BannedUserException;
import exception.LoggedException;
import system.Application;
import user.RegisteredUser;
import views.*;

public class LoginController implements ActionListener{
	private Application app;
	private LoginView login;
	
	public LoginController(LoginView login) {
		this.login = login;
		app = Application.getApplication("Eva", "Touris", "OpenBalls");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Login":
			String user = login.getUser();
			String password = login.getPassword();
			System.out.println(user + "\n" + password);
			try {
				RegisteredUser register = app.loginUser(user, password);
				if ( register == null) {
					JOptionPane.showMessageDialog(null, "The user is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if (register.isGuest() && !(register.isHost())) {
						GuestView newView = new GuestView(register);
						login.setVisible(false);
						newView.setVisible(true);
						//Falta asignar el controller nuevo
					}else if(register.isHost() /*&& !(register.isGuest())*/) {
						HostView newView = new HostView(register);
						login.setVisible(false);
						newView.setVisible(true);
						//Falta asignar el controller nuevo
					}else {
						//falta vista ambos
					}
				}
			} catch (LoggedException e1) {
				JOptionPane.showMessageDialog(null, "Someone is already logged", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (BannedUserException e1) {
				JOptionPane.showMessageDialog(null, "You are banned. Please, contact the administrator", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "No Login":
			
		}
		
	}

}
