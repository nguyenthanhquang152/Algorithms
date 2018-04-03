package preparation.chapter8;

import java.util.Arrays;
import java.util.List;

public class Ex10 {
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
        ListNode<Integer> result = evenOddMerge(node9);
        ListNode.printNode(result);
    }

    public static ListNode<Integer> evenOddMerge(ListNode<Integer> node){
        ListNode<Integer> evenDummyHead = new ListNode<>();
        ListNode<Integer> oddDummyHead = new ListNode<>();
        List<ListNode<Integer>> dummyHeades = Arrays.asList(evenDummyHead,oddDummyHead);
        int turn = 0;
        for(ListNode<Integer> iter = node; iter != null; iter = iter.next){
            ListNode<Integer> dummyHead = dummyHeades.get(turn);
            dummyHead.next = iter;
            dummyHeades.set(turn, iter);
            turn ^= 1;
        }
        dummyHeades.get(1).next = null;
        dummyHeades.get(0).next = oddDummyHead.next;
        return evenDummyHead.next;
    }
}
