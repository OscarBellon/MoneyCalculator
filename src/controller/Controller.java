package controller;

import java.io.IOException;
import model.Model;

public class Controller {
    
    Model model;

    public Controller(Model model) {
        this.model = model;
    }
    public void updateOrigin(String origen) throws IOException {
        model.getMoneyOrigen().setCurrency(model.getCurrencies().getCurrencySet().get(origen));
        
    }

    public void updateDestiny(String destino) throws IOException {
        model.getMoneyDestino().setCurrency(model.getCurrencies().getCurrencySet().get(destino));
        
    }

    public void updateMoneyOriginAmmount(String ammount) {
        if(!ammount.equals("")){
            model.getMoneyOrigen().setAmmount(Double.parseDouble(ammount));
        }else{
            model.getMoneyOrigen().setAmmount(0.0);
        }
    }

    public void updateRate() throws IOException {
        model.setRate(RateLoader.loader(model.getMoneyOrigen().getCurrency().
                getCurrencyCode().toLowerCase(),
                model.getMoneyDestino().getCurrency().
                        getCurrencyCode().toLowerCase()));
    }
    
    public void updateMoneyDestinyAmmount(){
        double temp = model.getMoneyOrigen().getAmmount();
        model.getMoneyDestino().setAmmount(temp * model.getRate());
    }
    
}
