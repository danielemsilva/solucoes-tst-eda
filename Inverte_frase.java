import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		System.out.println(reverses(input));
		sc.close();
	}

	private static String reverses(String[] input) {
		int i = 0;
		int length = input.length-1;
		while (i < length - i) {
			swap(input, i, length - i);
			i++;
		}
		return join(input);
	}

	private static String join(String[] input) {
		String output = "";
		for (int i = 0; i < input.length; i++) {
			output += input[i];
			if (i != input.length-1) {
				output += " ";
			}
		}
		return output;
	}

	private static void swap(String[] array, int i, int j) {
		String aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

}
