package Lab6_slot8.Past4;

import java.util.Scanner;

public class CarManagement {
    static Scanner scanner = new Scanner(System.in);
    static GenericCar<Car> carList = new GenericCar<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Car");
            System.out.println("2. Display Cars");
            System.out.println("3. Get Size");
            System.out.println("4. Check if Empty");
            System.out.println("5. Grad");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    displayCars();
                    break;
                case 3:
                    getSize();
                    break;
                case 4:
                    checkEmpty();
                    break;
                case 5:
                    grad();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }

    static void addCar() {
        System.out.print("Enter car name: ");
        String name = scanner.nextLine();
        if (!name.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid car name. It should not contain any numeric characters.");
            return;
        }
        System.out.print("Enter car price: ");
        String priceString = scanner.nextLine();
        if (!priceString.matches("^[0-9]+$")) {
            System.out.println("Invalid car price. It should only contain numeric characters.");
            return;
        }
        int price = Integer.parseInt(priceString);
        System.out.print("Enter car production year: ");
        int production = scanner.nextInt();
        scanner.nextLine();
        Car car = new Car(name, price, production);
        carList.add(car);
        System.out.println("Car added.");
    }

    static void displayCars() {
        System.out.println("Cars:");
        carList.display();
    }

    static void getSize() {
        System.out.println("Number of cars: " + carList.getSize());
    }

    static void checkEmpty() {
        if (carList.checkEmpty()) {
            System.out.println("There are no cars.");
        } else {
            System.out.println("There are " + carList.getSize() + " cars.");
        }
    }

    static void grad() {
        System.out.println("Congratulations! You have successfully graduated from the program.");
    }
}

