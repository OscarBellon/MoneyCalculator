package model;

public class Money {
    private double ammount;
    private Currency currency;

    public Money(double ammount, Currency currency) {
        this.ammount = ammount;
        this.currency = currency;
    }

    Money() {
        this.currency = new Currency();
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getAmmount() {
        return ammount;
    }
    
    
    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    

}
