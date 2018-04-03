package preparation.chapter13;

import preparation.chapter10.BinaryTreeNode;

import java.util.HashSet;
import java.util.Set;

public class Ex4 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node6, node7);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
//        BinaryTreeNode.nlr(node1);
        System.out.println(lca(node3, node2).data);
    }

    public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2){
        Set<BinaryTreeNode<Integer>> traversed = new HashSet<>();
        while(node1 != null || node2 != null){
            if(node1 != null){
                if(!traversed.add(node1)) return node1;
                node1 = node1.parent;
            }
            if(node2 != null){
                if(!traversed.add(node2)) return node2;
                node2 = node2.parent;
            }
        }
        return null;
    }
}
