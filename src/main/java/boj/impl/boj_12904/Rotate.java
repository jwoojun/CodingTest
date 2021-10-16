package boj.impl.boj_12904;

public class Rotate {
    static int[][] board = new int[3][3];
    static int[][] turnCounterClockwise(int[][] matrix, final int row_count, final int column_count){
        int[][] array = new int[row_count][column_count];
        for(int row=0; row<row_count; row++){
            for(int col=0; col<column_count; col++){
                array[row][col] = matrix[col][row_count-row];
            }
        }
        return array;
    }

    static int[][] turnClockwise(int[][] matrix, final int row_count, final int column_count){
        int[][] temp = new int[row_count][column_count];
        for(int row=0; row<row_count; row++){
            for(int col=0; col<column_count; col++){
                temp[row][col] = matrix[column_count-col][row];
            }
        }
        return temp;
    }

    static int[][] test(int[][] board){
        int[][] temp = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                temp[row][col] = board[2-col][2-row];
            }
        }
        return temp;
    }

    static int[][] test2(int[][] board){
        int[][] temp = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                temp[row][col] = board[col][row];
            }
        }
        return temp;
    }

    static int[][] 좌우(int[][] board){
        int[][] temp = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                temp[row][col] = board[col][2-row];
            }
        }
        return temp;
    }

    static int[][] 상하(int[][] board){
        int[][] temp = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                temp[row][col] = board[2-col][row];
            }
        }
        return temp;
    }

    static int[][] transFormMatrix(int [][] matrix, final int ROW_COUNT, final int COLUMN_COUNT){
        int[][] temp = new int[COLUMN_COUNT][ROW_COUNT] ;
        for(int row=0; row<COLUMN_COUNT; row++){
            for(int col=0; col<ROW_COUNT; col++){
                temp[row][col] = matrix[col][row];
            }
        }
        return temp;
    }

    public static void main(String[] args){
        int value = 1;
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                board[row][col] = value;
                value++;
            }
        }
        print(board);
        System.out.println();
        int[][] array = 상하(board);
        print(array);
        System.out.println();
        int[][] array_v2 = transFormMatrix(new int[2][4], 2, 4);
        print2(array_v2);

    }

    static void print(int[][] array){
        for(int row=0; row<3; row++){
            System.out.println();
            for(int col=0; col<3; col++){
                System.out.print(array[row][col]+" ");
            }
        }
    }

    static void print2(int[][] array){
        for(int row=0; row<4; row++){
            System.out.println();
            for(int col=0; col<2; col++){
                System.out.print(array[row][col]+" ");
            }
        }
    }

    static void print3(int[][] array){
        for(int row=0; row<2; row++){
            System.out.println();
            for(int col=0; col<4; col++){
                System.out.print(array[row][col]+" ");
            }
        }
    }
}
