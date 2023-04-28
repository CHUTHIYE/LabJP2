package Lab3_slot5;

import java.io.*;
import java.util.*;


public class StudentManager {
    class Student {
        private String name;
        private int age;
        private double mark;

        public Student(String name, int age, double mark) {
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
    }
    private static final String FILE_NAME = "students.txt";
    private static final int MENU_ADD = 1;
    private static final int MENU_LOAD = 2;
    private static final int MENU_EXIT = 3;

    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Menu");
            System.out.println("---------------------------");
            System.out.println("1. Add a list of Students and save to File");
            System.out.println("2. Loading list of Students from a File");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case MENU_ADD:
                    System.out.print("Enter number of students to add: ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter student mark: ");
                        double mark = scanner.nextDouble();
                        scanner.nextLine();

                        students.add(new Student(name, age, mark));
                    }

                    try (DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(new FileOutputStream(FILE_NAME)))) {
                        for (Student student : students) {
                            dos.writeUTF(student.getName());
                            dos.writeInt(student.getAge());
                            dos.writeDouble(student.getMark());
                        }

                        System.out.println("Students added and saved to file successfully!");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case MENU_LOAD:
                    students.clear();

                    try (DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(new FileInputStream(FILE_NAME)))) {
                        while (dis.available() > 0) {
                            String name = dis.readUTF();
                            int age = dis.readInt();
                            double mark = dis.readDouble();

                            students.add(new Student(name, age, mark));
                        }

                        System.out.println("Students loaded from file successfully!");
                    } catch (IOException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    for (Student student : students) {
                        System.out.println(student);
                    }

                    break;

                case MENU_EXIT:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}



