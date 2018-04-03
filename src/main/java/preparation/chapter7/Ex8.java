package preparation.chapter7;

public class Ex8 {
    public static void main(String[] args) {
        System.out.println(nextLookAndSayNumber(8));
    }

    public static Integer nextLookAndSayNumber(int n){
        String number = "1";
        for(int i=1; i<n; i++){
            number = nextLookAndSayNumber(number);
        }
        return Integer.parseInt(number);
    }

    public static String nextLookAndSayNumber(String number){
        char curChar = number.charAt(0);
        int nDigit = 1;
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<number.length(); i++){
            if(Character.compare(curChar, number.charAt(i)) == 0){
                nDigit++;
            } else {
                builder.append(Integer.toString(nDigit));
                builder.append(Character.toString(curChar));
                curChar = number.charAt(i);
                nDigit = 1;
            }
        }
        builder.append(Integer.toString(nDigit));
        builder.append(Character.toString(curChar));
        return builder.toString();
    }
}
