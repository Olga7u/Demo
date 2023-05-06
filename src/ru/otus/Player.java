package ru.otus;

import java.util.Scanner;

public class Player {
    public static void main(String[] args) {
        Test cosmicTest = new Test() {
            @Override
            public Question[] getQuestionList() {
                return new Question[]{
                        new Question("Что находится в центре Солнечной системы?",new String[]{"1 - Земля","2 - Луна","3 - Солнце","4 - Юпитер","5 - Альфа Центавра"},3),
                        new Question("Как называются спутники Марса?",new String[]{"1 - Фобос и Деймос","2 - Геракл и Гидра","3 - Ромео и Джульетта"},1),
                        new Question("На нашу Землю постоянно падают",new String[]{"1 - Астероиды", "2 - Метеориты", "3 - Малые планеты", "4 - НЛО"},2)};
            }

            @Override
            public String[] getTestResult() {
                return new String[]{"Астрономия - это не ваше", "Могло быть и хуже", "Совсем неплохо", "Вы - Астроном-Эксперт!"};
            }
        };
        Play(cosmicTest.getQuestionList(), cosmicTest.getTestResult());
    }

    private static void Play(Question[] questionList, String[] testResult){
        int rightAnswerCount = 0;
        for (Question item : questionList) {
            System.out.println(item.getQuestion());
            if (item.isRight(getAnswer(item.getAnswerCount()))) {
                System.out.println("Верно");
                rightAnswerCount++;
            } else {
                System.out.println("Неверно - " + item.getRightAnswer());
            }
        }
        try{
            System.out.println(testResult[rightAnswerCount]+" ("+rightAnswerCount+" из "+questionList.length+")");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    // Принимает с консоли и возвращает номер ответа
    private static int getAnswer(int size){
        boolean exit = false;
        int r = 0;
        do{
            Scanner scanner = new Scanner(System.in);
            try{
                r = scanner.nextInt();
                if(r < 1 || r > size){
                    System.out.println("!!! Введите число от 1 до "+ size);
                }else {
                    exit = true;
                }
            }
            catch (Exception e){
                System.out.println("!!! Введите число от 1 до "+ size);
            }
        }while(!exit);

        return r;
    }
}
