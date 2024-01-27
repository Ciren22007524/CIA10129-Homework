package hw3;

import java.util.Scanner;

// 請設計一隻程式,會亂數產生一個0~100的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜對則顯示正確訊息,如圖示結果:

public class Hw3GuessProgress {
	public static void main(String[] args) {
		System.out.println("開始猜數字吧!");
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int a = (int)(Math.random()*101);
		while ( n < 1) {
			int number = sc.nextInt();
			if ( a != number ) {
				System.out.print("猜錯囉，");
				if ( a > number ) {
					System.out.println("小於正確答案");
				} else {
					System.out.println("大於正確答案");
				}
			} else {
				System.out.println("答對了 ! 答案就是" + a);
				break;
			}
		}
		
	}
}