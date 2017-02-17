package com.example.admin.data.domain;

/**
 * Created by Admin on 2017/2/17.
 */

public class Person {
    public String get_id() {
        return _id;
    }

    public Person set_id(String _id) {
        this._id = _id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getSalary() {
        return salary;
    }

    public Person setSalary(String salary) {
        this.salary = salary;
        return this;
    }

    public Person(String _id, String name, String phone, String salary) {
        this._id = _id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    private String _id;
    private String name;
    private String phone;
    private String salary;
}
