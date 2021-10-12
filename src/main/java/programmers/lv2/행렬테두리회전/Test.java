package programmers.lv2.행렬테두리회전;

public class Test {
    static int [][] matrix = new int[3][3];
    static int [][] temp = new int[3][3];
    static final int ROW_START_NUMBER = 0;
    static final int ROW_LAST_NUMBER = 2;
    static final int COLUMN_START_NUMBER = 0;
    static final int COLUMN_LAST_NUMBER = 2;

    public static void main(String[] args){
        init();
        pirnt();
        System.out.println();
        System.out.println("================================");
        roate();
        System.out.println();
        System.out.println("================================");
        pirnt2();

    System.out.println();
    }

    static void roate(){
        int before = Integer.MAX_VALUE;
        int after = Integer.MAX_VALUE;
        before = matrix[COLUMN_START_NUMBER][0];

        for(int i=1; i<3; i++){
            after = matrix[COLUMN_START_NUMBER][i];
            temp[COLUMN_START_NUMBER][i] = before;
            before = after;
        }
        System.out.println("value="+before);

        for(int i=1; i<3; i++){
            after = matrix[i][ROW_LAST_NUMBER];
            temp[i][ROW_LAST_NUMBER] = before;
            before=after;
        }
        System.out.println("value="+before);
        for(int i=1; i>=0; i--){
            after = matrix[COLUMN_LAST_NUMBER][i];
            temp[COLUMN_LAST_NUMBER][i] = before;
            before = after;
        }
        System.out.println("value="+before);
        for(int i=1; i>=0; i--){
            after = matrix[i][ROW_START_NUMBER];
            temp[i][ROW_START_NUMBER] = before;
            before=after;
        }

    };

    static void init() {
        int i=1;
        for(int row=0; row<3; row++){
            for(int col=0; col<3 ; col++){
                matrix[row][col] = i;
                i++;
            }
        }

        for(int row=0; row<3; row++){
            for(int col=0; col<3 ; col++){
                temp[row][col] = 0;
            }
        }
    }

    static void pirnt(){
        for(int row=0; row<3; row++){
            System.out.println();
            for(int col=0; col<3 ; col++){
                System.out.print(matrix[row][col]+" ");
            }
        }
    }

    static void pirnt2(){
        for(int row=0; row<3; row++){
            System.out.println();
            for(int col=0; col<3 ; col++){
                System.out.print(temp[row][col]+" ");
            }
        }
    }

}
