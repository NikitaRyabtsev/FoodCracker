package by.htp.example.bean;

public class Meal {

    private String date;
    private String time;
    private double weight;
    private double calories;


    public Meal(String date, String time, double weight, double calories) {
        super();
        this.date = date;
        this.time = time;
        this.weight = weight;
        this.calories = calories;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return
                "Date: " + date + "," +
                        "Time: " + time + ", Weight: " + weight + ", Calories: "
                        + calories + "]";
    }


}
