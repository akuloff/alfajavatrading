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
    private String name, code, description;
    private String systemId;
    private Date startDate, endDate;
    private double spreadInPoints = 0;
    private double pointValue = 1;

    public double getSpreadInPoints() {
        return spreadInPoints;
    }

    public TradeInstrument setSpreadInPoints(double spreadInPoints) {
        this.spreadInPoints = spreadInPoints;
        return this;
    }

    public double getPointValue() {
        return pointValue;
    }

    public TradeInstrument setPointValue(double pointValue) {
        this.pointValue = pointValue;
        return this;
    }

    public TradeInstrument(String name, String code) {
        this.name = name;
        this.code = code;
    }
    
    public TradeInstrument(String name, String code, String descr) {
        this.name = name;
        this.code = code;
        this.description = descr;
    }
    
    public TradeInstrument(String code) {
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
    
    
}
