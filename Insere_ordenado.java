import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    sort(integers);
    System.out.println(Arrays.toString(array));
  }

  private static void sort(int[] array) {
    int noSorted = array[array.length - 1];
    int i = array.length - 1;
    while (i > 0 && noSorted < array[i]) {
      int aux = array[i];
      array[i] = array[i - 1];
      array[i - 1] = aux;
      i--;
    }
  }

}
