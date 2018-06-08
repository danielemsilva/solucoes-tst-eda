import java.util.Scanner;

class Main {

  private static int array[];
  private static int top;

  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    // size input
    int length = Integer.valueOf(sc.nextLine());
    array = new int[length];
    top = -1;

    // commands input
    String[] command = sc.nextLine().split(" ");
    while (!command[0].equals("end")) {
      if (command[0].equals("push")) {
        boolean success = push(Integer.valueOf(command[1]));
        if (!success) {
          System.out.println("full");
        }
      }

      if (command[0].equals("print")) {
        String output = print();
        if (output.equals("")) {
          System.out.println("empty");
        } else {
          System.out.println(output);
        }
      }

      if (command[0].equals("peek")) {
        String output = peek();
        if (output.equals("")) {
          System.out.println("empty");
        } else {
          System.out.println(output);
        }
      }

      if(command[0].equals("pop")) {
        boolean success = pop();
        if (!success) {
          System.out.println("empty");
        }
      }

      command = sc.nextLine().split(" ");
    }
  }

  private static boolean push(int number) {
    if (top + 1 < array.length) {
      top++;
      array[top] = number;
      return true;
    }
    return false;
  }

  private static boolean pop() {
    if (isEmpty()) {
      return false;
    }
    top--;
    return true;
  }

  private static String peek() {
    if (isEmpty()) {
      return "";
    }
    return String.valueOf(array[top]);
  }

  private static String print() {
    String toString = "";
    for (int i = 0; i <= top; i++) {
      toString += array[i];
      if (i + 1 <= top) {
        toString += " ";
      }
    }
    return toString;
  }

  private static boolean isEmpty() {
    return top == -1;
  }

}
