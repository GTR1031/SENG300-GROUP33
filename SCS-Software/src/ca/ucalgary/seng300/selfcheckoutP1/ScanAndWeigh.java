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
import org.lsmr.selfcheckout.devices.SimulationException;
import java.math.BigDecimal;

public class ScanAndWeigh implements BarcodeScannerObserver, ElectronicScaleObserver {
	private Map<Barcode, BarcodedProduct> productDatabase;
	private Map<Barcode, BarcodedItem> itemDatabase;
	private double totalWeight;
	private double expectedWeight;
	private double previousWeight;
	private BigDecimal totalPrice;
	
	public ScanAndWeigh(Map<Barcode, BarcodedProduct> allProduct, Map<Barcode, BarcodedItem> allItem) {
		totalWeight = 0;
		previousWeight = 0;
		totalPrice = new BigDecimal(0);
		this.productDatabase = allProduct;
		this.itemDatabase = allItem;
	}

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {}

	@Override
	public void weightChanged(ElectronicScale scale, double weightInGrams) {
		if ((weightInGrams - previousWeight) == expectedWeight) {
			previousWeight = totalWeight;
			totalWeight = weightInGrams;
		}
		else {
			throw new SimulationException("Weight added to scale does not match the expected weight.");
		}
		
	}

	@Override
	public void overload(ElectronicScale scale) {
		System.out.println("The scale is overloaded. Please remove items.");
		
	}

	@Override
	public void outOfOverload(ElectronicScale scale) {
		System.out.println("The scale is no longer overloaded. You may resume scanning.");
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
