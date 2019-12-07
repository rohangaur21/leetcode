package misc;

import java.util.Arrays;

public class GameOfLife {
    final static int[][] directions = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        int[][] countLive = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                countLive[i][j] = getCountLive(board, i, j);
            }
        }

        print(countLive);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    if (countLive[i][j] < 2)
                        board[i][j] = 0;
                    else if (countLive[i][j] > 3)
                        board[i][j] = 0;
                } else {
                    if (countLive[i][j] == 3)
                        board[i][j] = 1;
                }
            }
        }
    }

    public int getCountLive(int[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < directions.length; k++) {
            int xx = i + directions[k][0];
            int yy = j + directions[k][1];
            if (isValid(board, xx, yy)) {
                if (board[xx][yy] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isValid(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        return true;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        print(board);
        System.out.println("---");
        new GameOfLife().gameOfLife(board);
        System.out.println("---");
        print(board);
    }
}
