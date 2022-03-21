package Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import org.lsmr.selfcheckout.Barcode;
import org.lsmr.selfcheckout.BarcodedItem;
import org.lsmr.selfcheckout.Numeral;
import org.lsmr.selfcheckout.devices.BarcodeScanner;
import org.lsmr.selfcheckout.devices.ElectronicScale;
import org.lsmr.selfcheckout.products.BarcodedProduct;

import ca.ucalgary.seng300.selfcheckoutP1.ScanAndWeigh;

//For Test Cases involving ScanAndWeigh

public class ScanAndWeighTests {
	private BarcodeScanner scanner;
	private ElectronicScale scale;
	private int testWeightLimit;
	private int testSensitivity;
	private Map<Barcode, BarcodedItem> itemDatabase = new HashMap<>();
	private Map<Barcode, BarcodedProduct> productDatabase = new HashMap<>();

	@Before
	public void setup() {
		// Test values for scale
		testWeightLimit = 50;
		testSensitivity = 1;
		
		// Create A scale and Barcode scanner to attach software
		scanner = new BarcodeScanner();
		scale = new ElectronicScale(testWeightLimit, testSensitivity);
		
		// Populate maps
		// Barcodes
		Barcode barcode1 = new Barcode(new Numeral[001]);
		Barcode barcode2 = new Barcode(new Numeral[002]);
		Barcode barcode3 = new Barcode(new Numeral[003]);
		// BarcodedItems
		BarcodedItem item1 = new BarcodedItem(barcode1, 10);
		BarcodedItem item2 = new BarcodedItem(barcode2, 5);
		BarcodedItem item3 = new BarcodedItem(barcode3, 2);
		
		// BarcodedProducts
		BarcodedProduct product1 = new BarcodedProduct(barcode1, "High Weight Product", new BigDecimal(20.0));
		BarcodedProduct product2 = new BarcodedProduct(barcode1, "Med Weight Product", new BigDecimal(10.0));
		BarcodedProduct product3 = new BarcodedProduct(barcode1, "Low Weight Product", new BigDecimal(3.00));
		
		// Maps
		itemDatabase.put(barcode1, item1);
		productDatabase.put(barcode1, product1);
		itemDatabase.put(barcode2, item2);
		productDatabase.put(barcode2, product2);
		itemDatabase.put(barcode3, item3);
		productDatabase.put(barcode3, product3);
		
		// Create instance of software
		new ScanAndWeigh(productDatabase, itemDatabase);
		
	}
	
	
}
