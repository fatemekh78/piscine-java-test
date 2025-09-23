/**
 * Abstract base class for calculating factorial of a number.
 * Provides the template for factorial calculation that child classes must implement.
 */
public abstract class Factorial {
    
    /**
     * Calculates the factorial of a given number.
     * @param n the number to calculate factorial for (must be non-negative)
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public abstract long calculate(int n);
    
    /**
     * Helper method to validate input (can be used by child classes)
     */
    protected void validateInput(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers: " + n);
        }
    }
}