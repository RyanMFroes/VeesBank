package br.com.veesbank.ui;

import br.com.veesbank.model.*;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criamos um cliente fixo por enquanto
        Custumer custumer = new Custumer(UUID.randomUUID().toString(), "Ryan Muto", "123.456.789-00");
        Account account = new Account("0001-01", custumer);
        custumer.addAccount(account);

        boolean running = true;

        while (running) {
            System.out.println("\n=== VeesBank ===");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Ver transações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (option) {
                case 1:
                    System.out.println("Saldo atual: R$ " + account.getBalance());
                    break;

                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    BigDecimal depositValue = scanner.nextBigDecimal();
                    Transaction deposit = new Transaction(
                            UUID.randomUUID().toString(),
                            TransactionType.DEPOSIT,
                            depositValue,
                            "Depósito em conta"
                    );
                    account.addTransaction(deposit);
                    account.setBalance(account.getBalance().add(depositValue));
                    System.out.println("Depósito realizado com sucesso!");
                    break;

                case 3:
                    System.out.print("Digite o valor do saque: ");
                    BigDecimal withdrawValue = scanner.nextBigDecimal();
                    if (withdrawValue.compareTo(account.getBalance()) <= 0) {
                        Transaction withdraw = new Transaction(
                                UUID.randomUUID().toString(),
                                TransactionType.WITHDRAW,
                                withdrawValue,
                                "Saque em conta"
                        );
                        account.addTransaction(withdraw);
                        account.setBalance(account.getBalance().subtract(withdrawValue));
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 4:
                    System.out.println("Histórico de transações:");
                    for (Transaction t : account.getTransactions()) {
                        System.out.println(t); // versão amigável
                    }

                    System.out.print("Deseja ver os IDs das transações? (s/n): ");
                    String showIds = scanner.next();
                    if (showIds.equalsIgnoreCase("s")) {
                        System.out.println("\nDetalhes técnicos:");
                        for (Transaction t : account.getTransactions()) {
                            System.out.println(t.getDetailedInfo());
                        }
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Saindo do VeesBank... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}
