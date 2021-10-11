package boj.impl.boj_16939;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Save {
    static Point [][] board = new Point[6][8];
    static Point [][] save = new Point[6][8];
    static Map<String, List<Point>> cube = new HashMap<>();
    static List<String> facet = List.of("back", "front", "left", "right", "top", "bottom");
    public static void main(String[] args) throws Exception {
        init();
        print();
        System.out.println();
        System.out.println("==========================");
        turnRight();
        pushUp_4행() ;
        print2();
        System.out.println("========================");
//        pushDown_3행();

//        turnUpRightReverse();
//        반시계방향회전_안쪽();
//        시계방향회전_바깥();
//        반시계방향회전_바깥();
//        pushLeft_4행();
//        pushRight_4행();
//        pushLeft_3행();
//        pushRight_3행();

//        turnUpLeft();

        System.out.println(0);
//        print();





    }

    static boolean isPossible(){
        for(int i=0; i<facet.size(); i++){
            for(int j=0; j<3; j++){
                if(cube.get(facet.get(i)).get(j).color != cube.get(facet.get(i)).get(j+1).color){
                    return false;
                }
            }
        }
        return true;
    }
    public static Point[][] deepCopy_Object(Point[][] original, int n) {
        if (original == null) {
            return null;
        }

        Point[][] result = new Point[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

    public static int[][] deepCopy(int[][] original, int n) {
        if (original == null) {
            return null;
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }

    private static void synchCubeColor(int[][] position, int[] colors) {
        int [][] newPosition = deepCopy(position, position.length);
        for(int i=0; i<colors.length; i++){
            Point point = board[newPosition[i][0]][newPosition[i][1]];
            point = save[newPosition[i][0]][newPosition[i][1]];
            point.color = colors[i];
        }
    }

    static void reset(){
        Point [][] reset = new Point[6][8];
        for(int row=0; row<6; row++){
            reset[row] = save[row].clone();
        }
        board = new Point[6][8];
        for(int row=0; row<6; row++){
            board[row] = reset[row].clone();
        }
        print();
    }

    static void end(){
        if(isPossible()){
            System.out.println(1);
            System.exit(0);
        }
        reset();
    }

    static void pushRight(int[] array, int [][] position){
        int colorA = array[position.length-1];
        int colorB = array[position.length-2];
        for(int i=0; i<2; i++){
            for(int j=array.length-1; j>=1; j--){
                array[j]= array[j-1];
            }
        }
        array[0] = colorB;
        array[1] = colorA;
    }

    static int[] pushLeft(int[] result, int[] array, int[][] position){
        int colorA = array[0];
        int colorB = array[1];
        for(int i=0; i<2; i++){
            for(int j=0; j<array.length-1; j++){
                result[j]= array[j+1];
            }
        }
        result[position.length-2] = colorA;
        result[position.length-1] = colorB;
        return result;
    }

    static void pushDown_3행(){
        int [][] position = {{4, 2}, {5,2},{3,7}, {2,7}, {0, 2}, {1, 2}, {2, 2}, {3,2}};
        int[] colors = extractColor(position);
        pushRight(colors, position);
        synchCubeColor(position, colors);
        end();
    }


//    static void turnUpLeft(){
//        int [][] position = {{4, 2}, {5,2},{3,7}, {2,7}, {0, 2}, {1, 2}, {2, 2}, {3,2}};
//        int[] colors = extractColor(position);
//        pushLeft(colors, position);
//        synchCubeColor(position, colors);
//        end();
//    }

    static void pushUp_4행(){
        int [][] position = {{4, 3}, {5,3}, {3,6}, {2,6}, {0,3}, {1,3}, {2,3},{3,3}};
//        Point [] points = {board[4][3], board[5][3], board[3][6], board[2][6], board[0][3],
//        board[1][3], board[2][3], board[3][3]};
        Point [][] points = board;
        deepCopy_Object(points, points.length);

        int[] colors = extractColor(position);
        int [] newColor = new int[colors.length];
        newColor = pushLeft(newColor, colors, position);
        System.out.println();
        System.out.println("변질 시작");
        synchCubeColor(position, newColor);
        end();
    }

    static void turnUpRightReverse(){
        int [][] position = {{4, 3}, {5,3}, {3,6}, {2,6},{0,3}, {1,3}, {2,3}, {3,3}};
        int[] colors = extractColor(position);
        pushRight(colors, position);
        synchCubeColor(position, colors);
        end();
    }

//    static void 시계방향회전_바깥(){
//        //
//        int[][] position = {{5,3}, {5,2}, {3,0}, {2,0}, {0,2}, {0,3}, {2,5}, {3,5}};
//        int [] colors = extractColor(position);
//        pushLeft(colors, position);
//        synchCubeColor(position, colors);
//        end();
//    }

    static void 반시계방향회전_바깥(){
        //
        int[][] position = {{5,3}, {5,2}, {3,0}, {2,0}, {0,2}, {0,3}, {2,5}, {3,5}};
        int [] colors = extractColor(position);
        pushRight(colors,position);
        synchCubeColor(position, colors);
        end();
    }


//    static void 반시계방향회전_안쪽(){
//        //
//        int[][] position = {{4,3}, {4,2}, {3,1}, {2,1}, {1,2}, {1,3}, {2,4}, {3,4}};
//        int [] colors = extractColor(position);
//        pushLeft(colors, position);
//        synchCubeColor(position, colors);
//        end();
//    }

    static void turnRight(){
        int[][] position = {{4,3}, {4,2}, {3,1}, {2,1}, {1,2}, {1,3}, {2,4}, {3,4}};
        int [] colors = extractColor(position);
        pushRight(colors, position);
        synchCubeColor(position, colors);
        end();
    }

    static void pushLeft_3행(){
        int colorA = board[2][0].color;
        int colorB = board[2][1].color;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                board[2][j].color = board[2][j + 1].color;
            }
        }
        board[2][board[2].length-2].color = colorA;
        board[2][board[2].length-1].color = colorB;
        end();
    }

    static void pushRight_3행(){
        //
        int colorA = board[2][7].color;
        int colorB = board[2][6].color;
        for (int i = 0; i < 2; i++) {
            for (int j = 7; j > 0; j--) {
                board[2][j].color = board[2][j - 1].color;
            }
        }
        board[2][1].color = colorA;
        board[2][0].color = colorB;
        end();
    }

    static void pushLeft_4행(){
        //
        int colorA = board[3][0].color;
        int colorB = board[3][1].color;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                board[3][j].color = board[3][j + 1].color;
            }
        }
        board[3][board[3].length-2].color = colorA;
        board[3][board[3].length-1].color = colorB;
        end();
    }

    static void pushRight_4행(){
        //
        int colorA = board[3][7].color;
        int colorB = board[3][6].color;
        for (int i = 0; i < 2; i++) {
            for (int j = 7; j > 0; j--) {
                board[3][j].color = board[3][j - 1].color;
            }
        }
        board[3][1].color = colorA;
        board[3][0].color = colorB;
        end();
    }

    static void init() throws Exception {
        cube.put("back", new ArrayList<>());
        for(int row=0; row<2; row++){
            for(int col=2; col<4; col++){
                int color = input.integer();
                Point point = new Point(row, col, color);
                board[row][col] = point;
                save[row][col] = new Point(row, col, color);
                cube.get("back").add(point);
            }
        }

        cube.put("bottom", new ArrayList<>());
        for(int row=2; row<4; row++){
            for(int col=2; col<4; col++){
                int color = input.integer();
                Point point = new Point(row, col, color);
                board[row][col] = point;
                save[row][col] = new Point(row, col, color);
                cube.get("bottom").add(point);
            }
        }

        cube.put("front", new ArrayList<>());
        for(int row=4; row<6; row++){
            for(int col=2; col<4; col++){
                int color = input.integer();
                Point point = new Point(row, col, color);
                board[row][col] = point;
                save[row][col] = new Point(row, col, color);
                cube.get("front").add(point);
            }
        }

        cube.put("left", new ArrayList<>());
        for (int row=2; row<4; row++){
            for(int col=0; col<2; col++){
                int color = input.integer();
                Point point = new Point(row, col, color);
                board[row][col] = point;
                save[row][col] = new Point(row, col, color);
                cube.get("left").add(point);
            }
        }

        cube.put("right", new ArrayList<>());
        for(int row =2; row<4; row++){
            for(int col=4; col< 6; col++){
                int color = input.integer();
                Point point = new Point(row, col, color);
                board[row][col] = point;
                save[row][col] = new Point(row, col, color);
                cube.get("right").add(point);
            }
        }
        cube.put("top", new ArrayList<>());
        for(int row =2; row<4; row++){
            for(int col=6; col< 8; col++){
                int color = input.integer();
                Point point = new Point(row, col, color);
                board[row][col] = point;
                save[row][col] = new Point(row, col, color);
                cube.get("top").add(point);
            }
        }
    }

    static void print(){
        for(int row=0; row<6; row++){
            System.out.println();
            for(int col=0; col<8; col++){
                System.out.print(save[row][col]+" ");
            }
        }
    }

    static void print2(){
        for(int row=0; row<6; row++){
            System.out.println();
            for(int col=0; col<8; col++){
                System.out.print(save[row][col]+" ");
            }
        }
    }

    static int [] extractColor(int[][] array){
        int [] result = new int[array.length];
        for(int i=0; i<array.length; i++){
            result[i] = board[array[i][0]][array[i][1]].color;
        }
        return result;
    }

    static Input input = new Input();
    static class Input {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public int integer() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return Integer.parseInt(st.nextToken());
        }
        public String next() throws Exception{
            if(!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
    }

    static class Point{
        int x;
        int y;
        int color;

        public Point(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        @Override
        public String toString() {
            return color +" ";
        }
    }
}
