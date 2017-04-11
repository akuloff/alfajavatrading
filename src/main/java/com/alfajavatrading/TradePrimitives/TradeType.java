/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfajavatrading.TradePrimitives;

import java.io.Serializable;

/**
 *
 * @author kulikov
 */
public enum TradeType{
    Buy, Sell;

    public TradeType opposite(){
        switch(this){
            case Buy:
                return TradeType.Sell;
            case Sell:
                return TradeType.Buy;
        }
        return null;
    }
}
