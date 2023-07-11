package server;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array of 100 empty strings
        String[] jsonDatabase = new String[100];

        // Initialize the array with empty strings
        Arrays.fill(jsonDatabase, "");

        boolean userWantToExit = false;
        while (!userWantToExit) {
            String userInput = scanner.nextLine();

            // If user input is "exit", set userWantToExit to true and continue to the start of the loop
            if (userInput.equals("exit")) {
                userWantToExit = true;
                continue;
            }

            // Split the user input into an array of strings
            String[] userInputArray = userInput.split(" ");

            // Values of userInputArray: [command, index, input]
            String command = userInputArray[0];

            // Check if index is between 1 and 100 inclusive
            int index = Integer.parseInt(userInputArray[1]);

            // If index is not between 1 and 100 inclusive, print ERROR and continue to next iteration
            if (index < 1 || index > 100) {
                System.out.println("ERROR");
                continue;
            }

            // Check if command is valid (set, get, delete, exit)
            // Execute it if it is valid or print ERROR if it is not valid
            switch (command.toLowerCase()) {
                case "set" -> {
                    // Join the input array from index 2 to the end with a space between each element to form a string
                    String input = String.join(" ", Arrays.copyOfRange(userInputArray, 2, userInputArray.length));

                    jsonDatabase[index - 1] = input;
                    System.out.println("OK");
                }
                case "get" -> {
                    if (jsonDatabase[index - 1].equals("")) {
                        System.out.println("ERROR");
                    } else {
                        System.out.println(jsonDatabase[index - 1]);
                    }
                }
                case "delete" -> {
                    jsonDatabase[index - 1] = "";
                    System.out.println("OK");
                }
                default -> {
                    System.out.println("ERROR");
                }
            }
        }
    }
}
