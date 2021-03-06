/*
    для отслеживания созданного ордера (поставленной заявки) на торговой площадке
 */
package com.alfajavatrading.TradePrimitives;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author kulikov
 */
public class TradeOrder implements Serializable{
    private TradeInstrument instrument;
    private TradeType tradeType;
    private OrderType orderType;
    private OrderState orderState;
    private String orderId;
    private Timestamp createDate;
    private Timestamp placedDate;
    private Timestamp completeDate;
    private String customField;
    private double amount, price, slPrice, tpPrice, executedAmount = 0;
    private TradeOrder linkedOrder;
    private String clientOrderId;
    private double executedPrice;

    public TradeOrder(TradeInstrument instrument, OrderType orderType, TradeType tradeType, double price, double amount, Timestamp createDate) {
        this.instrument = instrument;
        this.tradeType = tradeType;
        this.createDate = createDate;
        this.orderType = orderType;
        this.price = price;
        this.amount = amount;
        this.orderState = OrderState.Processing;
    }

    public TradeInstrument getInstrument() {
        return instrument;
    }

    public TradeOrder setInstrument(TradeInstrument instrument) {
        this.instrument = instrument;
        return this;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public TradeOrder setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
        return this;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public TradeOrder setOrderType(OrderType orderType) {
        this.orderType = orderType;
        return this;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public TradeOrder setOrderState(OrderState orderState) {
        this.orderState = orderState;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public TradeOrder setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public TradeOrder setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
        return this;
    }

    public Timestamp getCompleteDate() {
        return completeDate;
    }

    public TradeOrder setCompleteDate(Timestamp completeDate) {
        this.completeDate = completeDate;
        return this;
    }

    public String getCustomField() {
        return customField;
    }

    public TradeOrder setCustomField(String customField) {
        this.customField = customField;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public TradeOrder setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public TradeOrder setPrice(double price) {
        this.price = price;
        return this;
    }

    public double getSlPrice() {
        return slPrice;
    }

    public TradeOrder setSlPrice(double slPrice) {
        this.slPrice = slPrice;
        return this;
    }

    public double getTpPrice() {
        return tpPrice;
    }

    public TradeOrder setTpPrice(double tpPrice) {
        this.tpPrice = tpPrice;
        return this;
    }

    public TradeOrder getLinkedOrder() {
        return linkedOrder;
    }

    public TradeOrder setLinkedOrder(TradeOrder linkedOrder) {
        this.linkedOrder = linkedOrder;
        return this;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public TradeOrder setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
        return this;
    }

    public double getExecutedAmount() {
        return executedAmount;
    }

    public TradeOrder setExecutedAmount(double executedAmount) {
        this.executedAmount = executedAmount;
        return this;
    }

    public double getExecutedPrice() {
        return executedPrice;
    }

    public TradeOrder setExecutedPrice(double executedPrice) {
        this.executedPrice = executedPrice;
        return this;
    }

    public Timestamp getPlacedDate() {
        return placedDate;
    }

    public TradeOrder setPlacedDate(Timestamp placedDate) {
        this.placedDate = placedDate;
        return this;
    }
}
