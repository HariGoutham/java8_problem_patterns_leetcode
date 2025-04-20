package Leetcode75.string;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestNonRepeatingSubstringInAString {
    public static void main(String[] args) {
        longestNonRepeatingSubstringInAStringBruteForce("Ramireddy Hari Goutham Reddy");
        //ToDo using sliding window technique
    }

    private static void longestNonRepeatingSubstringInAStringBruteForce(String s) {
        int len  = s.length();
        boolean found = false;
        for(int i=0; i < len; i++){
            for(int j=0,k=len-i; j<=i; j++,k++){
                if(hasNoDuplicates(s.substring(j,k))){
                    System.out.println(s.substring(j,k));
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
    }


    private static boolean hasNoDuplicates(String s){
        Map<Character, Long> duplicates = s.chars()
                .filter(c -> c!=' ')
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return duplicates.isEmpty();
    }
}
