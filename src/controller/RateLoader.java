package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RateLoader {
    public static double loader(String origen,String destino) throws MalformedURLException, IOException{
        URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/"
                + "currency-api@1/latest/currencies/"+origen+"/"+destino+".json");
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while((line = bf.readLine())!= null){
            if(line.contains(destino)){
                String[] sep = line.split(":");
                return Double.parseDouble(sep[1]);
            }
        }
        return 0;
    }
}
