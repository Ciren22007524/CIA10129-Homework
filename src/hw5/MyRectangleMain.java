package hw5;

public class MyRectangleMain {
	public static void main(String[] args) {
		MyRectangle r = new MyRectangle(10, 20);
		r.getArea();
		
		MyRectangle re = new MyRectangle(10.0, 20.0);
		re.getArea();
	}
}