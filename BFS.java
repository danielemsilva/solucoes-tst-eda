import java.util.ArrayList;
import java.util.Scanner;

class BST {

	private Node root;
	private int qtdElements = 0;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void add(int element) {
		qtdElements++;
		if (isEmpty()) {
			this.root = new Node(element);
		} else {
			this.root.add(element);
		}
	}

	public Node getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		String[] linha = scan.nextLine().split(" ");
		for (String x : linha) {
			bst.add(Integer.parseInt(x));
		}

		ArrayList<Integer> ret = new ArrayList<Integer>();
		ArrayList<Node> queue = new ArrayList<Node>();
		int index = -1, qtdElements = bst.qtdElements - 1;
		queue.add(bst.getRoot());

		while (index < qtdElements) {
			ret.add(queue.get(++index).value);
			if (queue.get(index).left != null)
				queue.add(queue.get(index).left);
			if (queue.get(index).right != null)
				queue.add(queue.get(index).right);
		}
		for (int i = 0; i <= qtdElements; i++) {
			if (i != 0)
				System.out.print(" ");
			System.out.print(ret.get(i));
		}
		System.out.println();
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
