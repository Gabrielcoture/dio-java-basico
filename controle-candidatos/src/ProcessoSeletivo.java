import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandiatos();
    }

    static void selecaoCandiatos() {
        // Array com a lista de candidatos
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        ArrayList<String> candidatosSelecionadosList = new ArrayList<>(); // ArrayList para armazenar os nomes dos candidatos selecionados

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double SalarioPretendido = valorPretendido();
            System.out.println("O canditado " + candidato + " Solicitou este valor de salário " + SalarioPretendido);
            if (salarioBase >= SalarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionadosList.add(candidato);
                candidatosSelecionados++;
            }
            candidatosAtual++;
            
        }


        // Imprime a lista de candidatos selecionados
        System.out.println("\nLista de candidatos selecionados para contato pelo RH:");
        for (String candidato : candidatosSelecionadosList) {
            System.out.println("- " + candidato);
        }

    }

    // Método que simula o valor pretendido
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double SalarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > SalarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == SalarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
