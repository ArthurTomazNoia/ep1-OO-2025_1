public class alunoEspecial extends Aluno {
    private String nome;
    private int matricula;
    private String curso;

    public alunoEspecial(String nome, int matricula, String curso){
        super(nome,matricula,curso);

    }
@Override
public void impressao(){
    System.out.println("Nome: " + getNome());
    System.out.println("Matricula: " + getMatricula());
    System.out.println("Curso: " + getCurso());
}
@Override
public String toString (){
    return "Nome: " + nome + "| Matricula: " + matricula + "| Curso: " + curso;
 }
}
