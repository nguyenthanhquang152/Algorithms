package preparation.chapter10;

public class Ex10 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8, null, null);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, node8);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, node7);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node6, null);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
        BinaryTreeNode<Integer> result = findNextSuccessor(node8);
        if(result == null) System.out.println("Reached to the end of inorder traversal");
        else System.out.println(result.data);
    }

    public static BinaryTreeNode<Integer> findNextSuccessor(BinaryTreeNode<Integer> node){
        BinaryTreeNode<Integer> iter = node;
        // Find the leftmost of right subtree
        if(iter.right != null){
            iter = iter.right;
            while(iter.left != null) iter = iter.left;
            return iter;
        }
        // Find the ancestor whose left subtree contains node
        while(iter.parent != null && iter.parent.right == iter){
            iter = iter.parent;
        }
        return iter.parent;
    }
}
