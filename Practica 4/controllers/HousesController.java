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
	
	private void aux(int i) {
		if(view.getType(i) == "Living") {
			AddLivingView nV = new AddLivingView();
			AddLivingController nC = new AddLivingController(view.getHouses().get(i + this.firstHouse), nV);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
		}else {
			AddVacationalView nV = new AddVacationalView();
			AddVacationalController nC = new AddVacationalController(view.getHouses().get(i + this.firstHouse), nV);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Make Offer 0":
			this.aux(0);
		break;
		case "Make Offer 1":
			this.aux(1);
		break;
		case "Make Offer 2":
			this.aux(2);
		break;
		case "Make Offer 3":
			this.aux(3);
		break;
		case "Make Offer 4":
			this.aux(4);
		break;
		case "Make Offer 5":
			this.aux(5);
		break;
		case "Make Offer 6":
			this.aux(6);
		break;
		case "Make Offer 7":
			this.aux(7);
		break;
		case "Make Offer 8":
			this.aux(8);
		break;
		case "Make Offer 9":
			this.aux(9);
		break;
		case ">>>":
			if (this.firstHouse + 10 >= view.getHouses().size()) {
				JOptionPane.showMessageDialog(null, "There are no more houses", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				HousesView newView11 = new HousesView(this.view.getHouses(),this.firstHouse + 10);
				HousesController newControler = new HousesController(newView11,this.firstHouse + 10);
				newView11.setControlador(newControler);
				this.view.setVisible(false);
				newView11.setVisible(true);
			}
			break;
		case "<<<":
			if (this.firstHouse - 10 < 0) {
				JOptionPane.showMessageDialog(null, "There are no more houses", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				HousesView newView11 = new HousesView(this.view.getHouses(),this.firstHouse - 10);
				HousesController newControler = new HousesController(newView11,this.firstHouse - 10);
				newView11.setControlador(newControler);
				this.view.setVisible(false);
				newView11.setVisible(true);
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
					HostView newView11 = new HostView(user);
					HostController newController11 = new HostController(newView11);
					newView11.setControlador(newController11);
					this.view.setVisible(false);
					newView11.setVisible(true);
				}else {
					GuestHostView newView11 = new GuestHostView(user);
					GuestHostController newController11 = new GuestHostController(newView11);
					newView11.setControlador(newController11);
					this.view.setVisible(false);
					newView11.setVisible(true);
				}
			}
			break;
		}
		
	}

}
