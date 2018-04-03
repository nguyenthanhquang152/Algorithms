package preparation.chapter7;

public class Ex6 {
    public static void main(String[] args) {
        String sentence = "Alice likes Bob";
        System.out.println(reverseWords(sentence));
        reverseWords(sentence.toCharArray());
    }

    public static void reverseWords(char[] sentence){
        // reverse full sentence
        reverseSequence(sentence, 0, sentence.length);

        int startIndex = 0;
        // restore each reversed word
        for(int i=0; i<sentence.length; i++){
            if(Character.isWhitespace(sentence[i])){
                reverseSequence(sentence, startIndex, i);
                startIndex = i + 1;
            }
        }
        reverseSequence(sentence, startIndex, sentence.length);
        System.out.println(sentence);
    }

    private static void reverseSequence(char[] sentence, int startIndex, int endIndex){
        while(startIndex <= endIndex - 1){
            char temp = sentence[startIndex];
            sentence[startIndex] = sentence[endIndex - 1];
            sentence[endIndex - 1] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static String reverseWords(String sentence){
        String[] words = sentence.split(" ");
        StringBuilder buffer = new StringBuilder();
        String[] reverseWords = new String[words.length];
        for(int i=0; i<words.length; i++){
            reverseWords[i] = new StringBuilder(words[i]).reverse().toString();
        }
        return buffer.append(String.join(" ", reverseWords)).reverse().toString();
    }
}
