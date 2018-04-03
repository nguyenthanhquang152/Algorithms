package ideserve;

import ideserve.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Find the lowest common ancestor of two nodes in a tree.
 */
public class Ex1 {

    public static TreeNode createDummyTree(){
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, node1, node2);

        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node5 = new TreeNode(5, node6, node7);

        TreeNode node4 = new TreeNode(4, node3, node5);

        return node4;
    }

    /**
     * In case of one node is not found, the result will be the other node
     * @param currentNode
     * @param first
     * @param second
     * @return
     */
    private static TreeNode solution1(TreeNode currentNode, int first, int second) {
        // Base case 1: currentNode == null => null
        if(currentNode == null) return null;

        // Base case 2: currentNode == first || currentNode == second => return currentNode
        // In this case, we can find one of input nodes
        if(currentNode.data == first || currentNode.data == second) return currentNode;

        // Recursive case:
        // Move to the left to get the common ancestor for first and second nodes.
        // Do the same for the right branch.
        TreeNode left = solution1(currentNode.left, first, second);
        TreeNode right = solution1(currentNode.right, first, second);
        // If we can find left and right successfully, so the current node is the common ancestor.
        if(left != null && right != null) return currentNode;
        // Otherwise: If we just get one branch successfully, just return that non-null to the current call.
        // It means that lowest common ancestor of an invalid node and a non-null node is the non-null one.
        if(left == null) return right;
        else return left;
    }

    /**
     *
     * @param currentNode
     * @param first
     * @param second
     * @return
     */
    public static TreeNode solution2(TreeNode currentNode, int first, int second) {
        Map<Integer, TreeNode> traversedParent = new HashMap<>();
        TreeNode fNode = findNodeByValue(currentNode, first);
        if(fNode == null) return null;
        TreeNode sNode = findNodeByValue(currentNode, second);
        if(sNode == null) return null;

        // Put all nodes of first branch to history.
        traversedParent.put(fNode.data, fNode);
        while(fNode.parent != null) {
            traversedParent.put(fNode.parent.data, fNode.parent);
            fNode = fNode.parent;
        }
        // if second node is traversed, so it will be the lowest common ancestor.
        while(sNode.parent != null) {
            if(traversedParent.get(sNode.data) != null) return sNode;
            sNode = sNode.parent;
        }
        return null;
    }

    private static TreeNode findNodeByValue(TreeNode currentNode, int value) {
        if(currentNode == null) return null;
        if(currentNode != null && currentNode.data == value) return currentNode;

        TreeNode left = findNodeByValue(currentNode.left, value);
        TreeNode right = findNodeByValue(currentNode.right, value);
        return left == null ? right : left;

    }

    public static void main(String[] args) {
        TreeNode root = createDummyTree();
        TreeNode lca = solution1(root, 0, 0);
        if(lca != null) System.out.println(lca.data);
        else System.out.println("Cannot find the lowest common ancestor");
        lca = solution2(root, 1, 3);
        if(lca != null) System.out.println(lca.data);
        else System.out.println("Cannot find the lowest common ancestor");
    }
}
