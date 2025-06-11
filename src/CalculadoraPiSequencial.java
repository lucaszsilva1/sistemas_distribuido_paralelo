import java.util.Random;

public class CalculadoraPiSequencial {
    public static void main(String[] args) {
        // Define o número total de pontos que vamos sortear.
        // Quanto maior o número, mais precisa será a estimativa de Pi.
        long totalDePontos = 10_000_000L; // Usando 10 milhões para começar

        // Chama o método que executa o cálculo.
        double piEstimado = calcularPi(totalDePontos);

        // Imprime o resultado.
        System.out.println("Estimativa de Pi: " + piEstimado);
    }

    /**
     * Calcula o valor de Pi usando o método de Monte Carlo de forma sequencial.
     * @param totalDePontos O número de pontos aleatórios a serem gerados.
     * @return Uma estimativa do valor de Pi.
     */
    public static double calcularPi(long totalDePontos) {
        Random geradorAleatorio = new Random();
        long pontosDentroDoCirculo = 0;

        // Loop para gerar os pontos e verificar se estão dentro do círculo.
        for (long i = 0; i < totalDePontos; i++) {
            // Gera coordenadas x e y entre -1 e 1.
            // Usamos nextDouble() que gera um valor entre 0.0 e 1.0,
            // então multiplicamos por 2 e subtraímos 1.
            double x = 2 * geradorAleatorio.nextDouble() - 1;
            double y = 2 * geradorAleatorio.nextDouble() - 1;

            // Verifica se o ponto (x, y) está dentro do círculo.
            // A equação de um círculo centrado na origem é x² + y² <= r².
            // Como nosso raio (r) é 1, a condição é x² + y² <= 1.
            if (x * x + y * y <= 1) {
                pontosDentroDoCirculo++;
            }
        }

        // Aplica a fórmula de Monte Carlo para estimar Pi.
        return 4.0 * pontosDentroDoCirculo / totalDePontos;
    }
}
