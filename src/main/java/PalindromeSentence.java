
public class PalindromeSentence {

    public static void main(String[] args) {
        System.out.println(perform("A man, a plan, a canal, Panama."));
        System.out.println(perform("Able was I, ere I saw Elba!"));
        System.out.println(perform("Ray a Ray"));
    }
    
    public static boolean perform(String sentence) {
        int left = 0;
        int right = sentence.length() - 1;
        while(left < right) {
            while((left < right) && !Character.isLetterOrDigit(sentence.charAt(left))) {
                left++;
            }
            
            while((left < right) && !Character.isLetterOrDigit(sentence.charAt(right))) {
                right--;
            }
            
            if(Character.toLowerCase(sentence.charAt(left++)) 
                    != Character.toLowerCase(sentence.charAt(right--))) return false;
        }
        return true;
    }

}
