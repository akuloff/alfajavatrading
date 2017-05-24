package com.alfajavatrading.TradePrimitives;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kulikov on 28/12/2016.
 */
public class AbstractTradeInstrument implements Serializable{
  private BookState bookState = new BookState();
  private String name, code, description;
  private String systemId;
  private Date startDate, endDate;
  private double tickSize = 1;
  private double tickPrice = 1;

  public AbstractTradeInstrument(String name, String code, String descr) {
    this.name = name;
    this.code = code;
    this.description = descr;
  }

  public AbstractTradeInstrument(String name, String code) {
    this(name, code, null);
  }

  public AbstractTradeInstrument(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSystemId() {
    return systemId;
  }

  public void setSystemId(String systemId) {
    this.systemId = systemId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public double getTickSize() {
    return tickSize;
  }

  public AbstractTradeInstrument setTickSize(double tickSize) {
    this.tickSize = tickSize;
    return this;
  }

  public double getTickPrice() {
    return tickPrice;
  }

  public AbstractTradeInstrument setTickPrice(double tickPrice) {
    this.tickPrice = tickPrice;
    return this;
  }

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
