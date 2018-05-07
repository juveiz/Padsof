package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exception.HostException;
import offer.House;
import system.Application;
import views.AddLivingView;
import views.HousesView;

public class AddLivingController implements ActionListener {
	private House house;
	private Application app;
	private AddLivingView view;
	
	public AddLivingController(House house,AddLivingView view) {
		this.house = house;
		this.view = view;
		app = Application.getInstance();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Accept":
			double price;
			LocalDate iniDate;
			int months;
			
			if(view.getIniDate() == "" || view.getMonths() == "" || view.getPrice() == "") {
				JOptionPane.showMessageDialog(null, "You didn't enter all the parameters. Please introduce all the parameters", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			try {
				iniDate = LocalDate.parse(view.getIniDate(), DateTimeFormatter.ISO_LOCAL_DATE);
			}catch(DateTimeParseException n) {
				JOptionPane.showMessageDialog(null, "Date format: YYYY-MM-DD", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			try{
				price = Double.parseDouble(view.getPrice());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The price is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			if (price < 0) {
				JOptionPane.showMessageDialog(null, "The price must be greater than 0. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			try{
				months = Integer.parseInt(view.getMonths());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The months is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			if(iniDate.isBefore(LocalDate.now())) {
				JOptionPane.showMessageDialog(null, "The initial date is before the actual date", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			try {
				app.addOfferLiving(iniDate, price, house, months);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			HousesView newView1;
			try {
				newView1 = new HousesView(app.getLoggedUser().getHost().getHouses(),0);
				HousesController newController1 = new HousesController(newView1,0);
				JOptionPane.showMessageDialog(null, "Offer added");
				view.setVisible(false);
				newView1.setVisible(true);
				newView1.setControlador(newController1);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);

			}
			break;
		case "Cancel":
			HousesView newView11;
			try {
				newView11 = new HousesView(app.getLoggedUser().getHost().getHouses(),0);
				HousesController newController1 = new HousesController(newView11,0);
				view.setVisible(false);
				newView11.setVisible(true);
				newView11.setControlador(newController1);
			} catch (HostException e1) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

	}

}
