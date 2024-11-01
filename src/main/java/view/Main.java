package view;

import models.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clinica clinica = new Clinica("Clínica Saúde");

        // Exemplos de dados
        clinica.adicionarFuncionario(new Funcionario("Ana Pereira", "98765432100", new Date(), "321654987", "ana@example.com", "Recepcionista", new Date(), 3000));
        clinica.adicionarMedico(new Medico("Dr. João", "12345678900", new Date(), "123456789", "joao@example.com", new Especialidade("Cardiologia"), "CRM-123456"));
        clinica.adicionarPaciente(new Paciente("Maria", "09876543211", new Date(), "987654321", "maria@example.com"));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Adicionar Médico");
            System.out.println("3. Adicionar Paciente");
            System.out.println("4. Listar Funcionários");
            System.out.println("5. Listar Médicos");
            System.out.println("6. Listar Pacientes");
            System.out.println("7. Marcar Consulta");
            System.out.println("8. Remover Funcionário");
            System.out.println("9. Remover Médico");
            System.out.println("10. Remover Paciente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (escolha) {
                case 1:
                    adicionarFuncionario(clinica, scanner);
                    break;
                case 2:
                    adicionarMedico(clinica, scanner);
                    break;
                case 3:
                    adicionarPaciente(clinica, scanner);
                    break;
                case 4:
                    System.out.println("Funcionários: " + clinica.listarFuncionarios());
                    break;
                case 5:
                    System.out.println("Médicos: " + clinica.listarMedicos());
                    break;
                case 6:
                    System.out.println("Pacientes: " + clinica.listarPacientes());
                    break;
                case 7:
                    marcarConsulta(clinica, scanner);
                    break;
                case 8:
                    removerFuncionario(clinica, scanner);
                    break;
                case 9:
                    removerMedico(clinica, scanner);
                    break;
                case 10:
                    removerPaciente(clinica, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void adicionarFuncionario(Clinica clinica, Scanner scanner) {
        System.out.print("Nome do Funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascStr = scanner.nextLine();
        Date dataNasc = parseDate(dataNascStr);
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Data de Admissão (dd/MM/yyyy): ");
        String dataAdmissaoStr = scanner.nextLine();
        Date dataAdmissao = parseDate(dataAdmissaoStr);
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        Funcionario funcionario = new Funcionario(nome, cpf, dataNasc, telefone, email, cargo, dataAdmissao, salario);
        clinica.adicionarFuncionario(funcionario);
    }

    private static void adicionarMedico(Clinica clinica, Scanner scanner) {
        System.out.print("Nome do Médico: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascStr = scanner.nextLine();
        Date dataNasc = parseDate(dataNascStr);
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidadeNome = scanner.nextLine();
        Especialidade especialidade = new Especialidade(especialidadeNome);
        System.out.print("CRM: ");
        String crm = scanner.nextLine();

        Medico medico = new Medico(nome, cpf, dataNasc, telefone, email, especialidade, crm);
        clinica.adicionarMedico(medico);
    }

    private static void adicionarPaciente(Clinica clinica, Scanner scanner) {
        System.out.print("Nome do Paciente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNascStr = scanner.nextLine();
        Date dataNasc = parseDate(dataNascStr);
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, dataNasc, telefone, email);
        clinica.adicionarPaciente(paciente);
    }

    private static void marcarConsulta(Clinica clinica, Scanner scanner) {
        System.out.println("Selecionar Médico:");
        List<Medico> medicos = clinica.listarMedicos();
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println((i + 1) + ". " + medicos.get(i).getNome());
        }
        System.out.print("Escolha o número do Médico: ");
        int medicoIndex = scanner.nextInt() - 1;
        Medico medico = medicos.get(medicoIndex);

        System.out.println("Selecionar Paciente:");
        List<Paciente> pacientes = clinica.listarPacientes();
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }
        System.out.print("Escolha o número do Paciente: ");
        int pacienteIndex = scanner.nextInt() - 1;
        Paciente paciente = pacientes.get(pacienteIndex);

        System.out.print("Data da Consulta (dd/MM/yyyy): ");
        String dataConsultaStr = scanner.next();
        Date dataConsulta = parseDate(dataConsultaStr);

        try {
            Consulta consulta = new Consulta(medico, paciente, dataConsulta);
            System.out.println("Consulta marcada com sucesso!");
            consulta.exibirInformacoes();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao marcar consulta: " + e.getMessage());
        }
    }

    private static void removerFuncionario(Clinica clinica, Scanner scanner) {
        System.out.print("CPF do Funcionário a remover: ");
        String cpf = scanner.nextLine();
        clinica.removerFuncionario(cpf);
    }

    private static void removerMedico(Clinica clinica, Scanner scanner) {
        System.out.print("CPF do Médico a remover: ");
        String cpf = scanner.nextLine();
        clinica.removerMedico(cpf);
    }

    private static void removerPaciente(Clinica clinica, Scanner scanner) {
        System.out.print("CPF do Paciente a remover: ");
        String cpf = scanner.nextLine();
        clinica.removerPaciente(cpf);
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Data inválida. Tente novamente.");
            return new Date(); // Retorna a data atual em caso de erro
        }
    }
}
