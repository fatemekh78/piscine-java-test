import java.util.*;

public class BreakdownURL {
    public Map<String, String> parseURL(String url) {
        Map<String, String> components = new LinkedHashMap<>();
        
        // Extract protocol
        int protocolEnd = url.indexOf("://");
        if (protocolEnd != -1) {
            components.put("protocol", url.substring(0, protocolEnd));
            url = url.substring(protocolEnd + 3); // Remove protocol part
        }
        
        // Extract domain and possibly port
        int pathStart = url.indexOf('/');
        int queryStart = url.indexOf('?');
        
        String domainPort;
        if (pathStart != -1) {
            domainPort = url.substring(0, pathStart);
        } else if (queryStart != -1) {
            domainPort = url.substring(0, queryStart);
        } else {
            domainPort = url;
        }
        
        // Split domain and port
        int portSeparator = domainPort.indexOf(':');
        if (portSeparator != -1) {
            components.put("domain", domainPort.substring(0, portSeparator));
            components.put("port", domainPort.substring(portSeparator + 1));
        } else {
            components.put("domain", domainPort);
        }
        
        // Extract path (only if present)
        if (pathStart != -1) {
            int pathEnd = (queryStart != -1) ? queryStart : url.length();
            components.put("path", url.substring(pathStart, pathEnd));
        }
        
        // Extract query
        if (queryStart != -1) {
            components.put("query", url.substring(queryStart + 1));
        }
        
        return components;
    }
}