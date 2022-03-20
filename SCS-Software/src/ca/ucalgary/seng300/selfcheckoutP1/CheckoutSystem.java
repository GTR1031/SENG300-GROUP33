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
import java.util.Currency;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.*;

public class CheckoutSystem implements CoinValidatorObserver, BanknoteValidatorObserver, TouchScreenObserver {
	private Currency currency;
	private double totalAmount;
	private BigDecimal coinTotal;
	private int banknoteTotal;
	
	// initial checkout system
	public CheckoutSystem() {
		currency = Currency.getInstance("CAD");
		coinTotal = new BigDecimal("0");
		banknoteTotal = 0;
		totalAmount = 0;
	}
	
	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
	}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		
	}

	@Override
	public void validCoinDetected(CoinValidator validator, BigDecimal value) {
		coinTotal.add(value); //adding to coinTotal when valid
	}

	@Override
	public void invalidCoinDetected(CoinValidator validator) {
		
	}

	@Override
	public void validBanknoteDetected(BanknoteValidator validator, Currency currency, int value) {
		banknoteTotal += value; //adding to banknoteTotal when valid
	}

	@Override
	public void invalidBanknoteDetected(BanknoteValidator validator) {
			
	}
	
	// input the total bill amount when hit the checkout button
	public void checkout_btn(double total) {
		totalAmount = total;
	}
	
	// called when customers hit the finish payment button
	public void finish() {
		double totalInserted = coinTotal.doubleValue() + (double) banknoteTotal; //converting BigDecimal number to double
	
		if (totalInserted < totalAmount) {
			throw new SimulationException("Not enough");
		}
	}
	

}
