import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

        ArrayList<AlunoNormal> alunosNormais = new ArrayList<>();
        ArrayList<AlunoEspecial> alunosEspeciais = new ArrayList<>();
        ArrayList<Aluno> alunos= new ArrayList<>();
        ArrayList<Turma> turmas = new ArrayList<>();
        List<Disciplina> disciplinas = new ArrayList<>();

public class Menu {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Repositorio repo = new Repositorio();
    int opcao;
    //repo.carregarArquivo("Alunos.csv");

do {
    System.out.println("| | MENU PRINCIPAL | |");
    System.out.println("1. Modo Aluno.");
    System.out.println("2. Modo disciplina/turma.");
    System.out.println("3. Modo avaliação/frequência.");
    System.out.println("4. Fechar programa.");
    System.out.println("Escolha uma opção: ");
     opcao = scanner.nextInt();

    switch (opcao) {
        case 1: //modo aluno
        do {
            Repositorio repositorio = new Repositorio();
            System.out.println("| | MODO ALUNO | |");
    System.out.println("1. Adicionar Aluno normal.");
     System.out.println("2. Adicionar Aluno especial.");
    System.out.println("3. Lista de alunos matriculados.");
    System.out.println("4. Matricular/Retirar matricula.");
    System.out.println("5. Editar aluno.");
    System.out.println("6. Remover aluno.");
    System.out.println("9. Retornar ao Menu principal.");
    System.out.println("Escolha uma opção: ");
     opcao = scanner.nextInt();

     switch (opcao) {
        case 1:
        System.out.println("Nome do aluno: ");
        String nomeNormal = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Matricula do aluno: ");
        int matriculaNormal = scanner.nextInt();
         
        if (Util.matriculaIgual(matriculaNormal) != -1) {
            System.out.println("Matricula ja existe, por favor, confira a matricula."); 
            break;
        } 
        System.out.println("Digite o curso do aluno: ");
        String cursoNormal = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Semestre do aluno (numero): ");
        int semestreNormal = scanner.nextInt();
        System.out.println("Digite o turno do aluno: ");
        String turnoNormal = scanner.nextLine();
        scanner.nextLine();
        
    
        
        Repositorio.salvarArquivo("alunos.csv");
        alunosNormais.add(new AlunoNormal(nomeNormal, matriculaNormal , cursoNormal, semestreNormal, turnoNormal));

        System.out.println("Aluno salvo com sucesso!");

        break;

        case 2: //alunoE
        System.out.println("Digite nome do aluno(E): ");
        String nomeEspecial = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Digite a matricula(E): ");
        int matriculaEspecial = scanner.nextInt();
         
        if (Util.matriculaIgual(matriculaEspecial) != -1) {
            System.out.println("Matricula ja existe, por favor, confira a matricula."); 
            break;
        } 
        System.out.println("Digite o curso do aluno(E): ");
        String cursoEspecial = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Semestre do aluno (numero)(E): ");
        int semestreEspecial = scanner.nextInt();
        System.out.println("Digite o turno do aluno(E): ");
        String turnoEspecial = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Aluno salvo com sucesso!(E)");


        case 3: //listas alunos
        case 4: //matricular tirar
      

        case 5: // editar aluno
System.out.println("| | EDITAR ALUNO | |");
        System.out.println("Digite a matrícula do aluno que deseja editar:");
        String matriculaEditar = scanner.nextLine();
        
        
        if (alunoExistente == null) {
         System.out.println("Aluno não encontrado!");
        } else {
            System.out.println("Aluno encontrado: " + alunoExistente);
               System.out.println("Insira os novos dados do aluno:");


               
        }
          break;
        case 6:
        System.out.println("| | REMOVER ALUNO | |");
        System.out.println("Digite a matrícula do aluno que deseja remover:");
        String matriculaRemover = sc.nextLine();

        String alunoExistenteRemover = buscarAlunoNoArquivo(matriculaRemover);
        if (alunoExistenteRemover == null) {
        System.out.println("Aluno não encontrado.");
        } else {
        System.out.println("Aluno encontrado: " + alunoExistenteRemover);
        System.out.println("Deseja realmente remover este aluno? (s/n)");
        String confirmacao = sc.nextLine();
        if (confirmacao.equalsIgnoreCase("s")) {
           removerAlunoArquivo(matriculaRemover);
         } else {
        System.out.println("Operação de remoção cancelada.");
     }
          }
            break;

        





     }






        } while (opcao != 9);
        










    } 








} while (opcao != 4);


















    }
}
