package boj.impl.boj_16939;

import java.util.Arrays;

public class Main {
  static final int SIDE_COUNT = 6;
  static int[] lineA = {0, 2, 4, 6, 8, 10, 23, 21};
  static int[] lineB = {1, 3, 5, 7, 9, 11, 22, 20};
  static int[] lineC = {12, 13, 4, 5, 16, 17, 20, 21};
  static int[] lineD = {2, 3, 16, 18, 9, 8, 15, 13};
  static int[] lineE = {0, 1, 17, 19, 11, 10, 14, 12};
  static int[][] lines = {lineA, lineB, lineC, lineD, lineE};

  static boolean same(int[] numbers) {
    boolean[] sides = new boolean[SIDE_COUNT];
    for (int side = 0; side < SIDE_COUNT; side++) {
      int[] sideArray = copy(numbers, 4, side * 4, side * 4 + 4);

      if (!hasSameColor(sideArray)) return false;
    }
    //    checkLine(sides, 2, 3);
    //    if(hasSameSide(sides[0], sides[2]) && )
    return false;
  }

  static boolean hasSameSide(boolean valueA, boolean valueB) {
    return valueA && valueB;
  }

  //  static boolean checkLine(int[] array, int lineNumber, int lineNumber2){
  //    int[][] sliceArray = {};
  //    int [] sliceTemp = {};
  //  }

  static boolean hasSameColor(int[] array) {
    return array[0] == array[1] && array[2] == array[3] && array[0] == array[2];
  }

  static boolean hasSameColorInSameLine(int array[]) {
    return false;
  }

  static int[] copy(int[] array, int count, int start, int end) {
    int[] copy = new int[count];
    int i = 0;
    for (int number = start; number < end; number++) {
      copy[i] = array[number];
      i++;
    }
    return copy;
  }

  public static void main(String args[]) {
    int[] array = {1, 2, 3, 4, 5};
    int[] test = copy(array, 3, 1, 4);
    Arrays.stream(test).forEach(System.out::println);
  }
}
