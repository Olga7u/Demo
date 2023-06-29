package ru.otus.exception;

import java.io.Closeable;

public class AnyWorker implements Closeable {
    void start() {
        System.out.println("Worker started");
    }

    void execWorker() throws CriticalException {
        AnyWork anyWork = new AnyWork();
        for (int i = 0; i < 100; i++) {
            System.out.print(i + ": ");
            try {
                anyWork.doWork();
                System.out.println("Fine");
            } catch (CriticalException exception) {
                throw exception;
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    @Override
    public void close() {
        System.out.println("Worker closed");
    }
}
