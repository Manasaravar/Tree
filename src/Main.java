import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert Tree size:");
        int size = scanner.nextInt();
        Random random = new Random(0);
        Tree tree = new Tree();
        for (int i = 0; i < size; i++) {
            tree.insert(random.nextInt(100),tree.getRoot());
        }
        tree.print(tree.getRoot());
        System.out.println();
        System.out.println("Max: " + tree.maxValue(tree.getRoot()));
        System.out.println("Min: " + tree.minValue(tree.getRoot()));
        System.out.println("Summa: " + tree.sum(tree.getRoot()));
        System.out.println("Enter number of erase:");
        int numberOfErase = scanner.nextInt();
        tree.erase(tree.getRoot(), numberOfErase);
        tree.print(tree.getRoot());

        System.out.println("Counter:\t" + tree.count(tree.getRoot()));
        tree.clear();

    }
}