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

import java.util.List;

import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.*;
import org.lsmr.selfcheckout.products.BarcodedProduct;

public class ScanAndWeigh implements BarcodeScannerObserver, ElectronicScaleObserver {

	public ScanAndWeigh(List<BarcodedProduct> allProduct, List<BarcodedItem> allItem) {
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
		// TODO Auto-generated method stub

	}
}
