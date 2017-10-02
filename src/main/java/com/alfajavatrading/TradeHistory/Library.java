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
    if (tper.getPeriodMsec() > 0) {
      rval = new java.util.Date(bdate.getTime() + tper.getPeriodMsec());
    }
    return rval;
  }

}
