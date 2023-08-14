package ru.otus.priceinwords;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CurrencyRussian implements Currency {
    private final HashMap<Object, Object> numbers = new HashMap<>();   // Числа строкой
    private final HashMap<Object, Object> numbersF = new HashMap<>();  // Числа строкой: одна, две

    private final HashMap<Object, ArrayList<String>> digits = new HashMap<>();  // Тысячи, миллионы
    private final ArrayList<Object> currency = new ArrayList<>();  // Валюта

    private final static BigDecimal DIVISOR = BigDecimal.valueOf(1000);

    /**
     * Возвращает число inputValue прописью с указанием валюты
     *
     */
    @Override
    public String number2Str(BigDecimal inputValue) {
        if (inputValue.compareTo(BigDecimal.valueOf(0))<0){
            return null;
        }
        // Разбиваем исходное число на сегменты по три цифры
        BigDecimal numberTmp = inputValue;
        List<Integer> segments = new ArrayList<>();
        while (numberTmp.compareTo(DIVISOR) >= 0) {
            BigDecimal seg = numberTmp.divide(DIVISOR, 0, RoundingMode.DOWN);
            segments.add(numberTmp.subtract(seg.multiply(DIVISOR)).intValue());
            numberTmp = seg;
        }
        segments.add(numberTmp.intValue());
        // Обрабатываем каждый сегмент
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0; i < segments.size(); i++) {
            int seg = segments.get(i);
            StringBuilder s = new StringBuilder();

            if (seg > 0 || segments.size() == 1) {
                s.append(" ").append(segment2Str(seg, i == 1));
            }

            int trail = seg % 100;
            trail = (trail > 19 ? trail % 10 : trail);
            s.append(" ");
            switch (i) {
                case 0 -> s.append(getCurrency(trail));
                case 1 -> s.append(getDigits(trail, Rank.THOUSANDS));
                case 2 -> s.append(getDigits(trail, Rank.MILLIONS));
            }
            items.add(s.toString());
        }

        StringBuilder result = new StringBuilder();
        for (int i = items.size() - 1; i >= 0; i--) {
            result.append(items.get(i));
        }

        return result.toString().strip();
    }

    // Перевод в слова трёхзначного числа value, fem определяет окончание один-одна, два-две
    private String segment2Str(int value, boolean fem) {
        if (value == 0) {
            return numbers.get(0).toString();
        }

        StringBuilder s = new StringBuilder();
        int digit3 = value - value % 100;
        if (digit3 > 0) {
            s.append(numbers.get(digit3));
        }
        int digit2 = value - digit3;
        if (digit2 >= 10 && digit2 <= 19) {
            s.append(" ").append(numbers.get(digit2));
            return s.toString().strip();
        } else if (digit2 > 19) {
            s.append(" ").append(numbers.get(digit2 - digit2 % 10));
        }

        int digit1 = digit2 % 10;
        if (digit1 > 0) {
            if (fem && (digit1 == 1 || digit1 == 2)) {
                s.append(" ").append(numbersF.get(digit1));
            } else {
                s.append(" ").append(numbers.get(digit1));
            }
        }

        return s.toString().strip();
    }

    // Словоформа тысяч, миллионов (определяется rank) для числа trail
    private String getDigits(int trail, Rank rank) {
        switch (trail) {
            case 1 -> {
                return this.digits.get(rank).get(0);
            }
            case 2, 3, 4 -> {
                return this.digits.get(rank).get(1);
            }
            default -> {
                return this.digits.get(rank).get(2);
            }
        }
    }

    // Словоформа валюты (рублей) для числа trail
    private String getCurrency(int trail) {
        switch (trail) {
            case 1 -> {
                return this.currency.get(0).toString();
            }
            case 2, 3, 4 -> {
                return this.currency.get(1).toString();
            }
            default -> {
                return this.currency.get(2).toString();
            }
        }
    }

    public CurrencyRussian() {
        numbers.put(0, "ноль");
        numbers.put(1, "один");
        numbers.put(2, "два");
        numbers.put(3, "три");
        numbers.put(4, "четыре");
        numbers.put(5, "пять");
        numbers.put(6, "шесть");
        numbers.put(7, "семь");
        numbers.put(8, "восемь");
        numbers.put(9, "девять");
        numbers.put(10, "десять");
        numbers.put(11, "одиннадцать");
        numbers.put(12, "двенадцать");
        numbers.put(13, "тринадцать");
        numbers.put(14, "четырнадцать");
        numbers.put(15, "пятнадцать");
        numbers.put(16, "шестнадцать");
        numbers.put(17, "семнадцать");
        numbers.put(18, "восемнадцать");
        numbers.put(19, "девятнадцать");
        numbers.put(20, "двадцать");
        numbers.put(30, "тридцать");
        numbers.put(40, "сорок");
        numbers.put(50, "пятьдесят");
        numbers.put(60, "шестьдесят");
        numbers.put(70, "семьдесят");
        numbers.put(80, "восемьдесят");
        numbers.put(90, "девяносто");
        numbers.put(100, "сто");
        numbers.put(200, "двести");
        numbers.put(300, "триста");
        numbers.put(400, "четыреста");
        numbers.put(500, "пятьсот");
        numbers.put(600, "шестьсот");
        numbers.put(700, "семьсот");
        numbers.put(800, "восемьсот");
        numbers.put(900, "девятьсот");

        numbersF.put(1, "одна");
        numbersF.put(2, "две");

        digits.put(Rank.THOUSANDS, new ArrayList<>(List.of("тысяча", "тысячи", "тысяч")));
        digits.put(Rank.MILLIONS, new ArrayList<>(List.of("миллион", "миллиона", "миллионов")));

        currency.add("рубль");
        currency.add("рубля");
        currency.add("рублей");
    }
}
