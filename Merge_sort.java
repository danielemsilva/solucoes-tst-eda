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
    sort(integers, 0, integers.length);
  }

  private static void merge(int[] array, int leftIndex, int middle, int rightIndex) {
		// Creates an array equal to the original
		int[] auxArray = Arrays.copyOf(array, array.length);
		// This index is the beginning of the left array
		int i = leftIndex;
		// This index is the beginning of the right array
		int j = middle + 1;
		// This index will go through the array
		int k = leftIndex;
		// Here goes through the two arrays looking for the lowest value
		while (i <= middle && j <= rightIndex) {
			// The lowest is in the left array
			if (auxArray[i] <= auxArray[j]) {
				array[k] = auxArray[i];
				i++; // Increments the index to the next position of this array
			} else {
				array[k] = auxArray[j];
				j++;
			}
			k++;
		}
		// Add the rest of the left array, if there is any
		while (i <= middle) {
			array[k] = auxArray[i];
			i++;
			k++;
		}
		// Add the rest of the right array, if there is any
		while (j <= rightIndex) {
			array[k] = auxArray[j];
			j++;
			k++;
		}

    printArray(array, leftIndex, rightIndex);
	}

	public static void sort(int[] array, int leftIndex, int rightIndex) {
		// Exceptional cases
		if (array == null || array.length == 0) {
			return;
		}
		if (leftIndex > rightIndex) {
			return;
		}
		if (leftIndex < 0 || rightIndex >= array.length) {
			return;
		}
		// leftIndex should not exceed the rightIndex
		if (leftIndex < rightIndex) {
			// Finds the middle position
			int middle = (leftIndex + rightIndex) / 2;
			// Separates the first half of the array
			sort(array, leftIndex, middle);
			// Separates the second half of the array
			sort(array, middle + 1, rightIndex);
			// Merges parts of the array to sort
			merge(array, leftIndex, middle, rightIndex);
		}
  }

  private static void printArray(int[] array, int leftIndex, int rightIndex) {
    for (int i = leftIndex; i <= rightIndex; i++) {
      if (i == leftIndex) {
        System.out.print("[");
      }
      if (i == rightIndex) {
        System.out.print("]");
      }
      System.out.print(array[i]);
      if (i < rightIndex) {
          System.out.print(" ");
      }
    }
    System.out.println();
  }
}
