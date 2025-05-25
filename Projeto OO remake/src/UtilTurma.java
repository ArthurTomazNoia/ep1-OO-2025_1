import java.util.ArrayList;
import java.util.List;

public class UtilTurma {
    private static volatile UtilTurma instance;
    private List<Turma> turmas;

    private UtilTurma() {
        this.turmas = new ArrayList<>();
    }

    public static UtilTurma getInstance() {
        if (instance == null) {
            synchronized (UtilTurma.class) {
                if (instance == null) {
                    instance = new UtilTurma();
                }
            }
        }
        return instance;
    }

    public void cadastrarTurma(Turma turma) {
        if (turma.getProfessor() == null) {
            System.out.println("Erro: A turma deve estar associada a um professor.");
            return;
        }
        if (turma.getDisciplina() == null) {
            System.out.println("Erro: A turma deve estar associada a uma disciplina.");
            return;
        }
        turmas.add(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }

    public void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (Turma turma : turmas) {
                System.out.println(turma.toString());
            }
        }
    }

    public List<Turma> getTurmas() {
        return new ArrayList<>(turmas);
    }
}