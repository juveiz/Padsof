package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import system.Application;
import user.RegisteredUser;
import views.ListOfferView;
import views.SearchDate2View;
import views.SearchDateView;

public class SearchOfferController implements ActionListener{
	
	private Application app;
	private ListOfferView view;
	private int firstOffer;
	
	public SearchOfferController(ListOfferView view,int firstOffer) {
		app = Application.getInstance();
		this.view = view;
		this.firstOffer = firstOffer;
	}
	
	private void aux(int i) {
		// hacer
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();

		switch (button.getActionCommand()) {
		case "See details 0":
			this.aux(0);
			break;
		case "See details 1":
			this.aux(1);
			break;
		case "See details 2":
			this.aux(2);
			break;
		case "See details 3":
			this.aux(3);
			break;
		case "See details 4":
			this.aux(4);
			break;
		case "See details 5":
			this.aux(5);
			break;
		case "See details 6":
			this.aux(6);
			break;
		case "See details 7":
			this.aux(7);
			break;
		case "See details 8":
			this.aux(8);
			break;
		case "See details 9":
			this.aux(9);
			break;
		case ">>>":
			if (this.firstOffer + 10 >= view.getOffers().size()) {
				JOptionPane.showMessageDialog(null, "There are no more offers", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				ListOfferView nV = new ListOfferView(view.getOffers(), this.firstOffer + 10, view.getLabel());
				SearchOfferController nC = new SearchOfferController(nV, this.firstOffer + 10);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		case "<<<":
			if (this.firstOffer - 10 < 0) {
				JOptionPane.showMessageDialog(null, "There are no more offers", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				ListOfferView nV = new ListOfferView(view.getOffers(), this.firstOffer - 10, view.getLabel());
				SearchOfferController nC = new SearchOfferController(nV, this.firstOffer - 10);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		case "Back":
			RegisteredUser user = app.getLoggedUser();
			if (user == null) {
				SearchDate2View nV = new SearchDate2View();
				SearchDate2Controller nC = new SearchDate2Controller(nV);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			} else {
				SearchDateView nV = new SearchDateView();
				SearchDateController nC = new SearchDateController(nV);
				nV.setControlador(nC);
				view.setVisible(false);
				nV.setVisible(true);
			}
			break;
		}
	}

}
