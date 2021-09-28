package by.htp.example.bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Meal {

	private int id;
	private LocalDate date;
	private LocalTime time;
	private double weight;
	private double calories;

	public Meal() {}

	public Meal(int id, LocalDate date, LocalTime time, double weight, double calories) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.weight = weight;
		this.calories = calories;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
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
	public int hashCode() {
		return Objects.hash(calories, date, id, time, weight);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
		return Double.doubleToLongBits(calories) == Double.doubleToLongBits(other.calories)
				&& Objects.equals(date, other.date) && id == other.id && Objects.equals(time, other.time)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}


	@Override
	public String toString() {
		return id + ". Date: " + date + ", Time: " + time + ", Weight: " + weight + ", Calories " + calories;
	}

	
	



}
