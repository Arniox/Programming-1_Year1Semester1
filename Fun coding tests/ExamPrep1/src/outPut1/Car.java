package outPut1;

public class Car extends Vehical {

	public void getName(){
		super.getName();
		System.out.println("I'm a car");
	}
	@Override
	public void printColour() {
		System.out.println("Red car");
	}

}
