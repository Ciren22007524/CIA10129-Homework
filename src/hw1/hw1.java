package hw1;

public class hw1 {
	public static void main(String[] args) {
// 1.請設計一隻Java程式，計算12，6這兩個數值的和與積
	int n1 = 12, n2 = 6;
	System.out.println(n1 + n2);
	System.out.println(n1 * n2);
// 2.請設計一隻Java程式，計算200顆蛋共是幾打幾顆?(一打為12顆)
	int egg = 200;
	int a1 = egg / 12, a2 = egg % 12; // a1為打, a2為剩幾顆
	System.out.println(a1 + "打" + a2 + "顆");
// 3.請由程式算出256559秒為多少天、多少小時、多少分與多少秒
	int time = 256559, day = 24 * 60 * 60, hour = 60 * 60, minute = 60; // day為一天共幾秒, hour為一小時共幾秒, minute為一分幾秒
	int b1 = time / day, b2 = (time % day) / hour, b3 = ((time % day) % hour) / minute, b4 = ((time % day) % hour) % minute; // b1為計算後共幾天, b2為計算後共幾小時, b3為計算後共幾分, b4為計算後共幾秒
	System.out.println(b1 + "天" + b2 + "小時" + b3 + "分" + b4 + "秒");
// 4.請定義一個常數為3.1415(圓周率)，並計算半徑為5的圓面積與圓周長
	double pi = 3.1415, r = 5;
	double c1 = Math.pow(r,2) * pi, c2 = 2 * pi * r; // c1為圓面積公式 = pi*r^2, c2為圓周長公式 = 2*pi*r
	System.out.print("圓面積 = " + c1 + "\n" + "圓周長 = " + c2 + "\n");
// 5.某人在銀行存入150萬，銀行利率為2%，如果每年利息都繼續存入銀行，請用程式計算10年後，本金加利息共有多少錢 (用複利計算)
	double d1 = 150000000, rate = 1.02;
	System.out.println(d1 * Math.pow(rate, 10)); // 等比級數 10年利率 = 利率n次方
// 6.請寫一個程式，利用Systemp.out.println()印出以下三個運算式結果:
//	5 + 5
//	5 + '5'
//	5 + "5"
	System.out.println( "5" + " + " + "5");
	System.out.println( 5 + " + " + "\'5\'");
	System.out.println( 5 + " + " + "\"5\"");
	}
}
