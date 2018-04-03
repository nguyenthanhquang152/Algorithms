package preparation.chapter8;

public class Ex1 {
    public static void main(String[] args) {
        ListNode<Integer> node9 = new ListNode<>(9, null);
        ListNode<Integer> node3 = new ListNode<>(3, node9);
        ListNode<Integer> node7 = new ListNode<>(7, null);
        ListNode<Integer> node5 = new ListNode<>(5, node7);
        ListNode<Integer> node1 = new ListNode<>(1, node5);
        ListNode<Integer> mergeList = merge(node1, node3);
        while(mergeList != null){
            System.out.println(mergeList.data);
            mergeList = mergeList.next;
        }
    }

    public static  ListNode<Integer> merge(ListNode<Integer> l1, ListNode<Integer> l2){
        ListNode<Integer> result = new ListNode<>();
        ListNode<Integer> pl1 = l1;
        ListNode<Integer> pl2 = l2;
        ListNode<Integer> pScan = result;
        while(pl1 != null && pl2 != null){
            if(pl1.data < pl2.data){
                pScan.next = pl1;
                pl1 = pl1.next;
            } else {
                pScan.next = pl2;
                pl2 = pl2.next;
            }
            pScan = pScan.next;
        }
        pScan.next = pl1 == null ? pl2 : pl1;
        return result.next;
    }
}
