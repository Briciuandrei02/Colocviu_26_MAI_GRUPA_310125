package isp.lab6.exercise1;

import java.util.HashMap;

public class Student {
    public static Student student;
    private String firstName;
    private String lastName;
    private String Id;
    private HashMap<String, Integer> grades;


    public Student(String firstName, String lastName, String Id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Id = Id;
        this.grades = new HashMap<>();

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void addGrade(String NumeleSubiect, Integer grade) {
        this.grades.put(NumeleSubiect, grade);
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Integer grade : grades.values()) {
            sum = sum + grade;
        }
        return sum / grades.size();
    }

    // Metoda toString
    public String toString() {
        return firstName + " " + lastName + " (" + Id + "): " + grades.toString();
    }
}
