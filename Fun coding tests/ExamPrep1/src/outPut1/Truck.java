package outPut1;

public class Truck extends Vehical {

	public void getName() {
		super.getName();
		System.out.println("I'm a truck");
	}
	
	@Override
	public void printColour() {
		System.out.println("Green truck");
	}

}
