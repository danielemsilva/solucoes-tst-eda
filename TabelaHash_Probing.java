import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	private static Pair[] table;
	private static int qtdElements = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		table = new Pair[size];

		String input = sc.nextLine();

		while (!input.equals("end")) {

			String[] commands = input.split(" ");
			if (commands[0].equals("put")) {
				int key = Integer.parseInt(commands[1]);
				put(key, commands[2]);
				System.out.println(passToString());
			} else if (commands[0].equals("remove")) {
				int key =  Integer.parseInt(commands[1]);
				remove(key);
				System.out.println(passToString());
			} else if (commands[0].equals("keys")) {
				System.out.println(keys());
			} else if (commands[0].equals("values")) {
				System.out.println(values());
			}
			input = sc.nextLine();
		}
		sc.close();
	}

	private static void put(int key, String value) {
    if (qtdElements + 1 <= table.length) {
  		Pair newPair = new Pair(key, value);
      int probe = 0;
  		int pos = getHash(key, probe);
      while (table[pos] != null && table[pos].getKey() != key) {
				probe++;
				pos = getHash(key, probe);
			}
      if (table[pos] == null) {
        qtdElements++;
      }
			table[pos] = newPair;
    }
	}

	private static void remove(int key) {
    int probe = 0;
		int pos = getHash(key, probe);
		while (table[pos] != null && probe < table.length) {
      if (table[pos].getKey() == key) {
        table[pos] = null;
        qtdElements--;
      }
		  probe++;
      pos = getHash(key, probe);
		}
	}

	private static String passToString() {
		return Arrays.toString(table);
	}

	private static String keys() {
		String[] keys = new String[qtdElements];
		int indexKeys = 0;
		for (int key = 0; key < table.length; key++) {
			if (table[key] != null) {
				Pair currentPair = (Pair) table[key];
				keys[indexKeys] = String.valueOf(currentPair.getKey());
				indexKeys++;
			}
		}
		Arrays.sort(keys);
		return Arrays.toString(keys);
	}

	private static String values() {
		String[] values = new String[qtdElements];
		int indexValues = 0;
		for (int key = 0; key < table.length; key++) {
			if (table[key] != null) {
				Pair currentPair = (Pair) table[key];
				values[indexValues] = String.valueOf(currentPair.getValue());
				indexValues++;
      }
		}
		Arrays.sort(values);
		return Arrays.toString(values);
	}

	private static int getHash(int key, int probe) {
		return (key + probe) % table.length;
	}

}

class Pair {

	private int key;
	private String value;

	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return this.key;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public String toString(){
		return ("<" + this.key + ", " + this.value + ">");
	}

}
