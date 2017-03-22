package com.alfajavatrading.TradePrimitives;

/**
 * Created by mpoke_000 on 10.03.2017.
 */
public class BookChangeEvent {
    private String instrument;
    private boolean ask;
    private int position;
    private double price, volume;
    private int actionType; //0 - add, 1 -change, 2- delete

    public BookChangeEvent(String instrument, boolean ask, int position, double price, double volume, int actionType) {
        this.instrument = instrument;
        this.ask = ask;
        this.position = position;
        this.price = price;
        this.volume = volume;
        this.actionType = actionType;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public boolean isAsk() {
        return ask;
    }

    public void setAsk(boolean ask) {
        this.ask = ask;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "instrument: " + instrument + "|is_ask: " + ask + " |position: " + position + " |price: " + price + " |volume: " + volume + " |actionType: " + actionType;
    }
}
