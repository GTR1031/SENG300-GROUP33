package Test;

import static org.junit.Assert.*;
import org.junit.*;

import java.math.BigDecimal;
import java.util.*;

import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.BanknoteSlotObserver;
import org.lsmr.selfcheckout.products.BarcodedProduct;

import ca.ucalgary.seng300.selfcheckoutP1.*;

public class TestCheckoutSystem {
	// items
	private double weight1, weight2, weight3;
	private BarcodedItem item1, item2, item3;
	private BarcodedProduct product1, product2, product3;
	private List<BarcodedProduct> allProduct = new ArrayList<BarcodedProduct>();
	private List<BarcodedItem> allItem = new ArrayList<BarcodedItem>();

	// banknotes
	private Currency currency;
	private int[] banknoteDenomin;
	private Banknote banknote_one, banknote_five, banknote_ten, banknote_twenty, banknote_fifty;

	// coins
	private BigDecimal[] coinDenomin;
	private Coin penny, nickel, dime, quarter, loonie, tonnie;
	
	// self-checkout station
	private SelfCheckoutStation scs;
	private ScanAndWeigh scanAndScaleObs;
	private CheckoutSystem checkout;

	@Before
	public void setupItemAndProduct() {
		// setup barcode for each item/product
		Numeral[] code1 = new Numeral[4];
		Numeral[] code2 = new Numeral[4];
		Numeral[] code3 = new Numeral[4];
		
		for (int i = 0; i < 3; i++) {
			code1[i] = Numeral.zero;
			code2[i] = Numeral.zero;
			code3[i] = Numeral.zero;
		}
		
		code1[3] = Numeral.one;
		code2[3] = Numeral.two;
		code3[3] = Numeral.three;
		
		Barcode barcode1 = new Barcode(code1);		// barcode for item1/product1 = '0001'
		Barcode barcode2 = new Barcode(code2);		// barcode for item2/product2 = '0002'
		Barcode barcode3 = new Barcode(code3);		// barcode for item3/product3 = '0003'

		// setup all products
		product1 = new BarcodedProduct(barcode1, "Product 1", new BigDecimal("10"));
		product2 = new BarcodedProduct(barcode2, "Product 2", new BigDecimal("0.05"));
		product3 = new BarcodedProduct(barcode3, "Product 3", new BigDecimal("0.39"));

		// setup all items
		weight1 = 0.5;
		weight2 = 10;
		weight3 = 20.6;
		item1 = new BarcodedItem(barcode1, weight1);
		item2 = new BarcodedItem(barcode2, weight2);
		item3 = new BarcodedItem(barcode3, weight3);
		
		// add all products to a list
		allProduct.add(product1);
		allProduct.add(product2);
		allProduct.add(product3);
		
		// add all items to alist
		allItem.add(item1);
		allItem.add(item2);
		allItem.add(item3);
		
//		ScanAndWeigh scan = new ScanAndWeigh(allProduct, allItem);
	}
	
	@Before
	public void setupBanknoteAndCoin() {
		// setup banknote
		currency =  Currency.getInstance("CAD");
		banknoteDenomin = new int[] {5, 10, 20, 50};
		
		// invalid banknote
		banknote_one = new Banknote(currency, 1);

		// valid banknote
		banknote_five = new Banknote(currency, 5);
		banknote_ten = new Banknote(currency, 10);
		banknote_twenty = new Banknote(currency, 20);
		banknote_fifty = new Banknote(currency, 50);

		// setup coins
		coinDenomin = new BigDecimal[] {new BigDecimal("0.05"), new BigDecimal("0.10"), new BigDecimal("0.25"), new BigDecimal("1.00"), new BigDecimal("2.00")};
		Coin.DEFAULT_CURRENCY = currency;

		// invalid coin
		penny = new Coin(new BigDecimal("0.01"));

		// valid banknote
		nickel = new Coin(new BigDecimal("0.05"));
		dime = new Coin(new BigDecimal("0.10"));
		quarter = new Coin(new BigDecimal("0.25"));
		loonie = new Coin(new BigDecimal("1.00"));
		tonnie = new Coin(new BigDecimal("2.00"));
	}
	
	@Before
	public void setup() {
		// setup self-checkout station
		currency =  Currency.getInstance("CAD");
		banknoteDenomin = new int[] {5, 10, 20, 50};
		coinDenomin = new BigDecimal[] {new BigDecimal("0.05"), new BigDecimal("0.10"), new BigDecimal("0.25"), new BigDecimal("1.00"), new BigDecimal("2.00")};
		
		int maxWeight = 500, sensitivity = 1;
		scs = new SelfCheckoutStation(currency, banknoteDenomin, coinDenomin, maxWeight, sensitivity);
		
		// create observer objects
		scanAndScaleObs = new ScanAndWeigh(allProduct, allItem);
		checkout = new CheckoutSystem(currency);
		BanknoteSlotObserver banknoteslotobs = new BanknoteSlotObs();
		
		// attach observers
		scs.scanner.attach(scanAndScaleObs);
		scs.scale.attach(scanAndScaleObs);
		scs.banknoteInput.attach(banknoteslotobs);
		scs.banknoteValidator.attach(checkout);
		scs.coinValidator.attach(checkout);
	}

	@Test
	public void testFunctionality() {	
		try {
			scs.scanner.scan(item1);
			scs.scale.add(item1);
			
			// here should use 
			// checkout.checkout_btn(scanAndScaleObs.getTotal());
			// or other mehtod that can get the total bill amount
			checkout.checkout_btn(product1.getPrice().doubleValue());
			
			// make payment
			scs.banknoteInput.accept(banknote_one);
			scs.banknoteInput.accept(banknote_fifty);
			scs.coinValidator.accept(loonie);
			scs.coinValidator.accept(penny);
			scs.coinValidator.accept(penny);
			
			
			// customer finish insert banknote/coin
			checkout.finish();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}
