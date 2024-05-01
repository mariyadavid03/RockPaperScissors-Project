package project;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
    static ArrayList<Character> strike = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        System.out.println("==========================");
        System.out.println(" Rock Paper Scissors Game ");
        System.out.println("==========================");

        //Instructions to Play
        System.out.println("\nInstructions:"
                + "\nSelect an object using its number"
                + "\n\t1 for Rock"
                + "\n\t2 for Paper"
                + "\n\t3 for Scissors");
        System.out.println("\nLet's Start");

        try {
            System.out.print("\nEnter Your Name: ");
            String userName = scanner.next();

            //Game Loop
            do {
                userGame();
                status();
            } while (count < 3);

            if (status()) {
                System.out.println(userName+" WIN the game!");
            } else {
                System.out.println("PC WINS the game!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //User's Turn Game
    public static void userGame() {
        System.out.print("\nEnter Object Number: ");
        int ob = scanner.nextInt();
        if (inputCheck(ob)) {
            int out = generateOb();
            System.out.print("Your Object: " + toObjName(ob));
            System.out.print("\nPC Generated Object: " + toObjName(out));
            gameLogic(ob, out);
        }
    }

    //Checking for wining status
    public static void gameLogic(int ob, int out) {
        System.out.println(count);
        if (ob == out) {
            System.out.println("\nDraw");
            strike.add('D');
            count++;
        } else if ((ob == 1 && out == 3) || (ob == 2 && out == 1) || (ob == 3 && out == 2)) {
            System.out.println("\nYou Win this Round");
            strike.add('W');
            count++;
        } else {
            System.out.println("\nPC Win this Round");
            strike.add('L');
            count++;
        }
    }

    //Generating Random Index
    public static int generateOb() {
        Random rand = new Random();
        return rand.nextInt(3) + 1; 
    }

    //Replace number with object name
    public static String toObjName(int num) {
        switch (num) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return null;
        }
    }

    //Checking user input
    public static boolean inputCheck(int num) {
        return num > 0 && num < 4;
    }

    //Checking for Strike
    public static boolean status() {
        int winCount = 0;
        int lossCount = 0;

        for (char result : strike) {
            if (result == 'W') {
                winCount++;
            } else if (result == 'L') {
                lossCount++;
            } 
        }
        
        return winCount > lossCount;
    }
}