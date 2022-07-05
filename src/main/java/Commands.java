import java.util.ArrayList;
import java.util.Scanner;

public class Commands {

    private final Scanner scanner = new Scanner(System.in);;
    private final String name;
    private final String[] commands;
    private String nextCommands;

    public Commands(String name, String[] commands, String nextCommand) {
        this.name = name;
        this.commands = commands;
        this.nextCommands = nextCommand;
    }

    public String getNextCommands() {
        return nextCommands;
    }

    public void setNextCommands(String nextCommand) {
        this.nextCommands = nextCommand;
    }

    public void printMessage(String message) {
        System.out.println("-----");
        System.out.println(message);
        System.out.println("-----");
    }

    public void printGreeting() {
        System.out.println("Welcome to the " + name + " commands.");
    }

    public void printCommands(String[] stringArr) {
        for (int i = 0; i < stringArr.length; i++) {
            System.out.println((i+1) + ": " + stringArr[i]);
        }
    }

    public void printCommands() {
        printCommands(commands);
    }

    public void printCommands(ArrayList<String> stringList) {
        int index = 1;
        for (String string : stringList) {
            System.out.println((index) + ": " + string);
            index += 1;
        }
    }

    public int getIntegerInput(int rangeLimit) {
        boolean correctInput = false;
        int input = 0;
        while (!correctInput) {
            printMessage("Enter a number between 1 and " + rangeLimit);
            int userInput = scanner.nextInt();
            if (userInput > 0 && userInput <= rangeLimit) {
                correctInput = true;
                input = userInput;
            } else {
                printMessage("Invalid input. Please input a number between 1 and " + rangeLimit);
            }
        }
        scanner.nextLine();
        return input;
    }

    public int getIntegerInput() {
        return getIntegerInput(commands.length);
    }

    public String getStringInput() {
        System.out.println("Enter text below: ");

        String userInput = scanner.nextLine();
        if (userInput.equals("")) {
            System.out.println("Unable to understand input, try again");
            return getStringInput();
        } else {
            return userInput;
        }
    }

}
