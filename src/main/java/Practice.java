import org.python.modules._py_compile;

public class Practice {
    static int[][] array = new int[3][3];
    static int[][] temp = new int[3][3];
    static int number=  1;
    static int ROW_START_NUMBER = 0;
    static int ROW_END_NUMBER = 3;
    static int COLUMN_START_NUMBER = 0;
    static int COLUMN_END_NUMBER = 3;
    public static void main(String[] args){
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                array[row][col] = number++;
            }
        }

        int before = Integer.MAX_VALUE;
        int after = Integer.MAX_VALUE;
        before = array[0][0];
        for(int i=COLUMN_START_NUMBER+1; i<COLUMN_END_NUMBER; i++){
            after = array[ROW_START_NUMBER][i];
            temp[ROW_START_NUMBER][i] = before;
            before = after;
        }

        for(int i=ROW_START_NUMBER+1; i<ROW_END_NUMBER; i++){
            after = array[i][COLUMN_END_NUMBER-1];
            temp[i][COLUMN_END_NUMBER-1] = before;
            before = after;
        }

        for(int i=COLUMN_END_NUMBER-2; i>=COLUMN_START_NUMBER; i--){
            after = array[ROW_END_NUMBER-1][i];
            temp[ROW_END_NUMBER-1][i] = before;
            before = after;
        }

        for(int i=ROW_END_NUMBER-2; i>=ROW_START_NUMBER; i--){
            after = array[i][COLUMN_START_NUMBER];
            temp[i][COLUMN_START_NUMBER] = before;
            before=after;
        }
        print();


    }

    static void print(){
        for(int row=0; row<3; row++){
            System.out.println();
            for(int col=0; col<3; col++){
                System.out.print(temp[row][col]+" ");
            }
        }
    }
}