package boj.impl.boj_2580;

public class Test {
    static int start_number = 1;
    public static void main(String args []){
        int [][] array = new int[3][3];
        int [][] copy = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                array[row][col] = start_number++;
            }
        }

        copy = array;

        for(int row=0; row<3; row++){
            System.out.println();
            for(int col=0; col<3; col++){
                System.out.print(copy[row][col]+" ");
            }
        }
    }
}
