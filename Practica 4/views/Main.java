package views;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import controllers.loginController;
import system.Application;

public class Main {
	public static void main(String args[]) {
		Application app = Application.getApplication("Eva", "Touris", "OpenBalls");
		System.out.println("First we charge the users for the txt");
		try {
			FileInputStream f = null;
			String line;
			f = new FileInputStream("ClientsExample.txt");
			BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
			buffer.readLine();
			while ((line = buffer.readLine()) != null) {
				boolean guest, host;
				String[] newUser = line.split(";");
				if (newUser[0].equals("O")) {
					guest = false;
					host = true;
				} else if (newUser[0].equals("D")) {
					guest = true;
					host = false;
				} else if (newUser[0].equals("OD")) {
					guest = true;
					host = true;
				} else {
					buffer.close();
					return;
				}
				System.out
						.println(app.addUser(newUser[3], newUser[2], newUser[1], newUser[4], newUser[5], guest, host));
			}
			buffer.close();
			System.out.println("User file charged for first time\n");
		} catch (IOException e) {
			System.out.println("The given file hasn't been opened");
			return;
		}
		loginView view = new loginView();
		loginController controller = new loginController(view);  
		view.setControlador(controller);
		view.setVisible(true);
	}
}
