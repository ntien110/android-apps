package com.example.currency;

public class CurrencyModel {
    private Float rate;
    private String nation;
    private String symbol;
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public String getNation() {
        return nation;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public CurrencyModel(String nation, String currency, String symbol, Float rate) {
        this.nation = nation;
        this.currency = currency;
        this.symbol = symbol;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return nation + " - " + currency;
    }
}
