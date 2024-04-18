public class ContaBancaria {

    private int numeroAgencia;
    private String numeroConta;
    private double saldo;
    private String nomeCliente;  

    /**
     * @param numeroAgencia
     * @param numeroConta
     * @param saldo
     */
    public ContaBancaria(int numeroAgencia, String numeroConta, double saldo, String nomeCliente2) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.nomeCliente = nomeCliente2; 
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getNumeroAgencia() {
        return String.valueOf(numeroAgencia); 
    }

    public String getSaldo() {
        return String.valueOf(saldo); 
    }

    public String getNumeroConta() {
        return numeroConta;
    }
}

