package com.alfajavatrading.TradeEnvironment;

import com.alfajavatrading.TradePrimitives.BookState;
import com.alfajavatrading.TradePrimitives.TradeInstrument;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mpoke_000 on 11.03.2017.
 */
public class TradeInstrumentsCollector {
    HashMap<String, TradeInstrument> instruments = new HashMap<>();
    HashMap<String, TradeInstrument> instruments_ids = new HashMap<>();
    HashMap<String, BookState> bookStatesForInstrument = new HashMap<>();
    private boolean isLocked = false;
    private boolean alwaysUpdateInstrument = false;

    public HashMap<String, TradeInstrument> getInstruments() {
        return instruments;
    }

    public TradeInstrument getInstrument(String code){
        TradeInstrument rval = null;
        if ( instruments.containsKey(code) ) {
            rval = instruments.get(code);
        }
        return rval;
    }

    /**
     * получение инструмента по id (system_id)
     * @param id_code
     * @return
     */
    public TradeInstrument getInstrumentFromId(String id_code){
        TradeInstrument rval = null;
        if ( instruments_ids.containsKey(id_code) ) {
            rval = instruments_ids.get(id_code);
        }

        return rval;
    }


    public synchronized boolean putInstrument(TradeInstrument instr){
        if (alwaysUpdateInstrument || !instruments.containsKey(instr.getCode())) {
            instruments.put(instr.getCode(), instr);
            instruments_ids.put(instr.getSystemId(), instr);
        }
        return true;
    }


    public HashMap<String, BookState> getBookStatesForInstrument() {
        return bookStatesForInstrument;
    }

    public BookState getBookStateForInstrumentSystemId(String systemId) {
        return bookStatesForInstrument.get(systemId);
    }


    public void initBookStates(int bookSize){
        bookStatesForInstrument.clear();
        for (Map.Entry<String, TradeInstrument> entry : instruments.entrySet()) {
            TradeInstrument instrument = entry.getValue();
            System.out.println("instrument, system_id: " + instrument.getSystemId() + " |code: " + instrument.getCode() + " |description: " + instrument.getDescription());
            BookState bookState = new BookState();
            bookState.setBookSize(bookSize);
            bookStatesForInstrument.put(instrument.getSystemId(), bookState);
        }
        System.out.println("------------------------");
    }

    public synchronized boolean isLocked() {
        return isLocked;
    }

    public synchronized TradeInstrumentsCollector setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }
}
