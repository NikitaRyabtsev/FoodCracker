package by.htp.example.bean.user;


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
    private String role;
    private String block;


    public User(int id, String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth){
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.secondName = secondName;
        this.weight = weight;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {

    }

    public User(int id , String block){
        this.id = id;
        this.block = block;
    }
    public User(String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth, String role, String block) {

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

    public User(int id , String login, String password, String email, String name, String secondName, double weight, String sex, LocalDate dateOfBirth,String role,String block) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.secondName = secondName;
        this.weight = weight;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.block = block;
        this.role = role;
    }

    public User(String block) {
        this.block = block;
    }

    public User(int id) {
        this.id = id;
    }


    public User(String role, String name, int id, String block,String email) {
        this.role = role;
        this.name = name;
        this.id = id;
        this.block = block;
        this.email = email;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Double.compare(user.weight, weight) == 0 &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(name, user.name) &&
                Objects.equals(secondName, user.secondName) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(dateOfBirth, user.dateOfBirth) &&
                Objects.equals(role, user.role) &&
                Objects.equals(block, user.block);
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
                ", role='" + role + '\'' +
                ", block='" + block + '\'' +
                '}';
    }
}
