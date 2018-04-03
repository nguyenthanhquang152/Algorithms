package preparation.chapter15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex9 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,3,5, 7,11,13,17,19, 23);
        BSTNode<Integer> root = buildFromSortedList(list, 0, list.size() - 1);
        BSTNode.displayByLevel(root);
    }

    public static <T extends Comparable<T>> BSTNode<T> buildFromSortedList(List<T> list, int start, int end){
        if(start > end) return null;
        if(start == end) return new BSTNode(list.get(start));
        int mid = start + (end - start) / 2;
        BSTNode<T> left = buildFromSortedList(list, start, mid - 1);
        BSTNode<T> right = buildFromSortedList(list, mid + 1, end);
        return new BSTNode(list.get(mid), left, right);
    }
}
