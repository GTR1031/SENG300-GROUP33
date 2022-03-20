import java.util.Map;
import java.util.HashMap;
import org.lsmr.selfcheckout.Barcode;
import org.lsmr.selfcheckout.devices.AbstractDevice;
import org.lsmr.selfcheckout.devices.BarcodeScanner;
import org.lsmr.selfcheckout.devices.observers.AbstractDeviceObserver;
import org.lsmr.selfcheckout.devices.observers.BarcodeScannerObserver;
import org.lsmr.selfcheckout.devices.ElectronicScale;
import org.lsmr.selfcheckout.devices.observers.ElectronicScaleObserver;
import org.lsmr.selfcheckout.products.BarcodedProduct;
import org.lsmr.selfcheckout.BarcodedItem;
import org.lsmr.selfcheckout.devices.OverloadException;
import java.math.BigDecimal;

public class ScanAndWeigh implements BarcodeScannerObserver, ElectronicScaleObserver {
	private BarcodeScanner scanner;
	private ElectronicScale scale;
	private Map<Barcode, BarcodedProduct> productDatabase = new HashMap<>();
	private Map<Barcode, BarcodedItem> itemDatabase = new HashMap<>();
	
	public ScanAndWeigh() {
		
	}

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {}

	@Override
	public void weightChanged(ElectronicScale scale, double weightInGrams) {
		
		
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
		
		
		
	}

}
