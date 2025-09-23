import java.util.Stack;
import java.util.Set;
import java.util.HashSet;

public class HTMLValidator {
    // Set of valid HTML tags that we support for validation
    private static final Set<String> VALID_TAGS = Set.of("html", "body", "div", "p", "b", "i", "h1", "h2", "br", "img");
    
    /**
     * Validates if the given HTML string is correctly formatted
     * @param html the HTML string to validate
     * @return true if HTML is valid, false otherwise
     */
    public boolean validateHTML(String html) {
        // Handle null input
        if (html == null) return false;
        
        // Empty string is considered valid HTML
        if (html.trim().isEmpty()) return true;
        
        // Stack to keep track of opening tags for proper nesting validation
        Stack<String> stack = new Stack<>();
        int i = 0; // Current position in the HTML string
        int n = html.length(); // Total length of HTML string
        
        // Iterate through the entire HTML string
        while (i < n) {
            // Check if we found the start of a tag
            if (html.charAt(i) == '<') {
                int j = i + 1; // Position after '<'
                if (j >= n) return false; // If '<' is at the end, invalid HTML
                
                // Check if this is a closing tag (starts with '</')
                boolean isClosingTag = (html.charAt(j) == '/');
                if (isClosingTag) j++; // Move past the '/'
                
                // Extract the tag name by reading letters/digits until we hit non-tag characters
                StringBuilder tagName = new StringBuilder();
                while (j < n && Character.isLetterOrDigit(html.charAt(j))) {
                    tagName.append(html.charAt(j));
                    j++;
                }
                
                String tag = tagName.toString().toLowerCase(); // Convert to lowercase for case-insensitive comparison
                
                // Skip to the end of the tag and check if it's self-closing
                boolean isSelfClosing = false;
                while (j < n && html.charAt(j) != '>') {
                    if (html.charAt(j) == '/') {
                        isSelfClosing = true; // Found '/' before '>' indicates self-closing tag
                    }
                    j++;
                }
                
                // If we reached the end without finding '>', it's invalid HTML
                if (j >= n) return false;
                
                // Skip empty tags (can occur in comments or malformed HTML)
                if (tag.isEmpty()) {
                    i = j + 1; // Move to position after '>'
                    continue; // Continue to next character
                }
                
                // Check if the tag is in our list of valid tags
                if (!VALID_TAGS.contains(tag)) {
                    return false; // Invalid tag name found
                }
                
                if (isClosingTag) {
                    // Handle closing tag: must match the most recent opening tag
                    if (stack.isEmpty() || !stack.pop().equals(tag)) {
                        return false; // Stack empty or tags don't match
                    }
                } else if (!isSelfClosing) {
                    // Handle opening tag (not self-closing): push to stack
                    stack.push(tag);
                }
                // Self-closing tags are not added to stack (they don't need closing)
                
                i = j + 1; // Move to position after the closing '>'
            } else {
                // Current character is not part of a tag, move to next character
                i++;
            }
        }
        
        // If stack is empty, all opening tags had matching closing tags
        // If stack is not empty, some tags were not properly closed
        return stack.isEmpty();
    }
}