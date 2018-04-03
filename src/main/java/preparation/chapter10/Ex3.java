package preparation.chapter10;

public class Ex3 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node6, node7);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
        System.out.println(lca(node1, node2, node3).data);
    }

    public static BinaryTreeNode<?> lca(BinaryTreeNode<?> tree, BinaryTreeNode<?> node1, BinaryTreeNode<?> node2){
        if(tree == null) return null;
        if(tree == node1 || tree == node2) return tree;
        BinaryTreeNode<?> l = lca(tree.left, node1, node2);
        BinaryTreeNode<?> r = lca(tree.right, node1, node2);
        if(l != null && r != null) return tree;
        if(l != null) return l;
        else return r;

    }
}
