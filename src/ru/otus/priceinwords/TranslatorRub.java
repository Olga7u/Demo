package ru.otus.priceinwords;

import java.math.BigDecimal;
import java.security.InvalidParameterException;

public class TranslatorRub implements Translator{
    private final Currency currency;

    private final BigDecimal Min_Value = new BigDecimal(0);
    private final BigDecimal Max_Value = new BigDecimal(999_999_999);

    public TranslatorRub(Currency currency){
        this.currency = currency;
    }

    /**
     * Принимает и корректирует строку inputStr для перевода в число
     * Проверяет на ограничения
     * Возвращает число прописью с указанием валюты
     *
     */
    @Override
    public String Translate(String inputStr)
            throws InvalidParameterException {
        BigDecimal inputValue;
        String str = inputStr.strip().replaceAll("[_ ]","");
        try {
            inputValue = new BigDecimal(str);
        }catch(Exception ex){
            throw new InvalidParameterException("Некорректное число!");
        }
        if(inputValue.compareTo(Min_Value)<0 || inputValue.compareTo(Max_Value)>0){
            throw new InvalidParameterException("Число вне диапазона!");
        }
        if (str.contains(".") || str.contains("e-") || str.contains("E-")){
            throw new InvalidParameterException("Только целые числа!");
        }
        return currency.number2Str(inputValue);
    }
}
