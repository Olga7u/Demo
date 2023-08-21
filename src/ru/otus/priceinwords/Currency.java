package ru.otus.priceinwords;

import java.math.BigDecimal;

public interface Currency {
    String number2Str(BigDecimal inputValue);
}
