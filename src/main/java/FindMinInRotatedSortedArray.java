
public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input = new int[] {
                3,4,5,6,7,1,2
        };
        System.out.println(perform(input, 0, input.length-1));
    }
    
    public static int perform(int[] input, int start, int end) {
        if(start >= end) return end+1;
        int mid = (start+end)/2;
        if(input[start] < input[mid]) {
            return perform(input, mid, end);
        } else {
            return perform(input, start, mid);
        }
    }
}
