import java.util.*;

public class DistinctSubstringLength {
    public int maxLength(String s) {
        if (s == null) return 0;
        if (s.isEmpty()) {
            return 0;
        }
        
        int longest = 0;
        Set<Character> seen = new HashSet<>();
        int start = 0;  // Start of current window
        
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            
            // If we've seen this character before
            if (seen.contains(current)) {
                // Move start forward until we remove the duplicate
                while (s.charAt(start) != current) {
                    seen.remove(s.charAt(start));
                    start++;
                }
                // Remove the duplicate itself
                seen.remove(s.charAt(start));
                start++;
            }
            
            // Add current character to our set
            seen.add(current);
            
            // Check if this is the longest substring we've seen
            int currentLength = end - start + 1;
            if (currentLength > longest) {
                longest = currentLength;
            }
        }
        
        return longest;
    }
}
