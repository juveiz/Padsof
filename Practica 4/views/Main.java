package views;


import controllers.LoginController;

public class Main {
	public static void main(String args[]) {
		LoginView view = new LoginView();
		LoginController controller = new LoginController(view);  
		view.setControlador(controller);
		view.setVisible(true);
	}
}
