package com.example.carrental.controller;

import com.example.carrental.controller.DTO.CurrencyDTO;
import com.example.carrental.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;


    @GetMapping("/get")
    public CurrencyDTO getCurrency(){
        return currencyService.getCurrencyDTO();
    }

    @GetMapping("/getsingle/price={price}/currency={currency}")
    public double convertToCurrency(@PathVariable Double price, @PathVariable String currency) {
        return currencyService.convertFromDollars(price, currency);
    }



}
