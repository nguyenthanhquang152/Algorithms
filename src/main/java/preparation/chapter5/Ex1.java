package preparation.chapter5;

public class Ex1 {
    public static void main(String[] args) {
        long word = 16;
        parity1(word);
        parity2(word);
    }
    private static void parity2(long word){
        word ^= word >>> 32;
        word ^= word >>> 16;
        word ^= word >>> 8;
        word ^= word >>> 4;
        word ^= word >>> 2;
        word ^= word >>> 1;
        // extract the last bit.
        System.out.println(word & 1);
    }

    private static void parity1(long word) {
        short n = 0;
        while(word != 0){
            n ^= 1;
            word &= (word - 1);
        }
        System.out.println(n);
    }
}
