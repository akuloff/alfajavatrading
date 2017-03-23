/*
   период торговлки (для бара/графика)
 */
package com.alfajavatrading.TradePrimitives;

/**
 *
 * @author kulikov
 */
public enum TradePeriod {
    BOOK("book"),
    M1("m1"),
    M5("m5"),
    M10("m10"),
    M15("m15"),
    M30("m30"),
    H1("h1"),
    D1("d1"),
    W1("w1");

    private String textName;

    TradePeriod(String textName){
        this.textName = textName;
    }

    public String getTextName(){
        return this.textName;
    }

    public static TradePeriod fromString(String textName) {
        for (TradePeriod t : TradePeriod.values()) {
            if (t.textName.equalsIgnoreCase(textName)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No constant with text " + textName + " found");
    }
}

