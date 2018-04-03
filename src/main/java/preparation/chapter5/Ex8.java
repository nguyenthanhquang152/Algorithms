package preparation.chapter5;

public class Ex8 {
    public static void main(String[] args) {
        int number = -1234;
        int absNumber = Math.abs(number);
        int result = 0;
        while(absNumber > 0){
            result = result * 10 + absNumber % 10;
            absNumber = absNumber / 10;
        }
        result = number < 0 ? -result : result;
        System.out.println(result);
    }
}
