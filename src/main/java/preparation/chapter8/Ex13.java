package preparation.chapter8;

public class Ex13 {
    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<>(1, null);
        ListNode<Integer> node2 = new ListNode<>(1, node1);
        ListNode<Integer> node3 = new ListNode<>(1, node2);
        ListNode<Integer> node4 = new ListNode<>(9, null);
        ListNode<Integer> node5 = new ListNode<>(9, node4);
        ListNode<Integer> node6 = new ListNode<>(9, node5);
        ListNode<Integer> result = add(node5, node3);
        ListNode.printNode(result);
    }

    public static ListNode<Integer> add(ListNode<Integer> node1, ListNode<Integer> node2){
        ListNode<Integer> dummy = new ListNode<>();
        ListNode<Integer> current = dummy;
        int c = 0;
        for( ListNode<Integer> n1 = node1, n2 = node2; n1 != null || n2 != null; n1 = n1==null? n1 : n1.next, n2 = n2 == null ? n2 : n2.next){
            int v1 = n1 == null? 0 : n1.data;
            int v2 = n2 == null? 0 : n2.data;
            int v = v1 + v2 + c;
            c = v/10;
            v %= 10;
            current.next = new ListNode<>(v, null);
            current = current.next;
        }
        if(c == 1) {
            current.next = new ListNode<>(1, null);
        }
        return dummy.next;
    }
}
