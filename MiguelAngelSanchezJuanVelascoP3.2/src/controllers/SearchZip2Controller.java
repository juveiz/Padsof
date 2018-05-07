package controllers;

import java.awt.event.*;
import javax.swing.*;
import system.Application;
import views.*;

public class SearchZip2Controller implements ActionListener {
	private Application app;
	private SearchZip2View view;
	
	public SearchZip2Controller(SearchZip2View view) {
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
			int zip;
			try{
				zip = Integer.parseInt(view.getZip());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The zip is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			ListOfferView nV = new ListOfferView(app.searchOfferZip(zip), 0, "Search by zip");
			SearchOfferController nC = new SearchOfferController(nV, 0);
			nV.setControlador(nC);
			view.setVisible(false);
			nV.setVisible(true);
			break;
		}
	}	
}

