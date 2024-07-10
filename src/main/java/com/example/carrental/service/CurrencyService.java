package com.example.carrental.service;

import com.example.carrental.controller.DTO.CurrencyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.TreeMap;

@Service
public class CurrencyService {

    private RestTemplate restTemplate;

    public CurrencyService() {
        this.restTemplate = new RestTemplate();
    }

    String url = "https://api.currencyapi.com/v3/latest?apikey=cur_live_ji8w7407dFjjZf3iof121LMtI3y8uyjHoPkjVsEF";

    public CurrencyDTO getCurrencyDTO () {
    return restTemplate.getForObject(url, CurrencyDTO.class);
    }

    public Double convertFromDollars (Double price, String currency) {
        TreeMap<String, CurrencyDTO.Currency> currencies = restTemplate.getForObject(url, CurrencyDTO.class).getData();
        CurrencyDTO.Currency currency1 = currencies.get(currency);
        return currency1.getValue() * price;
    }

    public Double getConvertRatio (String currency) {
        if (currency.isEmpty()) {
            return 1.0;
        }

        return convertFromDollars(1.0, currency);
    }


}
