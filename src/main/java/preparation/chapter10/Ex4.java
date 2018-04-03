package preparation.chapter10;

import java.util.Deque;
import java.util.LinkedList;

public class Ex4 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node6, node7);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
        System.out.println(lca(node7, node6).data);
    }

    public static BinaryTreeNode<?> lca(
            BinaryTreeNode<?> node1, BinaryTreeNode<?> node2){
        Deque<BinaryTreeNode<?>> path1 = new LinkedList<>();
        while(node1 != null){
            path1.push(node1);
            node1 = node1.parent;
        }

        Deque<BinaryTreeNode<?>> path2 = new LinkedList<>();
        while(node2 != null){
            path2.push(node2);
            node2 = node2.parent;
        }
        BinaryTreeNode<?> result = null;
        while(path1.peek() == path2.peek()){
            result = path1.pop();
            path2.pop();
        }
        return result;
    }
}
