package preparation.chapter8;

import java.util.Arrays;
import java.util.List;

public class Ex12 {
    public static void main(String[] args) {
        ListNode<Integer> node1 = new ListNode<>(11, null);
        ListNode<Integer> node2 = new ListNode<>(5, node1);
        ListNode<Integer> node3 = new ListNode<>(7, node2);
        ListNode<Integer> node4 = new ListNode<>(11, node3);
        ListNode<Integer> node5 = new ListNode<>(2, node4);
        ListNode<Integer> node6 = new ListNode<>(2, node5);
        ListNode<Integer> node7 = new ListNode<>(3, node6);
        ListNode<Integer> result = pivot(node7, 7);
        ListNode.printNode(result);
    }

    public static ListNode<Integer> pivot(ListNode<Integer> node, Integer k){
        ListNode<Integer> lessThanDummy = new ListNode<>();
        ListNode<Integer> equalToDummy = new ListNode<>();
        ListNode<Integer> greaterThan = new ListNode<>();
        List<ListNode<Integer>> dummies = Arrays.asList(lessThanDummy,equalToDummy,greaterThan);
        for(ListNode<Integer> iter = node; iter != null; iter = iter.next){
            int index = Integer.compare(iter.data, k) + 1;
            System.out.println(iter.data + " " + index);
            dummies.get(index).next = iter;
            dummies.set(index, dummies.get(index).next);
        }
        dummies.get(2).next = null;
        dummies.get(1).next = greaterThan.next;
        dummies.get(0).next = equalToDummy.next;
        return lessThanDummy.next;
    }
}
