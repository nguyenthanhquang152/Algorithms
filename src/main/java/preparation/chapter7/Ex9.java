package preparation.chapter7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ex9 {
    public static void main(String[] args) {
        String romanNumber = "LIX";
        Map<Character, Integer> dictionary = new HashMap<>();
        dictionary.put('I',1);
        dictionary.put('V',5);
        dictionary.put('X',10);
        dictionary.put('L',50);
        dictionary.put('C',100);
        dictionary.put('D',500);
        dictionary.put('M',1000);
        Map<Character, Character> exceptions = new HashMap<>();
        exceptions.put('V', 'I');
        exceptions.put('X', 'I');
        exceptions.put('L', 'X');
        exceptions.put('C', 'X');
        exceptions.put('D', 'C');
        exceptions.put('M', 'C');
        int result = dictionary.get(romanNumber.charAt(romanNumber.length() - 1));
        char lastCompared = romanNumber.charAt(romanNumber.length() - 1);
        boolean sign = false;
        for(int i=romanNumber.length() - 2; i>=0; i--){
            if(dictionary.get(lastCompared) > dictionary.get(romanNumber.charAt(i))){
                sign = true;
                if(exceptions.get(lastCompared) != null && exceptions.get(lastCompared) == romanNumber.charAt(i))
                    result -= dictionary.get(romanNumber.charAt(i));
                else {
                    System.out.println("Invalid roman number");
                    return;
                }
            } else if(dictionary.get(lastCompared) == dictionary.get(romanNumber.charAt(i))){
                if(sign){
                    result -= dictionary.get(romanNumber.charAt(i));
                } else {
                    result += dictionary.get(romanNumber.charAt(i));
                }
            } else {
                result += dictionary.get(romanNumber.charAt(i));
                lastCompared = romanNumber.charAt(i);
                sign = false;
            }
        }
        System.out.println(result);
//        IntStream.range(1, 4000).boxed().forEach(i -> System.out.print(iToR(i) + " "));
        System.out.println(iToR(944));
    }

    public static String iToR(int number){
        if(number < 1 || number > 3999) return "";
        StringBuilder builder = new StringBuilder();
        while(number > 0){
            if(number >= 1000) {
                number -= 1000;
                builder.append('M');
            } else if(number >= 900) {
                number -= 900;
                builder.append('C');
                builder.append('M');
            } else if(number >= 500) {
                number -= 500;
                builder.append('D');
            } else if(number >= 400) {
                number -= 400;
                builder.append('C');
                builder.append('D');
            } else if(number >= 100) {
                number -= 100;
                builder.append('C');
            } else if(number >= 90) {
                number -= 90;
                builder.append('X');
                builder.append('C');
            } else if(number >= 50) {
                number -= 50;
                builder.append('L');
            } else if(number >= 40) {
                number -= 40;
                builder.append('X');
                builder.append('L');
            } else if(number >= 10) {
                number -= 10;
                builder.append('X');
            } else if(number == 9) {
                number -= 9;
                builder.append('I');
                builder.append('X');
            } else if(number >= 5) {
                number -= 5;
                builder.append('V');
            } else if(number == 4) {
                number -= 4;
                builder.append('I');
                builder.append('V');
            } else if(number >= 1) {
                number -= 1;
                builder.append('I');
            }
        }
        return builder.toString();
    }
}
