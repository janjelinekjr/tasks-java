package task3_army;

import task3_army.interfaces.Attack;
import task3_army.interfaces.Defense;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Soldier> soldiersList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        Knight knight1 = new Knight("John", 5);
        Knight knight2 = new Knight("Leo", 5);
        Knight knight3 = new Knight("Mike", 5);
        Archer archer1 = new Archer("Anna", 3);
        Archer archer2 = new Archer("Luck", 3);
        Archer archer3 = new Archer("Salamon", 3);
        Archer archer4 = new Archer("Ornal", 3);
        Swordsman swordsman1 = new Swordsman("Harold", 2);
        Swordsman swordsman2 = new Swordsman("Jonah", 2);
        Swordsman swordsman3 = new Swordsman("Caroline", 2);
        Swordsman swordsman4 = new Swordsman("Patric", 2);
        Swordsman swordsman5 = new Swordsman("Jessica", 2);

        soldiersList.add(knight1);
        soldiersList.add(knight2);
        soldiersList.add(knight3);
        soldiersList.add(archer1);
        soldiersList.add(archer2);
        soldiersList.add(archer3);
        soldiersList.add(archer4);
        soldiersList.add(swordsman1);
        soldiersList.add(swordsman2);
        soldiersList.add(swordsman3);
        soldiersList.add(swordsman4);
        soldiersList.add(swordsman5);

        Army army = new Army(soldiersList);

        while (running) {
            displayCommandsMenu();
            int input = getIntInput();

            switch (input) {
                case 1:
                    army.report();
                    continue;
                case 2:
                    for (Soldier soldier : soldiersList) {
                        if (soldier instanceof Attack) {
                            ((Attack) soldier).makeAttack();
                        }
                    }
                    continue;
                case 3:
                    for (Soldier soldier : soldiersList) {
                        if (soldier instanceof Defense) {
                            ((Defense) soldier).makeDefense();
                        }
                    }
                    continue;
                case 4:
                    army.flank();
                    continue;
                case 5:
                    army.fireDefense();
                    continue;
                case 6:
                    army.shortDistanceAttack();
                    continue;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static int getIntInput() {
        System.out.println("Choose command:");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid option");
            System.out.println("Choose command:");
            scanner.next();
        }

        final int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public static void displayCommandsMenu() {
        System.out.println("-------ARMY GENERAL COMMANDS--------");
        System.out.println("1. REPORT");
        System.out.println("2. ATTACK");
        System.out.println("3. DEFEND");
        System.out.println("-------ARMY SPECIAL COMMANDS--------");
        System.out.println("4. FLANK");
        System.out.println("5. FIRE DEFEND");
        System.out.println("6. SHORT DISTANCE ATTACK");
        System.out.println("-------GAME COMMANDS--------");
        System.out.println("7. QUIT");
    }
}
