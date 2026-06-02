package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public abstract class Product {
    protected double quote;
    protected TimePeriod timePeriod;
    protected Company company;

    protected Product(double quote, TimePeriod timePeriod, Company company){
        this.quote = quote;
        this.timePeriod = timePeriod;
        this.company = company;
    }

    public double getQuote() {
        return this.quote;
    }

    protected LocalDate startDate(){
        return this.timePeriod.start();
    }

    protected LocalDate endDate(){
        return this.timePeriod.end();
    }

    protected abstract double price();
}
