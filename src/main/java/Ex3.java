import java.util.Arrays;

public class Ex3 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[] {
            1, 3, 46, 1, 3, 9    
        }, 47));
        System.out.println(optimizedNumberOfPairs(new int[] {
                1, 3, 46, 1, 3, 9    
            }, 47));
        
        System.out.println(numberOfPairs(new int[] {
                6, 6, 3, 9, 3, 5, 1    
            }, 12));
        System.out.println(optimizedNumberOfPairs(new int[] {
                6, 6, 3, 9, 3, 5, 1    
            }, 12));
    }
    
    public static int numberOfPairs(int[] a, long k) {
        java.util.Map<Integer, Long> result = new java.util.HashMap<>();
        java.util.Arrays.sort(a);
        int left = 0;
        int right = a.length-1;
        while(left < right) {
            long curPairSum = a[left] + a[right];
            if(Long.compare(curPairSum, k) == 0) {
                result.put(a[left], curPairSum);
                left++;
            } else if(Long.compare(curPairSum, k) == -1 ) {
                left++;
            } else {
                right--;
            }
        }
        return result.size();
    }
    
    public static int optimizedNumberOfPairs(int[] a, long k) {
        java.util.Map<Integer, Boolean> hasVisited = new java.util.HashMap<>();
        Arrays.stream(a).forEach(value -> hasVisited.put(value, false));
        int[] result = new int[] {0};
        Arrays.stream(a).forEach(value ->{
            if(hasVisited.get((int) (k-value)) != null && !hasVisited.get((int) (k-value))) {
                hasVisited.put((int) (k-value), true);
                hasVisited.put(value, true);
                result[0]++;
            }
        });
        return result[0];
    }
}
