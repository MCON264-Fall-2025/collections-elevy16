package exercises;

import edu.touro.mcon264.apps.collections.LinkedCollection;
import edu.touro.mcon264.support.LLNode;

/**
 * Extends LinkedCollection by adding three utility methods:
 * toString(), count(), and removeAll(). Uses the same linked list
 * structure with a head node and links between nodes.
 *
 * @param <T> the type of elements stored in this collection
 */
public class ExtendedLinkedCollection<T> extends LinkedCollection<T> {

    /**
     * Builds and returns a string version of the collection in the form
     * "[A, B, C]". Traverses the list from head to end.
     *
     * @return a string showing all elements in order
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        LLNode<T> current = head; // first node

        while (current != null) {
            sb.append(current.getInfo());   // add the element

            if (current.getLink() != null) {
                sb.append(", ");            // only add comma if not the last element
            }

            current = current.getLink();    // move to the next node
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Counts how many nodes in the list contain the target value.
     * Uses equals() to compare elements.
     *
     * @param target the value to count
     * @return the number of times target appears in the list
     */
    public int count(T target) {
        int counter = 0;  // counter to track matches
        LLNode<T> current = head; // start traversal at first node
        while (current != null) {
            if (current.getInfo().equals(target)) { // compare value of current node to target
                counter++; // if it matches, increase counter
            }
            current = current.getLink();  // move to next node
        }
        return counter;
    }

    /**
     * Removes every node whose value equals the target. Handles matches
     * at the head and inside the list. Updates numElements as nodes are removed.
     *
     * @param target the value to remove from the collection
     */
    public void removeAll(T target) {
        // remove matching nodes at the head
        while (head != null && head.getInfo().equals(target)) {
            head = head.getLink(); // move head forward
            numElements--;         // one element removed
        }

        // if the list is now empty, we're done
        if (head == null) {
            return;
        }

        // remove matches after the head
        LLNode<T> previous = head;
        LLNode<T> current = head.getLink();

        while (current != null) {
            if (current.getInfo().equals(target)) {
                // skip over current node
                previous.setLink(current.getLink());
                numElements--;
                // current jumps to the next node after previous
                current = previous.getLink();
            } else {
                // move both pointers forward
                previous = current;
                current = current.getLink();
            }
        }
    }
}

