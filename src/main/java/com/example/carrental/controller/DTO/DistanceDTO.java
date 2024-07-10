package com.example.carrental.controller.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties
public class DistanceDTO {

    private Rows[] rows;

    public DistanceDTO(Rows[] rows) {
        this.rows = rows;
    }

    public DistanceDTO() {
    }

    public Rows[] getRows() {
        return rows;
    }

    public void setRows(Rows[] rows) {
        this.rows = rows;
    }

    public static class Rows {

        private Elements[] elements;

        public Rows(Elements[] elements) {
            this.elements = elements;
        }

        public Rows() {
        }

        public Elements[] getElements() {
            return elements;
        }

        public void setElements(Elements[] elements) {
            this.elements = elements;
        }

        public static class Elements {

            private Distance distance;

            public Elements(Distance distance) {
                this.distance = distance;
            }

            public Distance getDistance() {
                return distance;
            }

            public Elements(){
            }

            public void setDistance(Distance distance) {
                this.distance = distance;
            }

            public static class Distance {
                private String text;
                private int value;

                public String getText() {
                    return text;
                }

                public int getValue() {
                    return value;
                }

                public Distance(String text, int value) {
                    this.text = text;
                    this.value = value;
                }

                public Distance() {
                }

                public void setText(String text) {
                    this.text = text;
                }

                public void setValue(int value) {
                    this.value = value;
                }
            }
        }
    }

}
