package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import exception.HostException;
import system.Application;
import views.AddHouseView;
import views.HousesView;

public class AddHouseController implements ActionListener {
	
	private Application app;
	private AddHouseView view;
	
	public AddHouseController(AddHouseView view) {
		app = Application.getInstance();
		this.view = view;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource();
		
		switch(button.getActionCommand()) {
		case "Accept":
			String city;
			int zip;
			String description;
			city = view.getCity();
			description = view.getDescription();
			
			if(city.equals("") || description.equals("") || view.getZip().equals("")) {
				JOptionPane.showMessageDialog(null, "You didn't enter all the parameters. Please introduce all the parameters", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			if(city == null || description == null|| view.getZip() == null) {
				JOptionPane.showMessageDialog(null, "You didn't enter all the parameters. Please introduce all the parameters", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			try{
				zip = Integer.parseInt(view.getZip());
			}catch(NumberFormatException n){
				JOptionPane.showMessageDialog(null, "The zip is not a number. Please introduce a number", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}
			
			
			try {
				app.addHouse(city, zip, description);
			} catch (HostException e2) {
				JOptionPane.showMessageDialog(null, "This won't happen", "Error", JOptionPane.ERROR_MESSAGE);
				break;
			}

			HousesView newView1;
			try {
				newView1 = new HousesView(app.getLoggedUser().getHost().getHouses(),0);
				HousesController newController1 = new HousesController(newView1,0);
				JOptionPane.showMessageDialog(null, "House added");
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
