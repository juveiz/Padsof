package controllers;

import java.awt.event.*;
import javax.swing.*;

import exception.BannedUserException;
import exception.LoggedException;
import system.Application;
import user.Admin;
import user.RegisteredUser;
import views.*;

public class LoginController implements ActionListener{
	private Application app;
	private LoginView login;
	
	public LoginController(LoginView login) {
		this.login = login;
		app = Application.getInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Login":
			String user = login.getUser();
			String password = login.getPassword();
			try {
				RegisteredUser register = app.loginUser(user, password);
				if ( register == null) {
					JOptionPane.showMessageDialog(null, "The user is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if (register.isGuest() && !(register.isHost())) {
						GuestView newView = new GuestView(register);
						GuestController newController = new GuestController(newView);
						login.setVisible(false);
						newView.setVisible(true);
						newView.setControlador(newController);
					}else if(register.isHost() && !(register.isGuest())) {
						HostView newView = new HostView(register);
						HostController newController = new HostController(newView);
						login.setVisible(false);
						newView.setVisible(true);
						newView.setControlador(newController);
					}else {
						GuestHostView newView = new GuestHostView(register);
						GuestHostController newController = new GuestHostController(newView);
						login.setVisible(false);
						newView.setVisible(true);
						newView.setControlador(newController);
					}
				}
			} catch (LoggedException e1) {
				JOptionPane.showMessageDialog(null, "Someone is already logged", "Error", JOptionPane.ERROR_MESSAGE);
			} catch (BannedUserException e1) {
				JOptionPane.showMessageDialog(null, "You are banned. Please, contact the administrator", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "Admin Login":
			String admin = login.getUser();
			String adminPassword = login.getPassword();
			try {
				Admin adm = app.loginAdmin(admin, adminPassword);
				if (adm == null) {
					JOptionPane.showMessageDialog(null, "The admin is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					AdminView newView = new AdminView(adm);
					login.setVisible(false);
					newView.setVisible(true);
					//falta asignar el controlador
				}
			} catch (LoggedException e1) {
				JOptionPane.showMessageDialog(null, "Someone is already logged", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case "No Login":
			//busqueda de ofertas
			break;
		}
		
	}

}
