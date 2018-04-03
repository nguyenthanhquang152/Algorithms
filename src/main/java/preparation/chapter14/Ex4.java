package preparation.chapter14;

import java.util.*;

import static preparation.chapter14.Ex4.CEvent.ce;

public class Ex4 {
    public static class CEvent{
        public int b;
        public int e;

        public CEvent(int b, int e) {
            this.b = b;
            this.e = e;
        }

        @Override
        public String toString() {
            return "CEvent{" +
                    "b=" + b +
                    ", e=" + e +
                    '}';
        }

        public static CEvent ce(int b, int e){
            return new CEvent(b, e);
        }
    }

    public static void main(String[] args) {
        List<CEvent> events = Arrays.asList(
                 ce(1,5)
                ,ce(6,10)
                ,ce(11,13)
                ,ce(14,15)
                ,ce(2,7)
                ,ce(8,9)
                ,ce(12,15)
                ,ce(4,5)
                ,ce(9,17)

        );

        List<User> users = Arrays.asList(
                User.make(9,1,5)
                ,User.make(9,6,10)
                ,User.make(9,11,13)
                ,User.make(9,14,15)
                ,User.make(9,2,7)
                ,User.make(9,8,9)
                ,User.make(9,12,15)
                ,User.make(9,4,5)
                ,User.make(9,9,17)

        );

        List<Integer> overlappingTimeline = new ArrayList<>(Collections.nCopies(17, 0));
        for(CEvent ce : events){
            for(int i = ce.b ; i < ce.e; i++){
                overlappingTimeline.set(i, overlappingTimeline.get(i) + 1);
            }
        }

        System.out.println(overlappingTimeline);
        System.out.println(findMaxConcurrentTask(events));
        System.out.println(findPeakBandWidth(users));
    }

    public static int findMaxConcurrentTask(List<CEvent> events){
        List<Endpoint> endpoints = new ArrayList<>(events.size() * 2);
        for(CEvent ce : events){
            endpoints.add(new Endpoint(ce.b, true));
            endpoints.add(new Endpoint(ce.e, false));
        }
        Collections.sort(endpoints);
        int maxConcurrentTasks = 0, nConcurrentTasks = 0;
        for(Endpoint endpoint: endpoints){
            if(endpoint.isStart){
                nConcurrentTasks++;
                if(maxConcurrentTasks < nConcurrentTasks){
                    maxConcurrentTasks = nConcurrentTasks;
                }
            } else {
                nConcurrentTasks--;
            }
        }
        return maxConcurrentTasks;
    }

    public static class Endpoint implements Comparable<Endpoint>{
        public int idx;
        public boolean isStart;

        public Endpoint(int idx, boolean isStart) {
            this.idx = idx;
            this.isStart = isStart;
        }

        @Override
        public String toString() {
            return
                    "" + idx +
                    "" + isStart;
        }

        @Override
        public int compareTo(Endpoint o) {
            if(Integer.compare(idx, o.idx) == 0)
            return isStart && !o.isStart ? -1 : !isStart && o.isStart ? 1 : 0;
            return Integer.compare(idx, o.idx);
        }
    }

    public static class User {
        public int bw;
        public int b;
        public int e;

        public User(int bw, int b, int e) {
            this.bw = bw;
            this.b = b;
            this.e = e;
        }

        public static User make(int bw, int b, int e){
            return new User(bw, b, e);
        }
    }

    public static class TimeBandwidth implements Comparable<TimeBandwidth>{
        public int idx;
        public int bw;
        public boolean using;

        public TimeBandwidth(int idx, int bw, boolean using) {
            this.idx = idx;
            this.bw = bw;
            this.using = using;
        }

        @Override
        public int compareTo(TimeBandwidth o) {
            if(Integer.compare(idx, o.idx) == 0)
                return using && !o.using ? -1 : !using && o.using ? 1 : 0;
            return Integer.compare(idx, o.idx);
        }
    }

    public static int findPeakBandWidth(List<User> users){
        List<TimeBandwidth> timeline = new ArrayList<>(users.size() * 2);
        for(User u : users){
            timeline.add(new TimeBandwidth(u.b, u.bw, true));
            timeline.add(new TimeBandwidth(u.e, u.bw, false));
        }
        Collections.sort(timeline);
        int peakBW = 0, bwSofar = 0;
        for(TimeBandwidth tb: timeline){
            if(tb.using){
                bwSofar += tb.bw;
                if(peakBW < bwSofar) peakBW = bwSofar;
            } else {
                bwSofar -= tb.bw;
            }
        }
        return peakBW;
    }
}
