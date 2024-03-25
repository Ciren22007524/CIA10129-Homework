package hw2;

import java.util.stream.IntStream;

public class Hw2 {

	public static void main(String[] args) {
//	• 請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		// 1. for迴圈
//		int sum1 = 0; // 總和
//		for(int n = 1; n <= 1000; n++) {
//			if (n % 2 ==0) {
//				sum1 += n;
//			}
//		}
		// 2. Stream
		// IntStream.rangeClosed(int startInclusive, int endExclusive)方法
		// 生成 1 ~ 1000 範圍的Stream，再用filter()中間操作、sum()終端操作
		// 補充:range方法生成半開區間
		// range(1, 3) = {1, 2}; rangeClosed(1, 3) = {1, 2, 3}
		int sum1 = IntStream.rangeClosed(1, 1000)
				//    保留所有除以2餘數為0的
							.filter(n -> n % 2 == 0)
							.sum();
		System.out.println("1. 1~1000 的偶數和 = " + sum1);
		System.out.println("======================================");
//	• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int sum2 = 1; // 作乘法基數
		for (int n = 1; n <= 10; n++) {
				sum2 *= n;
		}
		System.out.println("2. 1~10 的連乘積 = " + sum2);
		System.out.println("======================================");
//	• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int i = 0; // while迴圈用
		int sum3 = 1; // 作乘法基數
		while ( i < 10) {
			i++;
			sum3 *= i;
		}
		System.out.println("3. 1~10 的連乘積 = " + sum3);
		// Stream操作
		// reduce()為聚合操作，會將所有元素聚合成一個結果
		//     初始值    定義如何連乘
		// reduce(1, (a, b) -> (a * b))
		int sum5 = IntStream.rangeClosed(1, 10)
							.reduce(1, (a, b) -> (a * b));
		System.out.println("lambda = " + sum5);
		System.out.println("======================================");
//	• 請設計一隻Java程式,輸出結果為以下:1 4 9 16 25 36 49 64 81 100
		System.out.print("4. ");
		for (int n = 1; n <= 10; n++) {
			System.out.print((int) Math.pow(n, 2) + " ");
		}
		System.out.println();
		// Stream
		System.out.print("lambda = ");
		IntStream.rangeClosed(1, 10)
				 // map 映射轉換，將n轉變成n平方
				 .map(n -> n * n)
				 .forEach(n -> System.out.print(n + " "));
		System.out.println();
//		方法二:篩選1~100開根號為整數者
//		double perfectSqure;
//		for (n =1; n <= 100; n++) {
//			perfectSquare = Math.sqrt(n);
//			if( perfectSquare % 1 == 0 ) {
//				System.out.print(n + " ");
//			}
//		}
		System.out.println("======================================");
//	• 阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		System.out.println("5. " + "\t");
		int dislike = 4;
		int digits = 0, tensDigits = 0, sum4 = 0;
		// digits為個位數,tensDigits為十位數,sum4為全部沒有4的數字
		for (int n = 1; n <= 49; n++) {
			// 個位數含4即除以10餘4
			if ( n % 10 == dislike ){
				digits++;
			}
			// 十位數含4即除以40為1.X者
			else if ( n / (dislike * 10) == 1){
				tensDigits++;
			}
			else {
				System.out.print(n + " ");
				sum4++;
			}
		}
		System.out.println();
		System.out.println("總共有 " + sum4 + " 個");
		// System.out.println("總共有 " + ( n - digits - tensDigits  + 1 ) + " 個"); // 用扣的，44重複計算 +1
		System.out.println("lambda = ");
		long sum6 = IntStream.rangeClosed(1, 49)
							 .filter(n -> n % 10 != 4 && n / 10 % 10 != 4)
							 // peek與forEach相同皆為Consumer
							 // 差在peek為中間操作，執行完後會返回Stream
							 .peek(n -> System.out.print(n + " "))
							 .count();
		System.out.println("總共有 " + sum6 + " 個");
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
		for(int n = 10; n >=0; n--) {
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
//		int ascCode;
		// 與列印下三角形相同，只需增加字元轉換
		for(int n = 1; n <= 6; n++) {
			for(int m = 1; m <= n; m++) {
				// ASCII code:A=65,B=66...,F=70
//				ascCode = n + 64;
//				System.out.println((char) ascCode);
				System.out.print((char)(n + 64));	
			}
			System.out.println();
		}
	}
}