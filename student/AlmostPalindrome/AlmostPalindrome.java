public class AlmostPalindrome {
    public static boolean isAlmostPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Use case-insensitive comparison
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                // Try skipping the left character OR the right character
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        
        return false; // Already a palindrome
    }
    
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            // Use case-insensitive comparison here too
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}