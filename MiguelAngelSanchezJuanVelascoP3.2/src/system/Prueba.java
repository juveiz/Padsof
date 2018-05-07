package system;
import java.time.LocalDate;

import offer.ModifiableDate;
public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModifiableDate.setToday();
		LocalDate today = ModifiableDate.getModifiableDate();
		System.out.println(today);
		ModifiableDate.plusDays(10);
		today = ModifiableDate.getModifiableDate();
		System.out.println(today);
	}

}
