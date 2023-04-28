package Lab3_slot5;

import java.io.*;


public class FileEncryptor {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileEncryptor <input_file> <output_file>");
            System.exit(1);
        }

        String inputFile = args[0];
        String outputFile = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            int c;
            while ((c = reader.read()) != -1) {
                if (Character.isLowerCase(c)) {
                    c = ((c - 'a' + 3) % 26) + 'a';
                } else if (Character.isUpperCase(c)) {
                    c = ((c - 'A' + 3) % 26) + 'A';
                }
                writer.write(c);
            }
        } catch (IOException e) {
            System.out.println("Error encrypting file: " + e.getMessage());
            System.exit(1);
        }

        System.out.println("File encrypted successfully");
    }
}
