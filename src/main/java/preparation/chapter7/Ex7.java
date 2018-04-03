package preparation.chapter7;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Ex7 {
    public static void main(String[] args) {
        printStringFromPhoneNumber(new Integer[]{0,1,2,3});
    }

    public static void printStringFromPhoneNumber(Integer[] numbers){
        Map<Integer, Character[]> dictionary = new HashMap<>();
        dictionary.put(0, new Character[] {'0'});
        dictionary.put(1, new Character[] {'1'});
        dictionary.put(2, new Character[] {'a','b','c'});
        dictionary.put(3, new Character[] {'d','e','f'});
        dictionary.put(4, new Character[] {'g','h','i'});
        dictionary.put(5, new Character[] {'j','k','l'});
        dictionary.put(6, new Character[] {'m','n','o'});
        dictionary.put(7, new Character[] {'p','q','r','s'});
        dictionary.put(8, new Character[] {'t','u','v'});
        dictionary.put(9, new Character[] {'w','x','y','z'});
        String[] mapping = new String[]{
                "0"
                ,"1"
                ,"abc"
                ,"def"
                ,"ghi"
                ,"jkl"
                ,"mno"
                ,"pqrs"
                ,"tuv"
                ,"wxyz"
        };
        char[] stack = new char[numbers.length];
        printStringFromPhoneNumber(numbers, mapping, stack, 0);
    }
    public static void printStringFromPhoneNumber(Integer[] numbers, String[] dictionary
            , char[] stack, Integer nextOrder){
        if(nextOrder ==  numbers.length){
            System.out.println(new String(stack));
        } else {
            String possibleCharacters = dictionary[numbers[nextOrder]];
            for (Character c : possibleCharacters.toCharArray()) {
                stack[nextOrder]=c;
                printStringFromPhoneNumber(numbers, dictionary, stack, nextOrder + 1);
            }
        }

    }

}
