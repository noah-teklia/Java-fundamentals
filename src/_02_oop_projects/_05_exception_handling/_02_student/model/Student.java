package _02_oop_projects._05_exception_handling._02_student.model;

public class Student implements Person {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);


    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

}
