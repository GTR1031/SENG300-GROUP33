package Test;

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
		
		// Create instance of software
		new ScanAndWeigh(scanner, scale);
		
		// Populate maps
		Barcode barcode1 = new Barcode(new Numeral[001]);
		Barcode barcode2 = new Barcode(new Numeral[002]);
		Barcode barcode3 = new Barcode(new Numeral[003]);
		
	}
	
	
}
