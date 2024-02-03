package hw4;

import java.util.Scanner;

public class Hw4Borrow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[][] arr = {
				{25, 32, 8, 19, 27},
				{2500, 800, 500, 1000, 1200}
		};
		int sum = 0;
		System.out.print("有錢可借的員工編號: ");
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] > money) {
					System.out.print(arr[0][j] + " ");
					sum++;
				}
			}
			System.out.println("共 " + sum + " 人!");
		}
	}
}
