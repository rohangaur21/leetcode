package misc;

public class Minesweeper {
    public static int[][] DIRECTIONS = {{0, 1}, {1, 1}, {1, 0}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
    public static int lenX;
    public static int lenY;

    public static void show(char[][] board, int x, int y, boolean[][] visited) {
        if (invalid(x, y) || visited[x][y]) {
            return;
        }
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        visited[x][y] = true;
        if (board[x][y] == 'E') {
            board[x][y] = 'B';
            boolean hasMine = false;
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int xx = x + DIRECTIONS[i][0];
                int yy = y + DIRECTIONS[i][1];
                if (!invalid(xx, yy) && (board[xx][yy] == 'M' || board[xx][yy] == 'X')) {
                    if(board[xx][yy]=='M'){
                        board[xx][yy] = 'X';
                    }
                    hasMine = true;
                    break;
                }
            }
            if (hasMine) {
                board[x][y] = '1';
                return;
            }
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int xx = x + DIRECTIONS[i][0];
                int yy = y + DIRECTIONS[i][1];
                show(board, xx, yy, visited);
            }
        }
    }


    private static boolean invalid(int x, int y) {
        boolean flag = false;
        if (x < 0 || y < 0 || x > lenX - 1 || y > lenY - 1) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {//
                {'E', 'E', 'E', 'E', 'E'},
                {'M', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'M', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        lenX = board.length;
        lenY = board[lenX - 1].length;

        prints(board);
        show(board, 3, 0, new boolean[lenX][lenY]);
        System.out.println("----");
        prints(board);
    }

    public static void prints(char[][] chars) {
        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                System.out.print(chars[i][j]);
            }
            System.out.println("");
        }
    }
}
