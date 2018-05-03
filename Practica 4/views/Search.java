package views;

import controllers.SearchZip2Controller;

public class Search {
	public static void main(String args[]) {
		SearchZip2View view = new SearchZip2View();
		SearchZip2Controller controller = new SearchZip2Controller(view);  
		view.setControlador(controller);
		view.setVisible(true);
	}
}
