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
            tree.insert(random.nextInt(100));
        }
        tree.print();
        System.out.println();
        System.out.println("Max: " + tree.maxValue());
        System.out.println("Min: " + tree.minValue());
        System.out.println("Summa: " + tree.sum());
        System.out.println("Avg: " + tree.avg());
      /*  System.out.println("Enter number of erase:");
        int numberOfErase = scanner.nextInt();
        tree.erase(tree.getRoot(), numberOfErase);
        tree.print();*/

        //System.out.println("Counter:\t" + tree.count());
        System.out.println("depth:\t" + tree.depth());
        tree.printDepth();
        tree.clear();
       /* UniqueTree u_tree = new UniqueTree();
        for (int i = 0; i < size; i++) {
            u_tree.insert(random.nextInt(100));
        }
        u_tree.print();*/
    }
}