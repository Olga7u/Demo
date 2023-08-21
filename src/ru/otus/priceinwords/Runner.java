package ru.otus.priceinwords;

import java.util.concurrent.atomic.AtomicBoolean;

public class Runner {
    private final IOService ioService;
    private final CommandHandler commandHandler;

    Runner(IOService ioService, CommandHandler commandHandler){
        this.ioService = ioService;
        this.commandHandler = commandHandler;
    }

    public void run() {
        AtomicBoolean executionFlag = new AtomicBoolean(true);

        while (executionFlag.get()) {
            String command = readCommand();

            if (!commandHandler.handleExitCommand(command, executionFlag)) {
                commandHandler.handleInputCommand(command);
            }
        }
    }

    private String readCommand() {
        ioService.outputStr("Введите целое число от 0 до 999 999 999 или exit");
        return ioService.readString();
    }
}
