import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] array = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      array[i] = Integer.valueOf(input[i]);
    }
    sort(array, 0, array.length - 1);
    printArray(array);
  }

  private static void sort(int[] array, int leftIndex, int rightIndex){
    // Checks if first element is smaller than last
    if (array[leftIndex] > array[rightIndex]) {
      int aux = array[leftIndex];
      array[leftIndex] = array[rightIndex];
      array[rightIndex] = aux;
    }

    // Check if array contains more than 1 element
    if (rightIndex - leftIndex > 1) {
      int particion = (rightIndex - leftIndex + 1) / 3;
      sort(array, leftIndex, rightIndex - particion);
      sort(array, leftIndex + particion, rightIndex);
      sort(array, leftIndex, rightIndex - particion);
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
