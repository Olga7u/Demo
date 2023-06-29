package ru.otus.bank;

import java.time.LocalDate;
import java.util.Arrays;

public class Run {
    public static void main(String[] args){
        Bank bank = getBank();

        // Печатаем список счетов клиента
        Client client = new Client("Gena", LocalDate.of(1979,5,6));
        Account[] accounts = bank.getAccounts(client);
        printClient(client,accounts);

        // Если клиент не найден
        client = new Client("Gena", LocalDate.of(1977,5,6));
        accounts = bank.getAccounts(client);
        printClient(client,accounts);

        System.out.println();

        // Печатаем клиента по счёту
        Account account = new Account("555");
        client = bank.findClient(account);
        printClient(client,account);
    }

    private static Bank getBank(){
        Bank bank = new Bank();
        bank.addClient("Gena", LocalDate.of(1979,5,6),
                new Account[]{
                        new Account("917"),
                        new Account("458"),
                        new Account("133")});
        bank.addClient("Cheburator", LocalDate.of(1989,12,30),
                new Account[]{
                        new Account("459")});
        bank.addClient("Katya",LocalDate.of(2006,9,19),
                new Account[]{
                        new Account("555"),
                        new Account("517")});
        return bank;
    }

    private static void printClient(Client client, Account[] accounts){
        System.out.println(client);
        System.out.println("Accounts: "+Arrays.toString(accounts));
    }

    private static void printClient(Client client, Account account){
        System.out.println("Account: "+account);
        System.out.println(client);
    }
}
