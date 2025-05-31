package se.kth.iv1350.pointOfSale.view;

import se.kth.iv1350.pointOfSale.model.TotalRevenueObserver;
import se.kth.iv1350.pointOfSale.model.TotalRevenueTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Prints a log message to a file. The log file will be in the same directory called "TotalRevenueFileOutput".
 */
public class TotalRevenueFileOutput extends TotalRevenueTemplate {
    private PrintWriter totalRevenueFileLogger;

    public TotalRevenueFileOutput() {
        try {
            totalRevenueFileLogger = new PrintWriter(new FileWriter("TotalRevenueFileOutput"), true);
        } catch (IOException ioException) {
            System.out.println("Can not be logged");
            ioException.printStackTrace();
        }
    }

    @Override
    protected void doShowTotalIncome() throws Exception {
        totalRevenueFileLogger.format("Total income: %.2f SEK\n", getTotalIncome());
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println("Error writing total income to file: " + e.getMessage());
    }
}