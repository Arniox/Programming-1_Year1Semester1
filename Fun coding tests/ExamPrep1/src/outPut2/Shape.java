package outPut2;

public abstract class Shape {
	abstract int area();
	public void output(){
		System.out.println("Area: " +
				this.area());
	}
}
