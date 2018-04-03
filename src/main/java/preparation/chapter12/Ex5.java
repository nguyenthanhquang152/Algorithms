package preparation.chapter12;

public class Ex5 {
    public static void main(String[] args) {
        double input = Math.pow(0.5, 2);
        System.out.println(squareRoot(input, 2));
        System.out.println(squareRoot(input));
    }

    public static double squareRoot(double input, int esi){
        long tenPowerEsi = (long)Math.pow(10.0000000, esi * 2);
        long ceil = (long) (input * tenPowerEsi * tenPowerEsi);
        long ceilSquareRoot = Ex4.nextLowestSquareRoot(ceil);
        return (double)ceilSquareRoot/tenPowerEsi;
    }

    public static double squareRoot(double input){
        double left,right;
        if(input < 1.0){
            left = input;
            right = 1.0;
        } else {
            left = 1.0;
            right = input;
        }
        while(dCompare(left, right) == -1){
            double mid = left + 0.5 * (right - left);
            double midPowerTwo = mid * mid;
            if(dCompare(midPowerTwo, input) == 0) return mid;
            else if(dCompare(midPowerTwo, input) == 1) right = mid;
            else left = mid;
        }
        return left;
    }

    private static int dCompare(double a, double b){
        double epsilon = 0.000001;
        double diff = (a - b)/b;
        return diff < -epsilon ? -1 :
                diff > epsilon ? 1 : 0;
    }
}
