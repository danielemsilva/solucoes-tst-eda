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
    exchange(integers);
  }
  
  public static void exchange(int[] array) {
    int size = array.length;
    if (size % 2 != 0){
      size -= 1;
    }
    for (int i = 0; i < size; i += 2) {
      int aux = array[i];
      array[i] = array[i + 1];
      array[i + 1] = aux;
    }
    System.out.println(Arrays.toString(array));
  }
}
