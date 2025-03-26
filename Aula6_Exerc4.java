public class Aula6_Exerc4 {
 
    public static boolean binarySearch(int[] alist, int item) {
        int first = 0; 
        int last = alist.length - 1; 

        while (first <= last) {
            int midpoint = (first + last) / 2; // ponto médio

            if (alist[midpoint] == item) {
                return true;
            }
            else if (item < alist[midpoint]) {
                last = midpoint - 1; 
            }
            else {
                first = midpoint + 1; 
            }
        }

        return false;
    }

    public static void main(String[] args) {
       int[] lista = {0, 3, 5, 9, 14, 17, 21, 33, 39};

        if (binarySearch(lista, 15)) {
            System.out.println("Número 15: True");
        } else {
            System.out.println("Número 15: False");
        }

        if (binarySearch(lista, 39)) {
            System.out.println("Número 39: True");
        } else {
            System.out.println("Número 39: False");
        }
    }
}