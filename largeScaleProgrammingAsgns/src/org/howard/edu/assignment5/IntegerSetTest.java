package org.howard.edu.assignment5;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class IntegerSetTest {

    private IntegerSet set;

    @Before
    public void setUp() {
        set = new IntegerSet();
    }

    @Test
    public void testClear() {
        set.add(1);
        set.clear();
        assertTrue(set.isEmpty());
    }

    @Test
    public void testLength() {
        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    public void testEquals() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(1);
        otherSet.add(2);
        set.add(2);
        set.add(1);
        assertTrue(set.equals(otherSet));
    }

    @Test
    public void testContains() {
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    public void testLargest() {
        set.add(1);
        set.add(2);
        assertEquals(2, set.largest());
    }

    @Test(expected = IntegerSet.IntegerSetException.class)
    public void testLargestEmptySet() {
        set.largest();
    }

    @Test
    public void testSmallest() {
        set.add(1);
        set.add(2);
        assertEquals(1, set.smallest());
    }

    @Test(expected = IntegerSet.IntegerSetException.class)
    public void testSmallestEmptySet() {
        set.smallest();
    }

    @Test
    public void testAdd() {
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    public void testRemove() {
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1));
    }

    @Test
    public void testUnion() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(1);
        otherSet.add(2);
        set.add(1);
        set.union(otherSet);
        assertTrue(set.contains(2));
    }

    @Test
    public void testIntersect() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(1);
        otherSet.add(2);
        set.add(1);
        set.add(2);
        set.intersect(otherSet);
        assertTrue(set.contains(1) && set.contains(2));
    }

    @Test
    public void testDiff() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(1);
        otherSet.add(2);
        set.add(1);
        set.add(2);
        set.diff(otherSet);
        assertFalse(set.contains(1) || set.contains(2));
    }

    @Test
    public void testComplement() {
        IntegerSet otherSet = new IntegerSet();
        otherSet.add(1);
        otherSet.add(2);
        set.add(1);
        set.add(2);
        set.complement(otherSet);
        assertFalse(set.contains(1) && set.contains(2));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(set.isEmpty());
    }

    @Test
    public void testToString() {
        set.add(1);
        set.add(2);
        assertEquals("[1, 2]", set.toString());
    }
}
