package src;

import java.util.Scanner;

class Balance {

	private Node root;

	public Balance() {
		this.root = new Node();
	}

	public void insert(int data) {
		insert(root, data);
	}

	private void insert(Node node, int data) {
		if (node.isEmpty()) {
			node.setData(data);
			node.setLeft(new Node());
			node.setRight(new Node());
		} else if (data < node.getData()) {
			insert(node.getLeft(), data);
		} else {
			insert(node.getRight(), data);
		}
	}

	public int balance(Node node) {
		return height(node.getLeft()) - height(node.getRight());
	}

	public int height(Node node) {
		if (node.isEmpty()) {
			return -1;
		}
		return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (!node.isEmpty()) {
			if (node.getData() != root.getData()) {
				System.out.print(" ");
			}

			System.out.print(node.getData() + "," + balance(node));
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public static Integer[] convertToInt(String[] array) {
		Integer[] arrayInt = new Integer[array.length];

		for (int i = 0; i < array.length; i++) {
			arrayInt[i] = Integer.parseInt(array[i]);
		}

		return arrayInt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] input = sc.nextLine().split(" ");
		Integer[] array = convertToInt(input);

		Balance bst = new Balance();
		for (int i = 0; i < array.length; i++) {
			bst.insert(array[i]);
		}

		bst.preOrder();
		System.out.println();
		sc.close();
	}

	class Node {

		private Integer data;
		private Node left;
		private Node right;
		
		public Node() {
			this(null);
		}

		public Node(Integer data) {
			this.data = data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public int getData() {
			return data;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getLeft() {
			return left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getRight() {
			return right;
		}

		public boolean isEmpty() {
			return data == null;
		}

	}

}
