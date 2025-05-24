import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {
    public static int matriculaIgual(int matricula) {
        try (Scanner scanner = new Scanner(new File("alunos.csv"))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                if (linha.contains("Matricula " + matricula)){
                    return 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: "+ e.getMessage());
        }
        
        return -1;
    }
     public static void removerAlunoArquivo(String matricula) {
        try {
            java.io.File arquivo = new java.io.File("alunos.csv");
            ArrayList<String> linhas = new ArrayList<>();
            boolean encontrado = false;
    
            // Ler todas as linhas do arquivo
            try (Scanner scanner = new Scanner(arquivo)) {
                while (scanner.hasNextLine()) {
                    String linha = scanner.nextLine();
                    if (linha.contains("Matrícula: " + matricula)) {
                        encontrado = true; // Ignora a linha do aluno a ser removido
                    } else {
                        linhas.add(linha); // Mantém as outras linhas
                    }
                }
            }
}
