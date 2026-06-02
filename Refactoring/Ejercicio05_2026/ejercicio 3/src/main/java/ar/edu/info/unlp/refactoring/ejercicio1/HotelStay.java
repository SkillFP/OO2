package ar.edu.info.unlp.refactoring.ejercicio1;

public class HotelStay extends Product {

    public HotelStay(double quote, TimePeriod timePeriod, Company company) {
        super(quote, timePeriod, company);
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    @Override
    public double price() {
        return this.timePeriod.duration() * company.calculatePrice();
    }
}
