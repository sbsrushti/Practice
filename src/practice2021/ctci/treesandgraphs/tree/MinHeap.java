package practice2021.ctci.treesandgraphs.tree;

import java.util.Arrays;

public class MinHeap {

    int[] heap;
    int MAX_SIZE;
    int size = -1;

    public MinHeap(int n) {
        MAX_SIZE = n;
        heap = new int[MAX_SIZE];
        Arrays.fill(heap, Integer.MAX_VALUE);
    }

    public int getLeftChildPos(int pos) {
        return 2*pos + 1;
    }

    public int getRightChildPos(int pos) {
        return 2*pos + 2;
    }

    public int getParentPos(int pos) {
        return (pos-1)/2;
    }
    public void swap(int pos1, int pos2) {
        int temp = this.heap[pos2];
        this.heap[pos2] = this.heap[pos1];
        this.heap[pos1] = temp;
    }

    public void heapify(int pos) {
        if (this.heap[pos] > this.heap[getLeftChildPos(pos)] || this.heap[pos] > this.heap[getRightChildPos(pos)]) {
            if (this.heap[getLeftChildPos(pos)] < this.heap[getRightChildPos(pos)]) {
                swap(pos, getLeftChildPos(pos));
                heapify(getLeftChildPos(pos));
            } else {
                swap(pos, getRightChildPos(pos));
                heapify(getRightChildPos(pos));
            }
        }
    }

    public void insert(int val) {
        this.heap[size+1] = val;
        this.size++;
        if (this.size == 0) return;
        int current = this.size;
        while (this.heap[current] < this.heap[getParentPos(current)]) {
            swap(current, getParentPos(current));
            current = getParentPos(current);
        }
    }

    public void deleteMin() {
        this.heap[0] = this.heap[size];
        this.heap[size] = Integer.MAX_VALUE;
        this.size--;
        print();
        heapify(0);
    }

    public void print() {
        for (int i = 0; i <= this.size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.print();
        minHeap.insert(8);
        minHeap.print();
        minHeap.insert(0);
        minHeap.print();
        minHeap.deleteMin();
        minHeap.print();
        minHeap.deleteMin();
        minHeap.print();
        minHeap.deleteMin();
        minHeap.print();
        minHeap.insert(1);
        minHeap.print();
        minHeap.insert(10);
        minHeap.print();
    }
}
