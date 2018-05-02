import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] input = sc.nextLine().split(" ");
    int position = sc.nextInt();
    controlCircle(input, position);
    System.out.println();
  }
  
  public static void controlCircle(String[] array, int position) {
   if (position <= array.length) {
     printArray(array, position);
   } else {
     printArray(array, array.length);
     System.out.print(" ");
     position-= array.length;
     controlCircle(array, position);
   }
  }
  
  public static void printArray(String[] array, int end){
    for (int i = 0; i < end; i++) {
      System.out.print(array[i]);
       if (i + 1 != end){
         System.out.print(" ");
       }
    }
  }
}