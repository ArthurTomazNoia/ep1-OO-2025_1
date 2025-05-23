public class alunoNormal extends Aluno{
    private String curso;
    private int semestre;
    private String turno;

    public alunoNormal(String nome,String curso,int semestre, String turno, int matricula){
        super(nome,matricula,curso);
        this.curso = curso;
        this.semestre = semestre;
        this.turno = turno;

    }
public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
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
    return "Nome: " + getNome() + "| Matricula: " + getMatricula() + "| Curso: " + curso + "| Semestre: " + semestre + "| Turno: " + turno;
 }

 public static alunoNormal fromCSV(String linha) {
        String[] partes = linha.split(",");
        String nome = partes[0];
        int matricula = Integer.parseInt(partes[1]);
        String curso = partes[2];
        return new alunoNormal(nome, matricula, curso);
    }
}
