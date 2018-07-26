package src;

import java.util.Scanner;

class Rotacoes {
    
    private Node root;

    public Rotacoes() {
        this.root = new Node();
        this.root.setParent(new Node());
    }
    
    public void insert(int data) {
        insert(root, data);
    }
    
    private void insert(Node node, int data) {
        if (node.isEmpty()) {
            node.setData(data);
            node.setLeft(new Node());
            node.setRight(new Node());
            node.getLeft().setParent(node);
            node.getRight().setParent(node);
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
        System.out.print("[");
        preOrder(root);
        System.out.println("]");
    }
    
    private void preOrder(Node node) {
        if (!node.isEmpty()) {
            if (node.getData() != root.getData())
                System.out.print(", ");
                
            System.out.print(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    public void rotateLeft(Node node) {
        Node aux = node.getRight();
    
        aux.setLeft(node);
        node.getParent().setLeft(aux);
        aux.setParent(node.getParent());
        node.setParent(aux);
        node.setRight(new Node());
        
        if (node.getData() == root.getData()) {
            root = aux;
        }
    }
    
    public void rotateRight(Node node) {
        Node aux = node.getLeft();
        
        aux.setRight(node);
        node.getParent().setRight(aux);
        aux.setParent(node.getParent());
        node.setParent(aux);
        node.setLeft(new Node());
    
        if (node.getData() == root.getData()) {
            root = aux;
        }
    }
    
    public void rotate() {
        if (balance(root) == 0) {
            System.out.println("balanceada");
        } else if (balance(root) > 0) {
            if (balance(root.getLeft()) > 0) {
                System.out.println("rot_dir(" + root.getData() + ")");
                rotateRight(root);    
                preOrder();
            } else {
                System.out.println("rot_esq(" + root.getLeft().getData() + ")");
                rotateLeft(root.getLeft());
                preOrder();
                
                System.out.println("rot_dir(" + root.getData() + ")");
                rotateRight(root);                
                preOrder();
            }
        } else {
            if (balance(root.getRight()) < 0) {
                System.out.println("rot_esq(" + root.getData() + ")");
                rotateLeft(root);                
                preOrder();
            } else {
                System.out.println("rot_dir(" + root.getRight().getData() + ")");
                rotateRight(root.getRight());
                preOrder();
                
                System.out.println("rot_esq(" + root.getData() + ")");
                rotateLeft(root);
                preOrder();
            }
        }
    }
    
    
    public static Integer[] toInt(String[] array) {
        Integer[] arrayInt = new Integer[array.length];
        
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = Integer.parseInt(array[i]);
        }
        
        return arrayInt;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] input = sc.nextLine().split(" ");
        Integer[] array = toInt(input);
        
        Rotacoes bst = new Rotacoes();
        
        for (int i = 0; i < array.length; i++) {
            bst.insert(array[i]);
        }
        
        bst.rotate();
        sc.close();
    }
    
    class Node {
    	
        private Integer data;
        private Node left;
        private Node right;
        private Node parent;
        
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
        
        public void setParent(Node parent) {
            this.parent = parent;
        }
        
        public Node getParent() {
            return parent;
        }
        
        public boolean isEmpty() {
            return data == null;
        }
        
    }
}