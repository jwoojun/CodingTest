package programmers.행렬테두리회전;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    static int totalRow;
    static int totalColumn;
    static int [][] board;
    static int[] answer;
    static List<Integer> numbers = new ArrayList<>();

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
        int row1 = array[0];
        int column1 = array[1];
        int row2 = array[2];
        int column2 = array[3];
        int tempNumber = board[row1-1][column1-1];
        int[][] temp = new int[totalRow][totalColumn];

        for(int number=row1-1; number < row2-1; number++){
            temp[number][column1-1] = board[number+1][column1-1];
        }

        for(int number=column1-1; number<column2-1; number++){
            temp[row2-1][number] = board[row2-1][number+1];
        }

        for(int number = row2-1; number>row1-1; number--){
            temp[number][column2-1] = board[number-1][column2-1];
        }

        for(int number = column2-1; number>column1-1; number--){
            temp[row1-1][number] = board[row1-1][number-1];
        }

        temp[row1-1][column1] = tempNumber;

        List<Integer> lst = new ArrayList<>();
        synBoard(temp, board, lst);
        numbers.add(Collections.min(lst));
        board = temp;
        return board;
    }

    static void synBoard(int[][] temp, int[][] board, List<Integer> lst){
        for(int row=0; row<totalRow; row++){
            for(int column=0; column<totalColumn; column++){
                if(temp[row][column]>0){
                    lst.add(temp[row][column]);
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

