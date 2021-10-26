package by.htp.example.bean.user;

import java.time.LocalDate;
import java.util.Objects;

public class UserWeightInfo {

    private double weight;
    private LocalDate dateOfWeighting;

    public UserWeightInfo(double weight, LocalDate dateOfWeighting) {
        this.weight = weight;
        this.dateOfWeighting = dateOfWeighting;
    }

    public UserWeightInfo() {

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getDateOfWeighting() {
        return dateOfWeighting;
    }

    public void setDateOfWeighting(LocalDate dateOfWeighting) {
        this.dateOfWeighting = dateOfWeighting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserWeightInfo that = (UserWeightInfo) o;
        return Double.compare(that.weight, weight) == 0 &&
                Objects.equals(dateOfWeighting, that.dateOfWeighting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, dateOfWeighting);
    }

    @Override
    public String toString() {
        return "UserWeightInfo{" +
                "weight=" + weight +
                ", dateOfWeighting=" + dateOfWeighting +
                '}';
    }
}
