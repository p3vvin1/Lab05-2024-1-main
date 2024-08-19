package sorter;

public class MergeSort implements Sorter {

    @Override
    public int[] sort(int[] values) {
        if (values == null || values.length <= 1) {
            return values;
    }
    return mergeSort(values);
}
    private int[] mergeSort(int[] values) {
    if (values.length <= 1) {
        return values;
    }
    
    // Divide o array em dois subarrays
    int mid = values.length / 2;
    int[] left = new int[mid];
    int[] right = new int[values.length - mid];
    
    System.arraycopy(values, 0, left, 0, mid);
    System.arraycopy(values, mid, right, 0, values.length - mid);
    
    // Ordena os subarrays recursivamente
    left = mergeSort(left);
    right = mergeSort(right);
    
    // Mescla os subarrays ordenados
    return merge(left, right);
}
   

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            result[k++] = left[i++];
        }
        
        while (j < right.length) {
            result[k++] = right[j++];
        }
        
        return result;
    }
}
