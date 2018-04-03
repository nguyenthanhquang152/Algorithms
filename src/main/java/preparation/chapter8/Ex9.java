package preparation.chapter8;

public class Ex9 {
    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<>(1, null);
        ListNode<Integer> node2 = new ListNode<>(2, node1);
        ListNode<Integer> node3 = new ListNode<>(3, node2);
        ListNode<Integer> node4 = new ListNode<>(4, node3);
        ListNode<Integer> node5 = new ListNode<>(5, node4);
        ListNode<Integer> node6 = new ListNode<>(6, node5);
        ListNode<Integer> node7 = new ListNode<>(7, node6);
        ListNode<Integer> node8 = new ListNode<>(8, node7);
        ListNode<Integer> node9 = new ListNode<>(9, node8);
        ListNode<Integer> result = shiftRightOpt(node9, 3);
        ListNode.printNode(result);
    }

    public static ListNode<Integer> shiftRight(ListNode<Integer> node, int k){
        int length = ListNode.length(node);
        k %= length;
        ListNode<Integer> reverseFirstSeq = Ex2.reverseSublist1(node,1, length - k);
        ListNode<Integer> reverseSecondSeq = Ex2.reverseSublist1(reverseFirstSeq, length - k + 1, length);
        ListNode<Integer> reverseFull = Ex2.reverseSublist1(reverseSecondSeq, 1, length);
        return reverseFull;
    }

    public static ListNode<Integer> shiftRightOpt(ListNode<Integer> node, int k){
        if(node == null) return node;
        ListNode<Integer> tail = node;
        int length = 1;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        k %= length;
        if(k==0) return node;
        tail.next = node;
        ListNode<Integer> newTail = tail;
        int newTailIndex = length - k;
        while(newTailIndex-- > 0){
            newTail = newTail.next;
        }
        ListNode<Integer> result = newTail.next;
        newTail.next = null;
        return result;

    }
}
