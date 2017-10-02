/*
   период торговлки (для бара/графика)
 */
package com.alfajavatrading.TradePrimitives;

/**
 *
 * @author kulikov
 */
public enum TradePeriod {
    BOOK(0),
    M1(60*1000),
    M5(60*1000*5),
    M10(60*1000*10),
    M15(60*1000*15),
    M30(60*1000*30),
    H1(60*1000*60),
    D1(60*1000*60*24),
    W1(60*1000*60*24*7);

    private long periodMsec;

    TradePeriod(long periodMsec){
        this.periodMsec = periodMsec;
    }

    public long getPeriodMsec() {
        return periodMsec;
    }

    public static TradePeriod fromString(String textName) {
        for (TradePeriod t : TradePeriod.values()) {
            if (t.name().equalsIgnoreCase(textName)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No constant with text " + textName + " found");
    }
}

