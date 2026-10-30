package application;

import entities.ContaBancaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            System.out.println("Bem vindo ao banco!");
            System.out.println("Criar conta bancária");
            System.out.print("Insira seu nome: ");
            String nomeTitular = sc.nextLine();
            double depositoInicial = lerValorPositivo(sc, "Insira o valor do depósito inicial: ");

            ContaBancaria conta = new ContaBancaria(nomeTitular, depositoInicial);
            System.out.println("Bem vindo, " + conta.getNomeTitular() + "!");

            int opcao;
            do {
                System.out.println("\nEscolha uma opção:");
                System.out.println("1 - Depósito");
                System.out.println("2 - Saque");
                System.out.println("3 - Consultar cheque especial");
                System.out.println("4 - Consultar saldo");
                System.out.println("5 - Pagar um boleto");
                System.out.println("6 - Verificar se cheque especial está ativo");
                System.out.println("0 - Sair");
                opcao = lerOpcao(sc);

                switch (opcao) {
                    case 1:
                        double valorDeposito = lerValorPositivo(sc, "Insira o valor do depósito: ");
                        conta.depositar(valorDeposito);
                        System.out.printf("Depósito realizado! Saldo atual: R$ %.2f%n", conta.getSaldo());
                        break;

                    case 2:
                        double valorSaque = lerValorPositivo(sc, "Insira o valor do saque: ");
                        if (conta.sacar(valorSaque)) {
                            System.out.printf("Saque realizado! Saldo atual: R$ %.2f%n", conta.getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente (incluindo cheque especial).");
                        }
                        break;

                    case 3:
                        System.out.printf("Cheque especial disponível: R$ %.2f%n", conta.chequeEspecialDisponivel());
                        break;

                    case 4:
                        System.out.printf("Saldo atual: R$ %.2f%n", conta.getSaldo());
                        System.out.printf("Saldo total (incluindo cheque especial): R$ %.2f%n", conta.getSaldoTotal());
                        break;

                    case 5:
                        double valorBoleto = lerValorPositivo(sc, "Insira o valor do boleto: ");
                        if (conta.pagarBoleto(valorBoleto)) {
                            System.out.printf("Boleto pago! Saldo atual: R$ %.2f%n", conta.getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente para pagar o boleto.");
                        }
                        break;

                    case 6:
                        if (conta.isChequeEspecialAtivo()) {
                            System.out.println("O cheque especial está ativo.");
                            System.out.printf("Limite do cheque especial: R$ %.2f%n", conta.getLimiteChequeEspecial());
                            System.out.printf("Disponível no cheque especial: R$ %.2f%n", conta.chequeEspecialDisponivel());
                            System.out.printf("Taxa do cheque especial: %.0f%%%n", conta.getTaxa() * 100);
                        } else {
                            System.out.println("O cheque especial não está ativo.");
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
        }
    }

    private static double lerValorPositivo(Scanner sc, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            while (!sc.hasNextDouble()) {
                System.out.print("Entrada inválida. Digite apenas números: ");
                sc.next();
            }
            double valor = sc.nextDouble();
            if (valor > 0) {
                return valor;
            }
            System.out.println("O valor deve ser maior que zero!");
        }
    }

    private static int lerOpcao(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número do menu: ");
            sc.next();
        }
        return sc.nextInt();
    }
}