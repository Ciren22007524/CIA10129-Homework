package hw4;

import java.util.Scanner;

public class Hw4Date {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 將每月有多少天設成二維矩陣
		int M[][] = { 
				{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
				{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }
		};
		int sum = 0; // 計算天數用
		int y = sc.nextInt(); // 年
		// 閏年2月改成29天
		if ((y % 4 == 0 && y % 100 != 0) && y % 400 == 0 && y % 1000 == 0) {
			M[1][1] = 29;
		}
		// 無限迴圈，若輸入錯誤重新輸入一次
		while(true) {
			int m = sc.nextInt(); // 月
			// 檢驗月份
			if (m > 12) {
				System.out.println("輸入月份不該超過12，請重新輸入");
				continue;
			}

			// 無限迴圈，檢驗有無超過相對應月份的日期
			while(true) {
				int d = sc.nextInt();
				// 二維矩陣天數
				if (d > M[1][m - 1]) {
					System.out.println("輸入日期不該超過" + M[1][m - 1] + "，請重新輸入");
					continue;
				}
				// 先計算當前月份前的天數
				for (int k = 0; k < (m - 1); k++) {
					sum += M[1][k];
				}
				sum += d; // 加上當月日期
				break;
			}
			break;
		}
		System.out.println("輸入的日期為該年第" + sum + "天");
	}
}
