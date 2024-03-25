package hw5;

public class Hw5RandAvg {
	public static void main(String[] args) {
		Hw5RandAvg r = new Hw5RandAvg();
		r.randAvg();
	}
	public void randAvg() {
		System.out.println("本次亂數結果:");
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			int a = (int)(Math.random()*101);
			sum += a;
			System.out.print( a + " ");
		}
		int avg = sum / 10;
		System.out.println("\n" + avg);
	}
}
