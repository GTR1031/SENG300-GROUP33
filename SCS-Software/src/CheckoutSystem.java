import org.lsmr.selfcheckout.devices.observers.AbstractDeviceObserver;
import org.lsmr.selfcheckout.devices.observers.TouchScreenObserver;
import org.lsmr.selfcheckout.devices.observers.CoinSlotObserver;
import org.lsmr.selfcheckout.devices.observers.CoinValidatorObserver;

import java.math.BigDecimal;
import java.util.Currency;
import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.BanknoteSlotObserver;
import org.lsmr.selfcheckout.devices.observers.BanknoteValidatorObserver;

public class CheckoutSystem implements CoinValidatorObserver, BanknoteValidatorObserver, TouchScreenObserver {
	private Currency currency;
	private double totalAmount;
	private BigDecimal coinTotal;
	private int banknoteTotal;
	
	
	public CheckoutSystem(int total) {
		currency = Currency.getInstance("CAD");
		coinTotal = new BigDecimal("0");
		banknoteTotal = 0;
		totalAmount = total;
	}
	
	public void finish() {
		double totalInserted = coinTotal.doubleValue() + (double) banknoteTotal;
	
		if (totalInserted < totalAmount) {
			throw new SimulationException("Not enough");
		}
	}

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
	}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		
	}


	@Override
	public void validCoinDetected(CoinValidator validator, BigDecimal value) {
		coinTotal.add(value);
	}

	@Override
	public void invalidCoinDetected(CoinValidator validator) {
		
	}

	@Override
	public void validBanknoteDetected(BanknoteValidator validator, Currency currency, int value) {
		banknoteTotal += value;
	}

	@Override
	public void invalidBanknoteDetected(BanknoteValidator validator) {
			
	}

}
