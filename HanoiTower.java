package geekbrains.HomeTask_5;

public class HanoiTower {
    static int counter = 0;

    public static void main(String[] args) {
        tower(8, 1, 2, 3);
        System.out.println();
        System.out.println(counter);
    }

    public static void tower(int rings, int sourceTower, int tempTower, int targetTower) {
        if (rings == 1) print(sourceTower, targetTower);
        else {
            tower(rings - 1, sourceTower, targetTower, tempTower);
            print(sourceTower, targetTower);
            tower(rings - 1, tempTower, sourceTower, targetTower);
        }
    }

    private static void print(int sourceTower, int targetTower) {
        System.out.printf("Put upper ring from %d to %d | ", sourceTower, targetTower);
        if (counter % 5 == 0) {
            System.out.println();
        }
        counter++;
    }
}
