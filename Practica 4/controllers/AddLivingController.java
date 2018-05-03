package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import offer.House;
import system.Application;
import views.AddVacationalView;

public class AddLivingController implements ActionListener {
	private House house;
	private Application app;
	private AddVacationalView view;
	
	public AddLivingController(House house,AddVacationalView view) {
		this.house = house;
		this.view = view;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Accept":
			int price;
			
		}

	}

}
