import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    int number = sc.nextInt();
    System.out.println(searchNumber(integers, number, 0));
  }
  
  public static int searchNumber(int[] array, int number, int index){
    if (index == array.length) {
      return -1;
    } else if (array[index] == number){
      return index;
    }
    return searchNumber(array, number, index + 1);
  }
}
