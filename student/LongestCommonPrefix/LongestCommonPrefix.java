public class LongestCommonPrefix {
    public String findLongestCommonPrefix(String[] strs) {
        // If array is empty, return empty string
        if (strs.length == 0) {
            return "";
        }
        
        // Take the first word as starting point
        String prefix = strs[0];
        
        // Compare with each subsequent word
        for (int i = 1; i < strs.length; i++) {
            String currentWord = strs[i];
            
            // Keep shortening the prefix until it matches the beginning of current word
            while (currentWord.indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, return immediately
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}