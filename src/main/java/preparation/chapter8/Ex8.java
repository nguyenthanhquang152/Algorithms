package preparation.chapter8;

public class Ex8 {
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
        ListNode<Integer> result = removeDuplicates(node9);
        ListNode.printNode(node9);
    }

    public static ListNode<Integer> removeDuplicates(ListNode<Integer> node){
        if(node == null) return null;// empty list
        if(node.next == null) return node;// list has only one element.
        ListNode<Integer> result  = node;
        ListNode<Integer> scan = node.next;
        ListNode<Integer> nextPivot = node;
        while(scan != null){
            if(nextPivot.data != scan.data){
                nextPivot.next = scan;
                nextPivot = scan;
            }
            scan = scan.next;
        }
        nextPivot.next = scan;
        return result;

    }
}
