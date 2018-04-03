package preparation.chapter13;

import java.util.*;

public class Ex7 {
    public static void main(String[] args) {
        List<String> paragraph = Arrays.asList("apple", "banana", "apple", "apple", "dog", "cat", "apple",
                "dog", "banana", "apple", "cat", "dog");
        Set<String> keyords = new HashSet<>(Arrays.asList("banana", "cat", "dog"));

        System.out.println(digest(paragraph, keyords));
        System.out.println(digest(paragraph.iterator(), keyords));
        System.out.println(digestWithLinkedHashMap(paragraph.iterator(), keyords));
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String word: paragraph){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        String text = "geeksforgeeks";
        // "egkegkesfesor"
        // "eskegserokgfe"
        System.out.println(makeNoTwoAdjacientEqual(text));
        System.out.println(scramble(text, 3));
    }

    public static String scramble(String input, int distance){
        Queue<ChararacterFrequency> lastRef = new LinkedList<>();
        Map<Character, ChararacterFrequency> dictionary = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for(char c : input.toCharArray()){
            dictionary.putIfAbsent(c, new ChararacterFrequency(c, 0));
            dictionary.get(c).f++;
        }
        PriorityQueue<ChararacterFrequency> maxFrequency = new PriorityQueue<>(new Comparator<ChararacterFrequency>() {

            public int compare(ChararacterFrequency o1, ChararacterFrequency o2) {
                return Integer.compare(o2.f, o1.f) != 0 ?
                        Integer.compare(o2.f, o1.f) : Integer.compare(o2.c, o1.c);
            }
        });
        dictionary.values().forEach(e -> maxFrequency.offer(e));
        while(!maxFrequency.isEmpty()){
            ChararacterFrequency current = maxFrequency.poll();
            builder.append(current.c);
            current.f--;
            if(lastRef.size() == (distance - 1)) {
                ChararacterFrequency recent = lastRef.poll();
                if(recent.f > 0) maxFrequency.offer(recent);
            }
            lastRef.offer(current);
        }
        String result = builder.toString();
        return result.length() == input.length() ? result : "";
    }
    public static class ChararacterFrequency{
        public Character c;
        public Integer f;

        public ChararacterFrequency(Character c, Integer f) {
            this.c = c;
            this.f = f;
        }

        @Override
        public String toString() {
            return c + " -> " + f;
//            return "ChararacterFrequency{" +
//                    "c=" + c +
//                    ", f=" + f +
//                    '}';
        }
    }

    public static String makeNoTwoAdjacientEqual(String input){
        Map<Character, ChararacterFrequency> dictionary = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for(char c : input.toCharArray()){
            dictionary.putIfAbsent(c, new ChararacterFrequency(c, 0));
            dictionary.get(c).f++;
        }
        PriorityQueue<ChararacterFrequency> maxFrequency = new PriorityQueue<>(new Comparator<ChararacterFrequency>() {

            public int compare(ChararacterFrequency o1, ChararacterFrequency o2) {
                return Integer.compare(o2.f, o1.f) != 0 ?
                        Integer.compare(o2.f, o1.f) : Integer.compare(o2.c, o1.c);
            }
        });
        dictionary.values().forEach(e -> maxFrequency.offer(e));
        ChararacterFrequency lastRef = null;
        while(!maxFrequency.isEmpty()){
            ChararacterFrequency current = maxFrequency.poll();
            builder.append(current.c);
            current.f--;
            if(lastRef != null && lastRef.f > 0) maxFrequency.offer(lastRef);
            lastRef = current;
        }
        String result = builder.toString();
        return result.length() == input.length() ? result : "";
    }

    private static void test(Map<String, Integer> dictionary){
        for(Map.Entry<String, Integer> entry : dictionary.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    private static StartEndIndices digest(Iterator<String> stream, Set<String> keywords){
        StartEndIndices se = new StartEndIndices();
        Map<String, Integer> traversed = new HashMap<>();
        LinkedList<Integer> lastIndices = new LinkedList<>();
        int i = 0;
        while(stream.hasNext()){
            String word = stream.next();
            if(keywords.contains(word)){
                if(!traversed.containsKey(word)) lastIndices.add(i);
                else {
                    lastIndices.remove(traversed.get(word));
                    lastIndices.add(i);
                }
                traversed.put(word, i);
                if(traversed.size() == keywords.size()
                        && Integer.compare(lastIndices.peekLast() - lastIndices.peekFirst(), se.distance()) < 0){
                    se.start = lastIndices.peekFirst();
                    se.end = lastIndices.peekLast();
                }
                if(se.distance().equals(keywords.size() - 1)) return se;
            }
            i++;
        }
        return se;
    }

    private static Integer getValueForFirstEntry(LinkedHashMap<String, Integer> dictionary){
        int value = -1;
        for(Map.Entry<String, Integer> entry : dictionary.entrySet()){
            value = entry.getValue();
            break;
        }
        return value;
    }
    private static StartEndIndices digestWithLinkedHashMap(Iterator<String> stream, Set<String> keywords){
        int i = 0;
        LinkedHashMap<String, Integer> traversed = new LinkedHashMap<>();
        StartEndIndices se = new StartEndIndices();
        while(stream.hasNext()){
            String word = stream.next();
            if(keywords.contains(word)){
                if(traversed.containsKey(word)){
                    traversed.remove(word);
                }
                traversed.put(word, i);
                if(traversed.size() == keywords.size()
                        && Integer.compare(i - getValueForFirstEntry(traversed), se.distance()) < 0){
                    se.start = getValueForFirstEntry(traversed);
                    se.end = i;
                }
            }
            i++;
        }
        return se;
    }

    private static StartEndIndices digest(List<String> paragraph, Set<String> keywords){
        StartEndIndices se = new StartEndIndices();
        Map<String, Integer> traversed = new HashMap<>();
        for(int left = 0, right = 0; left <= right && right < paragraph.size(); right++){
            String rw = paragraph.get(right);
            if(keywords.contains(rw)){
                if(traversed.containsKey(rw)) traversed.put(rw, traversed.get(rw) + 1);
                else traversed.put(rw, 1);
                if(traversed.keySet().size() == keywords.size()){
                    while(left <= right && traversed.size() == keywords.size()){
                        String lw = paragraph.get(left);
                        if(keywords.contains(lw)){
                            if(traversed.containsKey(lw)) {
                                traversed.put(lw, traversed.get(lw) - 1);
                                if(traversed.get(lw) == 0) traversed.remove(lw);
                            }
                        }
                        left++;
                    }
                    left--;
                    traversed.put(paragraph.get(left), 1);
                    if(Integer.compare(right - left, se.distance()) < 0) {
                        se.start = left;
                        se.end = right;
                    }
                    if(se.distance().equals(keywords.size() - 1)) return se;
                }
            }
        }
        return se;
    }

    public static class StartEndIndices {
        int start;
        int end;

        public StartEndIndices() {
            this.start = -1;
            this.end = -1;
        }

        public StartEndIndices(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Integer distance(){
            return (this.start == -1 && this.end == -1) ? Integer.MAX_VALUE : this.end - this.start;
        }

        @Override
        public String toString() {
            return "StartEndIndices{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
