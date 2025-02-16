import java.util.Scanner;

public class Aula1_Exerc3 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
            
            System.out.print("Digite um número inteiro para ver sua tabuada: ");
            int numero = scanner.nextInt();

            System.out.println("\nTabuada do " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                int resultado = numero * i;
                System.out.printf("%d x %d = %d\n", numero, i, resultado);
            }
    }
}