import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BST {
	private Node root;
	int qtdElements = 0;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void add(int element) {
		if (isEmpty()) {
			this.root = new Node(element);
		} else {
			this.root.add(element);
		}
		qtdElements++;
	}

	public void remove(Node current) {
		if (current != null) {
			qtdElements--;

			if (current.left == null && current.right == null) {
				if (current.parent == null) {
					this.root = null;
				} else if (current.parent.left != null && current.parent.left.value == current.value)
					current.parent.left = null;
				else
					current.parent.right = null;
			} else if (current.left == null) {
				if (current.parent.left != null && current.parent.left.value == current.value) {
					current.parent.left = current.right;
					current.right.parent = current.parent;
				} else {
					current.parent.right = current.right;
					current.right.parent = current.parent;
				}
			} else if (current.right == null) {
				if (current.parent.left != null && current.parent.left.value == current.value) {
					current.parent.left = current.left;
					current.left.parent = current.parent;
				} else {
					current.parent.right = current.left;
					current.left.parent = current.parent;
				}
			} else {
				Node succ = this.successor(current);
				int c = current.value;
				current.value = succ.value;
				succ.value = c;
				this.qtdElements++;
				this.remove(succ);
			}
		}
	}

	public Node successor(Node current) {
		Node left;
		if (current.right != null) {
			left = current.right;
			while (left.left != null) {
				left = left.right;
			}
			return left;
		} else {
			Node parent = current.parent;
			while (parent != null && parent.value > current.value) {
				parent = parent.parent;
			}
			return parent;
		}
	}

	public Node search(int value) {
		if (isEmpty()) {
			return null;
		}
		return search(value, this.root);
	}

	private Node search(int value, Node node) {
		if (node != null) {
			if (node.value == value) {
				return node;
			} else if (node.value > value) {
				return search(value, node.left);
			} else {
				return search(value, node.right);
			}
		}
		return node;
	}
	public ArrayList<Integer> preOrder() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		if (!isEmpty()) {
			return preOrder(this.root, array);
		}
		return array;
	}

	private ArrayList<Integer> preOrder(Node node, ArrayList<Integer> array) {
		array.add(node.value);
		if (node.left != null)
			preOrder(node.left, array);
		if (node.right != null)
			preOrder(node.right, array);
		return array;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		String[] input1 = scan.nextLine().split(" ");
		for (String x : input1) {
			bst.add(Integer.parseInt(x));
		}

		String[] input2 = scan.nextLine().split(" ");
		for (String x : input2) {
			bst.remove(bst.search(Integer.parseInt(x)));
			if (bst.qtdElements == 0) {
				System.out.println("null");
			} else {
				System.out.println(Arrays.toString(bst.preOrder().toArray(new Integer[0])));
			}
		}
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
