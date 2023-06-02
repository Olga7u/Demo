package ru.otus.bank;

import java.time.LocalDate;
import java.util.Objects;

class Client {
    private final String name;
    private final LocalDate birthDate;

    Client(String name, LocalDate birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(birthDate, client.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate);
    }
}
