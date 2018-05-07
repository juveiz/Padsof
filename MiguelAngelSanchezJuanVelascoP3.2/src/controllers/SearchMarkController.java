package controllers;

import java.awt.event.*;

import javax.swing.*;

import exception.NonRegisteredException;
import system.Application;
import user.RegisteredUser;
import views.*;

public class SearchMarkController implements ActionListener {
	private Application app;
	private SearchMarkView view;
	
	public SearchMarkController(SearchMarkView view) {
		this.view = view;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Search by zip":
			SearchZipView newView = new SearchZipView();
			SearchZipController newController = new SearchZipController(newView);
			view.setVisible(false);
			newView.setVisible(true);
			newView.setControlador(newController);
			break;
		case "Search by date":
			SearchDateView newView3 = new SearchDateView();
			SearchDateController newController3 = new SearchDateController(newView3);
			view.setVisible(false);
			newView3.setVisible(true);
			newView3.setControlador(newController3);
			break;
		case "Search by type":			
			SearchTypeView newView1 = new SearchTypeView();
			SearchTypeController newController1 = new SearchTypeController(newView1);
			view.setVisible(false);
			newView1.setVisible(true);
			newView1.setControlador(newController1);
			break;
		case "Search by mark":
			SearchMarkView newView2 = new SearchMarkView();
			SearchMarkController newController2 = new SearchMarkController(newView2);
			view.setVisible(false);
			newView2.setVisible(true);
			newView2.setControlador(newController2);
			break;
		case "Search reserved":
			ListOfferView nV2;
			try {
				nV2 = new ListOfferView(app.searchOfferReserved(), 0, "Search reserved");
			} catch (NonRegisteredException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			SearchOfferController nC2 = new SearchOfferController(nV2, 0);
			nV2.setControlador(nC2);
			view.setVisible(false);
			nV2.setVisible(true);
			break;
		case "Search bought":
			ListOfferView nV1;
			try {
				nV1 = new ListOfferView(app.searchOfferBought(), 0, "Search bought");
			} catch (NonRegisteredException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			SearchOfferController nC1 = new SearchOfferController(nV1, 0);
			nV1.setControlador(nC1);
			view.setVisible(false);
			nV1.setVisible(true);
			break;		
		case "Search":
			int mark;
			try{
				mark = Integer.parseInt(view.getMark());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The mark is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			ListOfferView nV;
			try {
				nV = new ListOfferView(app.searchOfferRate(mark), 0, "Search by mark");
			} catch (NonRegisteredException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			SearchOfferController nC = new SearchOfferController(nV, 0);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
			break;
		case "Back":
			RegisteredUser user = app.getLoggedUser();
			if (user == null) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				if(user.isHost() == false) {
					GuestView newView11 = new GuestView(user);
					GuestController newController11 = new GuestController(newView11);
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
