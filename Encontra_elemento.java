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
    if (searchNumber(integers, number)) {
      System.out.println("sim");
    } else {
      System.out.println("nao");
    }
  }
  
  public static boolean searchNumber(int[] array, int number){
    for (int i = 0; i < array.length; i++) {
        if (array[i] == number) {
          return true;
        }
    }
    return false;
  }
}
