import java.util.Random;

public class Aula2_Exerc2 {

    /**
     * Implementação do Insertion Sort em Java.
     *
     * @param arr array de inteiros a ser ordenado
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move os elementos arr[j] que são maiores que key para
            // uma posição à frente da sua posição atual.
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Gera um array de inteiros aleatórios no intervalo [0, range).
     *
     * @param size  Tamanho do array
     * @param range Valor máximo de cada elemento
     * @return array de inteiros
     */
    public static int[] generateRandomArray(int size, int range) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(range);
        }
        return arr;
    }

    /**
     * Gera um array já ordenado (crescente) de 0 até size-1.
     *
     * @param size Tamanho do array
     * @return array ordenado de inteiros
     */
    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;  // Sequência crescente
        }
        return arr;
    }

    /**
     * Gera um array ordenado (decrescente).
     *
     * @param size Tamanho do array
     * @return array ordenado de inteiros de forma decrescente
     */
    public static int[] generateReverseArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i - 1;  // Sequência decrescente
        }
        return arr;
    }

    /**
     * Mede o tempo de execução de uma função de ordenação.
     *
     * @param arr o array a ordenar
     * @return tempo em nanosegundos
     */
    public static long measureInsertionSortTime(int[] arr) {
        long start = System.nanoTime();
        insertionSort(arr);
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        // Tamanhos solicitados
        int[] sizes = {10, 100, 500, 1000, 2000, 5000};

        System.out.printf("%-10s %-20s %-20s\n", "N", "Crescente", "Decrescente");
        for (int n : sizes) {
            // Gera array ordenado (melhor caso)
            int[] sortedArray = generateSortedArray(n);
            // Gera array ordenado de forma decrescente (pior caso)
            int[] reverseArray = generateReverseArray(n);

            // Mede tempo para o array ordenado (melhor caso)
            long timeSorted = measureInsertionSortTime(sortedArray);

            // Mede tempo para o array ordenado de forma decrescente (pior caso)
            long timeReverse = measureInsertionSortTime(reverseArray);

            System.out.printf("%-10d %-20d %-20d\n", n, timeSorted, timeReverse);
        }
    }
}