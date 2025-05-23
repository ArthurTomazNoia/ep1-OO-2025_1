import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {
    public static int matriculaIgual(int matricula) {
        try (Scanner scanner = new Scanner(new File("alunos.txt"))) {
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
}
