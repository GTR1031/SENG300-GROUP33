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
	public CheckoutSystem(Currency currency) {
		this.currency = currency;
		coinTotal = new BigDecimal("0.00");
		banknoteTotal = 0;
		totalAmount = 0;
	}
	
	// input the total bill amount when hit the checkout button
	public void checkout_btn(double total) {
		totalAmount = total;
	}
	
	// called when customers hit the finish payment button
	public void finish() throws CashPaymentException {
		//converting BigDecimal number to double
		double totalInserted = coinTotal.doubleValue() + (double) banknoteTotal;
		
		// print out the message on the screen
		System.out.println("The total bill is: " + totalAmount);
		System.out.println("The total cash inserted is: " + totalInserted);
	
		if (totalInserted < totalAmount) {
			throw new CashPaymentException("The payment is not enough");
		} else {
			System.out.printf("The chages is: %.2f\n", totalInserted-totalAmount);
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
		coinTotal = coinTotal.add(value);
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
}
