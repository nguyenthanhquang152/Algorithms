package preparation.chapter5;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println(add(9, 9));
        System.out.println(multiply(9,8));
    }

    public static long multiply(long a, long b){
        long result = 0;
        while(a != 0){
            if((a & 1) != 0){
               result = add(result, b);
            }
            a >>>= 1;
            b <<= 1;
        }
        return result;
    }

    public static long add(long a, long b) {
        long ta = a;
        long tb = b;
        long result = 0;
        long carry = 0;
        long nextShift = 1;
        while(ta != 0 || tb != 0){
            // every step, we have nextABitmask and nextBBitmask like
            // (1,1), (10,10), (100,100), etc...
            long nextABitmask = a & nextShift;
            long nextBBitmask = b & nextShift;
            // calculate the value for the current bit.
            // (1 ^ 1 ^ carry), (10 ^ 10  ^ carry), (100 ^ 100 ^ carry), etc...
            // OR to the current result to get the new one.
            result |= (nextABitmask ^ nextBBitmask ^ carry);
            // Calculate the next carry.
            // 0: if having 1 value in (nextABitmask, nextBBitmask, carry) is set
            carry = (nextABitmask & nextBBitmask) | (nextABitmask & carry) | (nextBBitmask & carry);
            // left shift carry for next calculation
            carry <<= 1;
            // calculate next bitmask.
            nextShift <<= 1;
            // right shift both of numbers.
            ta >>>= 1;
            tb >>>= 1;
        }
        return result | carry;
    }
}
