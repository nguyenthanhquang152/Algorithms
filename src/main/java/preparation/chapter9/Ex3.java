package preparation.chapter9;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Ex3 {
    public static void main(String[] args) {
        String input = "[,}],[,(,),{,},],]";
        String[] elements = input.split(",");
        System.out.println(isWellformed(elements));
    }

    private static boolean isWellformed(String[] elements) {
        Deque<String> stack = new LinkedList<>();
        for(String element : elements){
            if("{[(".contains(element)) stack.push(element);
            else {
                if (stack.isEmpty()) return false;
                if (
                        (stack.peek().equals("{") && !element.equals("}"))
                                || (stack.peek().equals("[") && !element.equals("]"))
                                || (stack.peek().equals("(") && !element.equals(")"))
                        ) return false;
                stack.pop();
            }

        }
        return stack.isEmpty();
    }
}
