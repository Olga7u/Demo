package ru.otus;

import java.util.Scanner;

class Test {
    private final String[] question = new String[]{
            "Что находится в центре Солнечной системы?",
            "Как называются спутники Марса?",
            "На нашу Землю постоянно падают"
    };

    private final String[][] answer = new String[][]{
            new String[]{"1 - Земля","2 - Луна","3 - Солнце","4 - Юпитер","5 - Альфа Центавра"},
            new String[]{"1 - Фобос и Деймос","2 - Геракл и Гидра","3 - Ромео и Джульетта"},
            new String[]{"1 - Астероиды", "2 - Метеориты", "3 - Малые планеты", "4 - НЛО"}
    };

    private final int[] rightAnswer = new int[]{3,1,2};

    private int rightAnswerCount = 0;

    private final String[] testResult = new String[]{
            "Астрономия - это не ваше",
            "Могло быть и хуже",
            "Совсем неплохо",
            "Вы - Астроном-Эксперт!"
    };

    private String GetTestResult(){
        return this.testResult[this.rightAnswerCount]+" ("+this.rightAnswerCount+" из 3)";
    }

    private boolean RightAnswer(int answerNum, int rightAnswer){
        if(answerNum == rightAnswer){
            this.rightAnswerCount++;
            return true;
        }else {
            return false;
        }
    }

    private int GetAnswer(int size){
        boolean exit = false;
        int r = 0;
        do{
            Scanner scanner = new Scanner(System.in);
            try{
                r = scanner.nextInt();
                if(r < 1 || r > size){
                    System.err.println("!!! Введите число от 1 до "+ size);
                }else {
                    exit = true;
                }
            }
            catch (Exception e){
                System.err.println("!!! Введите число от 1 до "+ size);
            }
        }while(!exit);

        return r;
    }

    private void PrintQuestion(int ind){
        System.out.println(question[ind]);
        for(String item : answer[ind]){
            System.out.println(item);
        }
    }

    void Exec(){
        for(int i = 0; i < question.length; i++){
            PrintQuestion(i);
            int a = GetAnswer(answer[i].length);
            if (RightAnswer(a, rightAnswer[i])){
                System.out.println("Верно");
            }else{
                System.out.println("Неверно - "+answer[i][rightAnswer[i]-1]);
            }
        }
        System.out.println(GetTestResult());
    }
}
