package preparation.chapter10;

public class Ex1 {

    public static class BalanceWithHeight{
        public boolean isBalanced;
        public int height;

        public BalanceWithHeight(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, null, null);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6, null, null);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5, node6, node7);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, null, null);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3, null, null);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, node3, node4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1, node2, node5);
        BinaryTreeNode.nlr(node1);
        System.out.println();
        System.out.println(height(node1));
        System.out.println(count(node1));
        System.out.println(isBalanced(node1));
    }

    public static boolean isBalanced(BinaryTreeNode<?> root){
        return balanceWithHeight(root).isBalanced;
    }

    private static BalanceWithHeight balanceWithHeight(BinaryTreeNode<?> root){
        if(root == null) return new BalanceWithHeight(true, -1);
        BalanceWithHeight lbh = balanceWithHeight(root.left);
        if(!lbh.isBalanced) return lbh;
        BalanceWithHeight rbh = balanceWithHeight(root.right);
        if(!rbh.isBalanced) return rbh;
        boolean isBalanced = Math.abs(lbh.height - rbh.height) <= 1;
        int height = 1 + Math.max(lbh.height, rbh.height);
        return new BalanceWithHeight(isBalanced, height);
    }

    public static int height(BinaryTreeNode<?> root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }

    public static int count(BinaryTreeNode<?> root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int lc = count(root.left);
        int rc = count(root.right);
        return 1 + lc + rc;
    }

}
