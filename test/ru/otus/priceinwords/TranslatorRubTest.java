package ru.otus.priceinwords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TranslatorRubTest {

    @Test
    void translate() {
        Currency currency = new CurrencyRussian();
        Translator translator = new TranslatorRub(currency);

        testTranslateStandard(translator);
        testTranslateWrong(translator);
    }

    private void testTranslateStandard(Translator translator){
        try{
            assertEquals("сто двадцать три рубля", translator.Translate("123"));
            assertEquals("десять рублей", translator.Translate("1e1"));
            assertEquals("шесть тысяч сто двадцать три рубля", translator.Translate("6_123"));
            assertEquals("шесть тысяч сто двадцать три рубля", translator.Translate("6 123"));
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void testTranslateWrong(Translator translator){
        try{
            assertNull(translator.Translate("lala"));
        }catch (Exception ex){
            assertEquals("Некорректное число!",ex.getMessage());
        }

        try{
            assertNull(translator.Translate("-100"));
            assertNull(translator.Translate("1e10"));
        }catch (Exception ex){
            assertEquals("Число вне диапазона!",ex.getMessage());
        }

        try{
            assertNull(translator.Translate("100.11"));
        }catch (Exception ex){
            assertEquals("Только целые числа!",ex.getMessage());
        }
    }
}