package controllers;

import java.awt.event.*;
import javax.swing.*;
import system.Application;
import views.*;

public class SearchDateController implements ActionListener {
	private Application app;
	private SearchDateView view;
	
	public SearchDateController(SearchDateView view) {
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
			/*Implement search*/
			break;
		case "Search bought":
			/*Implement search*/
			break;	
		case "Search":
			/*Implement search*/
			break;
		}
	}	
}
