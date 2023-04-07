package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.HashMap;

import static isp.lab6.exercise1.Student.*;

public class Exercise1 {
    public static void main(String[] args) {
        SistemMonitorizareNote system = new SistemMonitorizareNote();
        // Adăugare studenți în sistem
        Student student1 = new Student("Briciu", "Andrei", "52001");
        student1.addGrade("ISP", 8);
        student1.addGrade("TS", 9);
        student1.addGrade("PC", 7);
        system.addStudent(student1);

        Student student2 = new Student("Popescu", "Daniel", "43002");
        student2.addGrade("ISP", 10);
        student2.addGrade("TS", 9);
        student2.addGrade("PC", 8);
        system.addStudent(student2);

        Student student3 = new Student("Pavel", "David", "65003");
        student3.addGrade("ISP", 9);
        student3.addGrade("TS", 7);
        student3.addGrade("PC", 6);
        system.addStudent(student3);

        // Test adăugare student în sistem
        Student student4 = new Student("Grama", "Ioana", "44004");
        student4.addGrade("ISP", 7);
        student4.addGrade("TS", 8);
        student4.addGrade("PC", 9);
        system.addStudent(student4);
        System.out.println("Lista de studenți după adăugarea studentei Ioana:\n");
        system.displayStudentList();

        // Test eliminare student din sistem
        boolean removed = system.removeStudent("65003");
        if (removed) {
            System.out.println("\nStudentul cu ID-ul 65003 a fost eliminat din sistem.");
        } else
            System.out.println("\nNu s-a găsit niciun student cu ID-ul 65003 în sistem.\n");

        System.out.println("Lista de studenți după eliminarea studentului Daniel:\n");
        system.displayStudentList();

        // Test actualizare informații student
        boolean updated = system.updateStudent("77775", "Robert", "Iacob");
        if (updated) {
            System.out.println("Informațiile studentului cu ID-ul 77775 au fost actualizate.\n");
        } else {
            System.out.println("Nu s-a găsit niciun student cu ID-ul 77775 în sistem.");
        }
        System.out.println("Lista de studenți după actualizarea informațiilor lui David:\n");
        system.displayStudentList();

        // Test calculare medie generală a unui student
        double averageGrade = system.getAverageGradeDupaId("43002");
        System.out.println("Media generală a lui Popescu Daniel este: " + averageGrade);

        // Test afișare listă de studenți
        System.out.println("\nLista de studenți:");
        system.displayStudentList();
    }

}


