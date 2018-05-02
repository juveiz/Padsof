package views;

import java.util.ArrayList;
import java.util.List;

import controllers.HousesController;
import offer.*;
import system.Application;

public class Pruebas {
	public static void main(String args[]) {
		Application app = Application.getInstance();
		System.out.println(app.getUser("51999111X", "pezEspada").getCreditCard());
		
	}
}
