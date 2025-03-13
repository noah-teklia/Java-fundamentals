package _02_oop_projects._06_file_handling.student;

public class Student implements Person {

    private int id;
    private String name;
    private Course course;
    private int marks;

    public Student(int id, String name, Course course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + course + "," + marks;
    }

    public static Student fromString(String line) {
        String[] lineArray = line.split(",");

        int id = Integer.parseInt(lineArray[0]);
        String name = lineArray[1];
        Course course = Course.fromString(lineArray[2]);
        int mark = Integer.parseInt(lineArray[3]);

        Student student = new Student(id, name, course, mark);
        return student;
    }
    public void displayDetails(){
        System.out.println("Student ID: "+id);
        System.out.println("Student Name: "+name);
        System.out.println("Student Course: "+course);
        System.out.println("Student Marks: "+marks);
    }
}
