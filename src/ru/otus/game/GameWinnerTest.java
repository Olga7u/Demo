package ru.otus.game;

public class GameWinnerTest implements GameWinnerPrinter {

    private Player testWinner = null;

    @Override
    public void printWinner(Player winner) {
        this.testWinner = winner;
    }

    public Player getTestWinner() {
        return testWinner;
    }
}
