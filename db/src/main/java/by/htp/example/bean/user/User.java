package by.htp.example.bean.user;

import by.htp.example.bean.dao.Role;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private int id;
    private String login;
    private String password;
    private String email;
    private String name;
    private String secondName;
    private double weight;
    private String sex;
    private LocalDate dateOfBirth;
    private Role role;
    private boolean block;

    public User(int id, String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth, Role role, boolean block) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.secondName = secondName;
        this.weight = weight;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        this.block = block;
    }

    public User(String login , String password){
        this.login = login;
        this.password = password;
    }
    public User(String login,String password,String name){
        this.login = login;
        this.password = password;
        this.name = name;
    }
    public User( String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth) {
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
    public User(int id, String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth, Role role) {
        this.id = id;
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

    public User() {

    }

    public boolean isBlock() {
        return block;
    }


    public void setBlock(boolean block) {
        this.block = block;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Double.compare(user.weight, weight) == 0 &&
                block == user.block &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, name, secondName, weight, sex, dateOfBirth, role, block);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", weight=" + weight +
                ", sex='" + sex + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", role=" + role +
                '}';
    }
}
