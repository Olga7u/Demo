package ru.otus.priceinwords;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CurrencyRussianTest {

    @Test
    void number2Str() {
        Currency currency = new CurrencyRussian();

        assertNull(currency.number2Str(BigDecimal.valueOf(-1)));

        assertEquals("ноль рублей", currency.number2Str(BigDecimal.valueOf(0)));
        assertEquals("один рубль", currency.number2Str(BigDecimal.valueOf(1)));
        assertEquals("два рубля", currency.number2Str(BigDecimal.valueOf(2)));
        assertEquals("три рубля", currency.number2Str(BigDecimal.valueOf(3)));
        assertEquals("четыре рубля", currency.number2Str(BigDecimal.valueOf(4)));
        assertEquals("пять рублей", currency.number2Str(BigDecimal.valueOf(5)));
        assertEquals("семь рублей", currency.number2Str(BigDecimal.valueOf(7)));
        assertEquals("десять рублей", currency.number2Str(BigDecimal.valueOf(10)));
        assertEquals("одиннадцать рублей", currency.number2Str(BigDecimal.valueOf(11)));
        assertEquals("пятнадцать рублей", currency.number2Str(BigDecimal.valueOf(15)));
        assertEquals("тридцать рублей", currency.number2Str(BigDecimal.valueOf(30)));
        assertEquals("тридцать один рубль", currency.number2Str(BigDecimal.valueOf(31)));
        assertEquals("сорок два рубля", currency.number2Str(BigDecimal.valueOf(42)));
        assertEquals("пятьдесят шесть рублей", currency.number2Str(BigDecimal.valueOf(56)));
        assertEquals("сто рублей", currency.number2Str(BigDecimal.valueOf(100)));
        assertEquals("двести один рубль", currency.number2Str(BigDecimal.valueOf(201)));
        assertEquals("триста три рубля", currency.number2Str(BigDecimal.valueOf(303)));
        assertEquals("триста тринадцать рублей", currency.number2Str(BigDecimal.valueOf(313)));
        assertEquals("триста тридцать четыре рубля", currency.number2Str(BigDecimal.valueOf(334)));
        assertEquals("четыреста шестьдесят восемь рублей", currency.number2Str(BigDecimal.valueOf(468)));
        assertEquals("одна тысяча рублей", currency.number2Str(BigDecimal.valueOf(1000)));
        assertEquals("две тысячи девятьсот рублей", currency.number2Str(BigDecimal.valueOf(2900)));
        assertEquals("пятьсот шестнадцать тысяч восемнадцать рублей", currency.number2Str(BigDecimal.valueOf(516018)));
        assertEquals("один миллион одна тысяча рублей", currency.number2Str(BigDecimal.valueOf(1001000)));
        assertEquals("шестьдесят миллионов семьдесят девять тысяч один рубль", currency.number2Str(BigDecimal.valueOf(60079001)));
        assertEquals("девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять рублей", currency.number2Str(BigDecimal.valueOf(999999999)));
    }
}