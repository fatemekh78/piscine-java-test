/**
 * Calculates factorial using an iterative approach.
 * This implementation uses a loop to multiply numbers from 1 to n.
 * More memory-efficient for large numbers as it doesn't use call stack.
 */
public class IterativeFactorial extends Factorial {
    
    @Override
    public long calculate(int n) {
        validateInput(n); // Validate that n is non-negative
        
        // Factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        
        long result = 1;
        
        // Multiply numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        
        return result;
    }
}