package preparation.chapter13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex6 {
    public static class WordPair{
        Integer index1;
        Integer index2;
        String word;

        public WordPair(String word, int index1, int index2) {
            this.word = word;
            this.index1 = index1;
            this.index2 = index2;
        }

        @Override
        public String toString() {
            return "WordPair{" +
                    "index1=" + index1 +
                    ", index2=" + index2 +
                    ", word='" + word + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("All", "work", "and", "no", "play",
                "makes", "for", "no", "work", "no", "fun", "and", "no", "results");
        WordPair result = new WordPair("", -1, -1);
        Map<String, WordPair> pairs = new HashMap<>();
        for(int i=0; i<words.size(); i++){
            String word = words.get(i);
            if(!pairs.containsKey(word)) pairs.put(word, new WordPair(word, -1, i));
            else {
                pairs.put(word, new WordPair(word, pairs.get(word).index2, i));
                if(result.word.isEmpty()
                        || (pairs.get(word).index2 - pairs.get(word).index1 < result.index2 - result.index1)) {
                    result = pairs.get(word);
                }
            }
        }
        if(result.word.isEmpty()) System.out.println("Input has distinct words.");
        else {
            System.out.println(result);
        }
    }
}
