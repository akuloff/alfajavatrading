package com.alfajavatrading.TradeHistory;

import com.alfajavatrading.TradePrimitives.TradePeriod;

/**
 * Created by kulikov on 23/03/2017.
 */
public class Library {
  /**
   * определяет дату завершения бара по дате начала и временному промежутку
   * @param bdate дата начала
   * @param tper  временной промежуток
   * @return дата окончания
   */
  public static java.util.Date getNextBarDate(java.util.Date bdate, TradePeriod tper){
    java.util.Date rval = null;
    if ( tper == TradePeriod.M1) {
      rval = new java.util.Date(bdate.getTime() + 60*1000);
    } else if ( tper == TradePeriod.M5) {
      rval = new java.util.Date(bdate.getTime() + 60*1000*5);
    } else if ( tper == TradePeriod.M10) {
      rval = new java.util.Date(bdate.getTime() + 60*1000*10);
    } else if ( tper == TradePeriod.M15) {
      rval = new java.util.Date(bdate.getTime() + 60*1000*15);
    } else if ( tper == TradePeriod.H1 ) {
      rval = new java.util.Date(bdate.getTime() + 60*1000*60);
    } else if ( tper == TradePeriod.D1 ) {
      rval = new java.util.Date(bdate.getTime() + 60*1000*60*24);
    } else if (tper == TradePeriod.W1 ) {
      rval = new java.util.Date(bdate.getTime() + 60*1000*60*24*7);
    }
    return rval;
  }
}
