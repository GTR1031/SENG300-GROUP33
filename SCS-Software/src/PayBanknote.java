import java.util.Currency;
import org.lsmr.selfcheckout.*;
import org.lsmr.selfcheckout.devices.*;
import org.lsmr.selfcheckout.devices.observers.AbstractDeviceObserver;
import org.lsmr.selfcheckout.devices.observers.BanknoteSlotObserver;

public class PayBanknote implements BanknoteSlotObserver {
	private Currency currency;
	private int total, fiveBanknoteNum, tenBanknoteNum, twentyBanknoteNum, fiftyBanknoteNum, hundredBanknoteNum;
	private boolean status;
	
	public PayBanknote(boolean status) {
		this.status = status;
		currency = Currency.getInstance("CAD");
		fiveBanknoteNum = 0;
		tenBanknoteNum = 0;
		twentyBanknoteNum = 0;
		fiftyBanknoteNum = 0;
		hundredBanknoteNum = 0;
		total = 0;
	}
	
	public void addBankNote(Banknote inserted) {
		int value = inserted.getValue();
		total += value;
		
		if (value == 5) {
			fiveBanknoteNum++;
		}
		else if (value == 10) {
			tenBanknoteNum++;
		}
		else if (value == 20) {
			twentyBanknoteNum++;
		}
		else if (value == 50) {
			fiftyBanknoteNum++;
		}
		else if (value == 100) {
			hundredBanknoteNum++;
		}
		else {
			throw new SimulationException("Not a Valid Canadian Banknote!!!");
		}
	}
	
	public int getBanknoteTotal() {
		return total;
	}

	public void enabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		status = true;	
	}

	public void disabled(AbstractDevice<? extends AbstractDeviceObserver> device) {
		status = false;	
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
