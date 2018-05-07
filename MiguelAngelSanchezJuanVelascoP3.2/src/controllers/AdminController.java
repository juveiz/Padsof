package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.Application;
import views.AdminView;
import views.ChangeCardView;
import views.ListOfferView;
import views.LoginView;

public class AdminController implements ActionListener {
	private Application app;
	private AdminView view;
	
	public AdminController(AdminView view) {
		this.view = view;
		app = Application.getInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Change Credit Card":
			ChangeCardView nView = new ChangeCardView();
			ChangeCardController nController = new ChangeCardController(nView);
			nView.setControlador(nController);
			view.setVisible(false);
			nView.setVisible(true);
			break;
		case "Approve Offers":
			ListOfferView nV = new ListOfferView(app.getAdminOffers(),0,"Approve Offers");
			AdminOfferController nC = new AdminOfferController(nV,0);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
			break;
		case "Logout":
			if (app.logut() == false) {
				JOptionPane.showMessageDialog(null, "The logout went wrong", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				LoginView newView1 = new LoginView();
				LoginController newControler1 = new LoginController(newView1);
				view.setVisible(false);
				newView1.setVisible(true);
				newView1.setControlador(newControler1);
				break;
			}
		}

	}

}
