package br.com.veesbank.model;

import java.util.ArrayList;
import java.util.List;

public class Custumer {
    private String id;              // Identificador único (pode ser UUID)
    private String name;            // Nome do cliente
    private String cpf;             // CPF
    private List<Account> accounts; // Contas do cliente

    public Custumer(String id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.accounts = new ArrayList<>();
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public List<Account> getAccounts() { return accounts; }

    // Método utilitário
    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "Cliente{id='" + id + "', nome='" + name + "', cpf='" + cpf + "'}";
    }
}
