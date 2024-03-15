package org.howard.edu.lsp.midterm.question2;

/**
 * Represents a range of integers.
 */
public class IntegerRange implements Range {
    private final int lowerBound;
    private final int upperBound;

    /**
     * Constructs an IntegerRange with specified lower and upper bounds.
     *
     * @param lowerBound The lower bound of the range (inclusive).
     * @param upperBound The upper bound of the range (inclusive).
     */
    public IntegerRange(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean contains(int value) {
        return value >= lowerBound && value <= upperBound;
    }

    @Override
    public boolean overlaps(Range other) {
        int otherLowerBound = Integer.MIN_VALUE;
        int otherUpperBound = Integer.MAX_VALUE;
        
        // Determine the lower and upper bounds of the other range
        if (other instanceof IntegerRange) {
            IntegerRange otherRange = (IntegerRange) other;
            otherLowerBound = otherRange.getLowerBound();
            otherUpperBound = otherRange.getUpperBound();
        }
        
        // Check for overlap between the ranges
        return lowerBound <= otherUpperBound && upperBound >= otherLowerBound;
    }

    @Override
    public int size() {
        return upperBound - lowerBound + 1;
    }

    /**
     * Gets the lower bound of the range.
     *
     * @return The lower bound.
     */
    public int getLowerBound() {
        return lowerBound;
    }

    /**
     * Gets the upper bound of the range.
     *
     * @return The upper bound.
     */
    public int getUpperBound() {
        return upperBound;
    }
}
