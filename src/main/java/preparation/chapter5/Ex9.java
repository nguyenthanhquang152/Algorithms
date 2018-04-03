package preparation.chapter5;

public class Ex9 {
    public static void main(String[] args) {
        int number = 1234321;
        System.out.println(isPalindromeNumber(number));

    }

    private static boolean isPalindromeNumber(int number) {
        if(number < 0) return false;
        //Get number of digits
        int ndigit = (int)Math.floor(Math.log10(number)) + 1;
        int mask = (int)Math.pow(10, ndigit - 1);
        for(int i=0; i<ndigit/2; i++){
            // Compare MSD and LSD
            if(number/mask != number%10){
                return false;
            }
            number %= mask; // Exclude MSD
            number /= 10; // Exclude LSD
            mask /= 100;
        }
        return true;
    }
}
