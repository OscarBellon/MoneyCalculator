package model;

public class Model {
    CurrencySet currencies;
    Money moneyOrigen,moneyDestino;
    Double rate=1.0;
    public Model(){
        moneyOrigen = new Money();
        moneyDestino = new Money();
        
    }

    public void setCurrencies(CurrencySet currencies) {
        this.currencies = currencies;
    }

    public Money getMoneyOrigen() {
        return moneyOrigen;
    }

    public Money getMoneyDestino() {
        return moneyDestino;
    }


    public void setMoneyOrigen(Money moneyOrigen) {
        this.moneyOrigen = moneyOrigen;
    }

    public void setMoneyDestino(Money moneyDestino) {
        this.moneyDestino = moneyDestino;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public CurrencySet getCurrencies() {
        return currencies;
    }
    
    
    
    
}
