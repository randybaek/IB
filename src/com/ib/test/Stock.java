package com.ib.test;

import com.ib.client.Contract;

public class Stock {
    private int StockId;
    private String Symbol;

    public Stock(){}

    public Stock(int StockId, String Symbol) {
        this.StockId = StockId;
        this.Symbol = Symbol;
    }

    public int getStockId() {
        return StockId;
    }

    public String getSymbol() {
        return Symbol;
    }

    Contract contract = new Contract();
    public void createContract(String ticker){
        contract.symbol(ticker);
        contract.exchange("ARCA");
        contract.secType("STK");
        contract.currency("USD");
    }
}
