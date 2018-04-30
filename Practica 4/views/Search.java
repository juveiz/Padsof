package views;

import controllers.SearchZipController;

public class Search {
	public static void main(String args[]) {
		SearchZipView view = new SearchZipView();
		SearchZipController controller = new SearchZipController(view);  
		view.setControlador(controller);
		view.setVisible(true);
	}
}
