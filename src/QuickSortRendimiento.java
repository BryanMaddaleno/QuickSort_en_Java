import java.util.Random;

public class QuickSortRendimiento {
    // Método principal de QuickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            
            // Ordenar elementos antes y después de la partición
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Función para particionar el arreglo usando el último elemento como pivote
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); 
        
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Intercambio
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }

    public static void main(String[] args) {
        // Escenarios de prueba (tamaños de arreglo)
        int[] tamanos = {100, 500, 1000, 5000, 10000};
        
        System.out.println("--- Benchmark QuickSort ---");
        for (int n : tamanos) {
            int[] data = generarArregloAleatorio(n);
            
            long inicio = System.nanoTime();
            quickSort(data, 0, data.length - 1);
            long fin = System.nanoTime();
            
            System.out.println("Tamaño: " + n + " | Tiempo: " + (fin - inicio)/ 1_000_000.0 + " ms");
        }
    }

    public static int[] generarArregloAleatorio(int tamano) {
        Random rd = new Random();
        int[] arr = new int[tamano];
        for (int i = 0; i < tamano; i++) {
            arr[i] = rd.nextInt(50000);
        }
        return arr;
    }
}
