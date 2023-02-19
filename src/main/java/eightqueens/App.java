package eightqueens;

import java.util.Arrays;

/**
 * OBJECTIVE:
 * Place 8 queens on a chessboard in such way that none of the queens can take each other.
 *
 * Chessboard has 8x8 tiles.
 *
 * The program must print a two dimensional array  where 1 means the queen is there, 0 means the queen is not there.
 *
 * End result looks like this:
 * 0 0 1 0 0 0 0 0
 * 0 0 0 0 1 0 0 0
 * 0 0 0 0 0 0 1 0
 * 0 1 0 0 0 0 0 0
 * 0 0 0 1 0 0 0 0
 * 0 0 0 0 0 1 0 0
 * 0 0 0 0 0 0 0 1
 * 0 0 0 0 0 0 0 0
 *
 *
 */
public class App  {

    public static void main( String[] args ) {

        int[][] chessboard = new int[8][8];

        fillRow(chessboard);

        printChessboard(chessboard);

    }


    private static void fillRow(int[][] chessboard) {

        short queenIsHere = 1;
        short queenIsNotHere = 0;

        try {


        for (int i=0; i<chessboard.length; i++) {

            chessboard[i][i] = queenIsHere;

            Arrays.fill(chessboard[i], i+1, chessboard[i].length, queenIsNotHere);


        }

        } catch (ArrayIndexOutOfBoundsException e) {


            e.printStackTrace();

        }



    }

    private static void printChessboard(int[][] chessboard) {


        for (int[] row : chessboard){

        System.out.println(Arrays.toString(row));

        }

    }

}
