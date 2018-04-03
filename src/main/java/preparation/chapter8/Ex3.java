package preparation.chapter8;

public class Ex3 {
    public static void main(String[] args) {
        // 11 - 3 - 5 - 7 - 2
        ListNode<Integer> node1 = new ListNode<>(1, null);
        ListNode<Integer> node2 = new ListNode<>(2, node1);
        ListNode<Integer> node3 = new ListNode<>(3, node2);
        ListNode<Integer> node4 = new ListNode<>(4, node3);
        ListNode<Integer> node5 = new ListNode<>(5, node4);
        ListNode<Integer> node6 = new ListNode<>(6, node5);
        ListNode<Integer> node7 = new ListNode<>(7, node6);
        ListNode<Integer> node8 = new ListNode<>(8, node7);
        ListNode<Integer> node9 = new ListNode<>(9, node8);
//        node1.next = node6;

        ListNode<Integer> headOfCycle = hasCycle(node9);
        System.out.println(headOfCycle == node6);
    }

    public static ListNode<Integer> hasCycle(ListNode<Integer> node){
        ListNode<Integer> fast = node, slow = node;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                // Find cycle length
                int clength = 0;
                do {
                    clength++;
                    fast = fast.next;
                } while(fast != slow);
                ListNode<Integer> advanced = node, current = node;
                while(clength-- > 0){
                    advanced = advanced.next;
                }
                while(advanced != current){
                    advanced = advanced.next;
                    current = current.next;
                }
                return current;
            }
        }
        return null;
    }
}
