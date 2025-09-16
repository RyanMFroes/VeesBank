package br.com.veesbank.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Transaction {
    private String id;                   // Identificador único (pode ser UUID)
    private TransactionType type;        // Tipo (enum)
    private BigDecimal amount;           // Valor
    private LocalDateTime date;          // Data/hora
    private String description;          // Descrição (ex: "Depósito em caixa eletrônico")

    private static final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Construtor
    public Transaction(String id, TransactionType type, BigDecimal amount, String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.description = description;
    }

    // Getters
    public String getId() { return id; }
    public TransactionType getType() { return type; }
    public BigDecimal getAmount() { return amount; }
    public LocalDateTime getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        String action = "";
        switch (type) {
            case DEPOSIT:
                action = "Você depositou";
                break;
            case WITHDRAW:
                action = "Você sacou";
                break;
            case TRANSFER:
                action = "Você transferiu";
                break;
        }

        return action + " " + moneyFormat.format(amount) + " em " + date.format(dateFormat);
    }

    // Versão detalhada com ID
    public String getDetailedInfo() {
        return "ID: " + id + " | Tipo: " + type + " | Valor: " + moneyFormat.format(amount) + " | Data: " + date.format(dateFormat);
    }
}
