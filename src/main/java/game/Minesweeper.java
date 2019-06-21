package game;

public class Minesweeper {
    public static int[] DIRECTIONS = {0, -1, 0, 1, 0};
    public static int lenX = board.length;
    public  static int lenY = board[lenX - 1].length;
    public static void show(char[][] board, int x, int y) {


        if(board[x][y]=='M'){
            board[x][y]='X';
            return;
        }else if (board[x][y]=='E'){
            for(int i=0; i< DIRECTIONS.length -1; i++){
                int xx = x+DIRECTIONS[i];
                int yy= y+DIRECTIONS[i+1];
                if(hasMine(board, x, y)){
                    board[x][y]='1';
                }else{
                    show(board, xx, yy);
                }
            }
        }else if (board[x][y]=='1'){
            return;
        }else if (board[x][y]=='B'){
            return ;
        }


    }

    private static boolean hasMine(char[][] board, int x, int y) {
        if(board)
    }

    private static boolean valid(char[][] board, int x, int y) {
        if(x>=0 || y>=0 || x<lenX ||y<lenY) return true;
        return false;
    }

    public static void main(String[] args) {
 int [][] board = {{'E', 'E', 'E', 'E', 'E'},
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']};
    }
}
