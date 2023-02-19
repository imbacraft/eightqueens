package eightqueens;

import java.util.Arrays;

/**
 * OBJECTIVE: Place 8 queens on a board in such way that none of the queens can take each other.
 *
 * <p>Board has 8x8 tiles.
 *
 * <p>The program must print a two dimensional array where 1 means the queen is there, 0 means the
 * queen is not there.
 *
 * <p>End result looks like this: 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0
 * 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0
 */
public class App {

  public static void main(String[] args) {

    int[][] board = new int[8][8];

    fillBoardWithZeroes(board);
    placeQueen(board);
    printBoard(board);
  }

  private static void fillBoardWithZeroes(int[][] board) {

    for (int i = 0; i < board.length; i++) {

      Arrays.fill(board[i], 0);
    }
  }

  private static void placeQueen(int[][] board) {

    int rowCounter = 0;

    try {

      while (rowCounter < board.length) {

        for (int column = 0; column < board.length; column++) {

          if (horizontalRowIsFree(board, rowCounter)
              && verticalRowIsFree(board, column)
              && diagonalRowIsFree(board, rowCounter, column)) {

            board[rowCounter][column] = 1;
          }
        }

        rowCounter++;
      }

    } catch (ArrayIndexOutOfBoundsException e) {

      e.printStackTrace();
    }
  }

  private static void printBoard(int[][] board) {

    for (int[] row : board) {

      System.out.println(Arrays.toString(row));
    }
  }

  private static boolean horizontalRowIsFree(int[][] board, int rowToCheck) {

    for (int i = 0; i < board.length; i++) {

      if (board[rowToCheck][i] == 1) {

        return false;
      }
    }

    return true;
  }

  private static boolean verticalRowIsFree(int[][] board, int column) {

    for (int i = 0; i < board.length; i++) {

      if (board[i][column] == 1) {

        return false;
      }
    }

    return true;
  }

  private static boolean diagonalRowIsFree(int[][] board, int row, int column) {

    if (downRightDiagonalDirectionIsFree(board, row, column)
        && downLeftDiagonalDirectionIsFree(board, row, column)) {

      return true;
    }

    return false;
  }

  private static boolean downRightDiagonalDirectionIsFree(int[][] board, int row, int column) {

    int rowToCheck;
    int columnToCheck;

    for (int i = 0; i < board.length; i++) {

      rowToCheck = row + i;
      columnToCheck = column + i;

      if (rowToCheck == board.length || columnToCheck == board.length) {

        break;
      }

      if (board[rowToCheck][columnToCheck] == 1) {

        return false;
      }
    }

    return true;
  }

  private static boolean downLeftDiagonalDirectionIsFree(int[][] board, int row, int column) {

    try {

      int rowToCheck;
      int columnToCheck;

      for (int i = 0; i < board.length; i++) {

        rowToCheck = row + i;
        columnToCheck = column - i;

        if (rowToCheck == board.length){

            break;
        }

        if (columnToCheck < 0) {

            break;
        }


        if (board[rowToCheck][columnToCheck] == 1) {

          return false;
        }
      }

    } catch (ArrayIndexOutOfBoundsException e) {

      e.printStackTrace();
    }

    return true;
  }
}
