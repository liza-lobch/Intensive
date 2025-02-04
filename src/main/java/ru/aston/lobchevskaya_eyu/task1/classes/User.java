package ru.aston.lobchevskaya_eyu.task1.classes;

import java.util.Objects;

public class User {

    private String surname;
    private String name;
    private Integer age;

    public User(String surname, String name, Integer age) {
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d", surname, name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // проверка на идентичность
            return true;
        }
        if (!(obj instanceof User)) { // проверка типа объекта
            return false;
        }
        User other = (User) obj; // приведение объекта к типу User
        return this.surname.equals(other.surname) && this.name.equals(other.name) && this.age == other.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, age);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}