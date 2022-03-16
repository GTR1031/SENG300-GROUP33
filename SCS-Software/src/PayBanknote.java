import java.util.Currency;
import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.AbstractDeviceObserver;
import org.lsmr.selfcheckout.devices.observers.BanknoteSlotObserver;

public class PayBanknote implements BanknoteSlotObserver {

	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
	}

	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		// TODO Auto-generated method stub
	}

	public void banknoteInserted(BanknoteSlot slot) {
		// TODO Auto-generated method stub
		
	}

	public void banknoteEjected(BanknoteSlot slot) {
		// TODO Auto-generated method stub
		
	}

	public void banknoteRemoved(BanknoteSlot slot) {
		// TODO Auto-generated method stub
		
	}
}
