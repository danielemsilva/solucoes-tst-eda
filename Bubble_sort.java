import java.util.Scanner;

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
		boolean sorted = true;
		boolean changed;
		do {
			changed = false;
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
				  int aux = array[i];
				  array[i] = array[i + 1];
          array[i + 1] = aux;
					sorted = false;
					changed = true;
	      }
	    }
	    if (changed) {
  	    printArray(array);
	    }
		} while(changed);

		if (sorted) {
		  printArray(array);
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
