package hw4;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Hw4Borrow {
	public static void main(String[] args) {
		System.out.println("請輸入想要借的金額 :");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[][] arr = {
				{25, 32, 8, 19, 27}, // 員工編號
				{2500, 800, 500, 1000, 1200} //可借金額
		};
		int sum = 0;
		System.out.print("有錢可借的員工編號: ");
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] >= money) {
					System.out.print(arr[0][j] + " ");
					sum++;
				}
			}
			System.out.println("\n共 " + sum + " 人!");
		}
		// Stream
		System.out.println("==========lambda==========");
		System.out.print("有錢可借的員工編號: ");
		long count = IntStream.range(0, arr[0].length)
							  .filter(i -> arr[1][i] >= money)
							  .peek(i -> System.out.print(arr[0][i] + " "))
							  .count();
		System.out.println("\n共 " + count + " 人!");	
	}
}
