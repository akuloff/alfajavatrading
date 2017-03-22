/*
    стакан (состояние стакана заявок) по инструменту
 */

package com.alfajavatrading.TradePrimitives;

import java.sql.Timestamp;

/**
 *
 * @author kulikov
 */
public class BookState {
    private TradeInstrument instrument;
    private double bestAskPrice, bestBidPrice;
    private double bestAskVolume, bestBidVolume;
    private Timestamp onDate;
    private int bookSize = 1;
    private double[] askPricesArray; 
    private double[] askPricesVolumes; 
    private double[] bidPricesArray; 
    private double[] bidPricesVolumes;
    private String customField;

    public int getBookSize() {
        return bookSize;
    }

    public void setBookSize(int bookSize) {
        if ( bookSize > 0 && bookSize != this.bookSize ) {
            this.bookSize = bookSize;
            askPricesArray = askPricesVolumes = bidPricesArray = bidPricesVolumes = new double[bookSize];
        }    
    }

    public double[] getAskPricesArray() {
        return askPricesArray;
    }

    public double[] getAskPricesVolumes() {
        return askPricesVolumes;
    }

    public double[] getBidPricesArray() {
        return bidPricesArray;
    }

    public double[] getBidPricesVolumes() {
        return bidPricesVolumes;
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
