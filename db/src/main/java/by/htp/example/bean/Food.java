package by.htp.example.bean;

import java.util.Objects;

public class Food {


    private int id;
    private String name;
    private double calories;
    private double proteins;
    private double fats;
    private double carbohydrates;
    private double portion;

    private int keyUserId;
    private int keyMealId;


    public Food() {
    }

    public Food(int id, String name, double calories, double proteins, double fats, double carbohydrates) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Food(String name, double calories, double proteins, double fats, double carbohydrates) {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Food(int id, String name, double calories, double proteins, double fats, double carbohydrates, int keyUserId, int keyMealId) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.keyUserId = keyUserId;
        this.keyMealId = keyMealId;
    }

    public int getKeyUserId() {
        return keyUserId;
    }

    public double getPortion() {
        return portion;
    }

    public void setPortion(double portion) {
        this.portion = portion;
    }

    public void setKeyUserId(int keyUserId) {
        this.keyUserId = keyUserId;
    }

    public int getKeyMealId() {
        return keyMealId;
    }

    public void setKeyMealId(int keyMealId) {
        this.keyMealId = keyMealId;
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

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return id == food.id &&
                Double.compare(food.calories, calories) == 0 &&
                Double.compare(food.proteins, proteins) == 0 &&
                Double.compare(food.fats, fats) == 0 &&
                Double.compare(food.carbohydrates, carbohydrates) == 0 &&
                Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, proteins, fats, carbohydrates);
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                '}';
    }
}

