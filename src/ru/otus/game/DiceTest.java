package ru.otus.game;

public class DiceTest implements Dice {
    private int index = 0;
    private final int[] points;

    DiceTest(int[] points) {
        super();
        this.points = points;
    }

    @Override
    public int roll() {
        int result = points[index];
        if (++index >= points.length){
            index = 0;
        }
        return result;
    }
}
