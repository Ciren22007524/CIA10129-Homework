package hw5;

public class MyRectangle {
	double width;
	double depth;
	double getArea() {
		double area = width*depth;
		System.out.println(area);
		return area;
	}
	void setWidth(double width) {
		this.width = width;
	}
	void setDepth(double depth) {
		this.depth = depth;
	}
	public MyRectangle() {
		
	}
	public MyRectangle(double width, double depth) {
		this.width = width;
		this.depth = depth;
	}
}
