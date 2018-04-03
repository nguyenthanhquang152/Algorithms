package preparation.chapter8;

import java.util.Arrays;
import java.util.List;

public class Ex5 {

    public static void main(String[] args) {

    }

    public static ListNode<Integer> hasCommonSublistOpt(ListNode<Integer> node1, ListNode<Integer> node2){
        List<Object> cycle1 = hasCycle(node1);
        List<Object> cycle2 = hasCycle(node2);
        int length1 = (Integer)cycle1.get(1);
        int clength1 = (Integer)cycle1.get(2);
        if(clength1 == 0) return null;
        ListNode<Integer> headCycle1 = ((ListNode<Integer>)cycle1.get(0)).data != null ?
                ((ListNode<Integer>)cycle1.get(0)) : null;
        int length2 = (Integer)cycle2.get(1);
        int clength2 = (Integer)cycle2.get(2);
        if(clength2 == 0) return null;
        if(clength1 != clength2) return null;
        ListNode<Integer> headCycle2 = ((ListNode<Integer>)cycle2.get(0)).data != null ?
                ((ListNode<Integer>)cycle2.get(0)) : null;
        ListNode<Integer> ph1 = headCycle1;
        ListNode<Integer> ph2 = headCycle2;
        if(ph1 != ph2) {
            do {
                ph1 = ph1.next;
                if (ph1 == ph2) break;
            } while (clength1-- > 0);
        }
        if(ph1 != ph2) return null; // sub cycle lists are not overlapping.

        ListNode<Integer> p1 = node1;
        ListNode<Integer> p2 = node2;
        if(length1 > length2){
            while(length1-- > length2){
                p1 = p1.next;
            }
        } else if(length2 > length1){
            while(length2-- > length1){
                p2 = p2.next;
            }
        }
        while(p1 != headCycle1 && p2 != headCycle2 && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == p2 ? p1 : headCycle1;

    }

    public static List<Object> hasCycle(ListNode<Integer> node){
        ListNode<Integer> fast = node, slow = node;
        int length = 0;
        int clen = 0;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                int clength = 0;
                do{
                    clength++;
                    fast = fast.next;
                } while (slow != fast);
                length += clength;
                clen = clength;
                ListNode<Integer> advanced = node;
                while(clength-- > 0) advanced = advanced.next;
                ListNode<Integer> headCycle = node;
                while(advanced != headCycle){
                    advanced = advanced.next;
                    headCycle = headCycle.next;
                    length++;
                }
                return Arrays.asList(headCycle, length, clen);
            }
        }
        return Arrays.asList(new ListNode<>(), 0, 0);

    }

}
