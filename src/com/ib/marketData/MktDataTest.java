package com.ib.marketData;


import java.sql.SQLException;

public class MktDataTest {
    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
        Downloader down = new Downloader();
        down.requestMarketData();
    }
}
