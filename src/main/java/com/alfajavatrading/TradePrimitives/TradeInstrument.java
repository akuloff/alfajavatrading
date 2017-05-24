/*
 Описание торгуемого инструмента   
 */

package com.alfajavatrading.TradePrimitives;

import java.util.Date;

/**
 *
 * @author kulikov
 */
public class TradeInstrument extends AbstractTradeInstrument{
    private double spreadInPoints = 0;

    public double getSpreadInPoints() {
        return spreadInPoints;
    }

    public TradeInstrument setSpreadInPoints(double spreadInPoints) {
        this.spreadInPoints = spreadInPoints;
        return this;
    }


    public TradeInstrument(String name, String code) {
        super(name, code);
    }
    
    public TradeInstrument(String name, String code, String descr) {
        super(name, code, descr);
    }

}
