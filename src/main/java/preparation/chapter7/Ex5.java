package preparation.chapter7;

public class Ex5 {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama.";
        System.out.println(hasPalindromicity(input));
    }

    private static boolean hasPalindromicity(String input) {
        int left = 0;
        int right = input.length() - 1;
        while(left <= right){
            while(!Character.isLetterOrDigit(input.charAt(left))){
                left++;
            }
            while(!Character.isLetterOrDigit(input.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(input.charAt(left)) != Character.toLowerCase(input.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
