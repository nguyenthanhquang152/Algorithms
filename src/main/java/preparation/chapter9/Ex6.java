package preparation.chapter9;

import java.util.*;

public class Ex6 {
    public static void main(String[] args) {
        List<Integer> heights = Arrays.asList(9,28,18,8);
        Deque<Integer> sunsetViewed = new LinkedList<>();
        sunsetViewed.push(0);
        for(int i=1; i<heights.size(); i++){
            Integer height = heights.get(i);
            while(!sunsetViewed.isEmpty() && heights.get(sunsetViewed.peek()) <= height){
                sunsetViewed.pop();
            }
            sunsetViewed.push(i);
        }
        System.out.println(sunsetViewed);
    }
}

