package com.alfajavatrading.TradePrimitives;


import com.alfajavatrading.TradeHistory.Library;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kulikov
 */
public class HistoryBar {
    private TradeInstrument instrument;
    
    //тип double имеет проблемы с точным вычислением, он используется только для оптимизации хранения и скорости обработки баров,
    //для точных вычислений использовать нельзя - необходимо переводить при вычислении в BigDecimal
    private double openPrice = 0, lowPrice = 0, highPrice = 0, closePrice = 0;
    
    private long value = 0;
    private Date openDate = null, closeDate = null;
    private String customField = null;
    private ArrayList<HistoryTick> ticksArray = new ArrayList<>(); //массив тиков
    private boolean isArtificial = false;

    public TradeInstrument getInstrument() {
        return instrument;
    }

    public HistoryBar setInstrument(TradeInstrument instrument) {
        this.instrument = instrument;
        return this;
    }

    public ArrayList getTicksArray() {
        return ticksArray;
    }

    public String getCustomField() {
        return customField;
    }

    public HistoryBar setCustomField(String customField) {
        this.customField = customField;
        return this;
    }

    public HistoryBar(TradeInstrument instrument, Date odate) {
        this.instrument = instrument;
        this.openDate = odate;
    }

    public HistoryBar(Date odate) {
        this.openDate = odate;
    }

    public HistoryBar(Date odate, Date cdate) {
        this.openDate = odate;
        this.closeDate = cdate;
    }

    public HistoryBar(Date odate, Date cdate, double close_price) {
        this.openDate = odate;
        this.closeDate = cdate;
        this.closePrice = close_price;
    }

    public HistoryBar(Date odate, TradePeriod period, double open, double low, double high, double close, long value){
        this.openDate = odate;
        this.closeDate = Library.getNextBarDate(odate, period);
        this.openPrice = open;
        this.lowPrice = low;
        this.highPrice = high;
        this.closePrice = close;
        this.value = value;
    }
    
    public HistoryBar(HistoryBar from_bar) {
        this.openDate = from_bar.getOpenDate();
        this.closeDate = from_bar.getOpenDate();
        this.openPrice = from_bar.getOpenPrice();
        this.highPrice = from_bar.getHighPrice();
        this.lowPrice = from_bar.getLowPrice();
        this.closePrice = from_bar.getClosePrice();
        this.value = from_bar.getValue();
    }
    
    /**
     * вставка нового тика в бар
     * 
     * @param newTick
     * @throws TradeHistoryException 
     */
    public void addTick(HistoryTick newTick, boolean storeTicks) throws TradeHistoryException {
        HistoryTick lastTick;
        double tp;
        
        tp = newTick.getPrice();
        
        //проверка на вхождение тика в даты бара
        if (this.closeDate != null ) {
            if (newTick.getDate().after(this.closeDate) ) {
                throw new TradeHistoryException("New tick date is out of bar dates, tick date: " + newTick.getDate() + " |closeDate: " + closeDate);
            }
        }
        
        if (this.openDate != null ) {
            if (newTick.getDate().before(this.openDate) ) {
                throw new TradeHistoryException("New tick date is out of bar dates, tick date: " + newTick.getDate() + " |openDate: " + this.openDate);
            }
        }
        
        
        if (ticksArray.size() > 0) {
            lastTick = (HistoryTick) ticksArray.get(ticksArray.size() - 1);
            if( newTick.getDate().before(lastTick.getDate()) ) {
                throw new TradeHistoryException("New tick date must be after last tick, newtick.date: " + newTick.getDate() + " |lastTick date: " + lastTick.getDate());
            }
        }

        if ( this.openPrice == 0 ) {
            openPrice = tp;
        }
        
        if ( tp < lowPrice || lowPrice == 0 ) {
            lowPrice = tp;
        }

        if( tp > highPrice ) {
            highPrice = tp;
        }

        closePrice = tp;

        if (storeTicks) {
            this.ticksArray.add(newTick);
        }

        this.value += newTick.getAmount();
    }

    public void addTick(HistoryTick newTick) throws TradeHistoryException {
        addTick(newTick, true);
    }

    
    public long getValue() {
        return value;
    }

    public HistoryBar setValue(long value) {
        this.value = value;
        return this;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public HistoryBar setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
        return this;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public HistoryBar setHighPrice(double highPrice) {
        this.highPrice = highPrice;
        return this;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public HistoryBar setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
        return this;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public HistoryBar setClosePrice(double closePrice) {
        this.closePrice = closePrice;
        return this;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public HistoryBar setOpenDate(Date OpenDate) {
        this.openDate = OpenDate;
        return this;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public HistoryBar setCloseDate(Date CloseDate) {
        this.closeDate = CloseDate;
        return this;
    }

    public boolean isArtificial() {
        return isArtificial;
    }

    public HistoryBar setArtificial(boolean artificial) {
        isArtificial = artificial;
        return this;
    }
}
