package model;

import java.util.HashMap;
import java.util.Map;

public class CurrencySet {
    private Map<String,Currency> currencySet = new HashMap<>();


    public Map<String,Currency> getCurrencySet() {
        return currencySet;
    }
    
    public String[] getCurrenciesNames(){
        return getCurrencySet().keySet().toArray(new String[0]);
    }
    
    public void addCurrency(Currency currency){
        currencySet.put(currency.getCurrencyName(),currency);
    }
    
}
