package outPut2;

public class Square extends Shape {
	
	public int base,height;
	
	public Square(int b,int h){
		this.base = b;
		this.height = h;
	}
	@Override
	int area() 
	{
		return base*height;
	}
}
