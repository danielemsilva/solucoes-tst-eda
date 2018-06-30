import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class BinarySearch {
	
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

	public int height() {
		if (isEmpty())
			return 0;
		return height(this.root) - 1;
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public Node search(int value) {
		if (isEmpty())
			return null;
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

	public ArrayList<Integer> predecessor(int value) {
		Node aux = search(value);
		ArrayList<Integer> array = new ArrayList<Integer>();
		if (aux != null) {
			Node rig;
			array.add(aux.value);
			if (aux.left != null) {
				rig = aux.left;
				array.add(rig.value);
				while (rig.right != null) {
					rig = rig.right;
					array.add(rig.value);
				}
			} else {
				Node parent = aux.parent;
				array.add(parent.value);
				while (parent != null && parent.value > aux.value) {
					parent = parent.parent;
					array.add(parent.value);
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinarySearch bs = new BinarySearch();
		String[] input = scan.nextLine().split(" ");
		for (String x : input) {
			bs.add(Integer.parseInt(x));
		}
		int value = scan.nextInt();
		Object[] array = bs.predecessor(value).toArray();
		System.out.println(Arrays.toString(array));
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
