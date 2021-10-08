package boj.impl.boj_2580;

public class Position {
    static int x = 1;
    static int y = 0;
    static int direction = 2;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    public static void main(String[] args){
        int[][] array = new int[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                array[row][col] = 1;
            }
        }

        int next_x = x+dy[direction];
        int next_y = y+dx[direction];

        System.out.println("next_x= "+next_x);
        System.out.println("next_y= "+next_y);
        array[x][y] = 0;
        array[next_x][next_y] = 0;

        for(int row=0; row<3; row++){
            System.out.println();
            for(int col=0; col<3; col++){
                System.out.print(array[row][col]+" ");
            }
        }
    }
}


