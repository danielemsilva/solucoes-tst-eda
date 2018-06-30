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

	public int countNodes(Node curr) {
		if (curr.left == null && curr.right == null)
			return 0;
		int sumLeft = 0;
		int sumRight = 0;
		if (curr.left != null)
			sumLeft = countNodes(curr.left);
		if (curr.right != null)
			sumRight = countNodes(curr.right);
		return sumLeft + sumRight + 1;
	}

	public Node getRoot() {
		return this.root;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		String[] input = scan.nextLine().split(" ");
		for (String x : input) {
			bst.add(Integer.parseInt(x));
		}
		System.out.println(bst.countNodes(bst.getRoot()));
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
