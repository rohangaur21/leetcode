import java.util.Arrays;

public class MazeHasPath {
    private static final int[] DIRECTIONS = {0, 1, 0, -1, 0};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }

    private boolean dfs(int[][] maze, boolean[][] visited, int[] start, int[] destination) {
        if (visited[start[0]][start[1]]) {
            return false;
        }
        if (Arrays.equals(start, destination)) {
            return true;
        }

        visited[start[0]][start[1]] = true;

        for (int i = 0; i < DIRECTIONS.length - 1; i++) {
            int[] newStart = roll(maze, start[0], start[1], DIRECTIONS[i], DIRECTIONS[i + 1]);
            if (dfs(maze, visited, newStart, destination)) {
                return true;
            }
        }
        return false;
    }

    private int[] roll(int[][] maze, int row, int col, int rowInc, int colInc) {
        while (canRoll(maze, row + rowInc, col + colInc)) {
            row += rowInc;
            col += colInc;
        }

        return new int[]{row, col};
    }

    private boolean canRoll(int[][] maze, int row, int col) {
        if (row >= maze.length || row < 0 || col >= maze[0].length || col < 0) {
            return false;
        }
        return maze[row][col] != 1; // 1 is a wall
    }

}
