import java.util.List;

public class ConfigProtector {
    
    public String hideSensitiveData(String configFile, List<String> sensitiveKeys) {
        if (configFile == null || configFile.isEmpty()) {
            return configFile;
        }
        
        // Split the config file into lines, preserving empty lines
        String[] lines = configFile.split("\\r?\\n", -1);
        StringBuilder result = new StringBuilder();
        
        // Process each line individually
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String processedLine = processLine(line, sensitiveKeys);
            result.append(processedLine);
            
            // Add newline except for the last line
            if (i < lines.length - 1) {
                result.append("\n");
            }
        }
        
        return result.toString();
    }
    
    private String processLine(String line, List<String> sensitiveKeys) {
        if (line == null || line.trim().isEmpty()) {
            return line; // Return empty lines as-is
        }
        
        // Check if this line contains any sensitive key (CASE-SENSITIVE)
        for (String key : sensitiveKeys) {
            // Use CASE-SENSITIVE comparison - exact match required
            if (line.startsWith(key + "=")) {
                // Split on the first equals sign only
                int equalsIndex = line.indexOf('=');
                if (equalsIndex != -1 && equalsIndex < line.length() - 1) {
                    String keyPart = line.substring(0, equalsIndex + 1); // Includes "="
                    String valuePart = line.substring(equalsIndex + 1);
                    
                    // Mask the value with asterisks of the same length
                    String maskedValue = "*".repeat(valuePart.length());
                    return keyPart + maskedValue;
                }
            }
        }
        
        // Return the original line if no sensitive key found
        return line;
    }
}