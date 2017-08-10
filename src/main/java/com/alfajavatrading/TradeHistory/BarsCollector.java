/*
   для хранения набора баров (для графика, анализа) 
 */
package com.alfajavatrading.TradeHistory;

import com.alfajavatrading.TradePrimitives.HistoryBar;
import com.alfajavatrading.TradePrimitives.TradeHistoryException;
import com.alfajavatrading.TradePrimitives.TradeInstrument;
import com.alfajavatrading.TradePrimitives.TradePeriod;

import java.util.ArrayList;

/**
 *
 * @author kulikov
 */
public class BarsCollector {
    private TradeInstrument instrument;
    private ArrayList<HistoryBar> barsArray = new ArrayList<>();
    private TradePeriod period = null;
    private ArrayList<BarsCollector> normalizedWith = new ArrayList<>();

    private double multiplyCoeff = 1;
    
    public double getMultCoeff() {
        return multiplyCoeff;
    }

    public ArrayList<BarsCollector> getNormalizedWith() {
        return normalizedWith;
    }

    /**
     * определяет факт наличия записей за указанный период
     * @param startDate
     * @param endDate
     * @return 
     */
    public boolean isContainsPeriod(java.util.Date startDate, java.util.Date endDate){
        boolean rval = false;
        int arsize;
        arsize = barsArray.size();
        if ( arsize > 0) {
            rval = ((HistoryBar)barsArray.get(0)).getOpenDate().before(startDate) && ((HistoryBar)barsArray.get(arsize - 1)).getCloseDate().after(endDate);
        }
        return rval;
    }
    
    
    public void emptyCollector(){
        this.barsArray.clear();
    }
    
    public BarsCollector() {
        this.period = TradePeriod.M1;
    }
    
    public BarsCollector(TradePeriod p) {
        this.period = p;
    }

    public BarsCollector(TradeInstrument instrument, TradePeriod p) {
        this.instrument = instrument;
        this.period = p;
    }

    private void copyFrom(BarsCollector from, boolean copy_array){
        int i;
        this.instrument = from.getInstrument();
        this.period = from.period;
        if ( copy_array ) {
            this.barsArray.clear();
            for(i=0; i<from.getBarsArray().size(); i++) {
                this.barsArray.add(new HistoryBar(from.getBar(i)));
            }
        }    
    }
    
    public BarsCollector(BarsCollector from, boolean copy_array){
        copyFrom(from, copy_array);
    }
    
    public BarsCollector(BarsCollector from){
        copyFrom(from, true);
    }    
    
    public TradePeriod getPeriod() {
        return period;
    }

    public void setPeriod(TradePeriod period) throws TradeHistoryException {
        if ( this.period != null ) {
             throw new TradeHistoryException("period for this collector already selected");
        } else {   
            this.period = period;
        }
    }

    public TradeInstrument getInstrument() {
        return instrument;
    }

    public void setInstrument(TradeInstrument ins) {
        this.instrument = ins;
    }

    public ArrayList<HistoryBar> getBarsArray() {
        return barsArray;
    }

    public void setBarsArray(ArrayList barsArray) {
        this.barsArray = barsArray;
    }
    
    
    public BarsCollector multiply(double multiplier){
        int i;
        HistoryBar br;
        
        for (i=0; i<getBarsArray().size(); i++) {
            br = getBar(i);
            br.setClosePrice(br.getClosePrice()*(float)multiplier);
            br.setOpenPrice(br.getOpenPrice()*(float)multiplier);
            br.setHighPrice(br.getHighPrice()*(float)multiplier);
            br.setLowPrice(br.getLowPrice()*(float)multiplier);
        }
        
        this.multiplyCoeff = multiplier;
        return this;
    }
    
    public void addNewBar(HistoryBar newbar, boolean checkContains){
        boolean do_flag = true;
        if ( checkContains) {
            if (barsArray.contains(newbar)) {
                do_flag = false;
            }
        }
        
        if ( do_flag ) {
            this.barsArray.add(newbar);
        }    
    }
    
    public void addNewBar(HistoryBar newbar){
        addNewBar(newbar, true);
    }
    
    
    public HistoryBar getBar(int i){
        return (HistoryBar)barsArray.get(i);
    }

}
