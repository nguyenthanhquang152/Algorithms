package preparation.chapter5;

public class Ex2 {
    public static void main(String[] args) {
        int i = 1;
        int j = 6;
        long word = 73;
        // extract the ith/jth bit
        short biti = (short)((word >> i) & 1);
        short bitj = (short)((word >> j) & 1);
        if(biti == bitj){
            System.out.println("No need to swap i and j: " + word);
        } else {
            long bitmask = (1<<i) + (1<<j);
            System.out.println(bitmask);
            System.out.println("Word after swapped: " + (bitmask ^ word));
        }
    }
}
