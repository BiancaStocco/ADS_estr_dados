public class Aula6_Exerc3 {

    public static boolean sequentialSearch(int[] alist, int item) {
        int pos = 0; 
 
         while (pos < alist.length) {
            if (alist[pos] == item) { 
                return true; 
            }
            pos++; 
        }

        return false; 
    }

    public static void main(String[] args) {
        int[] lista = {0, 3, 5, 9, 14, 17, 21, 33, 39};

        if (sequentialSearch(lista, 15)) {
            System.out.println("Número 15: True");
        } else {
            System.out.println("Número 15: False");
        }

        if (sequentialSearch(lista, 39)) {
            System.out.println("Número 39: True");
        } else {
            System.out.println("Número 39: False");
        }
    }
}