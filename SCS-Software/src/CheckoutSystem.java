import org.lsmr.selfcheckout.devices.observers.AbstractDeviceObserver;
import org.lsmr.selfcheckout.devices.observers.TouchScreenObserver;
import org.lsmr.selfcheckout.devices.observers.CoinSlotObserver;
import java.util.Currency;
import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.BanknoteSlotObserver;

public class CheckoutSystem implements CoinSlotObserver, BanknoteSlotObserver, TouchScreenObserver {

	@Override
	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void banknoteInserted(BanknoteSlot slot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void banknoteEjected(BanknoteSlot slot) {
<<<<<<< Updated upstream:SCS-Software/src/CheckoutSystem.java
		// TODO Auto-generated method stub
		
=======
		Banknote ejected = slot.removeDanglingBanknote();

		// print out the situation
		System.out.println("Situation: Remove the ejected banknote " + ejected);
>>>>>>> Stashed changes:SCS-Software/src/ca/ucalgary/seng300/selfcheckoutP1/BanknoteSlotObs.java
	}

	@Override
	public void banknoteRemoved(BanknoteSlot slot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coinInserted(CoinSlot slot) {
		// TODO Auto-generated method stub
		
	}

}
