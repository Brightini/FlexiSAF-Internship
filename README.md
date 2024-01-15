# ElementCounter

## Overview

The ElementCounter is a Java class designed to provide a generic method for counting elements in a collection based on a specific property. This can be particularly useful for scenarios where you need to count elements that satisfy certain criteria, such as odd integers, prime numbers, or palindromes.

## How to Use

### Using the `countElementsWithProperty` Method

The main functionality is encapsulated in the `countElementsWithProperty` method. It takes a collection of elements and a `PropertyChecker` interface, allowing you to define your own criteria for counting elements.

#### Signature

```java
public static <T> int countElementsWithProperty(Collection<T> elements, PropertyChecker<T> propertyChecker)
```

Parameters

- elements: A collection of elements of any type.
- propertyChecker: An interface that checks a specific property for each element.

Returns

- The total count of elements that satisfy the specified property.

### Examples

Counting Odd Integers

```java
Collection<Integer> integerCollection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
int oddIntegerCount = countElementsWithProperty(integerCollection, new OddIntegerPropertyChecker());
System.out.println("Count of odd integers: " + oddIntegerCount);
```

Counting **Prime** Numbers

```java
Collection<Integer> integerCollection = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
int primeNumberCount = countElementsWithProperty(integerCollection, new PrimeNumberPropertyChecker());
System.out.println("Count of prime numbers: " + primeNumberCount);
```

Counting Palindromes

```java
Collection<String> stringCollection = List.of("level", "java", "radar", "programming");
int palindromeCount = countElementsWithProperty(stringCollection, new PalindromePropertyChecker());
System.out.println("Count of palindromes: " + palindromeCount);
```

### Property Checkers

The code includes predefined property checkers for odd integers, prime numbers, and palindromes. You can use these as examples or create your own by implementing the PropertyChecker interface.

Interfaces

- `PropertyChecker<T>`

```java
public interface PropertyChecker<T> {
    boolean checkProperty(T element);
}
```

## Testing

The main method provides a simple testing scenario. You can run the main method to see the counts for different types of properties.

## Contributors

Bright Okon
