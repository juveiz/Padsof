package controllers;

import java.awt.event.*;
import java.time.LocalDate;

import javax.swing.*;
import system.Application;
import views.*;

public class SearchDate2Controller implements ActionListener {
	private Application app;
	private SearchDate2View view;
	
	public SearchDate2Controller(SearchDate2View view) {
		this.view = view;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Search by zip":
			SearchZip2View newView = new SearchZip2View();
			SearchZip2Controller newController = new SearchZip2Controller(newView);
			view.setVisible(false);
			newView.setVisible(true);
			newView.setControlador(newController);
			break;
		case "Search by date":
			SearchDate2View newView3 = new SearchDate2View();
			SearchDate2Controller newController3 = new SearchDate2Controller(newView3);
			view.setVisible(false);
			newView3.setVisible(true);
			newView3.setControlador(newController3);
			break;
		case "Search by type":			
			SearchType2View newView1 = new SearchType2View();
			SearchType2Controller newController1 = new SearchType2Controller(newView1);
			view.setVisible(false);
			newView1.setVisible(true);
			newView1.setControlador(newController1);
			break;
		case "Login":
			LoginView newView4 = new LoginView();
			LoginController controller = new LoginController(newView4);
			view.setVisible(false);
			newView4.setControlador(controller);
			newView4.setVisible(true);
			break;
		case "Search":
			LocalDate ini,end;
			try {
				ini = view.getIniDate();
				end = view.getEndDate();
			}catch(Exception n) {
				JOptionPane.showMessageDialog(null, "Date format: YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			ListOfferView nV = new ListOfferView(app.searchOfferDate(ini, end), 0, "Search by date");
			SearchOfferController nC = new SearchOfferController(nV, 0);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
			break;
		}
	}	
}

