package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class iMazeShortestPathBFS {
    class Node {
        public int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int[][] DISTANCE = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] end) {
        int min_dist = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Node> queue = new ArrayDeque();
        queue.add(new Node(start[0], start[1], 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == end[0] && node.y == end[1]) {
                min_dist = node.dist;
                break;
            }
            for (int i = 0; i < DISTANCE.length; i++) {
                int[] newStart = move(maze, node.x, node.y, DISTANCE[i][0], DISTANCE[i][1]);
                if (!visited[newStart[0]][newStart[1]]) {
                    visited[newStart[0]][newStart[1]] = true;
                    queue.add(new Node(newStart[0], newStart[1], node.dist + 1));
                }
            }
        }
        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        } else {
            return -1;
        }
    }


    public int[] move(int[][] maze, int x, int y, int xp, int yp) {
        if (canMove(maze, x + xp, y + yp)) {
            x += xp;
            y += yp;
        }
        return new int[]{x, y};
    }

    public boolean canMove(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length ||
                y < 0 || y >= maze[0].length) {
            return false;
        }
        return maze[x][y] != 1;
    }

    public static void main(String[] args) {
        // input maze
        int[][] mat =
                {
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                };
        System.out.println(new iMazeShortestPathBFS().shortestDistance(mat, new int[]{0, 0}, new int[]{2, 0}));
    }
}


