package test.se.kth.iv1350.pointOfSale.view;

import org.junit.jupiter.api.*;
import se.kth.iv1350.pointOfSale.view.TotalRevenueView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TotalRevenueViewTest {
    private TotalRevenueView view;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        view = new TotalRevenueView();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testDoShowTotalIncomePrintsTotalIncome() {
        view.newTotalPrice(100.0);
        String output = outContent.toString();
        assertTrue(output.contains("Total income: 100.00 SEK"), "Should print total income.");
    }
}
