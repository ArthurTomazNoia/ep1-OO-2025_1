import java.util.ArrayList;
import java.util.List;

public class Turma {
    private int codigo;
    private Disciplina disciplina;
    private int anoLetivo;
    private Professor professor;
    private List<Aluno> alunos = new ArrayList<>();

    // Construtor
    public Turma(int codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return new ArrayList<>(alunos);
    }

    public void addAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    @Override
    public String toString() {
        return "Turma: " + codigo +
               "\nDisciplina: " + disciplina.getNome() +
               "\nProfessor: " + professor.getNome() +
               "\nQuantidade de alunos: " + alunos.size();
    }
}