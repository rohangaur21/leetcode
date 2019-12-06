package misc;

import java.util.LinkedList;
import java.util.Queue;

public class Server0n1Array {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, },
                {0,1}
        };
        System.out.println(getNumOfHoursForAllOne(arr));
    }

    private static int getNumOfHoursForAllOne(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        if (grid.length == 1 && grid[0][0] == 1) return 0;
        int hours = 0;

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }
        int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                Node node = queue.poll();
                for (int i = 0; i < DIRECTIONS.length; i++) {
                    int xx = node.x + DIRECTIONS[i][0];
                    int yy = node.y + DIRECTIONS[i][1];
                    if (xx >= 0 && yy >= 0 && xx < grid.length && yy < grid[0].length && grid[xx][yy] == 0) {
                        grid[xx][yy] = 1;
                        queue.add(new Node(xx, yy));
                    }
                }
            }
            hours++;
        }
        return hours;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
