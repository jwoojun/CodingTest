package programmers.행렬테두리회전;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    static int totalRow;
    static int totalColumn;
    static int [][] board;
    static int[] answer;
    static List<Integer> numbers = new ArrayList<>();
    static List<Integer> rotatedNumbers = new ArrayList<>();
    public static int[] solution(int rows, int columns, int[][] queries) {
        totalRow = rows;
        totalColumn = columns;
        board = new int[rows][columns];
        answer = new int[queries.length];
        init(board);

        for (int i = 0; i < queries.length; i++) {
            int[] array = queries[i];
            board = rotate(array);
        }
        return sync(answer);
    }

    static int [] sync(int[] answer){
        for(int i=0; i<numbers.size(); i++){
            answer[i] = numbers.get(i);
        }
        return answer;
    }

    private static void init(int[][] board){
        for(int row=0; row<totalRow; row++){
            for(int column=0; column<totalColumn; column++){
                board[row][column] = ((row)*totalColumn+column+1);
            }
        }
    }

    private static int[][] rotate(int[] array){
        int startRow = array[0];
        int startColumn = array[1];
        int endRow = array[2];
        int endColumn = array[3];
        int tempNumber = board[startRow-1][startColumn-1];
        int[][] temp = new int[totalRow][totalColumn];

        int before = board[startRow][startColumn];

        for(int number=startRow-1; number < endRow-1; number++){
            temp[number][startColumn-1] = board[number+1][startColumn-1];
        }

        for(int number=startColumn-1; number<endColumn-1; number++){
            temp[endRow-1][number] = board[endRow-1][number+1];
        }

        for(int number = endRow-1; number>startRow-1; number--){
            temp[number][endColumn-1] = board[number-1][endColumn-1];
        }

        for(int number = endColumn-1; number>startColumn-1; number--){
            temp[startRow-1][number] = board[startRow-1][number-1];
        }

        temp[startRow-1][startColumn] = tempNumber;

        synBoard(temp, board);
        addMinNumber();
        board = temp;
        return board;
    }

    static void addMinNumber(){
        numbers.add(Collections.min(rotatedNumbers));
        rotatedNumbers.clear();
    }

    static void synBoard(int[][] temp, int[][] board){
        for(int row=0; row<totalRow; row++){
            for(int column=0; column<totalColumn; column++){
                if(temp[row][column]>0){
                    rotatedNumbers.add(temp[row][column]);
                }
                if(temp[row][column]==0){
                    temp[row][column] = board[row][column];
                }
            }
        }
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
}

