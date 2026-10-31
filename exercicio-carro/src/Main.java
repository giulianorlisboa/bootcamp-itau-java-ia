import entities.Car;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter the car brand: ");
        String model = sc.nextLine().trim();
        System.out.print("Enter the car name: ");
        String name = sc.nextLine().trim();
        Car car = new Car(model, name);
        int option = -1;
        do {
            switch (option) {
                case 1 -> car.start();
                case 2 -> car.stop();
                case 3 -> car.accelerate();
                case 4 -> car.brake();
                case 5 -> car.changeGear();
                case 6 -> car.turnLeft();
                case 7 -> car.turnRight();
                case 8 -> car.carStatus();
            }
            option = selectOption(sc);
        } while (option != 0);
        System.out.println("Exiting the program. Goodbye!");

    }

    private static void printMenu() {
        System.out.println("=== Car Menu ===");
        System.out.println("1. Start the car");
        System.out.println("2. Stop the car");
        System.out.println("3. Accelerate");
        System.out.println("4. Brake");
        System.out.println("5. Change gear");
        System.out.println("6. Turn left");
        System.out.println("7. Turn right");
        System.out.println("8. Display speed and gear");
        System.out.println("0. Exit");
    }

    private static int selectOption(Scanner sc) {
        while (true) {
            printMenu();
            try {
                int option = Integer.parseInt(sc.nextLine().trim());
                if (option >= 0 && option <= 8) {
                    return option;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Opção inválida. Tente novamente.");
        }
    }

}
