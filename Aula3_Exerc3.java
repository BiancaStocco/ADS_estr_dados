// Aula3_Exerc3.java

// Classe ContaBancaria
class ContaBancaria {
    // Atributos privados
    private String titular;
    private double saldo;
    private String numeroConta;

    // Construtor
    public ContaBancaria(String titular, String numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0; // Saldo inicial
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor; // Adiciona o valor ao saldo
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    // Método para sacar dinheiro
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor; // Subtrai o valor do saldo
            System.out.println("Saque de R$ " + valor + " realizado com sucesso.");
        } else {
            System.out.println("Erro: Saldo insuficiente para saque.");
        }
    }

    // Método para consultar o saldo
    public double consultarSaldo() {
        return saldo; // Retorna o saldo atual
    }

    // Método para exibir os dados da conta
    public String exibirDadosConta() {
        return String.format("Titular: %s, Número da Conta: %s, Saldo: R$ %.2f", 
                             titular, numeroConta, saldo);
    }
}

// Classe Aula3_Exerc3
public class Aula3_Exerc3 {
    public static void main(String[] args) {
        // Criando uma conta bancária
        ContaBancaria conta = new ContaBancaria("João Silva", "12345-6");

        // Exibindo dados da conta
        System.out.println(conta.exibirDadosConta());

        // Depositando dinheiro
        conta.depositar(1000.0);
        System.out.println("Saldo após depósito: " + conta.consultarSaldo());

        // Sacando dinheiro
        conta.sacar(500.0);
        System.out.println("Saldo após saque: " + conta.consultarSaldo());

        // Tentando sacar mais do que o saldo disponível
        conta.sacar(600.0); // Deve exibir uma mensagem de erro

        // Exibindo dados atualizados da conta
        System.out.println(conta.exibirDadosConta());
    }
}