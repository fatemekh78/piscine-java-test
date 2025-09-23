/**
 * Calculates factorial using a recursive approach.
 * This implementation uses the mathematical definition: 
 * n! = n × (n-1)! with base case 0! = 1
 * More intuitive but may cause stack overflow for very large numbers.
 */
public class RecursiveFactorial extends Factorial {
    
    @Override
    public long calculate(int n) {
        validateInput(n); // Validate that n is non-negative
        
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        
        // Recursive case: n! = n × (n-1)!
        return n * calculate(n - 1);
    }
}