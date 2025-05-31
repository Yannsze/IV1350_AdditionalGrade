package se.kth.iv1350.pointOfSale.view;

import se.kth.iv1350.pointOfSale.model.TotalRevenueObserver;
import se.kth.iv1350.pointOfSale.model.TotalRevenueTemplate;
/**
 * This is the view that is interested in notification of new total sum of a sale.
 */
public class TotalRevenueView extends TotalRevenueTemplate {
    @Override
    protected void doShowTotalIncome() {
        System.out.format("Total income: %.2f SEK\n", getTotalIncome());
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println("Error displaying total income: " + e.getMessage());
    }
}