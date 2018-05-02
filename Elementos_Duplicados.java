import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    System.out.println(searchDuplicated(integers));
  }
  
  public static boolean searchDuplicated(int[] array){
    for (int i = 0; i < array.length; i++){
      for (int j = i + 1; j < array.length; j++){
        if (array[i] == array[j]){
          return true;
        }
      }
    }
    return false;
  }
}
