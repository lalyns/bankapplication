package com.Trade;

import java.time.LocalDate;
import java.time.LocalTime;

public class Trade {
    
    public enum TradeType {
        Deposit,
        Withdraw
    }

    private LocalDate date;
    private LocalTime time;
    private String accountNumber;
    private TradeType tradeType;
    private int fee;
    private String bankName;
    
    // 생성자
    public Trade() {
    }

    public Trade(LocalDate date, LocalTime time, String accountNumber, TradeType tradeType, int fee, String bankName) {
        this.date = date;
        this.time = time;
        this.accountNumber = accountNumber;
        this.tradeType = tradeType;
        this.fee = fee;
        this.bankName = bankName;
    }

    // 메소드
    // 거래 내역 조회
    public Trade getTrade() {
        return this;
    }

    // 게터
    public LocalDate getDate() { return date; }
    public LocalTime getTime() { return time; }
    public String getAccountNumber() { return accountNumber; }
    public TradeType getTradeType() { return tradeType; }
    public int getFee() { return fee; }
    public String getBankName() { return bankName; }
    
}
