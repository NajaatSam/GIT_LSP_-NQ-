package org.howard.edu.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a set of integers.
 */
public class IntegerSet {
	// Store the set elements in an ArrayList
	private List<Integer> set = new ArrayList<>();

	// Default Constructor
	public IntegerSet() {
	}

	// Constructor if you want to pass in already initialized
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	/**
	 * Clears the internal representation of the set.
	 */
	public void clear() {
		set.clear();
	}

	/**
	 * Returns the length of the set.
	 * 
	 * @return The number of elements in the set.
	 */
	public int length() {
		return set.size();
	}

	/**
	 * Returns true if the two sets are equal, false otherwise. Two sets are equal
	 * if they contain all of the same values in ANY order.
	 * 
	 * @param o The object to compare with this set.
	 * @return True if the sets are equal, false otherwise.
	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof IntegerSet))
			return false;
		IntegerSet other = (IntegerSet) o;
		if (other.length() != this.length())
			return false;
		for (int i = 0; i < this.length(); i++) {
			if (!other.contains(this.set.get(i)))
				return false;
		}
		return true;
	}

	/**
	 * Returns true if the set contains the specified value, otherwise false.
	 * 
	 * @param value The value to check for in the set.
	 * @return True if the set contains the value, false otherwise.
	 */
	public boolean contains(int value) {
		return set.contains(value);
	}

	/**
	 * Returns the largest item in the set.
	 * 
	 * @return The largest item in the set.
	 * @throws IntegerSetException If the set is empty.
	 */
	public int largest() throws IntegerSetException {
		if (set.isEmpty())
			throw new IntegerSetException("Set is empty");
		int max = Integer.MIN_VALUE;
		for (int i : set) {
			if (i > max)
				max = i;
		}
		return max;
	}

	/**
	 * Returns the smallest item in the set.
	 * 
	 * @return The smallest item in the set.
	 * @throws IntegerSetException If the set is empty.
	 */
	public int smallest() throws IntegerSetException {
		if (set.isEmpty())
			throw new IntegerSetException("Set is empty");
		int min = Integer.MAX_VALUE;
		for (int i : set) {
			if (i < min)
				min = i;
		}
		return min;
	}

	/**
	 * Adds an item to the set if it is not already present.
	 * 
	 * @param item The item to add to the set.
	 */
	public void add(int item) {
		if (!set.contains(item))
			set.add(item);
	}

	/**
	 * Removes an item from the set if it is present.
	 * 
	 * @param item The item to remove from the set.
	 */
	public void remove(int item) {
		set.remove((Integer) item);
	}

	/**
	 * Performs the union operation between this set and another set.
	 * 
	 * @param intSetb The other set to perform the union with.
	 */
	public void union(IntegerSet intSetb) {
		for (int i : intSetb.set) {
			if (!set.contains(i))
				set.add(i);
		}
	}

	/**
	 * Performs the intersection operation between this set and another set.
	 * 
	 * @param intSetb The other set to perform the intersection with.
	 */
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}

	/**
	 * Performs the set difference operation between this set and another set.
	 * 
	 * @param intSetb The other set to perform the set difference with.
	 */
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}

	/**
	 * Computes the complement of this set.
	 * 
	 * @param intSetb The set from which the complement is computed.
	 */
	public void complement(IntegerSet intSetb) {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		for (int i : set) {
			if (i < max) max = i - 1;
			if (i > min) min = i + 1;
		}
		List<Integer> complementSet = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			if (!set.contains(i))
				complementSet.add(i);
		}
		set = complementSet;
	}

	/**
	 * Returns true if the set is empty, otherwise false.
	 * 
	 * @return True if the set is empty, otherwise false.
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Returns the string representation of the set.
	 * 
	 * @return The string representation of the set.
	 */
	public String toString() {
		return set.toString();
	}

	/**
	 * Represents an exception specific to IntegerSet operations.
	 */
	public class IntegerSetException extends RuntimeException {
		public IntegerSetException(String message) {
			super(message);
		}
	}
}
