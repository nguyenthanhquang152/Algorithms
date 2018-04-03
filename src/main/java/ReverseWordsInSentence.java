
public class ReverseWordsInSentence {

    public static void main(String[] args) {
        char[] input = "ram is costly".toCharArray();
        perform(input);
        System.out.println(input);
    }
    
    public static void perform(char[] sentence) {
        reverse(sentence, 0, sentence.length);
        
        int start = 0;
        int end = -1;
        while((end = find(sentence, start, ' ')) != -1) {
            reverse(sentence, start, end);
            start = end + 1;
        }
        reverse(sentence, start, sentence.length);
    }
    
    public static void reverse(char[] sentence, int start, int end) {
        int left = start;
        int right = end-1;
        while(left < right) {
            char temp = sentence[left];
            sentence[left] = sentence[right];
            sentence[right] = temp;
            left++;
            right--;
        }
    }
    
    public static int find(char[] sentence, int start, char c) {
        for(int i=start; i<sentence.length; i++) {
            if(sentence[i] ==  c) return i;
        }
        return -1;
    }

}
