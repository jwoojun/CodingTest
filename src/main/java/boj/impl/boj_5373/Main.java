package boj.impl.boj_5373;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
  static int n;
  static char[][][] cube;
  static char[][] map;
  static Map<Integer, int[][]> position = new HashMap<>();
  static char[] colors = new char[] {'w', 'y', 'r', 'o', 'g', 'b'};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    init();
//    cube[L][0][0]= 'A';
    counter_clockwise(U);
    counter_clockwise(D);
    clockwise(L);
    clockwise(R);



//    counter_clockwise(L);
//    counter_clockwise(D);
//    clockwise(L);
//    counter_clockwise(U);
//    counter_clockwise(L);
//    counter_clockwise(U);
//    counter_clockwise(U);
//    clockwise(L);
//    clockwise(U);
//    clockwise(U);

    print();
//    n = input.integer();
//    while (n-- > 0) {
//      int count = input.integer();
//      String [] array= new String[count];
//      for(int i=0; i<count; i++){
//        array[i] = input.next();
//      }
//      rotate(array);
//      print();
//      init();
//      System.out.println();
//      System.out.println("====================================================");
//    }
  }

  static void init() {
    cube = new char[6][3][3];
    for (int number = 0; number < 6; number++) {
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          cube[number][row][col] = colors[number];
        }
      }
    }
    // F
    int[][] arrayF = {
            {L, 2, 2}, {L, 1, 2}, {L, 0, 2}, {U, 2, 0}, {U, 2, 1}, {U, 2, 2},
            {R, 0, 0}, {R, 1, 0}, {R, 2, 0}, {D, 0, 2}, {D, 0, 1}, {D, 0, 0}
    };
    // U
    int[][] arrayU = {
            {L, 0, 0}, {L, 0, 1}, {L, 0, 2}, {F, 0, 0}, {F, 0, 1}, {F, 0, 2},
            {R, 0, 0}, {R, 0, 1}, {R, 0, 2}, {B, 0, 0}, {B, 0, 1}, {B, 0, 2}

    };
    // L -> B 순서바꿈
    int[][] arrayL = {
            {U, 2, 0}, {U, 1, 0}, {U, 0, 0}, {F, 0, 0}, {F, 1, 0}, {F, 2, 0},
            {D, 0, 0}, {D, 1, 0}, {D, 2, 0}, {B, 2, 2}, {B, 1, 2}, {B, 0, 2}
    };
    // R -> B수정(순서 바꿈)
    int[][] arrayR = {
            {U, 0, 2}, {U, 1, 2}, {U, 2, 2}, {B, 2, 0}, {B, 1, 0}, {B, 0, 0},
            {D, 2, 2}, {D, 1, 2}, {D, 0, 2}, {F, 0, 2}, {F, 1, 2}, {F, 2, 2}
    };
    // D
    int[][] arrayD = {
            {L, 2, 0}, {L, 2, 1}, {L, 2, 2}, {F, 2, 0}, {F, 2, 1}, {F, 2, 2},
            {R, 2, 0}, {R, 2, 1}, {R, 2, 2}, {B, 2, 0}, {B, 2, 1}, {B, 2, 2}
    };
    // B
    int[][] arrayB = {
            {L, 2, 0}, {L, 1, 0}, {L, 0, 0}, {U, 0, 0}, {U, 0, 1}, {U, 0, 2},
            {R, 0, 2}, {R, 1, 2}, {R, 2, 2}, {D, 2, 2}, {D, 2, 1}, {D, 2, 0}
    };
    position.put(U, arrayU);
    position.put(F, arrayF);
    position.put(L, arrayL);
    position.put(R, arrayR);
    position.put(D, arrayD);
    position.put(B, arrayB);
  }

  static void print() {
    map = new char[9][12];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 12; j++) {
        map[i][j] = '0';
      }
    }
    for (int i = 0; i < 3; i++) {
      for (int j = 3; j < 6; j++) {
        map[i][j] = cube[U][i][j - 3];
      }
    }
    for (int i = 3; i < 6; i++) {
      for (int j = 0; j < 3; j++) {
        map[i][j] = cube[L][i - 3][j];
      }
    }

    for (int i = 3; i < 6; i++) {
      for (int j = 3; j < 6; j++) {
        map[i][j] = cube[F][i - 3][j - 3];
      }
    }
    for (int i = 3; i < 6; i++) {
      for (int j = 6; j < 9; j++) {
        map[i][j] = cube[R][i - 3][j - 6];
      }
    }
    // B
    for (int i = 3; i < 6; i++) {
      for (int j = 9; j < 12; j++) {
        map[i][j] = cube[B][i - 3][j - 9];
      }
    }
    for (int i = 6; i < 9; i++) {
      for (int j = 3; j < 6; j++) {
        map[i][j] = cube[D][i - 6][j - 3];
      }
    }
    for (int i = 0; i < 9; i++) {
      System.out.println();
      for (int j = 0; j < 12; j++) {
        System.out.print(map[i][j] + " ");
      }
    }
//    for (int i = 0; i < 3; i++) {
//      System.out.println();
//      for (int j = 0; j < 3; j++) {
//        System.out.print(cube[U][i][j] + " ");
//      }
//    }
  }

  static void counter_clockwise(int facet) {
    char[][] temp = new char[3][3];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        temp[row][col] = cube[facet][col][2-row];
      }
    }
    cube[facet] = temp;

    int[][] array = position.get(facet);
    char colorA = cube[array[0][0]][array[0][1]][array[0][2]];
    char colorB = cube[array[1][0]][array[1][1]][array[1][2]];
    char colorC = cube[array[2][0]][array[2][1]][array[2][2]];
    for (int i = 0; i < 9; i++) {
      cube[array[i][0]][array[i][1]][array[i][2]] =
              cube[array[i + 3][0]][array[i + 3][1]][array[i + 3][2]];
    }
    cube[array[9][0]][array[9][1]][array[9][2]] = colorA;
    cube[array[10][0]][array[10][1]][array[10][2]] = colorB;
    cube[array[11][0]][array[11][1]][array[11][2]] = colorC;
  }

  static void clockwise(int facet) {
    char[][] temp = new char[3][3];
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        temp[row][col] = cube[facet][2-col][row];
      }
    }
    cube[facet] = temp;
    int[][] array = position.get(facet);
    char colorA = cube[array[9][0]][array[9][1]][array[9][2]];
    char colorB = cube[array[10][0]][array[10][1]][array[10][2]];
    char colorC = cube[array[11][0]][array[11][1]][array[11][2]];
    for (int i = 8; i >= 0; i--) {
      cube[array[i + 3][0]][array[i + 3][1]][array[i + 3][2]] =
              cube[array[i][0]][array[i][1]][array[i][2]];
    }
    cube[array[0][0]][array[0][1]][array[0][2]] = colorA;
    cube[array[1][0]][array[1][1]][array[1][2]] = colorB;
    cube[array[2][0]][array[2][1]][array[2][2]] = colorC;
  }

//  static void rotate(String[] array) {
//    int count = array.length;
//    System.out.println(count);
//    for (int i = 0; i < count; i++) {
//      boolean direction = array[i].charAt(1) == '+';
//      System.out.println("Direction= "+array[i].charAt(0));
//      switch (array[i].charAt(0)) {
//        case 'U':
//          change(U, direction);
//          break;
//        case 'D':
//          change(D, direction);
//          break;
//        case 'F':
//          change(F, direction);
//          break;
//        case 'B':
//          change(B, direction);
//          break;
//        case 'L':
//          change(L, direction);
//          break;
//        case 'R':
//          change(R, direction);
//          break;
//      }
//      print();
//    }
//  }

  static Input input = new Input();

  static class Input {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    public int integer() throws Exception {
      if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
      return Integer.parseInt(st.nextToken());
    }

    public String next() throws Exception {
      if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
      return st.nextToken();
    }

    public char[] nToCharArray() throws Exception {
      if (!st.hasMoreElements()) st = new StringTokenizer(br.readLine());
      return st.nextToken().toCharArray();
    }
  }
}
