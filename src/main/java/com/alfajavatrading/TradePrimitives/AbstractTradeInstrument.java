package com.alfajavatrading.TradePrimitives;

/**
 * Created by kulikov on 28/12/2016.
 */
public class AbstractTradeInstrument {
  private BookState bookState = new BookState();

  /**
   * проверка спреда на адекватность
   * @param ask
   * @param bid
   * @param onDate
   * @return
   */
  public boolean checkSpread(double ask, double bid, java.sql.Timestamp onDate){
    return (ask >0 && bid > 0 && (ask > bid));
  }

  public BookState getBookState() {
    return bookState;
  }
}
