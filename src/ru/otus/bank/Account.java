package ru.otus.bank;

import java.util.Objects;

class Account {
    private final String num;

    Account(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return num.equals(account.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
