import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BST {
	
	private Node root;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void add(int element) {
		if (isEmpty()) {
			this.root = new Node(element);
		} else {
			this.root.add(element);
		}
	}

	public int count(Node current, int value) {
		if (current == null) {
			return 0;
		}
		if (current.value == value) {
			return 1;
		}
		if (current.value > value) {
			return 1 + count(current.left, value);
		} else {
			return 1 + count(current.right, value);
		}
	}

	public Node getRoot() {
		return this.root;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		String[] input = scan.nextLine().trim().split(" ");
		for (String x : input) {
			bst.add(Integer.parseInt(x));
		}
		
		int value = scan.nextInt();
		int[] res = new int[bst.count(bst.getRoot(), value)];
		
		Node current = bst.root;
		int index = 0;
		while (current != null) {
			res[index++] = current.value;
			if (current.value == value)
				break;
			if (current.value > value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		System.out.println(Arrays.toString(res));
		scan.close();
	}
}

class Node {
	
	int value;
	Node left;
	Node right;
	Node parent;

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node parent) {
		this.value = value;
		this.parent = parent;
	}

	public void add(int value) {
		if (value > this.value) {
			if (this.right == null) {
				this.right = new Node(value, this);
			} else {
				this.right.add(value);
			}
		} else if (value < this.value) {
			if (this.left == null) {
				this.left = new Node(value, this);
			} else {
				this.left.add(value);
			}
		}
	}

}
