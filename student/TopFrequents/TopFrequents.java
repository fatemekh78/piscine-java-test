import java.util.*;

public class TopFrequents {
    public List<Integer> findTopKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies - simpler approach
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }
        
        // Step 2: Put all numbers in a list
        List<Integer> numbers = new ArrayList<>(frequency.keySet());
        
        // Step 3: Sort with custom criteria
        Collections.sort(numbers, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int freqA = frequency.get(a);
                int freqB = frequency.get(b);
                
                // First compare by frequency (descending)
                if (freqA != freqB) {
                    return freqB - freqA;
                }
                
                // If frequencies are equal, find which appears first in original array
                for (int num : nums) {
                    if (num == a) return -1;  // a comes first
                    if (num == b) return 1;   // b comes first
                }
                return 0;
            }
        });
        
        // Step 4: Return first k elements
        if (k > numbers.size()) {
            return numbers; // Return all if k is too large
        }
        return numbers.subList(0, k);
    }
}