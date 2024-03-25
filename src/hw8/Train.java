package hw8;

public class Train {
	private int number;
	private String type;
	private String start;
	private String dest;
	private double price;
	
	// 無參數建構子
	public Train() {
		
	}
	// 含參數(班次, 車別, 起站, 迄站, 票價)建構子
	public Train(int number, String type, String start, String dest, double price) {
		this.number = number;
		this.type = type;
		this.start = start;
		this.dest = dest;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return  "(" + number + "," + type + "," + start + "," + dest + "," + price + ")";
	}
	// 班次getter, setter
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	// 車別getter, setter
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	// 起站getter, setter
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	// 迄站getter, setter
	public String getDest() {
		return dest;
	}
	
	public void setDest(String dest) {
		this.dest = dest;
	}
	// 票價getter, setter
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
