import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class Menu {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
    int opcao;

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
            System.out.println("| | MODO ALUNO | |");
    System.out.println("1. Adicionar Aluno normal.");
    System.out.println("2. Lista de alunos matriculados.");
    System.out.println("3. Matricular/Retirar matricula.");
    System.out.println("9. Retornar ao Menu principal.");
    System.out.println("Escolha uma opção: ");
     opcao = scanner.nextInt();






        } while (opcao != 9);
        










    } 








} while (opcao != 4);


















    }
}
