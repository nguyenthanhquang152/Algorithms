package interview.agoda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FirstChallenge {
    // 3 sorted arrays
    // [1,3,5]
    // [2,4,6]
    // [0,7,8]
    public static void main() {
        // maybe use the priority queue
        PriorityQueue<Integer> buffer = new PriorityQueue<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> input = new ArrayList<>();
        List<Integer> first = Arrays.asList(1,3,5); // => ((1, 0), (3, 0), (5, 0)
        List<Integer> second = Arrays.asList(2,4,6); // => ((2, 1), (4, 1), (6, 1)
        List<Integer> third = Arrays.asList(0,7,8); // => ((0, 2), (7, 2), (8, 2)
        int firstIndex = 0;
        int secondIndex = 0;
        int thirdIndex = 0;
        // Add every first element of three arrays to priority queue.
        // We continue to process when we see one of the arrays has the remaining elements
        while (firstIndex < first.size() || secondIndex < second.size() || thirdIndex < third.size()) {


            if(!first.isEmpty()) {
                buffer.add(first.get(firstIndex));
                firstIndex++;
            }

            if(!second.isEmpty()) {
                buffer.add(second.get(secondIndex));
                secondIndex++;
            }

            if(!third.isEmpty()) {
                buffer.add(third.get(thirdIndex));
                thirdIndex++;
            }

            result.add(buffer.poll());
        }

        // (1,0), (2,1), (0,2)
        // (0,2) => choose third array
        // one array is empty,

    }

//    public List<Integer> merge(List<List<Integer>> inputLists) {
        // the body code is above

        // the result

//        return
//        val and var
//        public final Integer result
//    }


//    class A {
//        val a: Int
//        val b: B
//    }
//
//    class B {
//        val b1: String
//    }

    public static class A {
        public final int a;
        public final B b;
        public A(int a, B b) {
            this.a = a;
            this.b = b;
        }

    }

    public static class B {

        public B(String b1) {
            this.b1 = b1;
        }
        public final String b1;
    }

    public static class C extends A {
        public C(int a, B b) {
            super(a + 2, b);
        }
    }
}
