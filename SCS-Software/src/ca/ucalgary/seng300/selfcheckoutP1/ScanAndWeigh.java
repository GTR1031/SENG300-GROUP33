package ca.ucalgary.seng300.selfcheckoutP1;
import org.lsmr.selfcheckout.Barcode;
import org.lsmr.selfcheckout.devices.AbstractDevice;
import org.lsmr.selfcheckout.devices.BarcodeScanner;
import org.lsmr.selfcheckout.devices.observers.AbstractDeviceObserver;
import org.lsmr.selfcheckout.devices.observers.BarcodeScannerObserver;
import org.lsmr.selfcheckout.devices.ElectronicScale;
import org.lsmr.selfcheckout.devices.observers.ElectronicScaleObserver;

public class ScanAndWeigh implements BarcodeScannerObserver, ElectronicScaleObserver {
	private BarcodeScanner barcodeScanner;
	private ElectronicScale electronicScale;
	private double totalWeight;
	
	/* Constructor for ScanAndWeigh
	 * 
	 * @param scanner
	 * 		The barcode scanner that we are using. Can't be null
	 * @param scale
	 * 		The scale that we are using. Can't be null
	 * @throws NullPointerException
	 * 		If either the scanner or scale is null
	 */
	public ScanAndWeigh (BarcodeScanner scanner, ElectronicScale scale) throws NullPointerException {
		barcodeScanner = scanner;
		electronicScale = scale;
		
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
