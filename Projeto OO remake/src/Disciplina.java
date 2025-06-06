import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String cargaHoraria;
    private String codigo;
    private List<Professor> professores = new ArrayList<>();

    // Construtor
    public Disciplina(String nome, String cargaHoraria, String codigo) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.codigo = codigo;
    }

    public Disciplina() {
    }

    // Getters e Setters
    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCargaHoraria() {

        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() {

        return codigo;
    }

    public void setCodigo(String codigo) {

        this.codigo = codigo;
    }

    public List<Professor> getProfessores() {

        return professores;
    }

    public void addProfessor(Professor professor) {

        professores.add(professor);
    }
}