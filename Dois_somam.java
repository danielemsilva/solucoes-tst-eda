import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int[] integers = new int[input.length];
    for (int i = 0; i < input.length; i++) {
      integers[i] = Integer.valueOf(input[i]);
    }
    int sum = sc.nextInt();
    
    boolean found = false;
    int i = 0;
    while (i + 1 < integers.length && !found) {
      for (int j = i + 1; j < integers.length; j++){
        if (integers[i] + integers[j] == sum){
          found = true;
          System.out.println(integers[i] + " " + integers[j]);
        }
      }
      i++;
    }
    if (!found) {
      System.out.println("-1");
    }
  }
  
}