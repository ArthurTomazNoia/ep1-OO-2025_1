public class alunoEspecial extends Aluno {
    private String curso;
    private int semestre;
    private String turno;

    public alunoEspecial(String nome, int matricula, String curso, String turno, int semestre){
        super(nome,matricula,curso);
        this.curso = curso;
        this.semestre = semestre;
        this.turno = turno;

    }
    public String getCurso(String curso){
        return curso;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
@Override
public void impressao(){
    System.out.println("Nome: " + getNome());
    System.out.println("Matricula: " + getMatricula());
    System.out.println("Curso: " + getCurso());
    System.out.println("Semestre: " + semestre);
    System.out.println("Turno: " + turno);
}
@Override
public String toString (){
    return "Nome: " + getNome() + "| Matricula: " + getMatricula() + "| Curso: " + getCurso() + "| Semestre" + semestre + "| Turno: " + turno;
 }
}
