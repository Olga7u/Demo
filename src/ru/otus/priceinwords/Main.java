package ru.otus.priceinwords;

public class Main {
    public static void main(String[] args) {
        IOService ioService = new IOServiceConsole();
        Currency currency = new CurrencyRussian();

        Translator translator = new TranslatorRub(currency);

        CommandHandler commandHandler = new CommandHandler(ioService, translator);

        Runner runner = new Runner(ioService, commandHandler);
        runner.run();
    }
}
