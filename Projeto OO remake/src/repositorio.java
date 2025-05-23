import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Repositorio {
    private ArrayList<alunoNormal> listaAlunos = new ArrayList<>();

    // Adiciona um aluno
    public void adicionarAluno(alunoNormal aluno) {
        listaAlunos.add(aluno);
    }

    // Salva a lista de alunos em arquivo .csv
    public void salvarArquivo(String nomeArquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (alunoNormal aluno : listaAlunos) {
                bw.write(aluno.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    // Carrega alunos de um arquivo .csv para listaAlunos
    public void carregarArquivo(String nomeArquivo) {
        listaAlunos.clear(); // limpa a lista antes de carregar
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                alunoNormal aluno = alunoNormal.fromCSV(linha);
                listaAlunos.add(aluno);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    // Outros métodos (buscar, remover, listar) aqui...
}
