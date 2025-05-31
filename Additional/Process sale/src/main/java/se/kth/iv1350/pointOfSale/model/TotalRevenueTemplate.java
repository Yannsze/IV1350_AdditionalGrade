package se.kth.iv1350.pointOfSale.model;

import se.kth.iv1350.pointOfSale.model.TotalRevenueObserver;

public abstract class TotalRevenueTemplate implements TotalRevenueObserver {
    private double totalIncome = 0;

    @Override
    public void newTotalPrice(double priceOfTheSaleThatWasJustMade) {
        calculateTotalIncome(priceOfTheSaleThatWasJustMade);
        showTotalIncome();
    }

    private void calculateTotalIncome(double price) {
        totalIncome += price;
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected double getTotalIncome() {
        return totalIncome;
    }

    protected abstract void doShowTotalIncome() throws Exception;
    protected abstract void handleErrors(Exception e);
}