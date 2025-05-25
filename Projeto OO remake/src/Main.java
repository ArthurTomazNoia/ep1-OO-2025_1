import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    private static UtilAluno utilAluno = new UtilAluno();
    private static UtilDisciplina utilDisciplina = new UtilDisciplina();
    private static UtilProf utilProf = new UtilProf();
    private static UtilTurma utilTurma = UtilTurma.getInstance();

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarDisciplina();
                    break;
                case 4:
                    cadastrarTurma();
                    break;
                case 5:
                    adicionarNota();
                    break;
                case 6:
                    listaAlunos();
                    break;
                case 7:
                    listarProfessores();
                    break;
                case 8:
                    listarDisciplina();
                    break;
                case 9:
                    listarTurmas();
                    break;
                case 10:
                    relatorioAlunoXNotaXMedia();
                    break;
                case 11:
                    quantidadeAluno();
                    break;
                case 12:
                    alunoMaiorNota();
                    break;
                case 13:
                    listarAlunosDeDisciplina();
                    break;
                case 14:
                    listarAlunosPorProfessor();
                    break;
                case 15:
                    gerarCSV();
                    sair();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 15);
        scanner.close();
    }

    private static void cadastrarAluno() {
        System.out.println("| |  CADASTRO ALUNO  | |");
        System.out.println("Nome:");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        System.out.println("Data de nascimento (dd/mm/aaaa):");
        String dataNascimento = scanner.nextLine().trim();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine().trim();
        System.out.println("Endereço:");
        String endereco = scanner.nextLine().trim();
        System.out.println("Matrícula:");
        String matricula = scanner.nextLine().trim();
        if (matricula.isEmpty()) {
            System.out.println("Matrícula não pode ser vazia!");
            return;
        }
        System.out.println("Ano de ingresso:");
        String anoIngresso = scanner.nextLine().trim();

        Aluno aluno = new Aluno(nome, dataNascimento, telefone, endereco, matricula, anoIngresso);
        utilAluno.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    private static void cadastrarProfessor() {
        System.out.println("| |  CADASTRO PROFESSOR  | |");
        System.out.println("Nome:");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        System.out.println("Data de nascimento (dd/mm/aaaa):");
        String dataNascimento = scanner.nextLine().trim();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine().trim();
        System.out.println("Endereço:");
        String endereco = scanner.nextLine().trim();
        System.out.println("Área de Formação:");
        String areaDeFormacao = scanner.nextLine().trim();
        System.out.println("Ano de Admissão:");
        String anoDeAdmissao = scanner.nextLine().trim();
        System.out.println("E-mail:");
        String email = scanner.nextLine().trim();

        Professor professor = new Professor(nome, dataNascimento, telefone, endereco, areaDeFormacao);
        professor.setAnoDeAdmissao(anoDeAdmissao);
        professor.setEmail(email);
        utilProf.cadastrarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private static void cadastrarDisciplina() {
        System.out.println("| |  CADASTRO DISCIPLINA  | |");
        System.out.println("Nome:");
        String nome = scanner.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio!");
            return;
        }
        System.out.println("Carga Horária:");
        String cargaHoraria = scanner.nextLine().trim();
        System.out.println("Código:");
        String codigo = scanner.nextLine().trim();
        if (codigo.isEmpty()) {
            System.out.println("Código não pode ser vazio!");
            return;
        }

        Disciplina disciplina = new Disciplina(nome, cargaHoraria, codigo);
        utilDisciplina.cadastrarDisciplina(disciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private static void cadastrarTurma() {
        System.out.println("| |  CADASTRO DE NOVA TURMA  | |");
        System.out.println("Escolha um professor:");
        utilProf.listarProfessores();
        System.out.println("Nome do Professor(a):");
        String nomeProfessor = scanner.nextLine().trim();
        Professor professor = utilProf.buscarProfessor(nomeProfessor);

        if (professor == null) {
            System.out.println("Professor não encontrado. Tente novamente.");
            return;
        }

        System.out.println("Escolha uma disciplina:");
        utilDisciplina.listarDisciplinas();
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine().trim();
        Disciplina disciplina = utilDisciplina.buscarDisciplina(nomeDisciplina);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Ano Letivo:");
        int anoLetivo;
        try {
            anoLetivo = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ano letivo inválido. Tente novamente.");
            return;
        }

        System.out.println("Código:");
        int codigo;
        try {
            codigo = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Código inválido. Tente novamente.");
            return;
        }

        Turma turma = new Turma(codigo, disciplina, professor);
        turma.setAnoLetivo(anoLetivo);
        professor.addDisciplina(disciplina); // Associate discipline with professor
        disciplina.addProfessor(professor); // Associate professor with discipline
        utilTurma.cadastrarTurma(turma);
    }

    private static void adicionarNota() {
        System.out.println("| |  ADICIONANDO NOTA  | |");
        System.out.println("Escolha uma disciplina:");
        utilDisciplina.listarDisciplinas();
        System.out.print("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine().trim();
        Disciplina disciplina = utilDisciplina.buscarDisciplina(nomeDisciplina);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada. Tente novamente.");
            return;
        }

        System.out.println("Escolha um aluno:");
        utilAluno.listarAlunos();
        System.out.print("Nome do aluno: ");
        String nomeAluno = scanner.nextLine().trim();
        Aluno aluno = utilAluno.buscarAluno(nomeAluno);

        if (aluno == null) {
            System.out.println("Aluno não encontrado. Tente novamente.");
            return;
        }

        System.out.print("Informe o valor da nota: ");
        double valorNota;
        try {
            valorNota = Double.parseDouble(scanner.nextLine().trim());
            if (valorNota < 0 || valorNota > 10) {
                System.out.println("Nota deve estar entre 0 e 10. Tente novamente.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Nota inválida. Tente novamente.");
            return;
        }

        System.out.print("Informe a data da nota (dd/mm/aaaa): ");
        String dataNota = scanner.nextLine().trim();
        if (!dataNota.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Formato de data inválido. Use dd/mm/aaaa.");
            return;
        }

        Nota novaNota = new Nota(valorNota, dataNota, aluno, disciplina);
        aluno.addNota(novaNota);
        System.out.println("Nota adicionada com sucesso!");
    }

    private static void listaAlunos() {
        System.out.println("| | LISTA DE ALUNOS | |");
        utilAluno.listarAlunos();
    }

    private static void listarProfessores() {
        System.out.println("| | LISTA DE PROFESSORES | |");
        utilProf.listarProfessores();
    }

    private static void listarDisciplina() {
        System.out.println("| | LISTA DE DISCIPLINAS | |");
        utilDisciplina.listarDisciplinas();
    }

    private static void listarTurmas() {
        System.out.println("| | LISTA DE TURMAS | |");
        utilTurma.listarTurmas();
    }

    private static void relatorioAlunoXNotaXMedia() {
        System.out.println("| | RELATÓRIO ALUNO X NOTAS X MÉDIA | |");
        for (Aluno aluno : utilAluno.getAlunos()) {
            System.out.println("Aluno: " + aluno.getNome());
            System.out.println("Notas:");
            double somaNotas = 0;
            int contadorNotas = 0;

            for (Nota nota : aluno.getNotas()) {
                System.out.println("- " + nota.getDisciplina().getNome() + ": " + nota.getValor() + " (Data: " + nota.getData() + ")");
                somaNotas += nota.getValor();
                contadorNotas++;
            }

            if (contadorNotas > 0) {
                double media = somaNotas / contadorNotas;
                System.out.println("Média: " + String.format("%.2f", media));
            } else {
                System.out.println("Nenhuma nota registrada.");
            }
            System.out.println();
        }
    }

    private static void quantidadeAluno() {
        int quantidade = utilAluno.quantidadeAlunos();
        System.out.println("Quantidade de alunos cadastrados: " + quantidade);
    }

    private static void alunoMaiorNota() {
        System.out.println("| | ALUNO COM MAIOR NOTA | |");
        Aluno alunoComMaiorNota = null;
        double maiorNota = -1;

        for (Aluno aluno : utilAluno.getAlunos()) {
            for (Nota nota : aluno.getNotas()) {
                if (nota.getValor() > maiorNota) {
                    maiorNota = nota.getValor();
                    alunoComMaiorNota = aluno;
                }
            }
        }

        if (alunoComMaiorNota != null) {
            System.out.println("Aluno: " + alunoComMaiorNota.getNome());
            System.out.println("Maior Nota: " + maiorNota);
        } else {
            System.out.println("Nenhuma nota registrada.");
        }
    }

    private static void listarAlunosDeDisciplina() {
        System.out.println("| | LISTAR ALUNOS POR DISCIPLINA | |");
        System.out.print("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine().trim();
        utilAluno.listarAlunosPorDisciplina(nomeDisciplina);
    }

    private static void listarAlunosPorProfessor() {
        System.out.println("| | LISTAR ALUNOS POR PROFESSOR | |");
        System.out.print("Digite o nome do professor: ");
        String nomeProfessor = scanner.nextLine().trim();
        utilAluno.listarAlunosPorProfessor(nomeProfessor);
    }

    private static void gerarCSV() {
        System.out.println("| | GERANDO CSV DOS DADOS | |");
        StringBuilder csvContent = new StringBuilder();

        // Alunos CSV
        csvContent.append("=== Alunos ===\n");
        csvContent.append("Nome,DataNascimento,Telefone,Endereco,Matricula,AnoIngresso\n");
        for (Aluno aluno : utilAluno.getAlunos()) {
            csvContent.append(String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"\n",
                    aluno.getNome(), aluno.getDataNascimento(), aluno.getTelefone(),
                    aluno.getEndereco(), aluno.getMatricula(), aluno.getAnoIngresso()));
        }
        csvContent.append("\n");

        // Professores CSV
        csvContent.append("=== Professores ===\n");
        csvContent.append("Nome,DataNascimento,Telefone,Endereco,AreaFormacao,AnoAdmissao,Email\n");
        for (Professor professor : utilProf.getProfessores()) {
            csvContent.append(String.format("\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\"\n",
                    professor.getNome(), professor.getDataNascimento(), professor.getTelefone(),
                    professor.getEndereco(), professor.getAreaDeFormacao(),
                    professor.getAnoDeAdmissao(), professor.getEmail()));
        }
        csvContent.append("\n");

        // Disciplinas CSV
        csvContent.append("=== Disciplinas ===\n");
        csvContent.append("Nome,CargaHoraria,Codigo\n");
        for (Disciplina disciplina : utilDisciplina.getDisciplinas()) {
            csvContent.append(String.format("\"%s\",\"%s\",\"%s\"\n",
                    disciplina.getNome(), disciplina.getCargaHoraria(), disciplina.getCodigo()));
        }
        csvContent.append("\n");

        // Turmas CSV
        csvContent.append("=== Turmas ===\n");
        csvContent.append("Codigo,Disciplina,Professor,AnoLetivo,QuantidadeAlunos\n");
        for (Turma turma : utilTurma.getTurmas()) {
            csvContent.append(String.format("\"%d\",\"%s\",\"%s\",\"%d\",\"%d\"\n",
                    turma.getCodigo(), turma.getDisciplina().getNome(),
                    turma.getProfessor().getNome(), turma.getAnoLetivo(), turma.getAlunos().size()));
        }
        csvContent.append("\n");

        // Notas CSV
        csvContent.append("=== Notas ===\n");
        csvContent.append("Aluno,Disciplina,Nota,Data\n");
        for (Aluno aluno : utilAluno.getAlunos()) {
            for (Nota nota : aluno.getNotas()) {
                csvContent.append(String.format("\"%s\",\"%s\",\"%.2f\",\"%s\"\n",
                        aluno.getNome(), nota.getDisciplina().getNome(), nota.getValor(), nota.getData()));
            }
        }

        // Write to file
        try (FileWriter writer = new FileWriter("school_data.csv")) {
            writer.write(csvContent.toString());
            System.out.println("Arquivo CSV gerado com sucesso: school_data.csv");
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo CSV: " + e.getMessage());
        }
    }

    private static void sair() {
        System.out.println("==============================================");
        System.out.println("=================== SAINDO... ================");
        System.out.println("==============================================");
    }

    private static void menu() {
        System.out.println("| |  MENU PRINCIPAL | |");
        System.out.println("Escolha uma opção");
        System.out.println(" 1 - Cadastrar Aluno");
        System.out.println(" 2 - Cadastrar Professor");
        System.out.println(" 3 - Cadastrar Disciplina");
        System.out.println(" 4 - Cadastrar Turma");
        System.out.println(" 5 - Inserir Notas");
        System.out.println(" 6 - Relatório Alunos");
        System.out.println(" 7 - Relatório Professor");
        System.out.println(" 8 - Relatório Disciplina");
        System.out.println(" 9 - Relatório Turmas");
        System.out.println(" 10 - Relatório de Aluno x Notas x Média");
        System.out.println(" 11 - Quantidade de Alunos Cadastrados");
        System.out.println(" 12 - Nome do Aluno que Possui a Maior Nota");
        System.out.println(" 13 - Listar Alunos de uma Determinada Disciplina");
        System.out.println(" 14 - Listar Alunos Associados a um Determinado Professor");
        System.out.println(" 15 - Gerar CSV e Sair");
        System.out.println("\nEscolha uma opção:");
    }
}