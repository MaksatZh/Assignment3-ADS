package test;

import java.util.Objects;

public class MyStudent {
    public String name;
    public int age;
    public String department;

    public MyStudent(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyStudent myStudent = (MyStudent) o;
        return age == myStudent.age && Objects.equals(name, myStudent.name) && Objects.equals(department, myStudent.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, department);
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                '}';
    }
}
