package preparation.chapter10;

public class Ex2 {
    public static void main(String[] args) {

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(2, node6, node7);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(BinaryTreeNode<Integer> tree){
        return tree == null || isSubSymmetric(tree.left, tree.right);
    }

    public static boolean isSubSymmetric(BinaryTreeNode<Integer> left, BinaryTreeNode<Integer> right){
        if(left == null && right == null) return true;
        else if(left != null && right != null){
            return left.data == right.data
                    && isSubSymmetric(left.left, right.right)
                    && isSubSymmetric(left.right, right.left);
        }
        return false;
    }
}
