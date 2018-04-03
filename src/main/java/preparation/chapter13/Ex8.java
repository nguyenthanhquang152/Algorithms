package preparation.chapter13;

import java.util.*;

public class Ex8 {
    public static void main(String[] args) {
        List<String> paragraph = Arrays.asList("apple", "banana", "apple", "apple", "dog", "cat", "apple",
                "dog", "banana", "apple", "cat", "dog");
        List<String> keywords = Arrays.asList("banana", "cat", "dog");

        System.out.println(perform(paragraph, keywords));
    }

    public static Ex7.StartEndIndices perform(List<String> paragraph, List<String> keywords){
        Map<String, Integer> keywordToInx = new HashMap<>();
        List<Integer> lastOccurences = new ArrayList<>(keywords.size());
        List<Integer> shortestSubarrayLength = new ArrayList<>(keywords.size());
        for(int i = 0; i < keywords.size(); i++){
            keywordToInx.put(keywords.get(i), i);
            shortestSubarrayLength.add(Integer.MAX_VALUE);
            lastOccurences.add(-1);
        }
        int shortestDistanceSofar = Integer.MAX_VALUE;
        Ex7.StartEndIndices result = new Ex7.StartEndIndices(-1, -1);

        for(int i = 0; i < paragraph.size(); i++){
            Integer keywordIdx = keywordToInx.get(paragraph.get(i));
            if(keywordIdx != null){
                if(keywordIdx == 0){
                    shortestSubarrayLength.set(0, 1);
                } else if(shortestSubarrayLength.get(keywordIdx - 1) != Integer.MAX_VALUE){
                    int distanceToPreviousKeyword = i - lastOccurences.get(keywordIdx - 1);
                    shortestSubarrayLength.set(keywordIdx
                            , distanceToPreviousKeyword + shortestSubarrayLength.get(keywordIdx - 1));
                }
                lastOccurences.set(keywordIdx, i);
                if(keywordIdx == keywords.size() - 1
                        && shortestSubarrayLength.get(keywordIdx) < shortestDistanceSofar){
                    result.start = i - shortestSubarrayLength.get(keywordIdx) + 1;
                    result.end = i;
                    shortestDistanceSofar = shortestSubarrayLength.get(keywordIdx);
                }
            }
        }
        return result;
    }
}
