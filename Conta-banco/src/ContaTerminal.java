import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coleta e Validação de Dados
        ContaBancaria conta = criarConta(scanner);

        // Mensagem de boas-vindas personalizada
        String mensagem = gerarMensagemBoasVindas(conta);
        System.out.println(mensagem);
    }

    /**
     * @param scanner
     * @return
     */
    private static ContaBancaria criarConta(Scanner scanner) {
        String nomeCliente;
        int numeroAgencia;
        String numeroConta;
        double saldoConta;


        do {
            System.out.println("Por favor, digite seu nome: ");
            nomeCliente = scanner.next();
        } while (!validarNome(nomeCliente));
        do {
            System.out.println("Por favor, digite o número da Agência (4 dígitos): ");
            numeroAgencia = scanner.nextInt();
        } while (!validarAgencia(numeroAgencia));

        do {
            System.out.println("Por favor, digite o número da Conta (7 dígitos): ");
            numeroConta = scanner.next();
        } while (!validarConta(numeroConta));

        do {
            System.out.println("Por favor, digite o saldo da Conta: ");
            saldoConta = scanner.nextDouble();
        } while (!validarSaldo(saldoConta));

        return new ContaBancaria(numeroAgencia, numeroConta, saldoConta, nomeCliente);
    }

    /**
     * @param nomeCliente
     * @return
     */
    private static boolean validarNome(String nomeCliente) {
        if (nomeCliente.isEmpty() || nomeCliente.isBlank()) {
            System.out.println("Erro: Nome não pode ser vazio. Por favor, digite novamente.");
            return false;
        }

        for (char c : nomeCliente.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                System.out.println("Erro: Nome contém caracteres inválidos. Digite apenas letras e espaços.");
                return false;
            }
        }

        return true;
    }


    /**
     * @param agencia
     * @return
     */
    private static boolean validarAgencia(int agencia) {
        return agencia >= 1000 && agencia <= 9999;
    }

    private static boolean validarConta(String conta) {
        if (conta.length() != 7) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            if (!Character.isDigit(conta.charAt(i))) {
                return false;
            }
        }

        // Cálculo do dígito verificador (simplificado)
        int digitoVerificador = 0;
        for (int i = 0; i < 6; i++) {
            digitoVerificador += Character.getNumericValue(conta.charAt(i));
        }
        digitoVerificador %= 10;

        if (digitoVerificador != Character.getNumericValue(conta.charAt(6))) {
            return false;
        }

        return true;
    }

    private static boolean validarSaldo(double saldo) {
        return saldo >= 0;
    }

    /**
     * @param conta
     * @return
     */
    private static String gerarMensagemBoasVindas(ContaBancaria conta) {
        return "Olá " + conta.getNomeCliente() + ", obrigado por criar uma conta em nosso banco!\n"
                + "Sua agência é " + conta.getNumeroAgencia() + ", conta " + conta.getNumeroConta() + " e seu saldo " + conta.getSaldo() + " já está disponível para saque.";
    }
}
