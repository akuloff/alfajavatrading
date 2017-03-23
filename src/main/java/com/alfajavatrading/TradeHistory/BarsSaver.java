/*
    Непосредственно осуществляет сбор данных в коллектор баров
 */
package com.alfajavatrading.TradeHistory;

import com.alfajavatrading.TradePrimitives.HistoryBar;
import com.alfajavatrading.TradePrimitives.HistoryTick;
import com.alfajavatrading.TradePrimitives.TradeHistoryException;
import com.alfajavatrading.TradePrimitives.TradePeriod;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author kulikov
 */
public class BarsSaver {
    private BarsCollector collector = new BarsCollector(TradePeriod.M1);
    private HistoryBar barForInsert = null; //бар для промежуточного накопления тиков
    private Calendar cal = Calendar.getInstance();
    private boolean fillGaps = true; //создавать промежуточные бары, там где не было тиков (заполняется барами с OHLC как последняя известная цена закрытия)
    private boolean storeAllTicks = true;

    public boolean isStoreAllTicks() {
        return storeAllTicks;
    }

    public BarsSaver setStoreAllTicks(boolean storeAllTicks) {
        this.storeAllTicks = storeAllTicks;
        return this;
    }

    public boolean isFillGaps() {
        return fillGaps;
    }

    public BarsSaver setFillGaps(boolean fillGaps) {
        this.fillGaps = fillGaps;
        return this;
    }

    public BarsSaver(BarsCollector collector) {
        this.collector = collector;
    }

    /**
     * добавление нового бара
     * @param newbar 
     */
    public void addNewBar(HistoryBar newbar){
        if (collector.getBarsArray().size() == 0 || !collector.getBarsArray().contains(newbar)) {
            collector.getBarsArray().add(newbar);
        }
    }


    private java.util.Date getBarBeginDate(java.util.Date tdate) {
        TradePeriod cper = collector.getPeriod();
        java.util.Date bdate = null;
        if ( cper == TradePeriod.M1 || cper == TradePeriod.M5 || cper == TradePeriod.M10 ) {
            bdate = DateUtils.truncate(tdate, Calendar.MINUTE);
        } else if ( cper == TradePeriod.H1 ) {
            bdate = DateUtils.truncate(tdate, Calendar.HOUR);
        } else if ( cper == TradePeriod.D1 ) {
            bdate = DateUtils.truncate(tdate, Calendar.DATE);
        } else if (cper == TradePeriod.W1 ) {
            cal.setTime(tdate);
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
            bdate = DateUtils.truncate(cal.getTime(), Calendar.WEEK_OF_YEAR);
        }
        return bdate;
    }
    
    /**
     * принимает новый тик в коллектор
     * @param newtick 
     */
    public void addNewTick(HistoryTick newtick) throws TradeHistoryException {
        java.util.Date bdate = null, edate = null, tdate;
        tdate = newtick.getDate();
        java.util.Date oneStepForward;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (barForInsert == null || tdate.compareTo(barForInsert.getCloseDate()) >= 0) {
            if (fillGaps) {
                if (barForInsert != null) {
                    java.util.Date barCloseDate = barForInsert.getCloseDate();
                    while (tdate.compareTo(barCloseDate) > 0) {
                        this.addNewBar(barForInsert); //добавление сформированного бара
                        double lastPrice = barForInsert.getClosePrice();
                        oneStepForward = Library.getNextBarDate(barCloseDate, collector.getPeriod());
                        barForInsert = new HistoryBar(barCloseDate, oneStepForward);
                        barForInsert.setOpenPrice(lastPrice);
                        barForInsert.setLowPrice(lastPrice);
                        barForInsert.setHighPrice(lastPrice);
                        barForInsert.setClosePrice(lastPrice);
                        barCloseDate = oneStepForward;
                    }
                } else {
                    //могут быть пробелы в тиках (больше чем промежуток бара), поэтому время нужно всегда инициализировать от тика
                    barForInsert = new HistoryBar(bdate = getBarBeginDate(tdate), edate = Library.getNextBarDate(bdate, collector.getPeriod()));
                }
            } else {
                if (barForInsert != null) this.addNewBar(barForInsert); //добавление сформированного бара
                //могут быть пробелы в тиках (больше чем промежуток бара), поэтому время нужно всегда инициализировать от тика
                barForInsert = new HistoryBar(bdate = getBarBeginDate(tdate), edate = Library.getNextBarDate(bdate, collector.getPeriod()));
            }
        }

        if (barForInsert != null) {
            barForInsert.addTick(newtick, storeAllTicks);
        }
    }
    
    public BarsCollector getCollector() {
        return collector;
    }

    public BarsSaver setCollector(BarsCollector collector) {
        this.collector = collector;
        return this;
    }
    
    public HistoryBar getCurrentBar(){
        return barForInsert;
    }
    
}
