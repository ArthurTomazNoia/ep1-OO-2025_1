import java.util.ArrayList;
import java.util.List;

public class UtilDisciplina {
    private List<Disciplina> disciplinas;

    public UtilDisciplina() {
        this.disciplinas = new ArrayList<>();
    }

    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public Disciplina buscarDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    public void listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina disciplina : disciplinas) {
                System.out.println("- Nome: " + disciplina.getNome() + ", Código: " + disciplina.getCodigo() + ", Carga Horária: " + disciplina.getCargaHoraria());
            }
        }
    }

    public List<Disciplina> getDisciplinas() {
        return new ArrayList<>(disciplinas);
    }
}