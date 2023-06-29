package ru.otus.exception;

import java.util.Random;

public class AnyWork {
    void doWork() throws Exception {
        var param = new Random().nextInt(10);
        switch (param) {
            case 1 -> throw new Exception("Something wrong");
            case 2 -> throw new CriticalException("Something BADLY wrong");
        }
    }
}
