import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private String areaDeFormacao;
    private String anoDeAdmissao;
    private String email;
    private List<Disciplina> disciplinas = new ArrayList<>();

    // Construtor
    public Professor(String nome, String dataNascimento, String telefone, String endereco,
                     String areaDeFormacao) {
        super(nome, dataNascimento, telefone, endereco);
        this.areaDeFormacao = areaDeFormacao;
        //this.anoDeAdmissao = anoDeAdmissao;
        //this.email = email;
    }

    // Getters e Setters
    public String getAreaDeFormacao() {
        return areaDeFormacao;
    }

    public void setAreaDeFormacao(String areaDeFormacao) {
        this.areaDeFormacao = areaDeFormacao;
    }

    public String getAnoDeAdmissao() {
        return anoDeAdmissao;
    }

    public void setAnoDeAdmissao(String anoDeAdmissao) {
        this.anoDeAdmissao = anoDeAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
}