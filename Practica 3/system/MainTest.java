package system;

import java.io.*;

import system.*;

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
					String name;
					String surname;
					for(String word: line.split(";")) {
						
					}
				}
			}catch(IOException e) {
		
			}
		
		}
}
