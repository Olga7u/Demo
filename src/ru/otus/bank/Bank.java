package ru.otus.bank;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Bank {
    private final Map<Client, Account[]> clients = new HashMap<>();
    private final Map<Account, Client> accounts = new HashMap<>();

    void addClient(String name, LocalDate birthDate, Account[] accounts){
        // Добавляем клиента со списком счетов accounts
        Client newClient = new Client(name, birthDate);
        this.clients.put(newClient, accounts);
        // Загружаем счета в общий список
        for(Account acc: accounts){
            this.accounts.put(acc,newClient);
        }
    }

    Account[] getAccounts(Client client){
        return this.clients.get(client);
    }

    Client findClient(Account account){
        return this.accounts.get(account);
    }
}
