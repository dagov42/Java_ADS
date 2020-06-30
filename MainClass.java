package geekbrains.HomeTask_1;

public class MainClass {
    public static void main(String[] args) {
        System.out.println(ratio(5, -2));

        int[] array = {5, 3, 10, -1, 2, 0};
        System.out.println(min(array));
        System.out.println(middleAriphmetic(array));
    }

    public static double ratio(int base, int sign) { // O(n), т.к. мы проходим только один раз циклом
        double result = base > 0 ? 1 : -1;
        if (sign == 0) return 1;
        if (base == 0) return 0;
        for (int i = 0; i < Math.abs(sign); i++) {
            result *= base;
        }
        return (sign < 0) ? 1 / result : result;
    }

    public static int min(int[] array) { // О(n) , т.к. тоже всего 1 цикл
        int min = array[0];
        for (int i : array) {
            if (i < min) min = i;
        }
        return min;
    }

    public static double middleAriphmetic(int[] array) { // О(n) , т.к. тоже всего 1 цикл
        double result = 0;
        for (int i : array) {
            result += i;
        }
        return result / array.length;
    }
}
