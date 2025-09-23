public class BubbleSort extends Sorter {
    
    @Override
    public void sort() {
        int[] array = getArray();
        if (array == null || array.length <= 1) {
            return;
        }
        
        int n = array.length;
        
        // REMOVE the early termination optimization to make bubble sort slower
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            // No early break - always does full n-1 passes
        }
    }
}