package ideserve.common;

public class TreeNode {
    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
        if(left != null) this.left.parent = this;
        if(right != null) this.right.parent = this;
    }

    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int data;
}
