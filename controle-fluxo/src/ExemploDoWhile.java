import java.util.Random;

public class ExemploDoWhile {
    public static void main(String[] args) {
        System.out.println("Discando...");

        int contadorDeChamadas = 0; // Variável para contagem de toques

        do {
            System.out.println("Telefone tocando...");
            contadorDeChamadas++; // Incrementa o contador a cada toque

        } while (tocando());

        System.out.println("Alô !!!");
        System.out.println("O telefone tocou " + contadorDeChamadas + " vezes.");
    }

    private static boolean tocando() {
        boolean atendeu = new Random().nextInt(3) == 1;
        System.out.println("Atendeu? " + atendeu);
        return !atendeu; // Retorna o inverso de "atendeu" para controlar o loop
    }
}
