package hw3;

import java.util.Scanner;

// 請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜對則顯示正確訊息,如圖示結果:

public class Hw3Guess {
	public static void main(String[] args) {
		System.out.println("開始猜數字吧!");
		Scanner sc = new Scanner(System.in);
		int number;
		int a = (int)(Math.random()*10);
//	    // 可用 Random 類別生成隨機數
//      Random random = new Random();  
//      // 生成0~9的整數
//      int a = random.nextInt(10);
	    // 可使用 Random 類別生成隨機數
	    // Random random = new Random();
		// 生成0~9的整數
	    // int a = random.nextInt(10);
//		1.while迴圈寫法
//		while (true) {
//			number = sc.nextInt();
//			if ( a != number) {
//				System.out.println("猜錯囉");
//			} else {
//				System.out.println("答對了 ! 答案就是" + a);
//				break;
//			}
//		}
//		2.do-while(更簡潔)
		do {
			number = sc.nextInt();
			if(a != number) {
				System.out.println("猜錯囉");
			}
		} while (a == number);
		System.out.println("答對了 ! 答案就是" + a);
	}
}