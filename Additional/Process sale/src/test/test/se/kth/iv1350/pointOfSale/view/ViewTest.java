package test.se.kth.iv1350.pointOfSale.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.pointOfSale.controller.Controller;
import se.kth.iv1350.pointOfSale.dto.ItemDTO;
import se.kth.iv1350.pointOfSale.integration.Printer;
import se.kth.iv1350.pointOfSale.integration.Register;
import se.kth.iv1350.pointOfSale.integration.SystemCreator;
import se.kth.iv1350.pointOfSale.model.SoldItem;
import se.kth.iv1350.pointOfSale.view.View;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printOutSale; // store System print as an array to read.
    private PrintStream originalSysOut;
    private Register registerTest;
    private Printer printerTest;
    private SystemCreator systemCreatorTest;

    @BeforeEach
    public void setUp() {
        systemCreatorTest = new SystemCreator();
        registerTest = new Register();
        printerTest = new Printer();

        Controller contr = new Controller(registerTest, printerTest, systemCreatorTest);
        instanceToTest = new View(contr);
        printOutSale = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printOutSale);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    public void tearDown() {
        instanceToTest = null;

        printOutSale = null;
        System.setOut(originalSysOut);
    }

    @Test
    public void testRunInitializeSale() {
        instanceToTest.runInitializeSale();
        String testPrintInitializeSale = printOutSale.toString();
        String expectedOutput = "initialized";
        assertTrue(testPrintInitializeSale.contains(expectedOutput), "UI did not start correctly");
    }

    @Test
    public void testPrintSoldItemInfoPrintsItemDetails() {
    // Skapa en dummy SoldItem
    ItemDTO item = new ItemDTO("Bread", 321, "Bread description", 20.0, 0.06);
    SoldItem soldItem = new SoldItem(item, 2);

    // Anropa metoden via reflection (om den är private)
    try {
        java.lang.reflect.Method method = View.class.getDeclaredMethod("printSoldItemInfo", SoldItem.class);
        method.setAccessible(true);
        method.invoke(instanceToTest, soldItem);
    } catch (Exception e) {
        fail("Reflection failed: " + e.getMessage());
    }

    String output = printOutSale.toString();
    assertTrue(output.contains("Item name: Bread"), "Should print item name.");
    assertTrue(output.contains("ItemID: 321"), "Should print item ID.");
    assertTrue(output.contains("Item cost: 20.00 SEK"), "Should print item cost.");
    assertTrue(output.contains("VAT: 6.0%"), "Should print VAT.");
    assertTrue(output.contains("Item description: Bread description"), "Should print item description.");
    assertTrue(output.contains("Total cost (incl VAT): 40.00 SEK"), "Should print total cost incl VAT.");
    }

}