package task1_tic_tac_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] field = new char[5][5];
        Scanner scanner = new Scanner(System.in);
        int round = 0;
        String winner = "";

        createEmptyField(field);

        displayField(field);

        while (winner.isEmpty()) {
            if (round % 2 == 0) {
                if (checkAndHandleInput("X", scanner, field)) {
                    if (hasLine(field, 'X')) {
                        winner = "Winner: X";
                        System.out.println(winner);
                        displayField(field);
                    } else {
                        displayField(field);
                        round++;
                    }
                }
            } else {
                if (checkAndHandleInput("O", scanner, field)) {
                    if (hasLine(field, 'O')) {
                        winner = "Winner: O";
                        System.out.println(winner);
                        displayField(field);
                    } else {
                        displayField(field);
                        round++;
                    }
                }
            }
        }
    }

    public static boolean hasLine(char[][] field, char player) {
        if (field[0][0] == player && field[0][2] == player && field[0][4] == player) return true;
        if (field[2][0] == player && field[2][2] == player && field[2][4] == player) return true;
        if (field[4][0] == player && field[4][2] == player && field[4][4] == player) return true;

        if (field[0][0] == player && field[2][0] == player && field[4][0] == player) return true;
        if (field[0][2] == player && field[2][2] == player && field[4][2] == player) return true;
        if (field[0][4] == player && field[2][4] == player && field[4][4] == player) return true;

        if (field[0][0] == player && field[2][2] == player && field[4][4] == player) return true;
        if (field[0][4] == player && field[2][2] == player && field[4][0] == player) return true;

        return false;
    }

    public static boolean checkAndHandleInput(String player, Scanner scanner, char[][] field) {
        System.out.println("Player " + player + " enter number (1-9)");
        try {
            int number = scanner.nextInt();

            if (number < 1 || number > 9) {
                System.out.println("Invalid range");
                return false;
            }

            if (!pushPlayerMoveToField(number, player.charAt(0), field)) {
                System.out.println("Field occupied");
                return false;
            }

            return true;

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            scanner.next();
            return false;
        }
    }

    public static boolean pushPlayerMoveToField(int number, char playerChar, char[][] field) {
        int row = ((number - 1) / 3) * 2;
        int col = ((number - 1) % 3) * 2;

        if (field[row][col] == ' ') {
            field[row][col] = playerChar;
            return true;
        } else {
            return false;
        }
    }

    public static void createEmptyField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        field[i][j] = ' ';
                    } else {
                        field[i][j] = '|';
                    }
                } else {
                    field[i][j] = '-';
                }
            }
        }
    }

    public static void displayField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}