import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int number = Integer.valueOf(sc.nextLine());
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    System.out.println(frequency(integers, number));
  }
  
  public static int frequency(int[] array, int number){
    int count = 0;
    for (int i = 0; i < array.length; i++) {
        if (array[i] == number) {
          count++;
        }
    }
    return count;
  }
}
