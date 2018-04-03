package system;

import java.io.*;

import system.*;
import comments.*;
import exception.*;
import offer.*;
import user.*;

public class MainTest {
		public static void main(String[] args) {
			try{
				FileInputStream f = null;
				String line;
				f = new FileInputStream("ClientsExamples.txt");
				BufferedReader buffer = new BufferedReader(new InputStreamReader(f));
				Application app = new Application("Eva","Touris","BolasAbiertas");
				line = buffer.readLine();
				while((line = buffer.readLine()) != null) {
					boolean guest,host;
					String[] newUser = line.split(";");
					if (newUser[0].equals("O")) {
						guest = false;
						host = true;
					}else if(newUser[0].equals("D")) {
						guest = true;
						host = false;
					}else if(newUser[0].equals("OD")) {
						guest = true;
						host = true;
					}else {
						buffer.close();
						return;
					}
					app.addUser(newUser[3],newUser[2],newUser[1],newUser[4],newUser[5],guest,host);
				}
				buffer.close();
			}catch(IOException e) {
		
			}
		
		}
}
