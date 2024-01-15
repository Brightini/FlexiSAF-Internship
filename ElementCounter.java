import java.util.Collection;
import java.util.List;


public class ElementCounter {
    
    /**
     * A generic method to count elements in a collection based on a property
     *
     * @param elements          a collection of elements of any type
     * @param propertyChecker   an interface that checks a specific property for each element.
     * @return                  the total count of elements that satisfy the specified property.
     */
    public static <T> int countElementsWithProperty(Collection<T> elements, PropertyChecker<T> propertyChecker) {
        int count = 0;
        
        for (T element : elements) {
            if (propertyChecker.checkProperty(element)) {
                count++;
            }
        }
        
        return count;
    }

    // Property checker for odd integers
    public static class OddIntegerPropertyChecker implements PropertyChecker<Integer> {
        @Override
        public boolean checkProperty(Integer element) {
            return element % 2 != 0;
        }
    }

    // Property checker for prime numbers
    public static class PrimeNumberPropertyChecker implements PropertyChecker<Integer> {
        @Override
        public boolean checkProperty(Integer element) {
            if (element < 2) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(element); i++) {
                if (element % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    // Property checker for palindromes (strings)
    public static class PalindromePropertyChecker implements PropertyChecker<String> {
        @Override
        public boolean checkProperty(String element) {
            String reversed = new StringBuilder(element).reverse().toString();
            return element.equals(reversed);
        }
    }

    // A generic interface for property checker
    public interface PropertyChecker<T> {
        boolean checkProperty(T element);
    }

    /**
     * The main method for testing
     *
     * @param args  represents character strings
     */
    public static void main(String[] args) {
        // A collection of integers
        Collection<Integer> integerCollection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Count of odd integers
        int oddIntegerCount = countElementsWithProperty(integerCollection, new OddIntegerPropertyChecker());
        System.out.println("Count of odd integers: " + oddIntegerCount);

        // Count of prime numbers
        int primeNumberCount = countElementsWithProperty(integerCollection, new PrimeNumberPropertyChecker());
        System.out.println("Count of prime numbers: " + primeNumberCount);

        // A collection of strings
        Collection<String> stringCollection = List.of("level", "java", "radar", "programming");

        // Count of palindromes
        int palindromeCount = countElementsWithProperty(stringCollection, new PalindromePropertyChecker());
        System.out.println("Count of palindromes: " + palindromeCount);
    }
}
