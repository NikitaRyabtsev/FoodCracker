package by.htp.example.bean.user;

public class User {

	private int id;
	private String name;
	private String role;
	private String surname;
	private double weight;

	public User() {

	}

	public User(int id, String name, String role, String surname, double weight) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.surname = surname;
		this.weight = weight;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
