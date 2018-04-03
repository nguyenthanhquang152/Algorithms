package preparation.chapter8;

public class Ex7 {
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
        ListNode<Integer> deleted = removeKLastElements(node9, 9);
        ListNode.printNode(deleted);
    }
    public static ListNode<Integer> removeKLastElements(ListNode<Integer> node, int k){
        ListNode<Integer> dummyhead = new ListNode<>();
        dummyhead.next = node;
        ListNode<Integer> advancedK = dummyhead.next;
        // Go through first k elements
        while(k-- > 0) advancedK = advancedK.next;
        ListNode<Integer> current = dummyhead;
        while(advancedK != null) {
            advancedK = advancedK.next;
            current = current.next;
        }
        // current is at the last (k+1)th element
        current.next = current.next.next;
        return dummyhead.next;
    }
}
