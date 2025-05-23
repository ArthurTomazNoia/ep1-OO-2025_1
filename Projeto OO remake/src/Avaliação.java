public class Avaliação {
    public double [] notas = new double[5]; // no caso é a p1,p2,p3 seminario e lista
    public int totalAulas = 0;
    public int presenca = 0;
    
    public Avaliacao(double[] notas, int presenca, int totalAulas) {
        this.notas = notas;
        this.presenca = presenca;
        this.totalAulas = totalAulas;
    }
    public  double calcularMedia (String tipoAvaliacao){ 
     if (tipoAvaliacao.equalsIgnoreCase("Simples")) {
        double soma = 0;
        for (double nota : notas) soma += nota;
        return soma/5;
     } else { return(notas[0] + notas [1] * 2 + notas[3] * 3 + notas[4] + notas[5])/8; }

     public double calcularFrenquencia() {
        return totalAulas == 0 ? 0 : (presenca * 100.0) /totalAulas;
    
     }
     }
}
