package geekbrains.HomeTask_6;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    final static int TREES = 20;
    static int max = 100;
    static int min = -100;
    static int LEVEL = 6;


    public static void main(String[] args) {
        int balancedCounter = 0;
        for (int i = 0; i < TREES; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            Randoms(list, 2000);
            Tree tree = new Tree(list);
            balancedCounter += tree.isBalanced();
        }
        System.out.println(balancedCounter * 100f / TREES + "%");
    }

    public static void Randoms(ArrayList<Integer> list, int quantity) {
        Random random = new Random();
        while (list.size() < quantity) {
            max -= min;
            int number = (int) (Math.random() * ++max) + min;
            if (!list.contains(number)) {
                list.add(number);
            }
        }
    }
}
