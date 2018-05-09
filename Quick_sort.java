import java.util.Scanner;

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

  private static int separate(int[] array, int leftIndex, int rightIndex) {
		// Assumes that the smallest element is in the first position
		int pivot = array[leftIndex];

		int j = leftIndex;
		// Here will scroll through the array looking for the values
		// smaller or equal to the pivot and switching to the first positions
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[i] <= pivot) {
				j++;
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
			}
		}
    int aux = array[j];
    array[j] = array[leftIndex];
    array[leftIndex] = aux;

		// This index indicates the new position of the ordered pivot
		return j;
	}

	private static void sort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int particion = separate(array, leftIndex, rightIndex);
			printArray(array);
			// Here is the first part of the array, with values smaller than the pivot
			sort(array, leftIndex, particion - 1);
			// In this part are the values greater than the pivot
			sort(array, particion + 1, rightIndex);
		}
  }

  private static void printArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i + 1 != array.length) {
        System.out.print(" ");
      }
    }
    System.out.println();
  }

}
