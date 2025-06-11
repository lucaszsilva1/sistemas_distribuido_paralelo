import java.util.Random;

public class CalculadorDePontos implements Runnable{
    private long pontosParaCalcular;
    private long pontosDentroDoCirculo;

    public CalculadorDePontos(long pontosParaCalcular) {
        this.pontosParaCalcular = pontosParaCalcular;
        this.pontosDentroDoCirculo = 0;
    }

    @Override
    public void run() {
        Random rand = new Random();
        for (long i = 0; i < pontosParaCalcular; i++) {
            double ponto = 2 * rand.nextDouble() - 1;
            double pontoDentro = 2 * rand.nextDouble() - 1;

            if (ponto * ponto + pontoDentro * pontoDentro <= 1) {
                pontosDentroDoCirculo ++;
            }
        }
    }
    public long getPontosDentroDoCircuito(){
        return pontosDentroDoCirculo;
    }
}
