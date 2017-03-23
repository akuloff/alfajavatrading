package com.alfajavatrading.TradePrimitives;

import java.util.Date;

/**
 *
 * @author kulikov
 */
public class HistoryTick {
    TradeInstrument instrument;
    private Date date;
    private double price;
    private long amount;
    private String tradeID;
    private Boolean buyFlag;
    private boolean isArtificial = false;

    public HistoryTick(Date date, double price, long amount, String tradeID) {
        this.date = date;
        this.price = price;
        this.amount = amount;
        this.tradeID = tradeID;
    }

    public TradeInstrument getInstrument() {
        return instrument;
    }

    public HistoryTick setInstrument(TradeInstrument instrument) {
        this.instrument = instrument;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public HistoryTick setDate(Date date) {
        this.date = date;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public HistoryTick setPrice(double price) {
        this.price = price;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public HistoryTick setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public String getTradeID() {
        return tradeID;
    }

    public HistoryTick setTradeID(String tradeID) {
        this.tradeID = tradeID;
        return this;
    }

    public Boolean isBuyFlag() {
        return buyFlag;
    }

    public HistoryTick setBuyFlag(Boolean buyFlag) {
        this.buyFlag = buyFlag;
        return this;
    }

    public boolean isArtificial() {
        return isArtificial;
    }

    public HistoryTick setArtificial(boolean artificial) {
        isArtificial = artificial;
        return this;
    }
}
