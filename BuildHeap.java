package src;

import java.util.Scanner;
import java.util.Arrays;

class BuildHeap {
    
    private int[] array;
    private int index;
    
    public BuildHeap(int size) {
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
    
    private void heapify(int i) {
        int max = i;

        if (left(i) <= index && array[left(i)] > array[max]) {
            max = left(i);
        }

        if (right(i) <= index && array[right(i)] > array[max]) {
            max = right(i);
        }

        if (max != i) {
            int aux = array[i];
            array[i] = array[max];
            array[max] = aux;
            
            this.heapify(max);
        }
        
    }
    
    public void printArray() {
        System.out.println(Arrays.toString(array));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[] input = sc.nextLine().split(" ");
        int[] arrayInt = toInt(input);
        
        BuildHeap heap = new BuildHeap(arrayInt.length);
        
        heap.build(arrayInt);
        
        heap.printArray();
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