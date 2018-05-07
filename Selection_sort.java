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
  }

  private static void sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int indexLower = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[indexLower]) {
					indexLower = j;
				}
			}
			if (i != indexLower) {
  			int aux = array[i];
  			array[i] = array[indexLower];
  			array[indexLower] = aux;
  			printArray(array);
			}
    }
  }

  private static void printArray(int[] array) {
    System.out.println(Arrays.toString(array));
  }
}
