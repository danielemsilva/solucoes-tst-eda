package src;

import java.util.Arrays;
import java.util.Scanner;

class Heap {

	private int[] array;
	private int index;

	public Heap(int size) {
		array = new int[size];
		index = -1;
	}

	private int left(int i) {
		return (i * 2) + 1;
	}

	private int right(int i) {
		return (i * 2) + 2;
	}

	public void build(int[] elements) {
		array = elements;
		index = array.length - 1;

		for (int i = array.length / 2; i >= 0; i--) {
			heapify(i);
		}
	}

	private boolean heapify(int i) {
		int max = i;

		if (left(i) <= index && array[left(i)] > array[max]) {
			max = left(i);
		}
		if (right(i) <= index && array[right(i)] > array[max]) {
			max = right(i);
		}
		if (max != i) {
			return false;
		}

		return true;
	}

	public boolean isHeap(int[] array) {
		this.array = array;
		index = array.length - 1;

		for (int i = (array.length / 2); i >= 0; i--) {
			boolean result = heapify(i);
			if (!result) {
				return false;
			}
		}

		return true;
	}

	public void printArray() {
		System.out.println(Arrays.toString(array));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");
		int[] arrayInt = toInt(input);

		Heap heap = new Heap(arrayInt.length);

		System.out.println(heap.isHeap(arrayInt));
		sc.close();
	}

	public static int[] toInt(String[] array) {
		int[] arrayInt = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}

		return arrayInt;
	}
	
}
