package ideserve;

import ideserve.common.TreeNode;

/**
 * Create a balanced Binary Search Tree from a sorted array/list.
 */
public class Ex2 {
    private static void printTree(TreeNode node, int indent){
        if(node == null) return;
        printTree(node.left, indent + 1);

        for(int i = 0; i < indent; i++) System.out.print("\t");
        System.out.println(node.data);
        printTree(node.right, indent + 1);
    }

    private static TreeNode solution(int[] array, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode lNode = solution(array, start, mid - 1);
        TreeNode rNode = solution(array, mid + 1, end);
        TreeNode mNode = new TreeNode(array[mid], lNode, rNode);
        return mNode;
    }
    public static void main(String[] args){
        int[] array = new int[]{1,2,3,4,5,6,7,8,9};
        TreeNode root = solution(array, 0, array.length - 1);
        printTree(root, 0);
    }
}
