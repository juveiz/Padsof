package controllers;

import java.awt.event.*;
import javax.swing.*;
import system.Application;
import views.*;

public class SearchZipController implements ActionListener {
	private Application app;
	private SearchZipView zipview;
	
	public SearchZipController(SearchZipView zipview) {
		this.zipview = zipview;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton button = (JRadioButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Search by type":
			zipview.setVisible(false);
			SearchTypeView typeview = new SearchTypeView();
			typeview.setVisible(true);
			break;
		}
	}
	
}
