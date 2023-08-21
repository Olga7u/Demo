package ru.otus.priceinwords;

import java.util.Scanner;

public class IOServiceConsole implements IOService{

    private final Scanner in;

    public IOServiceConsole() {
        in = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return in.nextLine();
    }

    @Override
    public void outputStr(String s) {
        System.out.println(s);
    }

    @Override
    public void outputError(String s) {
        System.err.println(s);
    }
}
