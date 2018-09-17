package outPut2;

public class Triangle extends Square {
	public Triangle(int b,int h){
		super(b,h);
	}
	
	@Override
	int area() {
		return super.area()/2;
	}
}
