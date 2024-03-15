package org.howard.edu.lsp.midterm.question2;

/**
 * Class to test the IntegerRange class.
 */
public class RangeTester {
    public static void main(String[] args) {
        // Create IntegerRange objects for testing
        IntegerRange range1 = new IntegerRange(1, 5);
        IntegerRange range2 = new IntegerRange(3, 7);
        IntegerRange range3 = new IntegerRange(6, 10);

        // Test contains method
        System.out.println("Range 1 contains 3: " + range1.contains(3));
        System.out.println("Range 1 contains 7: " + range1.contains(7));

        // Test overlaps method
        System.out.println("Range 1 overlaps with Range 2: " + range1.overlaps(range2));
        System.out.println("Range 1 overlaps with Range 3: " + range1.overlaps(range3));

        // Test size method
        System.out.println("Size of Range 1: " + range1.size());
    }
}
