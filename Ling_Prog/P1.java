import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 1, 2 ou 3: ");
        int N = sc.nextInt();

        if (N == 1) {
            metodo1(sc);
        } else if (N == 2) {
            metodo2(sc);
        } else if (N == 3) {
            metodo3(sc);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    // MÉTODO 1
    public static void metodo1(Scanner sc) {
        int[][] matriz = new int[4][4];
        int somaDiagonal = 0;

        System.out.println("Digite os valores da matriz 4x4: "); //era 10x10
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        System.out.println("Valores abaixo da diagonal principal: ");
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            somaDiagonal += matriz[i][3 - i];
        }

        char resul = (somaDiagonal % 2 == 0) ? 'V' : 'F';
        System.out.println("Soma da diagonal secundária: " + somaDiagonal);
        System.out.println("Resultado: " + resul);
    }

    // MÉTODO 2
    public static void metodo2(Scanner sc) {
        int[] num = new int[10];
        int[] divis = new int[5];

        System.out.println("Digite 10 valores para o vetor 1: ");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Digite o %dº número para Num: ", i + 1);
            num[i] = sc.nextInt();
        }

        System.out.println("Digite 5 valores para o vetor 2: ");
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número para Divis: ", i + 1);
            divis[i] = sc.nextInt();
        }

        System.out.println("Divisores encontrados:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("Número: %d\n", num[i]);
            boolean encontrouDivisor = false;
            for (int j = 0; j < 5; j++) {
                if (num[i] % divis[j] == 0) {
                    System.out.printf("  Divisor: %d na posição %d\n", divis[j], j);
                    encontrouDivisor = true;
                }
            }
            if (!encontrouDivisor) {
                System.out.println("  Nenhum divisor encontrado.");
            }
        }
    }

    // MÉTODO 3
    public static void metodo3(Scanner sc) {
        int[] vetor = new int[5];
        int contador = 0;

        System.out.println("Digite 5 números inteiros para o vetor:"); //era 50
        for (int i = 0; i < 5; i++) {
            System.out.printf("Digite o %dº número: ", i + 1);
            vetor[i] = sc.nextInt();
        }

        for (int i = 1; i < 5; i += 2) {
            if (vetor[i] % 2 == 0 && vetor[i] % 3 == 0) {
                contador++;
            }
        }

        System.out.println("Elementos nos índices ímpares que são pares e divisíveis por 3: " + contador);
    }
}