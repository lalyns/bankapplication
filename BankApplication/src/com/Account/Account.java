package com.Account;

import java.util.ArrayList;
import java.util.List;

import com.Trade.Trade;

public class Account {
    // 멤버 변수
    private String user;
    private String accountNumber;
    private int balance;
    private String bankName;
    private List<Trade> trades;

    // 생성자
    public Account() {
    }

    
    public Account(String user, String accountNumber, int balance, String bankName, String tradePath) {
        this.user           = user;
        this.accountNumber  = accountNumber;
        this.balance        = balance;
        this.bankName       = bankName;
        trades = new ArrayList<>();
    }


    
    // 매소드
    // 입금
    void deposit() {}
    
    // 출금
    void withdraw() {}

    // 잔고확인
    public String getUser() { return user; }
    public String getAccountNumber() { return accountNumber; }
    public int getBalance() { return balance; }
    public List<Trade> getTrades() { return trades; }
    public String getBankName() { return bankName; }
    
}
