package programmers.자물쇠와열쇠;


public class Solution {
    static int[][] new_lock;
    static int n;
    static int m;
    public static boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        m = key.length;
        new_lock = new int[n * 3][n * 3];

        insertCenterNumber(lock);

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate(key);
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {
                    insertKey(key, x, y);
                    if (check(new_lock)) {
                        return true;
                    }
                    removeKey(key, x, y);
                }
            }
        }
        return false;
    }

    private static void insertCenterNumber(int [][] lock) {
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                new_lock[n + row][n + column] = lock[row][column];
            }
        }
    }

    private static void insertKey(int[][] key, int x, int y) {
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < m; column++) {
                new_lock[x + row][y + column] += key[row][column];
            }
        }
    }

    private static void removeKey(int[][] key, int x, int y) {
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < m; column++) {
                new_lock[x + row][y + column] -= key[row][column];
            }
        }
    }

    public static int[][] rotate(int[][] key) {
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
}
