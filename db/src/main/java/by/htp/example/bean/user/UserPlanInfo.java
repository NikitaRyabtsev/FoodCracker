package by.htp.example.bean.user;

import java.util.Objects;

public class UserPlanInfo {

    private int id;
    private String name;
    private double calories;

    public UserPlanInfo(int id, String name, double calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPlanInfo that = (UserPlanInfo) o;
        return id == that.id &&
                Double.compare(that.calories, calories) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories);
    }

    @Override
    public String toString() {
        return "UserPlanInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}

