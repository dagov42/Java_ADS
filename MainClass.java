package geekbrains.HomeTask_2;

public class MainClass {
    public static void main(String[] args) {
        Array array = new Array(2, 6, 1, 0, -12, -177, 12, 18, 24, -26, 5);
        System.out.println(array.sortBubble());
        System.out.println(array.sortBubbleSimple());
        System.out.println(array.sortInsert());
        System.out.println(array.sortSelect());

    }
}
