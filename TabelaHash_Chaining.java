import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

	private static ArrayList[] table;
	private static int qtdElements = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = Integer.parseInt(sc.nextLine());
		table = new ArrayList[size];

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
		Pair newPair = new Pair(key, value);
		int pos = getHash(key);
		if (table[pos] == null) {
			table[pos] = new ArrayList<Pair>();
		}

		int index = indexOfList(key);
		if (index == -1){
			// insert
			table[pos].add(newPair);
			qtdElements++;
		} else {
			// update
			table[pos].set(index, newPair);
		}
	}

	private static void remove(int key) {
		int pos = getHash(key);

		for (int i = 0; i < table[pos].size(); i++) {
			Pair currentPair = (Pair) table[pos].get(i);
			if (currentPair.getKey() == key) {
				table[pos].remove(i);
				qtdElements--;
			}
		}
	}

	private static String passToString() {
		String[] array = new String[table.length];
		int indexArray = 0;
		for (int key = 0; key < table.length; key++) {
			String result = "[";
			if (table[key] != null) {
				for (int index = 0; index < table[key].size(); index++) {
					Pair currentPair = (Pair) table[key].get(index);
					result += currentPair.toString();
					if (index + 1 != table[key].size()) {
						result += ", ";
					}
				}
			}
			result += "]";
			array[indexArray] = result;
			indexArray++;
		}
		return Arrays.toString(array);
	}

	private static String keys() {
		String[] keys = new String[qtdElements];
		int indexKeys = 0;
		for (int key = 0; key < table.length; key++) {
			if (table[key] != null) {
				for (int index = 0; index < table[key].size(); index++) {
					Pair currentPair = (Pair) table[key].get(index);
					keys[indexKeys] = String.valueOf(currentPair.getKey());
					indexKeys++;
				}
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
				for (int index = 0; index < table[key].size(); index++) {
					Pair currentPair = (Pair) table[key].get(index);
					values[indexValues] = String.valueOf(currentPair.getValue());
					indexValues++;
				}
			}
		}
		Arrays.sort(values);
		return Arrays.toString(values);
	}

	private static int getHash(int key) {
		return key % table.length;
	}

	private static int indexOfList(int key) {
		int pos = getHash(key);
		int i = 0;
		while (i < table[pos].size()) {
			Pair currentPair = (Pair) table[pos].get(i);
			if (currentPair.getKey() == key) {
				return i;
			}
			i++;
		}
		return -1;
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
