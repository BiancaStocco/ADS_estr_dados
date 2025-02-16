import java.util.Scanner;

public class Aula1_Exerc4 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
            
        System.out.println("Informe seu nome: ");
        String nome = scanner.nextLine(); 
        
        System.out.println("Informe sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Informe sua altura (cm): ");
        int altura = scanner.nextInt();

        System.out.println("Seus dados são: ");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Altura: " + altura + "cm");
    }
}