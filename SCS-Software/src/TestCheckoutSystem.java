import static org.junit.Assert.*;
import org.junit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.lsmr.selfcheckout.Banknote;
import org.lsmr.selfcheckout.devices.*;

public class TestCheckoutSystem {
//	private ElectronicScale scale;

	@Before
	private void setup() {
		// TODO Auto-generated method stub

	}

	@Test
	public void testInsert() {
		Currency currency =  Currency.getInstance("CAD");
		int bkdom[] = {5,10,20,50};
		List<BigDecimal> coindom = new ArrayList<>();
	
		coindom.add(new BigDecimal("0.05"));
		coindom.add(new BigDecimal("0.10"));
		coindom.add(new BigDecimal("0.25"));
		coindom.add(new BigDecimal("1.00"));
		coindom.add(new BigDecimal("2.00"));
		
		BanknoteValidator bk = new BanknoteValidator(currency, bkdom);
		CoinValidator coin = new CoinValidator(currency, coindom);
		
		
		CheckoutSystem cs = new CheckoutSystem(10);
		bk.attach(cs);
		coin.attach(cs);
		
		try {
			bk.accept(new Banknote(currency, 0) );
			
		} catch (Exception e) {
			fail();
		}
		
	}
}
