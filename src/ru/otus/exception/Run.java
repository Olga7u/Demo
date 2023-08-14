package ru.otus.exception;

public class Run {
    public static void main(String[] args) {
        try (AnyWorker anyWorker = new AnyWorker()) {
            anyWorker.start();
            anyWorker.execWorker();
        } catch (CriticalException criticalException) {
            criticalException.printStackTrace();
            System.exit(53);
        }
        System.out.println("Doing something else");
    }
}
