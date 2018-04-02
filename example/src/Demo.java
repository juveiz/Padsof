import application.MyApplication;
import exception.NameException;
public class Demo {

	public static void main(String[] args) {
		try {
			MyApplication app = new MyApplication("PADSOFT", "Maria de los Remedios", "mr");
		} catch (NameException e) {
			System.out.println("Error. The UserName is really long.");
		}
		
		try {
			MyApplication app = new MyApplication("PADSOFT", "Antonio", "agpardo");
			app.saveInfo("database.obj");
			System.out.println("Application succesfully saved.");
			System.out.println(app.printInfo());
		} catch (NameException e) {
			System.out.println("Error. The UserName is really long.");
		}

		System.out.println("Done");

		System.out.println("Done");
		MyApplication app = null;
		app = MyApplication.loadInfo("database.obj");
		
	}

}
