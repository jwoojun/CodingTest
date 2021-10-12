package programmers.lv3.자물쇠와열쇠;

public class Practice {
    public static void main(String[] args){
        int [][] board = new int[4][4];
        int i = 1;
        for(int row=0; row<4; row++){
            System.out.println();
            for(int column=0; column<4; column++){
                board[row][column] = i++;
            }
        }
        for (int j = 0; j < 3; j++) {
            board = rotate(board);
            for(int row=0; row<4; row++){
                System.out.println();
                for(int column=0; column<4; column++){
                    System.out.print(board[row][column] + " ");
                }
            }

            System.out.println("======================");
            System.out.println();

        }

//        for(int row=0; row<4; row++){
//            System.out.println();
//            for(int column=0; column<4; column++){
//                System.out.print(board[row][column] + " ");
//            }
//        }
//        int [][] copy = new int[4][4];
//        for(int row=0; row<4; row++){
//            System.out.println();
//            for(int column=0; column<4; column++){
//                copy[row][column] = board[column][3-row];
//            }
//        }

//        for(int row=0; row<4; row++){
//            System.out.println();
//            for(int column=0; column<4; column++){
//                copy[row][column] = board[3-column][row];
//            }
//        }
//
//        for(int row=0; row<4; row++){
//            System.out.println();
//            for(int column=0; column<4; column++){
//                System.out.print(copy[row][column] + " ");
//            }
//        }
    }
    static int[][] rotate(int[][] board){
        int[][] copy = new int[4][4];
        for(int row=0; row<4; row++){
            System.out.println();
            for(int column=0; column<4; column++){
                copy[row][column] = board[column][3-row];
            }
        }
        board = copy;
        return board;
    }
}
