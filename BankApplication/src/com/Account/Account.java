package com.Account;

import java.util.ArrayList;
import java.util.List;

import com.Trade.Trade;

public class Account {
    // 멤버 변수
    String user;
    String accountNumber;
    int balance;
    List<Trade> trades;
    
    // 생성자
    public Account() {
        trades = new ArrayList<>();
    }
    
    // 매소드
    // 입금
    void deposit() {}
    
    // 출금
    void withdraw() {}

    // 잔고확인
    int checkBalance() { return this.balance; }
}
