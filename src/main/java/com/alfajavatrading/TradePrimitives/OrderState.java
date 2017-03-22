/*
 состояния ордера (TradeOrder)
 */
package com.alfajavatrading.TradePrimitives;

/**
 *
 * @author kulikov
 */
public enum OrderState {
    Placed, 
    Canceled, 
    Partial, 
    Filled, 
    Processing,
    Expired;
}
