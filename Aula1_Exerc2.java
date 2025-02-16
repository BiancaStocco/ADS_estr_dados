import java.util.Scanner;

public class Aula1_Exerc2 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Digite a nota (0 a 10): ");
        double nota = scanner.nextDouble();

        if (nota >= 7) {
            System.out.println("Aluno aprovado.");
        } else if (nota >= 5 && nota < 7) {
            System.out.println("Aluno de recuperação.");
        } else {
            System.out.println("Aluno reprovado.");
        }
        
    }
}
