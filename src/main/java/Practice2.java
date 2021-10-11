public class Practice2 {
    static int[][] array = new int[9][9];
    static int[][] temp = new int[9][9];
    static int number=  0;
    static int ROW_START_NUMBER = 0;
    static int ROW_END_NUMBER = 9;
    static int COLUMN_START_NUMBER = 0;
    static int COLUMN_END_NUMBER = 9;
    public static void main(String[] args){
        for(int row=ROW_START_NUMBER; row<ROW_END_NUMBER; row++){
            for(int col=COLUMN_START_NUMBER; col<COLUMN_END_NUMBER; col++){
                array[row][col] = number++;
                if(number==3){
                    number=0;
                }
            }
        }
        print();
        System.out.println();
        System.out.println("========================================");

        int before = Integer.MAX_VALUE;
        int after = Integer.MAX_VALUE;
        print();
        System.out.println();
        System.out.println("========================================");
        before = array[0][0];
        for(int i=COLUMN_START_NUMBER+1; i<COLUMN_END_NUMBER; i++){
            after = array[ROW_START_NUMBER][i];
            temp[ROW_START_NUMBER][i] = before;
            before = after;
        }

        for(int i=ROW_START_NUMBER+1; i<3; i++){
            after = array[i][COLUMN_END_NUMBER-1];
            temp[i][COLUMN_END_NUMBER-1] = before;
            before = after;
        }

        for(int i=COLUMN_END_NUMBER-2; i>=COLUMN_START_NUMBER; i--){
            after = array[2][i];
            temp[2][i] = before;
            before = after;
        }

        for(int i=2; i>=ROW_START_NUMBER; i--){
            after = array[i][0];
            temp[i][0] = before;
            before=after;
        }
        print2();
        System.out.println();
        System.out.println("========================================");
    }

    static void print(){
        for(int row=ROW_START_NUMBER; row<ROW_END_NUMBER; row++){
            System.out.println();
            for(int col=COLUMN_START_NUMBER; col<COLUMN_END_NUMBER; col++){
                System.out.print(array[row][col]+" ");
            }
        }
    }

    static void print2(){
        for(int row=ROW_START_NUMBER; row<ROW_END_NUMBER; row++){
            System.out.println();
            for(int col=COLUMN_START_NUMBER; col<COLUMN_END_NUMBER; col++){
                System.out.print(temp[row][col]+" ");
            }
        }
    }
}