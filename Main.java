
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static Scanner input = new Scanner(System.in);

    
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

   
    static void addElements() {

        System.out.print("How many elements do you want to add? ");
        int n = input.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.print("Enter element " + (i + 1) + ": ");
            String element = input.next();

            queue.add(element);
        }

        System.out.println("Elements successfully added!");
    }

   
    static void displayQueue() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue: " + queue);
    }


    static void generatePermutations() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        List<String> elements = new ArrayList<>(queue);

        System.out.println("Queue: " + elements);

        System.out.print("Enter number of elements to arrange: ");
        int r = input.nextInt();

        if (r < 0 || r > elements.size()) {
            System.out.println("Invalid number of elements!");
            return;
        }

        System.out.println();

        int[] count = {0};

        permutation(
            elements,
            new ArrayList<>(),
            new boolean[elements.size()],
            r,
            count
        );

        System.out.println();
        System.out.println("Total Permutations: " + count[0]);
    }
    
    static void permutation(
            List<String> elements,
            List<String> current,
            boolean[] used,
            int r,
            int[] count) {

        if (current.size() == r) {

            for (String element : current) {
                System.out.print(element);
            }

            System.out.println();
            count[0]++;
            return;
        }

        for (int i = 0; i < elements.size(); i++) {

            if (!used[i]) {

                used[i] = true;
                current.add(elements.get(i));

                permutation(
                    elements,
                    current,
                    used,
                    r,
                    count
                );

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

   
    static void generateCombinations() {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        List<String> elements = new ArrayList<>(queue);

        System.out.println("Queue: " + elements);

        System.out.print("Enter number of elements to select: ");
        int r = input.nextInt();

        if (r < 0 || r > elements.size()) {
            System.out.println("Invalid number of elements!");
            return;
        }

        System.out.println();

        int[] count = {0};

        combination(
            elements,
            new ArrayList<>(),
            0,
            r,
            count
        );

        System.out.println();
        System.out.println("Total Combinations: " + count[0]);
    }

    
    static void combination(
            List<String> elements,
            List<String> current,
            int start,
            int r,
            int[] count) {

        if (current.size() == r) {

            for (String element : current) {
                System.out.print(element);
            }

            System.out.println();
            count[0]++;
            return;
        }

        for (int i = start; i < elements.size(); i++) {

            current.add(elements.get(i));

            combination(
                elements,
                current,
                i + 1,
                r,
                count
            );

            current.remove(current.size() - 1);
        }
    }
}
