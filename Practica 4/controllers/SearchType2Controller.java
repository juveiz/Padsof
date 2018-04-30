package controllers;

import java.awt.event.*;
import javax.swing.*;
import system.Application;
import views.*;

public class SearchType2Controller implements ActionListener {
	private Application app;
	private SearchType2View view;
	
	public SearchType2Controller(SearchType2View view) {
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
			LoginView view = new LoginView();
			LoginController controller = new LoginController(view);
			view.setVisible(false);
			view.setControlador(controller);
			view.setVisible(true);
			break;
		case "Search":
			/*Implement search*/
			break;
		}
	}	
}


