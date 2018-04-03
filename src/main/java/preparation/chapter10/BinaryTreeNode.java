package preparation.chapter10;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> parent,left, right;
    public BinaryTreeNode(T data, BinaryTreeNode<T> left, BinaryTreeNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
        if(this.left != null) this.left.parent = this;
        if(this.right != null) this.right.parent = this;
    }

    public static void nlr(BinaryTreeNode<?> r){
        if(r != null){
            System.out.print(r.data + " ");
            nlr(r.left);
            nlr(r.right);
        }
    }
}
