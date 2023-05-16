package ru.otus.quiz;

class Question {
    private final String question;
    private final String[] answer;
    private final int rightAnswer;

    Question(String question, String[] answer, int rightAnswer) {
        this.question = question;
        this.answer = answer;
        this.rightAnswer = rightAnswer;
    }
    // Проверяет правильность полученного извне ответа
    boolean isRight(int answer){
        return  answer == rightAnswer;
    }
    // Вопрос и ответы
    String getQuestion(){
        StringBuilder str = new StringBuilder(this.question);
        for (String item : this.answer){
            str.append("\n").append(item);
        }
        return str.toString();
    }
    // Текст правильного ответа
    String getRightAnswer(){
        return answer[rightAnswer-1];
    }
    // Кол-во ответов
    int getAnswerCount(){
        return answer.length;
    }
}
