/*
    стакан (состояние стакана заявок) по инструменту
 */

package com.alfajavatrading.TradePrimitives;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author kulikov
 */
public class BookState implements Serializable{
    private TradeInstrument instrument;
    private double bestAskPrice, bestBidPrice;
    private double bestAskVolume, bestBidVolume;
    private Timestamp onDate = null;
    private int bookSize = 1;
    private double[] askPrices = new double[1];
    private double[] askVolumes = new double[1];
    private double[] bidPrices = new double[1];
    private double[] bidVolumes = new double[1];
    private String customField = null;

    public BookState() {
    }

    public int getBookSize() {
        return bookSize;
    }

    public synchronized void setBookSize(int bookSize) {
        if ( bookSize > 0 && bookSize != this.bookSize ) {
            this.bookSize = bookSize;
            askPrices = new double[bookSize];
            askVolumes = new double[bookSize];
            bidPrices = new double[bookSize];
            bidVolumes = new double[bookSize];
        }    
    }

    public synchronized void clearAll(){
        bestAskPrice = bestBidPrice = bestAskVolume = bestBidVolume = 0;
        java.util.Arrays.fill(askPrices, 0);
        java.util.Arrays.fill(askVolumes, 0);
        java.util.Arrays.fill(bidPrices, 0);
        java.util.Arrays.fill(bidVolumes, 0);
    }

    public double[] getAskPrices() {
        return askPrices;
    }

    public double[] getAskVolumes() {
        return askVolumes;
    }

    public double[] getBidPrices() {
        return bidPrices;
    }

    public double[] getBidVolumes() {
        return bidVolumes;
    }
    
    
    public BookState(Timestamp onDate) {
        this.onDate = onDate;
    }

    public TradeInstrument getInstrument() {
        return instrument;
    }

    public void setInstrument(TradeInstrument instrument) {
        this.instrument = instrument;
    }

    public double getBestAskPrice() {
        return bestAskPrice;
    }

    public void setBestAskPrice(double bestAskPrice) {
        this.bestAskPrice = bestAskPrice;
    }

    public double getBestBidPrice() {
        return bestBidPrice;
    }

    public void setBestBidPrice(double bestBidPrice) {
        this.bestBidPrice = bestBidPrice;
    }

    public double getBestAskVolume() {
        return bestAskVolume;
    }

    public void setBestAskVolume(double bestAskVolume) {
        this.bestAskVolume = bestAskVolume;
    }

    public double getBestBidVolume() {
        return bestBidVolume;
    }

    public void setBestBidVolume(double bestBidVolume) {
        this.bestBidVolume = bestBidVolume;
    }
    

    public Timestamp getOnDate() {
        return onDate;
    }

    public void setOnDate(Timestamp onDate) {
        this.onDate = onDate;
    }

    public String getCustomField() {
        return customField;
    }

    public BookState setCustomField(String customField) {
        this.customField = customField;
        return this;
    }
}
