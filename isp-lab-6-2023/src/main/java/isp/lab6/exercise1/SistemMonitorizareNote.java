package isp.lab6.exercise1;

import java.util.ArrayList;

public class SistemMonitorizareNote {
    private ArrayList<Student> studentList;

    public SistemMonitorizareNote() {

        studentList = new ArrayList<>();
    }

    //1-->adaugare a unui student in lista
    public void addStudent(Student student) {
        studentList.add(student);
    }

    //2-->eliminare student din lista
    public boolean removeStudent(String studentId) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(studentId)) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    //3-->metoda de actualizare a unui student
    public boolean updateStudent(String studentId, String firstName, String lastName) {
        for (Student student : studentList) {
            if (student.getId().equals(studentId)) {
                student.setFirstName(firstName);
                student.setLastName(lastName);
                return true;
            }
        }
        return false;
    }

    //4-->metoda pentru calcularea mediei
    public double getAverageGradeDupaId(String studentId) {
        for (Student student : studentList)
            if (student.getId().equals(studentId)) {
                return student.getAverageGrade();
            }
        return 0.0;
    }

    //5-->afisarea listei de studenti
    public void displayStudentList() {
        for (Student student : studentList) {
            System.out.println(student.toString());
        }
    }
}
