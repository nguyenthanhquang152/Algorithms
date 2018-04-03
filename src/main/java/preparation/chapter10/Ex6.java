package preparation.chapter10;

public class Ex6 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node6, node7);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
        BinaryTreeNode<Integer> result = findLeaf(node1, 9);
        if(result != null) System.out.println(result.data);
        else System.out.println("Invalid path");
    }

    public static BinaryTreeNode<Integer> findLeaf(BinaryTreeNode<Integer> node, int sum){
        if(node == null) return null;
        sum -= node.data;
        if(node.left == null && node.right == null && sum == 0) return node;
        BinaryTreeNode<Integer> lNode = findLeaf(node.left, sum);
        BinaryTreeNode<Integer> rNode = findLeaf(node.right, sum);
        return lNode == null ? rNode : lNode;
    }
}
