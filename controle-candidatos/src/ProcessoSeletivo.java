import com.github.javafaker.Faker;


public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {    
        Faker faker = new Faker(); // Criar uma instância do Faker
        
        int numCandidatos = ThreadLocalRandom.current().nextInt(5, 20); // Gerar um número aleatório de candidatos
    
        System.out.println("Número total de candidatos: " + numCandidatos);
        for (int i = 0; i < numCandidatos; i++) {
            String nome = faker.name().fullName(); // Gerar um nome aleatório
            double salarioPretendido = ThreadLocalRandom.current().nextDouble(1500.0, 3000.0); // Gerar um salário aleatório entre 1500.0 e 3000.0
            System.out.println("Nome: " + nome + ", Salário Pretendido: " + salarioPretendido);
            analisarCandidato(salarioPretendido);
            System.out.println("--------------------------------------------");
        }
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}