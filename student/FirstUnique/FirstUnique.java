import java.util.*;

public class FirstUnique {
    public char findFirstUnique(String s) {
        if (s == null) return '_';

        // Count frequency of each character
        Map<Character, Integer> frequency = new HashMap<>();
        
        // First pass: count occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        // Second pass: find first character with count = 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequency.get(c) == 1) {
                return c;
            }
        }
        
        // If no unique character found
        return '_';
    }
}