package sorter;

public class QuickSorter implements Sorter {
    public int[] sort(int[] values) {
       
        if (values == null || values.length <= 1) {
            return values;
        }
            quickSort(values, 0, values.length - 1);
        return values;
    }

    private void quickSort(int[] values, int low, int high) {
        if (low < high) {
            // Encontra o índice de partição
            int pi = partition(values, low, high);
            // Ordena as duas sublistas
            quickSort(values, low, pi - 1);
            quickSort(values, pi + 1, high);
        }

    }

   

    public int partition(int[] values, int low, int high) {
            
        int pivo = values[low];
        int i = low + 1;
    
        for (int j = low + 1; j < high; j++) {
            if (values[j] <= pivo) {
                i +=1;
                troca(values, i, j);
                }     
            }
        troca(values, low, i);
        return i;
        }
    
    private void troca(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        

    }
    
}
