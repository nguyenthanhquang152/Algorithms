package preparation.chapter8;

public class Ex2 {
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

        ListNode.printNode(node9);
        ListNode<Integer> reversedNode = reverseEachSequence(node9, 4, 9);
        ListNode.printNode(reversedNode);
    }
    public static ListNode<Integer> reverseEachSequence(ListNode<Integer> node, int sequence, int size){
        if(sequence == 1) return node;
        int nSeqs = size/sequence;
        ListNode<Integer> dummyHead = new ListNode<>();
        dummyHead.next = node;
        ListNode<Integer> successor = dummyHead;
        for(int iSeq = 0; iSeq < nSeqs; iSeq ++){
            ListNode<Integer> current = successor.next;
            for(int iSubList = 0; iSubList < sequence - 1; iSubList++){
                ListNode<Integer> cnext = current.next;
                current.next = cnext.next;
                cnext.next = successor.next;
                successor.next = cnext;
            }
            successor = current;
        }
        return dummyHead.next;
    }
    public static ListNode<Integer> reverseSublist1(ListNode<Integer> node, int start, int end){
        if(start == end) return node;
        ListNode<Integer> dummyHead = new ListNode<>();
        dummyHead.next = node;
        ListNode<Integer> successor = dummyHead;
        for(int i=1; i<start; i++){
            successor = successor.next;
        }
        ListNode<Integer> headSublist = successor.next;// we are at the first node in sublist.
        while(start++ < end){
            // swap current and current.next
            // point successor to new current
            ListNode<Integer> cnext = headSublist.next;
            headSublist.next = cnext.next;
            cnext.next = successor.next;
            successor.next = cnext;
        }
        return dummyHead.next;
    }

    public static ListNode<Integer> reverseSublist0(ListNode<Integer> node, int start, int end){
        ListNode<Integer> dummyHead = new ListNode<>();
        ListNode<Integer> resultNode = dummyHead;
        dummyHead.next = node;
        int i;
        for(i = 1; dummyHead != null && i<start; i++){
            dummyHead = dummyHead.next;
        }
        ListNode<Integer> current = dummyHead.next;
        ListNode<Integer> tail = current;
        for(; tail!= null && i<=end; i++){
            tail = tail.next;
        }
        while(start<=end){
            ListNode<Integer> cnext = current.next;
            current.next = tail;
            tail = current;
            dummyHead.next = current;
            current = cnext;
            start++;
        }
        return resultNode.next;
    }
}
