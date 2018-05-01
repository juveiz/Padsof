package views;

import java.util.ArrayList;
import java.util.List;

import controllers.HousesController;
import offer.*;

public class Pruebas {
	public static void main(String args[]) {
		List<House> houses = new ArrayList<>();
		for(int i=0; i < 29;i++) {
			houses.add(new House("Madrid", i, "Avenida de la Felicidad nº 23.\n Very wide\nPool"));
		}
		HousesView view = new HousesView(houses,0);
		HousesController controler = new HousesController(view,0);
		view.setVisible(true);
		view.setControlador(controler);
	}
}
