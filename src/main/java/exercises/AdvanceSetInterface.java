package exercises;

import edu.touro.mcon264.apps.collections.CollectionInterface;

/**
 * Advance Set Interface
 * @param <T>
 */
public interface AdvanceSetInterface <T> extends CollectionInterface<T> {

    /**
     * Creates and returns a new set that contains all elements from
     * this set and the other set (no duplicates).
     *
     * @param other another set to combine with this one
     * @return a new set representing the union of the two sets
     */
    AdvanceSetInterface<T> union(AdvanceSetInterface<T> other);

    /**
     * Creates and returns a new set that contains only the elements
     * that appear in both this set and the other set.
     *
     * @param other another set to compare with
     * @return a new set representing the intersection of the two sets
     */
    AdvanceSetInterface<T> intersection(AdvanceSetInterface<T> other);

    /**
     * Creates and returns a new set that contains the elements that
     * are in this set but not in the other set.
     *
     * @param other another set whose elements should be removed from this set
     * @return a new set representing the difference between the sets
     */
    AdvanceSetInterface<T> difference(AdvanceSetInterface<T> other);

}
