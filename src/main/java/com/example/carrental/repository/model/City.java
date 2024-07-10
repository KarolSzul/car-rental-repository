package com.example.carrental.repository.model;

public enum City {

    WROCLAW (51.107883, 17.038538),
    WARSAW (52.237049, 21.017532),
    BERLIN(52.520008, 13.404954),
    KRAKOW(50.049683, 19.944544),
    POZNAN(52.406376, 16.925167),
    LVIV(49.842957, 24.031111),
    GDANSK(54.372158, 18.638306);

    private double latitude;

    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    City(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
