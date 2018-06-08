import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(check(input));
	}

	private static String check(String input) {
		int count = 0;
		int i = 0;

		while (i < input.length()) {
			String symbol = Character.toString(input.charAt(i));
			if (symbol.equals("(")) {
				count += 1;
			} else if (symbol.equals(")")) {
				count -= 1;
			}
			if (count < 0) {
				break;
			}
			i++;
		}

		if (count == 0) {
			return "S";
		}
		return "N";
	}

}
