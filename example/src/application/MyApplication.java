package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import exception.NameException;

public class MyApplication implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String _appName;
	public User _owner;
	
	public MyApplication(String name_, String userName_, String owner_) throws NameException{
		_appName = name_;
		if(userName_.length() > 8) {
			NameException ex = new NameException(userName_);
			throw ex;
		}
		
		_owner = new User(userName_, owner_);
	}
	
	public String printInfo() {
		return "Application: " + _appName + ".\tBuilt by: " + _owner.printInfo();
	}
	
	public void saveInfo(String file_) {
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream( new FileOutputStream(file_));
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MyApplication loadInfo(String file_) {
		MyApplication app = null;
		try { 
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file_));
			app = (MyApplication) is.readObject();
			return app;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return app;
	}
}
