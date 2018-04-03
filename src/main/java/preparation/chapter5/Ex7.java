package preparation.chapter5;

public class Ex7 {
    public static void main(String[] args) {
        double base = 2.0;
        int exp = 17;
        System.out.println(pow(base, exp));
        System.out.println(power(base, exp));
//        System.out.println(Math.pow(base, exp));
    }

    public static double pow(double x, int y) {
        double result = 1.0;
        long power = y;
        if (y < 0) {
            power = -power;
            x = 1.0 / x ;
        }
        while (power != 0) {
            if ((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            System.out.println(result + " -- -- " + x);
            power >>= 1;
        }
        return result;
    }

    private static double power(double base, int exp){
        if(exp < 0){
            exp = -exp;
            base = 1.0/base;
        }
        if(exp == 0) return 1f;
        if(exp == 1) return base;
        if(exp%2 == 0){
            double temp = power(base, exp/2);
            return temp * temp;
        } else {
            double temp = power(base, exp/2);
            return temp * temp * base;
        }
    }
}
