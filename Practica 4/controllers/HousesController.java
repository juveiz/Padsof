package controllers;

import java.awt.event.*;
import javax.swing.*;
import system.Application;
import user.RegisteredUser;
import views.*;

public class HousesController implements ActionListener{
		
	private Application app;
	private HousesView view;
	private int firstHouse;
	
	public HousesController(HousesView view,int firstHouse) {
		this.view = view;
		this.firstHouse = firstHouse;
		app = Application.getInstance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Make Offer 0":
			System.out.println(view.getHouses().get(0 + this.firstHouse));
			//falta asignar siguiente vista y controlador a todos
		break;
		case "Make Offer 1":
			System.out.println(view.getHouses().get(1+ this.firstHouse));
		break;
		case "Make Offer 2":
			System.out.println(view.getHouses().get(2+ this.firstHouse));
		break;
		case "Make Offer 3":
			System.out.println(view.getHouses().get(3+ this.firstHouse));
		break;
		case "Make Offer 4":
			System.out.println(view.getHouses().get(4+ this.firstHouse));
		break;
		case "Make Offer 5":
			System.out.println(view.getHouses().get(5+ this.firstHouse));
		break;
		case "Make Offer 6":
			System.out.println(view.getHouses().get(6+ this.firstHouse));
		break;
		case "Make Offer 7":
			System.out.println(view.getHouses().get(7+ this.firstHouse));
		break;
		case "Make Offer 8":
			System.out.println(view.getHouses().get(8+ this.firstHouse));
		break;
		case "Make Offer 9":
			System.out.println(view.getHouses().get(9+ this.firstHouse));
		break;
		case "Next":
			if (this.firstHouse + 10 >= view.getHouses().size()) {
				JOptionPane.showMessageDialog(null, "There are no more houses", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				HousesView newView = new HousesView(this.view.getHouses(),this.firstHouse + 10);
				HousesController newControler = new HousesController(newView,this.firstHouse + 10);
				newView.setControlador(newControler);
				this.view.setVisible(false);
				newView.setVisible(true);
			}
			break;
		case "Previous":
			if (this.firstHouse - 10 < 0) {
				JOptionPane.showMessageDialog(null, "There are no more houses", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				HousesView newView = new HousesView(this.view.getHouses(),this.firstHouse - 10);
				HousesController newControler = new HousesController(newView,this.firstHouse - 10);
				newView.setControlador(newControler);
				this.view.setVisible(false);
				newView.setVisible(true);
			}
			break;
		case "Add House":
			AddHouseView nView = new AddHouseView();
			AddHouseController nController = new AddHouseController(nView);
			nView.setControlador(nController);
			view.setVisible(false);
			nView.setVisible(true);
			break;
		case "Back":
			RegisteredUser user = app.getLoggedUser();
			if (user == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(user.isGuest() == false) {
					HostView newView = new HostView(user);
					HostController newController = new HostController(newView);
					newView.setControlador(newController);
					this.view.setVisible(false);
					newView.setVisible(true);
				}else {
					GuestHostView newView = new GuestHostView(user);
					GuestHostController newController = new GuestHostController(newView);
					newView.setControlador(newController);
					this.view.setVisible(false);
					newView.setVisible(true);
				}
			}
			break;
		}
		
	}

}
