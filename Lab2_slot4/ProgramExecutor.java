package Lab2_slot4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProgramExecutor {
    private static List<String> programNames = new ArrayList<>();
    private static List<String> programPaths = new ArrayList<>();

    public static void main(String[] args) {
        loadPrograms();
        displayPrograms();
        selectProgram();
    }

    private static void loadPrograms() {
        try (BufferedReader reader = new BufferedReader(new FileReader("programs.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                programNames.add(parts[0]);
                programPaths.add(parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Error loading programs: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void displayPrograms() {
        System.out.println("Available programs:");
        for (int i = 0; i < programNames.size(); i++) {
            System.out.println((i + 1) + ". " + programNames.get(i));
        }
    }

    private static void selectProgram() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a program to run (enter number): ");
        int selection = scanner.nextInt();
        if (selection < 1 || selection > programNames.size()) {
            System.out.println("Invalid selection");
            selectProgram();
        } else {
            String programPath = programPaths.get(selection - 1);
            try {
                Runtime.getRuntime().exec(programPath);
            } catch (IOException e) {
                System.out.println("Error running program: " + e.getMessage());
            }
        }
    }
}
