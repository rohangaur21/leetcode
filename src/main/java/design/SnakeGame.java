package design;

import java.util.LinkedList;

public class SnakeGame {
    enum CellType {
        EMPTY,
        FOOD,
        SNAKE_NODE;
    }

    class Cell {
        int row, col;
        CellType cellType;
    }

    class Snake {
        LinkedList<Cell> snakePartList = new LinkedList<>();
        Cell head;
        // void grow() => snakePartList.add(head)
        // move(Cell nextCell) => Cell tail = snakePartList.removeLast(); tail.setCellType(CellType.EMPTY); head = nextCell; snakePartList.addFirst(head);
        // boolean checkCrash(Cell nextCell)

    }

    public class Board {
        int ROW_COUNT, COL_COUNT;
        Cell[][] cells;
        // void generateFood() =>  cells[row][column].setCellType(CellType.FOOD);
    }

//    public class Game {
//        int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = -1, DIRECTION_UP = 2, DIRECTION_DOWN = -2;
//        Snake snake;
//        Board board;
//        int direction;
//        boolean gameOver;
//
//        public void update() {
//            if (!gameOver) {
//                if (direction != DIRECTION_NONE) {
//                    Cell nextCell = getNextCell(snake.head);
//                    if (snake.checkCrash(nextCell)) {
//                        direction = DIRECTION_NONE;
//                        gameOver = true;
//                    } else {
//                        snake.move(nextCell);
//                        if (nextCell.getCellType() == CellType.FOOD) {
//                            snake.grow();
//                            board.generateFood();
//                        }
//                    }
//                }
//            }
//        }
//
//        private Cell getNextCell(Cell currentPosition) {
//            System.out.println("Going to find next cell");
//            int row = currentPosition.getRow();
//            int col = currentPosition.getCol();
//
//            if (direction == DIRECTION_RIGHT) {
//                col++;
//            } else if (direction == DIRECTION_LEFT) {
//                col--;
//            } else if (direction == DIRECTION_UP) {
//                row--;
//            } else if (direction == DIRECTION_DOWN) {
//                row++;
//            }
//
//            Cell nextCell = board.getCells()[row][col];
//
//            return nextCell;
//        }
//
//        public static void main(String[] args) {
//
//            System.out.println("Going to start game");
//
//            Cell initPos = new Cell(0, 0);
//            Snake initSnake = new Snake(initPos);
//            Board board = new Board(10, 10);
//            Game newGame = new Game(initSnake, board);
//            newGame.gameOver = false;
//            newGame.direction = DIRECTION_RIGHT;
//
//            // We need to update the game at regular intervals,
//            // and accept user input from the Keyboard.
//
//            // here I have just called the different methods
//            // to show the functionality
//            for (int i = 0; i < 5; i++) {
//                if (i == 2)
//                    newGame.board.generateFood();
//                newGame.update();
//                if (i == 3)
//                    newGame.direction = DIRECTION_RIGHT;
//                if (newGame.gameOver == true)
//                    break;
//            }
//        }
//    }
}
