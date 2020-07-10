package geekbrains.HomeTask_5;

public class EightQueens {
    public static final int SIZE = 10;
    static int board[][] = new int[SIZE][SIZE];

    public static void main(String[] args) {
        isQueenPlaced(1);
        printBoard();

    }

    public static boolean isQueenPlaced(int number) {
        if (!isBoardDone()) return false;
        if (number == SIZE + 1) return true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = number;
                    if (isQueenPlaced(number + 1))
                        return true;
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }

    static void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static boolean isFight(int x, int y) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0)
                    if (!(i == x && j == y)) {
                        if (i - x == 0 || j - y == 0) return false;
                        if (Math.abs(i - x) == Math.abs(j - y)) return false;
                    }
            }
        }
        return true;
    }

    public static boolean isBoardDone() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != 0)
                    if (!isFight(i, j))
                        return false;
            }
        }
        return true;
    }
}
