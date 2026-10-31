package main;

import entities.Pet;
import entities.PetWash;

import java.util.Scanner;


public class Main {

    private final static PetWash petMachine = new PetWash();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option;
        do {
            option = selectOption(sc);
            switch (option) {
                case 1 -> petMachine.washPet();
                case 2 -> petMachine.addWater();
                case 3 -> petMachine.addShampoo();
                case 4 -> {
                    if (petMachine.hasPet()) {
                        System.out.println("Há um pet na máquina. Retire o pet antes de lavar a máquina.");
                    } else {
                        petMachine.washMachine();
                    }
                }
                case 5 -> {
                    System.out.println("Nível de água: " + petMachine.getWater() + " litros");
                    System.out.println("Nível de shampoo: " + petMachine.getShampoo() + " litros");
                }
                case 6 -> {
                    if (petMachine.hasPet()) {
                        System.out.println("Já há um pet na máquina. Retire o pet antes de colocar outro.");
                    } else {
                        String name;
                        do {
                            System.out.print("Digite o nome do pet: ");
                            name = sc.nextLine().trim();
                        } while (name.isBlank());
                        if (petMachine.setPet(new Pet(name))) {
                            System.out.println("Pet " + name + " colocado na máquina.");
                        }
                    }
                }
                case 7 -> {
                    if (petMachine.hasPet()) {
                        petMachine.removePet();
                    } else {
                        System.out.println("Não há nenhum pet na máquina.");
                    }
                }
                case 8 -> {
                    if (petMachine.hasPet()) {
                        System.out.println("Há um pet na máquina.");
                    } else {
                        System.out.println("Não há nenhum pet na máquina.");
                    }
                }
                case 0 -> System.out.println("Saindo do programa...");
            }

        }
        while (option != 0);
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

    private static void printMenu() {
        System.out.println();
        System.out.println("1 - Dar banho no pet");
        System.out.println("2 - Adicionar água na máquina");
        System.out.println("3 - Adicionar Shampoo na máquina");
        System.out.println("4 - Lavar a máquina");
        System.out.println("5 - Verificar nível de água e shampoo");
        System.out.println("6 - Colocar pet na máquina");
        System.out.println("7 - Tirar pet da máquina");
        System.out.println("8 - Verificar se há pet na máquina");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

}
