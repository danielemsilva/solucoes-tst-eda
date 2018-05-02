import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    int position = sc.nextInt();
    replace(integers, 0, position);
  }
  
  public static void replace(int[] array, int leftIndex, int rightIndex) {
    for (int i = rightIndex; i > leftIndex; i--) {
      swap(array, i, i - 1);
    }
    printArray(array);
    leftIndex++;
    rightIndex++;
    if (rightIndex < array.length) {
      replace(array, leftIndex, rightIndex);
    }
  }
  
  public static void swap(int[] array, int i, int j) {
    int aux = array[i];
    array[i]= array[j];
    array[j] = aux;
  }
  
  public static void printArray(int[] array) {
    System.out.print("[");
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i]);
      if (i + 1 != array.length) {
        System.out.print(", ");
      }
    }
    System.out.println("]");
  }
}