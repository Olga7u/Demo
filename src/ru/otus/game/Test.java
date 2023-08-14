package ru.otus.game;

public class Test {

    public static void main(String[] args) {
        testDiceRepeat();
        testDiceRollRange();

        testGame1();
        testGame2();
        testGame3();
    }

    // Выигрывает игрок Player1
    static void testGame1() {
        DiceTest diceTest = new DiceTest(new int[]{2,1});
        GameWinnerTest testWinner = new GameWinnerTest();

        Game game = new Game(diceTest, testWinner);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        game.playGame(player1, player2);
        boolean res = player1.equals(testWinner.getTestWinner());

        printRes(res, "Выигрывает игрок Player1");
    }

    // Выигрывает игрок Player2
    static void testGame2() {
        DiceTest diceTest = new DiceTest(new int[]{1,2});
        GameWinnerTest testWinner = new GameWinnerTest();

        Game game = new Game(diceTest, testWinner);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        game.playGame(player1, player2);
        boolean res = player2.equals(testWinner.getTestWinner());

        printRes(res, "Выигрывает игрок Player2");
    }

    // Никто не выигрывает, результаты равны
    static void testGame3() {
        DiceTest diceTest = new DiceTest(new int[]{2,2});
        GameWinnerTest testWinner = new GameWinnerTest();

        Game game = new Game(diceTest, testWinner);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        game.playGame(player1, player2);
        boolean res = testWinner.getTestWinner() == null;

        printRes(res, "Никто не выигрывает, результаты равны");
    }

    // Диапазон результата броска кубика (1 - 6)
    static void testDiceRollRange() {
        Dice dice = new DiceImpl();
        boolean res = true;
        for (int i = 0; i < 100; i++) {
            int resRoll = dice.roll();
            if (resRoll < 1 || resRoll > 6) {
                res = false;
                break;
            }
        }
        printRes(res,"Диапазон результата броска кубика (1 - 6)");
    }

    // Результатом броска кубика не должно быть одно и то же число
    static void testDiceRepeat() {
        Dice dice = new DiceImpl();
        boolean res = false;
        int resRoll2 = dice.roll();
        for (int i = 0; i < 100; i++) {
            int resRoll = dice.roll();
            if (resRoll != resRoll2) {
                res = true;
                break;
            }
        }
        printRes(res,"Результатом броска кубика не должно быть одно и то же число");
    }

    static private void printRes(boolean res, String testName) {
        if (res) {
            System.out.println("Тест "+ testName+" пройден");
        } else {
            System.err.println("Тест "+ testName+" не пройден");
        }
    }
}
