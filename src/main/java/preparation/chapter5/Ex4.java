package preparation.chapter5;

public class Ex4 {
    public static void main(String[] args) {
        int word = 7; //(1011100)2
        // lowest set bit = (0000100)2
        int lowestSetBit = word & ~(word - 1);
        System.out.println(lowestSetBit);
        // lowest unset bit = (0000001)2
        int lowestUnsetBit = (~word) & (word + 1);
        System.out.println(lowestUnsetBit);
        // conduct bitmask = (0000101)2
        int bitmask = lowestSetBit | lowestUnsetBit;
        System.out.println(bitmask);
        // Swap bits => (1011001)2
        System.out.println(bitmask ^ word);
    }
}
