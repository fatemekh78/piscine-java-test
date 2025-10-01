public class AnagramChecker {
    public boolean isAnagram(String str1, String str2) {
        // Normalize case only (do NOT remove spaces) so spaces are considered characters
        String cleanStr1 = str1.toLowerCase();
        String cleanStr2 = str2.toLowerCase();

        // Quick length check (including spaces and special characters)
        if (cleanStr1.length() != cleanStr2.length()) {
            return false;
        }

        // Use a wider counting array to include spaces and common ASCII characters
        int[] charCount = new int[256];

        // Count characters in first string
        for (char c : cleanStr1.toCharArray()) {
            charCount[(int) c]++;
        }

        // Subtract counts for second string
        for (char c : cleanStr2.toCharArray()) {
            charCount[(int) c]--;
        }
        
        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}
