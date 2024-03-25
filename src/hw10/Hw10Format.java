package hw10;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Hw10Format {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int n = 0, m = 0; // do-while迴圈計數
			double number;
			int choice;
			do {
				try {
					System.out.print("請輸入數字: ");
					number = sc.nextDouble();
					do {
						System.out.println("欲格式化成(1)千分位(2)百分比(3)科學記號: ");
						choice = sc.nextInt();
						switch (choice) {
						case 1:
							formatWithThousandSeparator(number);
							m++;
							break;
						case 2:
							formatAsPercentage(number);
							m++;
							break;
						case 3:
							formatInScientificNotation(number);
							m++;
							break;
						default:
							System.out.println("請輸入有效選項。");
							sc.nextLine(); // 清除當前行的錯誤輸入
						}
					} while (m < 1);
					n++;
				} catch (Exception e) {
					System.out.println("數字格式不正確，請再輸入一次!");
					sc.nextLine(); // 清除當前行的錯誤輸入
				}
			} while (n < 1);
		}
	}

	public static void formatWithThousandSeparator(double number) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		String formattedNumber = formatter.format(number);
		System.out.println("千分位數字: " + formattedNumber);
	}

	public static void formatAsPercentage(double number) {
		DecimalFormat formatter = new DecimalFormat("0.##%");
		String formattedNumber = formatter.format(number);
		System.out.println("百分比數字: " + formattedNumber);
	}

	public static void formatInScientificNotation(double number) {
		DecimalFormat formatter = new DecimalFormat("0.###E0");
		String formattedNumber = formatter.format(number);
		System.out.println("科學記號數字: " + formattedNumber);
	}
}
