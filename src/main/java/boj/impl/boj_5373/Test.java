package boj.impl.boj_5373;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
  private static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;
  static int n, m;
  static int[][] rotate = new int[6][12];

  static int[][][] cube = new int[6][3][3];
  ;
  static char[] cubeNumbers = new char[54];
  static char[][] temp = new char[3][3];
  static char[] colors = new char[] {'w', 'y', 'r', 'o', 'g', 'b'};
  static Map<Character, Integer> commands = new HashMap<>();
  static Map<Integer, Facet> repository = new HashMap<>();

  static void initCommands() {
    commands.put('-', 3);
    commands.put('+', 1);
    commands.put('U', 0);
    commands.put('D', 1);
    commands.put('F', 2);
    commands.put('B', 3);
    commands.put('L', 4);
    commands.put('R', 5);
  }

  static void initCube() {
    for (int facet = 0; facet < 6; facet++) {
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          cube[facet][row][col] = facet * 9 + row * 3 + col;
          cubeNumbers[facet*9+row*3+col] = colors[facet];
//          repository.put(facet * 9 + row * 3 + col, new Facet(facet * 9 + row * 3 + col, colors[facet]));
        }
      }
    }
    rotate[U] = new int[] {36, 37, 38, 18, 19, 20, 45, 46, 47, 27, 28, 29};
    rotate[D] = new int[] {33, 34, 35, 51, 52, 53, 24, 25, 26, 42, 43, 44};
    rotate[F] = new int[] {6, 7, 8, 44, 41, 38, 11, 10, 9, 45, 48, 51};
    rotate[B] = new int[] {2, 1, 0, 53, 50, 47, 15, 16, 17, 36, 39, 42};
    rotate[L] = new int[] {0, 3, 6, 35, 32, 29, 9, 12, 15, 18, 21, 24};
    rotate[R] = new int[] {8, 5, 2, 26, 23, 20, 17, 14, 11, 27, 30, 33};
    System.out.println();
//    System.out.println("===========================================================================================");
//    Arrays.asList(cubeNumbers).forEach(System.out::println);
//    System.out.println();
//    System.out.println("===========================================================================================");
  }

  static void rotate(int facet, int count) {
    char[] queue = new char[12];
    while (count-- > 0) {
      for (int i = 0; i < 12; i++) {
        queue[i] = cubeNumbers[rotate[facet][i]];
      }
//      Arrays.asList(queue).forEach(System.out::println);

      for (int i = 0; i < 12; i++) {
        cubeNumbers[rotate[facet][i]] = queue[(i + 3) % 12];
      }

      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
          System.out.println((char)cube[facet][i][j]);
          temp[i][j] = (char) cube[facet][j][2-i];
        }
      }

      for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
//          System.out.println((char)cube[facet][i][j]);
          cube[facet][j][2-i] = temp[i][j];
        }
      }
    }
  }

  static void printt() {
    for (int number = 0; number < 6; number++) {
      System.out.println("========================================");
      for (int row = 0; row < 3; row++) {
        System.out.println();
        for (int col = 0; col < 3; col++) {
          System.out.print(cube[number][row][col] + " ");
        }
      }
    }
  }

  static void init() {
    for (int number = 0; number < 6; number++) {
      for (int row = 0; row < 3; row++) {
        for (int col = 0; col < 3; col++) {
          cube[number][row][col] = colors[number];
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    n = input.integer();
    initCommands();
    initCube();
//    repository.values().forEach(System.out::println);
    while (n-- > 0) {
      init();

      m = input.integer();
      List<String> lst = new ArrayList<>();
      for (int i = 0; i < m; i++) {
        String str = input.next();
        if (str.length() != 0) {
          lst.add(str);
        }
      }

      for (int i = 0; i < m; i++) {
        rotate(commands.get(lst.get(i).charAt(0)), commands.get(lst.get(i).charAt(1)));
      }
      for (int row = 0; row < 3; row++) {
        System.out.println();
        for (int col = 0; col < 3; col++) {
          System.out.print((char) cube[U][row][col]);
        }
      }
    }
  }
//
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

  static class Facet {
    int no;
    char color;

    public Facet(int no, char color) {
      this.no = no;
      this.color = color;
    }

    @Override
    public String toString() {
      return "Facet{" +
              "no=" + no +
              ", color=" + color +
              '}';
    }
  }
}
