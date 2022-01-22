package view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import model.Currency;
import model.CurrencySet;

public class CurrencyLoader {
    public static CurrencySet Load(String file) throws FileNotFoundException, IOException{
        CurrencySet currencies = new CurrencySet();
        FileReader lector = new FileReader(file);
        BufferedReader bf = new BufferedReader(lector);
        String linea;
        while((linea = bf.readLine())!=null){
            String[] sep= linea.split(",");
            currencies.addCurrency(new Currency(sep[0],sep[1],sep[2]));
        }
        return currencies;
    }
}
