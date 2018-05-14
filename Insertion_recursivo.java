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
    sort(integers, 0, integers.length - 1);
  }

  private static void sort(int[] array, int leftIndex, int rightIndex) {
    for (int i = leftIndex; i > 0; i--) {
			if (array[i] < array[i - 1]) {
			  int aux = array[i];
			  array[i] = array[i - 1];
			  array[i - 1] = aux;
			}
		}
		if (leftIndex != 0) {
		  printArray(array);
		}
    if (leftIndex < rightIndex) {
      leftIndex++;
      sort(array, leftIndex, rightIndex);
    }
  }

  private static void printArray(int[] array) {
    System.out.println(Arrays.toString(array));
  }
}
