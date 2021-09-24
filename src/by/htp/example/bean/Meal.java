package by.htp.example.bean;

public class Meal {

	private String name;
	private String date;
	private double weight;
	private double calories;

	public Meal(String name, String date, double weight, double calories) {
		super();
		this.name = name;
		this.date = date;
		this.weight = weight;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	@Override
	public String toString() {
		return name + ", date=" + date + ", weight=" + weight + ", calories=" + calories + "]";
	}



}
