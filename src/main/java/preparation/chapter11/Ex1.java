package preparation.chapter11;

import java.util.*;

public class Ex1 {
    public static class ArrayEntry{
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> sortedArrays = Arrays.asList(
                Arrays.asList(4,5,7),
                Arrays.asList(0,2,3),
                Arrays.asList(0,2,28));
        List<Integer> merged = merged(sortedArrays);
        System.out.println(merged);
    }

    public static List<Integer> merged(List<List<Integer>> sortedArrays){
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
        for (List<Integer> sortedArray : sortedArrays) {
            iters.add(sortedArray.iterator());
        }
        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value,o2.value);
            }
        });

        for(int i=0; i<sortedArrays.size(); i++){
            if(iters.get(i).hasNext()) minHeap.add(new ArrayEntry(iters.get(i).next(), i));
        }
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ArrayEntry head = minHeap.poll();
            result.add(head.value);
            int i = head.arrayId;
            System.out.println(i);
            if(iters.get(i).hasNext()) minHeap.add(new ArrayEntry(iters.get(i).next(), i));

        }
        return result;
    }
}
