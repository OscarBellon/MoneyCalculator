package main;

import java.io.IOException;
import model.Model;
import view.CurrencyLoader;
import view.View;

public class Main {

    public static void main(String[] args) throws IOException {
        Model modelo = new Model();
        modelo.setCurrencies(CurrencyLoader.Load("currencies.txt"));
        View view = new View(modelo);
    }
    
}
