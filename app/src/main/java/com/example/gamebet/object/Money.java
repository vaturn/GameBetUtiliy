package com.example.gamebet.object;

public class Money {
    private int money;

    public Money() {
    }

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int money){
        this.money += money;
    }

    public int withdrawMoney(int money){
        if(this.money < money)
            return -1;

        this.money -= money;
        return 0;
    }
}
