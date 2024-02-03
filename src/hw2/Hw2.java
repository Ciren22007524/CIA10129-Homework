package hw2;

public class Hw2 {
//	• 請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
	public static void main(String[] args) {
		int sum = 0; // 宣告總和 sum = 0
		for(int n = 1; n <= 1000; n++) {
			if (n % 2 ==0) {
				sum += n;
			}
		}
		System.out.println("1. 1~1000 的偶數和 = " + sum);
		System.out.println("======================================");
//	• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int a1 = 1; // a1 作為乘法基數
		for (int n = 1; n <= 10; n++) {
				a1 *= n;
		}
		System.out.println("2. 1~10 的連乘積 = " + a1);
		System.out.println("======================================");
//	• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int n = 0; // 因使用while迴圈，先宣告圈數常數n
		int b1 = 1; // b1 作為乘法基數
		while ( b1 < 10) {
			n++;
			b1 *= n;
		}
		System.out.println("3. 1~10 的連乘積 = " + a1);
		System.out.println("======================================");
//	• 請設計一隻Java程式,輸出結果為以下:1 4 9 16 25 36 49 64 81 100
		System.out.print("4. ");
		// 列印n^2，因第3題While迴圈已宣告n,條件式內不另外宣告，以下題目使用n狀況皆相同
		for (n = 1; n <= 10; n++) {
			System.out.print((int) Math.pow(n, 2) + " ");
		}
		System.out.println();
//		方法二:篩選1~100開根號為整數者
//		double s1; // s1為n開根號
//		for (n =1; n <= 100; n++) {
//			s1 = Math.sqrt(n);
//			if( s1 % 1 == 0 ) {
//				System.out.print(n + " ");
//			}
//		}
		System.out.println("======================================");
//	• 阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		System.out.println("5. " + "\t");
		int c1 = 0, d1 = 0, sum1 = 0;
		// c1為個位數含4的數字,d1為十位數含4的數字,sum1為全部沒有4的數字
		for (n = 1; n <= 49; n++) {
			// 個位數含4即除以10餘4
			if ( n % 10 == 4 ){
				c1++;
			}
			// 十位數含4即除以40為1.X者
			else if ( n / 40 == 1){
				d1++;
			}
			else {
				System.out.print(n + " ");
				sum1++;
			}
		}
		System.out.println();
		System.out.println("總共有 " + sum1 + " 個");
		// System.out.println("總共有 " + ( n - c1 - d1  + 1 ) + " 個"); // 用扣的，44重複計算 +1
		System.out.println("======================================");
//	• 請設計一隻Java程式,輸出結果為以下:
//	1 2 3 4 5 6 7 8 9 10
//	1 2 3 4 5 6 7 8 9
//	1 2 3 4 5 6 7 8
//	1 2 3 4 5 6 7
//	1 2 3 4 5 6
//	1 2 3 4 5
//	1 2 3 4
//	1 2 3
//	1 2
//	1
		System.out.println("6. " + "\t");
		for(n = 10; n >=0; n--) {
			for(int o = 1; o <= n; o++) {
				System.out.print(o);
			}
			System.out.println();
		}
		System.out.println("======================================");
//	• 請設計一隻Java程式,輸出結果為以下:
//		A
//		BB
//		CCC
//		DDDD
//		EEEEE
//		FFFFFF
		System.out.println("7. " + "\t");
		int e1;
		// 與列印下三角形相同，只需增加字元轉換
		for(n = 1; n <= 6; n++) {
			for(int m = 1; m <= n; m++) {
				// ASCII編碼中A=65,B=66...,F=70
				e1 = n + 64;
				char e2 = (char) e1; // 將數字轉成char字元
				System.out.print(e2);	
			}
			System.out.println();
		}
	}
}