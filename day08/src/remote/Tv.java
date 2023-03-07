package remote;

public class Tv implements Remote {

	@Override
	public void turnOn() {
		System.out.println("Turn On Tv");
	}

	@Override
	public void turnOff() {
		System.out.println("Turn Off Tv");
	}

}
