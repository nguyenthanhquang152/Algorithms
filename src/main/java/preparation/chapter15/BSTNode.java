package preparation.chapter15;

import java.util.LinkedList;
import java.util.Queue;

public class BSTNode<T> {
    public T data;
    public BSTNode<T> left, right;

    public BSTNode(T data) {
        this.data = data;
    }

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public static <T> void displayByLevel(BSTNode<T> node){
        Queue<BSTNode<T>> queue = new LinkedList<>();
        BSTNode<T> curr = node;
        queue.add(curr);
        while(!queue.isEmpty()){
            Queue<BSTNode<T>> levelQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                BSTNode<T> next = queue.remove();
                System.out.printf(next.data + "\t");
                if(next.left != null) levelQueue.add(next.left);
                if(next.right != null) levelQueue.add(next.right);
            }
            System.out.println();
            queue = levelQueue;
        }
    }
}
