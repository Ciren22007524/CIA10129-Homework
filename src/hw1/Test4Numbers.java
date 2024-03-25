
package hw1;

public class Test4Numbers {
	public static void main(String[] args) {
//		for(int n = 0; n <= 25; n++) {
//			System.out.println(4 * n);
//		}
		
		for (int i = 0; i <= 100; i++) {
			if (i % 4 == 0)
				System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i <= 100; i += 4) {
			System.out.print(i + " ");
		}
	}
}
