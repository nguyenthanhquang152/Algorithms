package preparation.chapter10;

import java.util.LinkedList;

public class Ex14 {
    public static void main(String[] args) {
        BinaryTreeNode<String> nodeD = new BinaryTreeNode<>("D", null, null);
        BinaryTreeNode<String> nodeE = new BinaryTreeNode<>("E", null, null);
        BinaryTreeNode<String> nodeC = new BinaryTreeNode<>("C", nodeD, nodeE);

        BinaryTreeNode<String> nodeH = new BinaryTreeNode<>("H", null, null);
        BinaryTreeNode<String> nodeG = new BinaryTreeNode<>("G", nodeH, null);
        BinaryTreeNode<String> nodeF = new BinaryTreeNode<>("F", null, nodeG);

        BinaryTreeNode<String> nodeB = new BinaryTreeNode<>("B", nodeC, nodeF);


        BinaryTreeNode<String> nodeM = new BinaryTreeNode<>("M", null, null);
        BinaryTreeNode<String> nodeL = new BinaryTreeNode<>("L", null, nodeM);
        BinaryTreeNode<String> nodeN = new BinaryTreeNode<>("N", null, null);
        BinaryTreeNode<String> nodeK = new BinaryTreeNode<>("K", nodeL, nodeN);
        BinaryTreeNode<String> nodeJ = new BinaryTreeNode<>("J", null, nodeK);

        BinaryTreeNode<String> nodeP = new BinaryTreeNode<>("P", null, null);
        BinaryTreeNode<String> nodeO = new BinaryTreeNode<>("O", null, nodeP);
        BinaryTreeNode<String> nodeI = new BinaryTreeNode<>("I", nodeJ, nodeO);

        BinaryTreeNode<String> nodeA = new BinaryTreeNode<>("A", nodeB, nodeI);
        LinkedList<String> acc = new LinkedList<>();
        formLinkedListFromLeaves(nodeA, acc);
        System.out.println(acc.toString());
    }

    public static void formLinkedListFromLeaves(BinaryTreeNode<String> node, LinkedList<String> acc){
        if(node != null){
            if(node.left == null && node.right == null) acc.add(node.data);
            formLinkedListFromLeaves(node.left, acc);
            formLinkedListFromLeaves(node.right, acc);
        }
    }
}
