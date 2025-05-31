package test.se.kth.iv1350.pointOfSale.integration;

import org.junit.jupiter.api.*;
import se.kth.iv1350.pointOfSale.integration.Printer;
import se.kth.iv1350.pointOfSale.model.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Printer for printing out the receipt.
 */
public class PrinterTest {
    private Printer printer;
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        printer = new Printer();
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testPrintReceiptPrintsReceiptToSystemOut() {
        Sale sale = new Sale();
        sale.addItem(new se.kth.iv1350.pointOfSale.dto.ItemDTO("Milk", 222, "Milk 1L", 10.0, 0.06), 2);
        sale.pay(50);
        Receipt receipt = new Receipt(sale);

        printer.printReceipt(receipt);

        String output = outContent.toString();
        assertTrue(output.contains("Receipt"), "Should print receipt header.");
        assertTrue(output.contains("Milk"), "Should print item name.");
        assertTrue(output.contains("Total:"), "Should print total.");
        assertTrue(output.contains("Cash:"), "Should print cash line.");
        assertTrue(output.contains("Change:"), "Should print change line.");
    }
}