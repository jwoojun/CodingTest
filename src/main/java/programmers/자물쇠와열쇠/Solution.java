package programmers.자물쇠와열쇠;

public class Solution {
    public static boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int[][] new_lock = new int[n * 3][n * 3];
        // 중앙에 key값
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                new_lock[n + row][n + column] = lock[row][column];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key, n);
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    for (int row = 0; row < m; row++) {
                        for (int column = 0; column < m; column++) {
                            new_lock[x + row][y + column] += key[row][column];
                        }
                    }
                    if (check(new_lock)) {
                        return true;
                    }
                    for (int row = 0; row < m; row++) {
                        for (int column = 0; column < m; column++) {
                            new_lock[x + row][y + column] -= key[row][column];
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int[][] rotate(int[][] key, int n) {
        int r = key.length;
        int c = key[0].length;
        int[][] result = new int[r][c];
        for (int row = 0; row < r; row++) {
            for (int column = 0; column < c; column++) {
                result[row][column] = key[column][c - 1 - row];
            }
        }
        return result;
    }

    static void print(int n, int[][] new_lock) {
        for (int row = 0; row < 3 * n; row++) {
            System.out.println();
            for (int column = 0; column < 3 * n; column++) {
                System.out.print(new_lock[row][column] + " ");
            }
        }
        System.out.println("===========================================");
    }



    public static boolean check(int[][] new_lock) {
        int lock_length = new_lock.length / 3;
        for (int row = lock_length; row < lock_length * 2; row++) {
            for (int column = lock_length; column < lock_length * 2; column++) {
                if (new_lock[row][column] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(4 / 3);
        System.out.println(solution(key, lock));
    }

    static void print() {
        //        int n = 4;
        //        for(int row=0; row<n; row++){
        //            System.out.println();
        //            for(int column=0; column<n; column++){
        //                System.out.print(result[row][column]+" ");
        //            }
        //        }
        //        System.out.println("===================");
        //    }
    }
}
