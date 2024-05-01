import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public class ProcessoSeletivo {
    public static void main(String[] args){
        ArrayList<String> candidatosSelecionadosList = selecaoCandidatos();
        tentarContato(candidatosSelecionadosList);
    }

    static ArrayList<String> selecaoCandidatos() {
        // Array com a lista de candidatos
        String[] candidatos = {"FELIPE", "MÁRCIA", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        ArrayList<String> candidatosSelecionadosList = new ArrayList<>(); // ArrayList para armazenar os nomes dos candidatos selecionados

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionadosList.add(candidato); // Adiciona o nome do candidato selecionado ao ArrayList
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }

        // Imprime a lista de candidatos selecionados
        System.out.println("\nLista de candidatos selecionados para contato pelo RH:");
        for (String candidato : candidatosSelecionadosList) {
            System.out.println("- " + candidato);
        }

        return candidatosSelecionadosList;
    }

    // Método que simula o valor pretendido
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void tentarContato(ArrayList<String> candidatosSelecionadosList) {
        for (String candidato : candidatosSelecionadosList) {
            System.out.println("\nTentando contato com o candidato " + candidato + "...");
            for (int tentativa = 1; tentativa <= 3; tentativa++) {
                try {
                    Thread.sleep(1000); // Pausa de 1 segundo entre as tentativas
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        System.out.println("CONSEGUIMOS CONTATO COM O " + candidato + " APÓS " + tentativa + " TENTATIVA(S)");
                        break; // Sai do loop se conseguir contato
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (candidatosSelecionadosList.indexOf(candidato) == candidatosSelecionadosList.size() - 1) {
                System.out.println("NÃO CONSEGUIMOS CONTATO COM O " + candidato);
            }
        }
    }
}
