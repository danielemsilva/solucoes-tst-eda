import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    System.out.println(searchNumberAlone(integers));
  }
  
  public static int searchNumberAlone(int[] array){
    int number = -1;
    for (int i = 0; i < array.length; i++) {
      int count = 0;
      number = array[i];
      for (int j = 0; j < array.length; j++) {
        if (number == array[j]) {
          count++;
        }
      }
      if (count == 1) {
        return number;
      }
    }
    return number;
  }
}
