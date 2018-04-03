import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

public class MedianValueOfNewValues {
    public static void main(String[] args) throws IOException{
        Median median = new Median();
        int randomSize = ThreadLocalRandom.current().nextInt(5, 20 + 1);
        String accNums = "";
        for(int i=0; i<randomSize; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(5, 40 + 1); 
            median.addNewNumber(randomNum);
            accNums += randomNum + ", ";
            System.out.println("Current numbers : " + accNums);
            System.out.println("Next median : " + median.getMedian());
        }
    }
    
    public static class Median{
        PriorityQueue<Integer> bigElements;
        PriorityQueue<Integer> smallElements;
        int size;
        public Median() {
            size = 0;
            bigElements = new PriorityQueue<>();
            smallElements = new PriorityQueue<>(Comparator.reverseOrder());
        }
        
        public void addNewNumber(int value) {
            if(size == 0) {
               bigElements.offer(value); 
            } else if(size == 1){
                smallElements.offer(value);
                swapPeeks();
            } else {
                if(value > bigElements.peek()) {
                    int bigPeek = bigElements.poll();
                    bigElements.offer(value);
                    smallElements.offer(bigPeek);
                } else if(value < smallElements.peek()) {
                    int smallPeek = smallElements.poll();
                    smallElements.offer(value);
                    bigElements.offer(smallPeek);
                } else {
                    if(bigElements.size() <= smallElements.size()) {
                        bigElements.offer(value);
                    } else {
                        smallElements.offer(value);
                    }
                }
                balance();
            }
            size++;
            System.out.println(bigElements + "" + smallElements);
        }
        
        private void balance() {
            if(bigElements.size() - smallElements.size() > 1) {
                smallElements.offer(bigElements.poll());
            }
            if(smallElements.size() - bigElements.size() > 1) {
                bigElements.offer(smallElements.poll());
            }
        }
        
        private void swapPeeks() {
            int smallPeek = smallElements.poll();
            int bigPeek = bigElements.poll();
            smallElements.offer(bigPeek);
            bigElements.offer(smallPeek);
        }
        
        public double getMedian() {
            if(smallElements.size() == bigElements.size()) {
                return (smallElements.peek() + bigElements.peek()) / 2.0f;
            } else if(smallElements.size() > bigElements.size()) {
                return smallElements.peek();
            } else {
                return bigElements.peek();
            }
        }
        
    }
}