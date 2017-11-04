package com.example.evetochkin.jeench.util;

public enum Currency {
    RUB(" ₽"), EUR(" €"), USD(" $");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
