package ru.otus.priceinwords;

import java.util.concurrent.atomic.AtomicBoolean;

public class CommandHandler {
    private static final String EXIT_COMMAND = "exit";

    private final IOService ioService;
    private final Translator translator;

    CommandHandler(IOService ioService, Translator translator){
        this.ioService = ioService;
        this.translator = translator;
    }

    public boolean handleExitCommand(String command, AtomicBoolean executionFlag) {
        if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            return false;
        }
        executionFlag.getAndSet(false);
        return true;
    }

    public void handleInputCommand(String inputStr) {
        String outputStr = null;
        try{
            outputStr = translator.Translate(inputStr);
        }
        catch (Exception ex){
            ioService.outputError(ex.getMessage());
        }
        if (outputStr != null){
            ioService.outputStr(outputStr);
        }
    }
}
