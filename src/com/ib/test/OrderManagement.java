package com.ib.test;

import com.ib.client.*;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Set;

class OrderManagement extends Thread implements EWrapper {
    private EClientSocket client = null; // IB API client socket object
    private Stock stock = new Stock();
    private Order order = new Order();
    private int orderId;
    private double limitprice;
    private String Ticker;

    public OrderManagement() throws InterruptedException, SQLException, ClassNotFoundException {
        // create a new eclientSocket object
        System.out.println("//////////////////////////// Creating a connection //////////////////////");
        EJavaSignal m_signal = new EJavaSignal();    // what's this?
        client = new EClientSocket(this, m_signal);      // creation of a socket to connect
        // connect to the TWS demo
        client.eConnect("localhost", 7498, 0);
        // 7497 - paper trading account

        // Pause here for connection to complete
        try {
            Thread.sleep(3000); // It waits 3 seconds for the user to accept
            while(!(client.isConnected()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("///////////////////////// Connected //////////////////");
    }

    public void sendMarketOrder(String Ticker, String buyerSell) throws SQLException, ClassNotFoundException {
        // New order ID
        orderId++;
        order.action(buyerSell);
        order.orderId(orderId);
        order.orderType("MKT");
        order.totalQuantity(100);
        order.account("U2201501");  // my account
        order.clientId(2);

        // create a new contract
        stock.createContract(Ticker);
        client.placeOrder(orderId, stock.contract, order);
        // show the order in the console
        SimpleDateFormat time_formatter = new SimpleDateFormat("HH:mm:ss");
        String current_time_str = time_formatter.format(System.currentTimeMillis());
        System.out.println("///////////////////////////////////////\n" +
                "#Limit Price: " + order.lmtPrice() + "/////////\n" +
                "#Client id: " + order.clientId() + "/////////\n" +
                "#Order type: " + order.orderType() + "/////////\n" +
                "#Order id: " + order.orderId() + "/////////\n" +
                "#Order action: " + order.action() + "/////////\n" +
                "#Order Quantity: " + order.totalQuantity() + "/////////\n" +
                "#Account Number: " + order.account() + "/////////\n" +
                "#Symbol:  " + stock.contract.symbol() + "/////////\n"
        );
    }

    @Override public void nextValidId(int orderId) {

    }

    @Override public void error(Exception e) {
    }

    @Override public void error(int id, int errorCode, String errorMsg) {
    }

    @Override public void connectionClosed() {
    }

    @Override public void error(String str) {
    }

    @Override public void tickPrice(int tickerId, int field, double price, int canAutoExecute) {
    }

    @Override public void tickSize(int tickerId, int field, int size) {
    }

    @Override public void tickOptionComputation(int tickerId, int field, double impliedVol, double delta, double optPrice, double pvDividend, double gamma, double vega, double theta, double undPrice) {
    }

    @Override public void tickGeneric(int tickerId, int tickType, double value) {
    }

    @Override public void tickString(int tickerId, int tickType, String value) {
    }

    @Override public void tickEFP(int tickerId, int tickType, double basisPoints, String formattedBasisPoints, double impliedFuture, int holdDays, String futureLastTradeDate, double dividendImpact,
                                  double dividendsToLastTradeDate) {
    }

    @Override public void orderStatus(int orderId, String status, double filled, double remaining, double avgFillPrice, int permId, int parentId, double lastFillPrice, int clientId, String whyHeld) {
    }

    @Override public void openOrder(int orderId, Contract contract, Order order, OrderState orderState) {
    }

    @Override public void openOrderEnd() {
    }

    @Override public void updateAccountValue(String key, String value, String currency, String accountName) {
    }

    @Override public void updatePortfolio(Contract contract, double position, double marketPrice, double marketValue, double averageCost, double unrealizedPNL, double realizedPNL, String accountName) {
    }

    @Override public void updateAccountTime(String timeStamp) {
    }

    @Override public void accountDownloadEnd(String accountName) {
    }

    @Override public void contractDetails(int reqId, ContractDetails contractDetails) {
    }

    @Override public void bondContractDetails(int reqId, ContractDetails contractDetails) {
    }

    @Override public void contractDetailsEnd(int reqId) {
    }

    @Override public void execDetails(int reqId, Contract contract, Execution execution) {
    }

    @Override public void execDetailsEnd(int reqId) {
    }

    @Override public void updateMktDepth(int tickerId, int position, int operation, int side, double price, int size) {
    }

    @Override public void updateMktDepthL2(int tickerId, int position, String marketMaker, int operation, int side, double price, int size) {
    }

    @Override public void updateNewsBulletin(int msgId, int msgType, String message, String origExchange) {
    }

    @Override public void managedAccounts(String accountsList) {
    }

    @Override public void receiveFA(int faDataType, String xml) {
    }

    @Override public void historicalData(int reqId, String date, double open, double high, double low, double close, int volume, int count, double WAP, boolean hasGaps) {
    }

    @Override public void scannerParameters(String xml) {
    }

    @Override public void scannerData(int reqId, int rank, ContractDetails contractDetails, String distance, String benchmark, String projection, String legsStr) {
    }

    @Override public void scannerDataEnd(int reqId) {
    }

    @Override public void realtimeBar(int reqId, long time, double open, double high, double low, double close, long volume, double wap, int count) {
    }

    @Override public void currentTime(long time) {
    }

    @Override public void fundamentalData(int reqId, String data) {
    }

    @Override public void deltaNeutralValidation(int reqId, DeltaNeutralContract underComp) {
    }

    @Override public void tickSnapshotEnd(int reqId) {
    }

    @Override public void marketDataType(int reqId, int marketDataType) {
    }

    @Override public void commissionReport(CommissionReport commissionReport) {
    }

    @Override public void position(String account, Contract contract, double pos, double avgCost) {
    }

    @Override public void positionEnd() {
    }

    @Override public void accountSummary(int reqId, String account, String tag, String value, String currency) {
    }

    @Override public void accountSummaryEnd(int reqId) {
    }

    @Override public void verifyMessageAPI( String apiData) {
    }

    @Override public void verifyCompleted( boolean isSuccessful, String errorText){
    }

    @Override public void verifyAndAuthMessageAPI( String apiData, String xyzChallenge) {
    }

    @Override public void verifyAndAuthCompleted( boolean isSuccessful, String errorText){
    }

    @Override public void displayGroupList( int reqId, String groups){
    }

    @Override public void displayGroupUpdated( int reqId, String contractInfo){
    }

    @Override public void positionMulti( int reqId, String account, String modelCode, Contract contract, double pos, double avgCost) {
    }

    @Override public void positionMultiEnd( int reqId) {
    }

    @Override public void accountUpdateMulti( int reqId, String account, String modelCode, String key, String value, String currency) {
    }

    @Override public void accountUpdateMultiEnd( int reqId) {
    }

    public void connectAck() {
    }

    @Override
    public void securityDefinitionOptionalParameter(int reqId, String exchange, int underlyingConId, String tradingClass,
                                                    String multiplier, Set<String> expirations, Set<Double> strikes) {
        System.out.print(reqId + ", " + exchange + ", " + underlyingConId + ", " + tradingClass + ", " + multiplier);

        for (String exp : expirations) {
            System.out.print(", " + exp);
        }

        for (double strk : strikes) {
            System.out.print(", " + strk);
        }

        System.out.println();
    }

    @Override
    public void securityDefinitionOptionalParameterEnd(int reqId) {
        System.out.println("done");
    }

    @Override
    public void softDollarTiers(int reqId, SoftDollarTier[] tiers) {
    }
}
