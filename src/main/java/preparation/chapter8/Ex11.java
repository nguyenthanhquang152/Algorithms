package preparation.chapter8;

public class Ex11 {
    public static void main(String[] args) {
//        ListNode<Integer> node1 = new ListNode<>(1, null);
//        ListNode<Integer> node2 = new ListNode<>(2, node1);
//        ListNode<Integer> node3 = new ListNode<>(3, node2);
//        ListNode<Integer> node4 = new ListNode<>(4, node3);
//        ListNode<Integer> node5 = new ListNode<>(5, node4);
//        ListNode<Integer> node6 = new ListNode<>(4, node5);
//        ListNode<Integer> node7 = new ListNode<>(3, node6);
//        ListNode<Integer> node8 = new ListNode<>(2, node7);
//        ListNode<Integer> node9 = new ListNode<>(1, node8);
        ListNode<Integer> node1 = new ListNode<>(1, null);
        ListNode<Integer> node2 = new ListNode<>(2, node1);
        ListNode<Integer> node3 = new ListNode<>(3, node2);
        ListNode<Integer> node4 = new ListNode<>(4, node3);
        ListNode<Integer> node51 = new ListNode<>(51, node4);
        ListNode<Integer> node52 = new ListNode<>(52, node51);
        ListNode<Integer> node6 = new ListNode<>(4, node52);
        ListNode<Integer> node7 = new ListNode<>(3, node6);
        ListNode<Integer> node8 = new ListNode<>(2, node7);
        ListNode<Integer> node9 = new ListNode<>(1, node8);
        System.out.println(isPalindrome(node9));
    }

    public static boolean isPalindrome(ListNode<Integer> node){
        ListNode<Integer> slow = node, fast = node;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode<Integer> fh = node;
        ListNode<Integer> sh = reverseList(slow);
        ListNode.printNode(fh);
        ListNode.printNode(sh);
        while(sh != null && fh != null){
            if(sh.data != fh.data) return false;
            sh = sh.next;
            fh = fh.next;
        }
        return true;
    }

    public static ListNode<Integer> reverseList(ListNode<Integer> node){
        if(node == null || node.next == null) return node;
        ListNode<Integer> dummy = new ListNode<>();
        dummy.next = node;
        ListNode<Integer> current = node;
        while(current.next != null){
            ListNode<Integer> cnext = current.next;
            current.next = cnext.next;
            cnext.next = dummy.next;
            dummy.next = cnext;
        }
        return dummy.next;
    }
}
