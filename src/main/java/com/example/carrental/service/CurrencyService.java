package com.example.carrental.service;

import com.example.carrental.repository.model.Currency;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    private RestTemplate restTemplate;

    String url = "https://api.currencyapi.com/v3/latest?apikey=cur_live_ji8w7407dFjjZf3iof121LMtI3y8uyjHoPkjVsEF";

//    public Double convertCurrency (Double amount, Currency currency) {
//
//    }


}
