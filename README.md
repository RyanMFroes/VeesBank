# VeesBank

**VeesBank** é um sistema bancário simples desenvolvido em Java, criado para fins de aprendizado e prática de programação orientada a objetos.  
O projeto simula operações básicas de um banco, como criação de contas, clientes e transações financeiras.

---

## 🛠️ Tecnologias Utilizadas

- **Java** (OpenJDK 24.0.2)  
- **IDE**: IntelliJ IDEA Community Edition  
- **Paradigma**: Programação Orientada a Objetos (POO)  

---

## 📂 Estrutura do Projeto

src/
└── br.com.veesbank
├── model/
│ ├── Account.java # Representa uma conta bancária
│ ├── Customer.java # Representa um cliente do banco
│ ├── Transaction.java # Registra uma transação
│ └── TransactionType.java # Enum com tipos de transação (DEPÓSITO, SAQUE, etc.)
│
├── repository/
│ └── AccountRepository.java # Simula o armazenamento de contas
│
├── service/
│ └── BankService.java # Contém as regras de negócio do sistema
│
└── ui/
└── Main.java # Ponto de entrada do sistema (executável)


---

## 📖 Funcionalidades

- Criar clientes e contas bancárias  
- Realizar depósitos e saques  
- Registrar e visualizar transações  
- Identificar o tipo de cada transação (ex: DEPÓSITO, SAQUE)  

---

## 📌 Observações

- Os dados não são persistidos em banco de dados, apenas em memória.  
- Ideal para aprendizado de **POO em Java** e **organização de pacotes**.  

