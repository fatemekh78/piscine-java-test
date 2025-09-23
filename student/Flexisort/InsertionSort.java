public class InsertionSort extends Sorter {
    
    @Override
    public void sort() {
        int[] array = getArray();
        if (array == null || array.length <= 1) {
            return;
        }
        
        int n = array.length;
        
        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = array[i];
            
            // If the current element is already in correct position, skip inner loop
            if (key >= array[i - 1]) {
                continue;
            }
            
            int j = i - 1;
            
            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            
            // Insert the key at its correct position
            array[j + 1] = key;
        }
    }
}