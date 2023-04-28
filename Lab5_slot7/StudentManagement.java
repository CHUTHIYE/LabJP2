package Lab5_slot7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String rollNumber;
    private String name;
    private int age;
    private double mark;

    public Student(String rollNumber, String name, int age, double mark) {
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Mark: %.2f", name, age, mark);
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
public class StudentManagement {

    static Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Students");
            System.out.println("2. Update a Student");
            System.out.println("3. Delete a Student");
            System.out.println("4. Search Students");
            System.out.println("5. Display All Students");
            System.out.println("6. Save to File");
            System.out.println("7. Load from File");
            System.out.println("8. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudents();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudents();
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    loadFromFile();
                    break;
                case 8:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 8);
    }

    private static void displayAllStudents() {
        System.out.println("List All Student");
        System.out.println(studentList);
    }

    static void addStudents() {
        System.out.print("Enter number of students to add: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.print("Roll Number: ");
            String rollNumber = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Mark: ");
            double mark = scanner.nextDouble();
            scanner.nextLine();
            Student student = new Student(rollNumber, name, age, mark);
            studentList.add(student);
        }
    }

    static void updateStudent() {
        System.out.print("Enter roll number of student to update: ");
        String rollNumber = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getRollNumber().equals(rollNumber)) {
                System.out.println("Student " + student.getRollNumber() + ":");
                System.out.print("Name (" + student.getName() + "): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    student.setName(name);
                }
                System.out.print("Age (" + student.getAge() + "): ");
                String ageString = scanner.nextLine();
                if (!ageString.isEmpty()) {
                    int age = Integer.parseInt(ageString);
                    student.setAge(age);
                }
                System.out.print("Mark (" + student.getMark() + "): ");
                String markString = scanner.nextLine();
                if (!markString.isEmpty()) {
                    double mark = Double.parseDouble(markString);
                    student.setMark(mark);
                }
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter roll number of student to delete: ");
        String rollNumber = scanner.nextLine();
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getRollNumber().equals(rollNumber)) {
                iterator.remove();
                System.out.println("Student deleted.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void searchStudents() {
        System.out.print("Enter age to search: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        List<Student> results = studentList.stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
        if (results.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Students found:");
            for (Student student : results) {
                System.out.println(student);
            }
        }
    }

    static void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            outputStream.writeObject(studentList);
            System.out.println("Students saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("students.dat"))) {
            studentList = (List<Student>) inputStream.readObject();
            System.out.println("Students loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
