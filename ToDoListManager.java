// To Do List Manager
// Touchstone 4 project
// Marvin Trevizo
// 09/25/2025

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<String>();

        boolean running = true;

        System.out.println("=== Welcome to the To-Do List Manager ===");

        while (running) {
            // Menu
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice;

            // Handle invalid input safely
            if (input.hasNextInt()) {
                choice = input.nextInt();
                input.nextLine(); // clear buffer
            } else {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // clear invalid input
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter your new task: ");
                    String newTask = input.nextLine();
                    tasks.add(newTask);
                    System.out.println("Task added!");
                    break;

                case 2:
                    System.out.println("\nYour To-Do List:");
                    if (tasks.isEmpty()) {
                        System.out.println("(No tasks yet)");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nEnter the task number to remove:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove!");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        if (input.hasNextInt()) {
                            int removeIndex = input.nextInt() - 1;
                            input.nextLine(); // clear buffer
                            if (removeIndex >= 0 && removeIndex < tasks.size()) {
                                System.out.println("Removed: " + tasks.remove(removeIndex));
                            } else {
                                System.out.println("Invalid task number.");
                            }
                        } else {
                            System.out.println("Invalid input.");
                            input.nextLine(); // clear bad input
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        input.close();
    }
}
