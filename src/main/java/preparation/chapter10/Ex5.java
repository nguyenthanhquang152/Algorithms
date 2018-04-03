package preparation.chapter10;

public class Ex5 {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> nodeD = new BinaryTreeNode<>(0, null, null);
        BinaryTreeNode<Integer> nodeE = new BinaryTreeNode<>(1, null, null);
        BinaryTreeNode<Integer> nodeC = new BinaryTreeNode<>(0, nodeD, nodeE);

        BinaryTreeNode<Integer> nodeH = new BinaryTreeNode<>(0, null, null);
        BinaryTreeNode<Integer> nodeG = new BinaryTreeNode<>(1, nodeH, null);
        BinaryTreeNode<Integer> nodeF = new BinaryTreeNode<>(1, null, nodeG);

        BinaryTreeNode<Integer> nodeB = new BinaryTreeNode<>(0, nodeC, nodeF);


        BinaryTreeNode<Integer> nodeM = new BinaryTreeNode<>(1, null, null);
        BinaryTreeNode<Integer> nodeL = new BinaryTreeNode<>(1, null, nodeM);
        BinaryTreeNode<Integer> nodeN = new BinaryTreeNode<>(0, null, null);
        BinaryTreeNode<Integer> nodeK = new BinaryTreeNode<>(0, nodeL, nodeN);
        BinaryTreeNode<Integer> nodeJ = new BinaryTreeNode<>(0, null, nodeK);

        BinaryTreeNode<Integer> nodeP = new BinaryTreeNode<>(0, null, null);
        BinaryTreeNode<Integer> nodeO = new BinaryTreeNode<>(0, null, nodeP);
        BinaryTreeNode<Integer> nodeI = new BinaryTreeNode<>(1, nodeJ, nodeO);

        BinaryTreeNode<Integer> nodeA = new BinaryTreeNode<>(1, nodeB, nodeI);


        System.out.println(sumBinaryTree(nodeA));
        System.out.println(sumBinaryTree(nodeA,0));
    }

    public static int sumBinaryTree(BinaryTreeNode<Integer> node, int partialNum){
        if(node == null) return 0;
        partialNum = partialNum * 2 + node.data;
        if(node.left == null && node.right == null) return partialNum;
        return sumBinaryTree(node.left, partialNum) + sumBinaryTree(node.right, partialNum);

    }

    public static class SumWithBinary{
        int acc;
        int num;

        public SumWithBinary(int acc, int num) {
            this.acc = acc;
            this.num = num;
        }
    }

    public static int sumBinaryTree(BinaryTreeNode<Integer> node){
        SumWithBinary sum = new SumWithBinary(0,0);
        sumBinaryTreeHelper(node, sum);
        return sum.acc;
    }

    public static void sumBinaryTreeHelper(BinaryTreeNode<Integer>node, SumWithBinary state){
        if(node != null) {
            state.num = (state.num << 1) + node.data;
            if (node.left == null && node.right == null) {
                state.acc += state.num;
                System.out.println(state.num);
            } else {
                if (node.left != null) {
                    sumBinaryTreeHelper(node.left, state);
                    state.num >>= 1;
                }
                if (node.right != null) {
                    sumBinaryTreeHelper(node.right, state);
                    state.num >>= 1;
                }
            }
        }

    }
}
