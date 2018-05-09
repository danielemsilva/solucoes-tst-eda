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
		for (int i = leftIndex; i <= rightIndex; i++) {
			if (array[leftIndex] >= array[i]) {
        int temp = array[i];
        array[i] = array[leftIndex];
        array[leftIndex] = temp;
  		}
  	}
  	if (leftIndex < rightIndex) {
      System.out.println(Arrays.toString(array));
      leftIndex++;
      sort(array, leftIndex, rightIndex);
    }
  }

}
