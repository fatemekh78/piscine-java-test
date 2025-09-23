/**
 * Abstract base class for sorting algorithms.
 * Provides common functionality for setting/getting arrays and defines
 * the abstract sort method that child classes must implement.
 */
public abstract class Sorter {
    private int[] array;

    /**
     * Gets the current array
     * @return the array being sorted
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Sets the array to be sorted
     * @param array the array to sort
     */
    public void setArray(int[] array) {
        this.array = array;
    }

    /**
     * Abstract method to sort the array
     * Child classes must implement their specific sorting algorithm
     */
    public abstract void sort();
}