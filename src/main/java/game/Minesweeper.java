package game;

import java.util.Arrays;

public class Minesweeper {
    public static int[] DIRECTIONS = {0, -1, 0, 1, 0};
    public static int lenX;
    public static int lenY;

    public static void show(char[][] board, int x, int y) {
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        } else if (board[x][y] == 'E') {
            for (int i = 0; i < DIRECTIONS.length - 1; i++) {
                int xx = x + DIRECTIONS[i];
                int yy = y + DIRECTIONS[i + 1];
                if (valid(xx, yy)) {
                    if (hasMine(board, xx, yy)) {
                        board[x][y] = '1';
                    } else {
                        board[x][y] = 'B';
                        show(board, xx, yy);
                    }
                }
            }
        } else if (board[x][y] == '1') {
            return;
        } else if (board[x][y] == 'B') {
            return;
        }


    }

    private static boolean hasMine(char[][] board, int x, int y) {
//        System.out.println(board[x][y] + "" + x + "" + y);
        if (board[x][y] == 'M') return true;
        return false;
    }

    private static boolean valid(int x, int y) {
        if (x >= 0 && y >= 0 && x < lenX && y < lenY) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        prints(board);
//        lenX = board.length;
//        lenY = board[lenX - 1].length;
//        show(board, 3, 0);
//        prints(board);
    }

    public static void prints(char[][] chars) {
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println();
        }
    }
}
