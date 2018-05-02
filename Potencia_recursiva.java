import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int base = Integer.valueOf(sc.nextLine());
    int exponent = Integer.valueOf(sc.nextLine());
    int power = calculate_power(base, exponent);
    System.out.println(power);
  }
  
  public static int calculate_power(int base, int exponent) {
   if(exponent == 0){
     return 1;
   }
   return base * calculate_power(base, exponent - 1);
  }
}