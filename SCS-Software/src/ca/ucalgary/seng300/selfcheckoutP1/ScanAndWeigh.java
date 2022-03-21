/*
 * SENG300 Group33
 * Project iteration 1
 * 
 * Group member:
 * Joshua Cordeiro-Zebkowitz
 * Ethan Macson
 * Spencer Mutch
 * Chenghou Si
 * Rei Tsunemi
 * Nhat Truong
 */

package ca.ucalgary.seng300.selfcheckoutP1;

import java.math.BigDecimal;
import java.util.*;

import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.*;
import org.lsmr.selfcheckout.products.BarcodedProduct;

public class ScanAndWeigh implements BarcodeScannerObserver, ElectronicScaleObserver {
	private BarcodeScanner scanner;
	private ElectronicScale scale;
	private Map<Barcode, BarcodedProduct> productDatabase = new HashMap<>();
	private Map<Barcode, BarcodedItem> itemDatabase = new HashMap<>();
	private double totalWeight;
	private double expectedWeight;
	private BigDecimal totalPrice;

	public ScanAndWeigh(Map<Barcode, BarcodedProduct> allProduct, Map<Barcode, BarcodedItem> allItem) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub

	}

	@Override
	public void weightChanged(ElectronicScale scale, double weightInGrams) {
		// TODO Auto-generated method stub

	}

	@Override
	public void overload(ElectronicScale scale) {
		// TODO Auto-generated method stub

	}

	@Override
	public void outOfOverload(ElectronicScale scale) {
		// TODO Auto-generated method stub

	}

	@Override
	public void barcodeScanned(BarcodeScanner barcodeScanner, Barcode barcode) {
		BarcodedProduct product = productDatabase.get(barcode);
		BarcodedItem item = itemDatabase.get(barcode);
		
		double weight = item.getWeight();
		BigDecimal price = product.getPrice();
		
		totalPrice = totalPrice.add(price);
		expectedWeight = weight;
	}
	
	public double getTotalWeight() {
		return totalWeight;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
}
