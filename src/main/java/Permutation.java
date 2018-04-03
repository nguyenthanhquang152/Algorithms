import java.util.Stack;

public class Permutation {

    public static void main(String[] args) {
//        perform("ABCD",0,3);
        performWithLength("ABCD",3);
    }
    
    public static void perform(String input, int start, int end) {
        if(start == end) System.out.println(input);
        else {
            for(int i=start; i<=end; i++) {
                String newPermutation = swap(input, start, i);
                perform(newPermutation, start+1, end);
            }
        }
    }
    
    public static String swap(String input, int start, int end) {
        char[] inputArray = input.toCharArray();
        char temp = inputArray[start];
        inputArray[start] = inputArray[end];
        inputArray[end] = temp;
        return String.valueOf(inputArray);
    }
    
    public static void performWithLength(String input, int length) {
        Stack<Integer> usedIndex = new Stack<>();
        performHelper(input,length,usedIndex);
    }
    
    public static void performHelper(String input, int length, Stack<Integer> usedIndex){
        if(length == usedIndex.size()) System.out.println(usedIndex.stream().map(value -> String.valueOf(input.charAt(value)))
                .reduce("", (a, b) -> a + b));
        else {
            for(int i=0; i<input.length();i++) {
                if(!usedIndex.contains(i)) {
                    usedIndex.push(i);
                    performHelper(input, length, usedIndex);
                    usedIndex.pop();
                }
            }
        }
    }

}
