import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input1 = sc.nextLine().split(" ");
    String[] input2 = sc.nextLine().split(" ");
    
    int[] arraySmaller = new int[input1.length];
    for (int i = 0; i < input1.length; i++) {
      arraySmaller[i] = Integer.valueOf(input1[i]);
    }
    int[] arrayBigger = new int[input2.length];
    for (int i = 0; i < input2.length; i++) {
      arrayBigger[i] = Integer.valueOf(input2[i]);
    }
    
    for (int i = 0; i < arrayBigger.length; i++) {
      boolean found = false;
      for (int j = 0; j < arraySmaller.length; j++) {
        if (arrayBigger[i] == arraySmaller[j]) {
          found = true;
        }
      }
      if (!found) {
        System.out.println(arrayBigger[i]);
      }
    }
  }
  
}