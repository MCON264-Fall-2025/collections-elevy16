package exercises;

import edu.touro.mcon264.apps.collections.ArrayCollection;
import edu.touro.mcon264.apps.collections.BagInterface;

/**
 * A BasicBag is a simple bag implementation backed by the
 * ArrayCollection data structure. It allows duplicates and provides
 * operations for grabbing a random element, counting occurrences,
 * and removing all occurrences of a target value.
 *
 * @param <T> the type of elements stored in the bag
 */
public class BasicBag<T> extends ArrayCollection<T> implements BagInterface<T> {

    /**
     * Returns a randomly selected element from the bag without removing it.
     * If the bag is empty, this method returns null.
     *
     * @return a randomly chosen element from the bag, or null if the bag is empty
     */
    @Override
    public T grab() {
        if (numElements == 0) {
            return null;
        }

        int index = (int) (Math.random() * numElements);
        T result = elements[index];

        // shift everything after index one step to the left
        for (int i = index + 1; i < numElements; i++) {
            elements[i - 1] = elements[i];
        }

        // clean last slot and update size
        elements[numElements - 1]  = null;
        numElements--;

        return result;
    }

    /**
     * Counts how many times the target element appears in the bag.
     * This method compares elements using equals().
     *
     * @param target the element to count occurrences of
     * @return the number of occurrences of target in the bag
     */
    @Override
    public int count(T target) {
        int count = 0;
        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Removes all occurrences of the specified target element from the bag.
     * The underlying array is compacted so that all remaining elements are in
     * the front of the array. Any leftover array slots are set to null.
     *
     * @param target the element to remove from the bag
     * @return the number of elements removed
     */
    @Override
    public int removeAll(T target) {
        int writeIndex = 0;
        int removed = 0;

        for (int i = 0; i < numElements; i++) {
            if (elements[i].equals(target)) {
                // skip this one
                removed++;
            } else {
                elements[writeIndex] = elements[i];
                writeIndex++;
            }
        }

        // Null out the leftover slots for cleanliness
        for (int i = writeIndex; i < numElements; i++) {
            elements[i] = null;
        }

        numElements = writeIndex;
        return removed;
    }

    /**
     * Removes all elements from the bag. After this operation, the bag is empty
     * and its size is zero. All previously occupied array slots are set to null.
     */
    @Override
    public void clear() {
        // set all used slots to null
        for (int i = 0; i < numElements; i++) {
            elements[i] = null;
        }
        numElements = 0;
    }

// SOLID principle applied here:
// This design follows the Liskov Substitution Principle (LSP) because
// BasicBag extends ArrayCollection and can be used anywhere a Collection is expected.
// It also follows the Open/Closed Principle by allowing behavior to be extended
// without modifying the original ArrayCollection implementation.


}
