package preparation.chapter5;

public class Ex6 {
    public static void main(String[] args) {
        long a = 18;
        long b = 3;
        divideWithoutShifting(a, b);
        divideWithShifting(a, b);
    }

    private static void divideWithShifting(long a, long b){
        long result = 0;
        long power = 32;
        long bpower = b << power;
        while(a >= b){
            while(bpower > a){
                bpower >>>= 1;
                power--;
            }
            result += 1 << power;
            a -= bpower;
        }
        System.out.println(result);
    }

    private static void divideWithoutShifting(long a, long b) {
        long result = 0;
        while(a >= b){
            result++;
            a -= b;
        }
        System.out.println(result);
    }
}
