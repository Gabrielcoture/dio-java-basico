import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Declaração de variáveis
            int numeroAgencia;
            int numeroConta;
            String nomeCliente;
            double saldoConta;

            // Coleta de dados do usuário
            System.out.println("Por favor, digite o número da Agência: ");
            numeroAgencia = scanner.nextInt();

            System.out.println("Por favor, digite o número da sua conta: ");
            numeroConta = scanner.nextInt();

            System.out.println("Por favor, digite o nome do Cliente: ");
            nomeCliente = scanner.next();

            System.out.println("Por favor, digite o saldo da Conta: ");
            saldoConta = scanner.nextDouble();

            // Mensagem de boas-vindas personalizada
            String mensagem = "Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco!\n"
                    + "Sua agência é " + numeroAgencia + ", conta " + numeroConta +" e seu saldo " + saldoConta + " já está disponível para saque.";

            System.out.println(mensagem);
        }
    }
}
