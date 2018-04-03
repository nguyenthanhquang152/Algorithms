package preparation.chapter8;

public class Ex4 {
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

        ListNode<Integer> node10 = new ListNode<>(10, node7);
        ListNode<Integer> node11 = new ListNode<>(11, node10);
        ListNode<Integer> cnode = hasCommonSublistOpt(node11, node2);
        ListNode.printNode(cnode);
    }

    public static ListNode<Integer> hasCommonSublistOpt(ListNode<Integer> node1, ListNode<Integer> node2){
        ListNode<Integer> p1 = node1;
        ListNode<Integer> p2 = node2;
        int l1 = ListNode.length(p1);
        int l2 = ListNode.length(p2);
        if(l1 > l2) {
            while (l1-- > l2) {
                p1 = p1.next;
            }
        } else if(l2 > l1) {
            while (l2-- > l1) {
                p2 = p2.next;
            }
        }
        while(p1 != null && p2 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;

    }

    public static ListNode<Integer> hasCommonSublist(ListNode<Integer> node1, ListNode<Integer> node2){
        ListNode<Integer> p1 = node1;
        ListNode<Integer> p2 = node2;
        while(p2 != null){
            while(p1 != null){
                if(p1 == p2) return p1;
                p1 = p1.next;
            }
            p2 = p2.next;
            p1 = node1;
        }
        return null;
    }
}
