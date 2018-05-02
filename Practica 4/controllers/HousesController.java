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
			SelectOfferView newView = new SelectOfferView(view.getHouses().get(0 + this.firstHouse));
			SelectOfferController newController = new SelectOfferController(newView);
			view.setVisible(false);
			newView.setVisible(true);
			newView.setControlador(newController);
		break;
		case "Make Offer 1":
			SelectOfferView newView1 = new SelectOfferView(view.getHouses().get(1 + this.firstHouse));
			SelectOfferController newController1 = new SelectOfferController(newView1);
			view.setVisible(false);
			newView1.setVisible(true);
			newView1.setControlador(newController1);
		break;
		case "Make Offer 2":
			SelectOfferView newView2 = new SelectOfferView(view.getHouses().get(2 + this.firstHouse));
			SelectOfferController newController2 = new SelectOfferController(newView2);
			view.setVisible(false);
			newView2.setVisible(true);
			newView2.setControlador(newController2);
		break;
		case "Make Offer 3":
			SelectOfferView newView3 = new SelectOfferView(view.getHouses().get(3 + this.firstHouse));
			SelectOfferController newController3 = new SelectOfferController(newView3);
			view.setVisible(false);
			newView3.setVisible(true);
			newView3.setControlador(newController3);
		break;
		case "Make Offer 4":
			SelectOfferView newView4 = new SelectOfferView(view.getHouses().get(4 + this.firstHouse));
			SelectOfferController newController4 = new SelectOfferController(newView4);
			view.setVisible(false);
			newView4.setVisible(true);
			newView4.setControlador(newController4);
		break;
		case "Make Offer 5":
			SelectOfferView newView5 = new SelectOfferView(view.getHouses().get(5 + this.firstHouse));
			SelectOfferController newController5 = new SelectOfferController(newView5);
			view.setVisible(false);
			newView5.setVisible(true);
			newView5.setControlador(newController5);
		break;
		case "Make Offer 6":
			SelectOfferView newView6 = new SelectOfferView(view.getHouses().get(6 + this.firstHouse));
			SelectOfferController newController6 = new SelectOfferController(newView6);
			view.setVisible(false);
			newView6.setVisible(true);
			newView6.setControlador(newController6);
		break;
		case "Make Offer 7":
			SelectOfferView newView7 = new SelectOfferView(view.getHouses().get(7 + this.firstHouse));
			SelectOfferController newController7 = new SelectOfferController(newView7);
			view.setVisible(false);
			newView7.setVisible(true);
			newView7.setControlador(newController7);
		break;
		case "Make Offer 8":
			SelectOfferView newView8 = new SelectOfferView(view.getHouses().get(8 + this.firstHouse));
			SelectOfferController newController8 = new SelectOfferController(newView8);
			view.setVisible(false);
			newView8.setVisible(true);
			newView8.setControlador(newController8);
		break;
		case "Make Offer 9":
			SelectOfferView newView9 = new SelectOfferView(view.getHouses().get(9 + this.firstHouse));
			SelectOfferController newController9 = new SelectOfferController(newView9);
			view.setVisible(false);
			newView9.setVisible(true);
			newView9.setControlador(newController9);
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
