public class NextPrime {
    /**
     * Finds the next prime number greater than the given integer.
     * A prime number is a natural number greater than 1 that has no positive divisors 
     * other than 1 and itself.
     * 
     * @param n the integer to start searching from (inclusive search starts from n+1)
     * @return the next prime number greater than n, or null if input is null
     */
    public static Integer nextPrime(Integer n) {
        // Handle null input
        if (n == null) {
            return null;
        }
        
        // Special case: if n is less than 2, the next prime is 2
        if (n < 2) {
            return 2;
        }
        
        // Start searching from the number after n
        int candidate = n + 1;
        
        // Continue searching until we find a prime number
        while (true) {
            if (isPrime(candidate)) {
                return candidate;
            }
            candidate++;
        }
    }
    
    /**
     * Determines whether a given number is prime.
     * Optimized by checking divisibility only up to the square root of the number
     * and skipping even numbers after checking 2.
     * 
     * @param num the number to check for primality
     * @return true if the number is prime, false otherwise
     */
    private static boolean isPrime(int num) {
        // Numbers less than 2 are not prime by definition
        if (num < 2) {
            return false;
        }
        
        // 2 is the only even prime number
        if (num == 2) {
            return true;
        }
        
        // Even numbers greater than 2 are composite (not prime)
        if (num % 2 == 0) {
            return false;
        }
        
        // Check odd divisors from 3 up to the square root of num
        // We can stop at sqrt(num) because if num has a divisor greater than sqrt(num),
        // it must also have a corresponding divisor less than sqrt(num)
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false; // Found a divisor, so not prime
            }
        }
        
        // No divisors found, so the number is prime
        return true;
    }
}