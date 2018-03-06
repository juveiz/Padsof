
public class Admin {
	
	private String name;
	private String surname;
	private String password;
	private int id;
	
	public Admin(String name, String surname, String password, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
