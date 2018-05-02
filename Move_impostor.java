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
    searchNumber(integers);
  }
  
  public static void searchNumber(int[] array) {
    boolean found = false;
    int i = 0;
    while(i < array.length && !found){
      if (array[i] > array[i + 1]){
        found = true;
        exchange(array, i + 1);
      }
      i++;
    }
    System.out.println(Arrays.toString(array));
  }
  
  public static void exchange(int[] array, int position) {
    for(int i = position; i >= 1; i--){
      if (array[i] < array[i - 1]) {
        int aux = array[i];
        array[i] = array[i - 1];
        array[i - 1] = aux;
      }
    }
  }
}
