package by.htp.example.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Meal implements Serializable {

	private int keyUserId;
//	@XmlTransient
	private int id;
//	@XmlElement(name="DateOfEating")
	private LocalDate date;
	private LocalTime time;
	private double weight;
	private double calories;

	public Meal(int id){
		super();
		this.id = id;
	}
	public Meal() {}

	public Meal(LocalDate date, LocalTime time, double weight, double calories) {
		super();
		this.date = date;
		this.time = time;
		this.weight = weight;
		this.calories = calories;
	}

	public Meal(int id, LocalDate date, LocalTime time, double weight, double calories) {
		super();
		this.id = id;
		this.date = date;
		this.time = time;
		this.weight = weight;
		this.calories = calories;
	}

	public Meal(LocalDate date, LocalTime time, double weight, double calories, int keyUserId) {

		this.date = date;
		this.time = time;
		this.weight = weight;
		this.calories = calories;
		this.keyUserId = keyUserId;
	}

    public Meal(LocalDate date, LocalTime time ,int id) {
		this.date = date;
		this.time = time;
		this.id = id;
    }


	public int getKeyUserId() {
		return keyUserId;
	}

	public void setKeyUserId(int keyUserId) {
		this.keyUserId = keyUserId;
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
		return "Meal{" +
				"id=" + id +
				", date=" + date +
				", time=" + time +
				", weight=" + weight +
				", calories=" + calories +
				'}';
	}
}
