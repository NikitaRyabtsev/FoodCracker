package by.htp.example.bean.user;

import java.time.LocalDate;
import java.util.Objects;

public class User {

	private String login;
	private String password;
	private String email;
	private String name;
	private String secondName;
	private double weight;
	private String sex;
	private LocalDate dateOfBirth;
	private String role;

	public User(String login,String password , String name, String role){
		this.login = login;
		this.password = password;
		this.name = name;
		this.role = role;
	}
	public User(String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth, String role) {
		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.secondName = secondName;
		this.weight = weight;
		this.sex = sex;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getSecondName() {
		return secondName;
	}

	public double getWeight() {
		return weight;
	}

	public String getSex() {
		return sex;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getRole() {
		return role;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Double.compare(user.weight, weight) == 0 &&
				Objects.equals(login, user.login) &&
				Objects.equals(password, user.password) &&
				Objects.equals(email, user.email) &&
				Objects.equals(name, user.name) &&
				Objects.equals(secondName, user.secondName) &&
				Objects.equals(sex, user.sex) &&
				Objects.equals(dateOfBirth, user.dateOfBirth) &&
				Objects.equals(role, user.role);
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password, email, name, secondName, weight, sex, dateOfBirth, role);
	}

	@Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", name='" + name + '\'' +
				", secondName='" + secondName + '\'' +
				", weight=" + weight +
				", sex='" + sex + '\'' +
				", dateOfBirth=" + dateOfBirth +
				", role='" + role + '\'' +
				'}';
	}
}
