package com.example.carrental.controller.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@JsonIgnoreProperties
@Getter
@Setter
public class CurrencyDTO {

    public static class Currency {

        private String code;
        private Double value;

        public Currency(String code, Double value) {
            this.code = code;
            this.value = value;
        }

        public Currency() {
        }

        public String getCode() {
            return code;
        }

        public Double getValue() {
            return value;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setValue(Double value) {
            this.value = value;
        }
    }

        private TreeMap<String, Currency> data;


        public TreeMap<String, Currency> getData() {
            return data;
        }



        public void setData(TreeMap<String, Currency> data) {
            this.data = data;

        }


    public CurrencyDTO(TreeMap<String, Currency> data) {
        this.data = data;
    }

    public CurrencyDTO() {
    }
}
