package preparation.chapter14;

import java.util.*;

public class Ex5 {
    public static class Interval implements Comparable<Interval>{
        public int b;
        public int e;

        public Interval(int b, int e) {
            this.b = b;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "b=" + b +
                    ", e=" + e +
                    '}';
        }

        public static boolean isOverlapping(Interval i1, Interval i2){
            return i1.b <= i2.e && i2.b <= i1.e;
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(b, o.b) == 0 ? Integer.compare(e, o.e) : 0;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(
                new Interval(-4, -1)
                , new Interval(0, 2)
                , new Interval(3, 6)
                , new Interval(7, 9)
                , new Interval(11, 12)
                , new Interval(14, 17)
        );
        List<Interval> newIntervals = new LinkedList<>();
        Interval newI = new Interval(1, 8);
//        Interval newI = new Interval(13, 13);
        int i = 0;
        while(i < intervals.size() && !Interval.isOverlapping(intervals.get(i), newI)){
            newIntervals.add(intervals.get(i));
            i++;
        }
        while(i < intervals.size() && Interval.isOverlapping(intervals.get(i), newI)){
            newI.b = Integer.min(newI.b, intervals.get(i).b);
            newI.e = Integer.max(newI.e, intervals.get(i).e);
            i++;
        }
        newIntervals.add(newI);
//        while(i < intervals.size() && !Interval.isOverlapping(intervals.get(i), newI)){
//            newIntervals.add(intervals.get(i));
//            i++;
//        }
        newIntervals.addAll(intervals.subList(i, intervals.size()));
        System.out.println(newIntervals);
        //[Interval{b=-4, e=-1}, Interval{b=0, e=2}, Interval{b=3, e=6}, Interval{b=7, e=9}, Interval{b=11, e=12}, Interval{b=14, e=18}]

    }
}
