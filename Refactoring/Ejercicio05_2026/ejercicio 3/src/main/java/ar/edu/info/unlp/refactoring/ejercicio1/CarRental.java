package ar.edu.info.unlp.refactoring.ejercicio1;

public class CarRental extends Product {

    public CarRental(double quote, TimePeriod timePeriod, Company company) {
        super(quote, timePeriod, company);
    }

    @Override
    public double price() {
        return this.company.calculatePrice();
    }
}
