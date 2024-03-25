package hw1;

public class Hw1 {
	public static void main(String[] args) {
// 1.請設計一隻Java程式，計算12，6這兩個數值的和與積
	int number1 = 12, number2 = 6;
	System.out.println(number1 + number2);
	System.out.println(number1 * number2);
// 2.請設計一隻Java程式，計算200顆蛋共是幾打幾顆?(一打為12顆)
	int egg = 200;
	int dozen = egg / 12, restEgg = egg % 12; // dozen為打, restEgg為剩幾顆
	System.out.println(dozen + "打" + restEgg + "顆");
// 3.請由程式算出256559秒為多少天、多少小時、多少分與多少秒
	// perMinute = 每分, perHour = 每小時, perDay = 每天
	int totalTime = 256559, perMinute = 60, perHour = 60 * perMinute, perDay = 24 * perHour;
	int days = totalTime / perDay, hours = (totalTime % perDay) / perHour, minutes = ((totalTime % perDay) % perHour) / perMinute, seconds = totalTime % perMinute;
	System.out.println(days + "天" + hours + "小時" + minutes + "分" + seconds + "秒");
// 4.請定義一個常數為3.1415(圓周率)，並計算半徑為5的圓面積與圓周長
	double pi = 3.1415, radius = 5;
	double circleArea = Math.pow(radius,2) * pi, circlePerimeter = 2 * pi * radius; // 圓面積公式 = pi*radius^2, 圓周長公式 = 2*pi*radius
	System.out.print("圓面積 = " + circleArea + "\n" + "圓周長 = " + circlePerimeter + "\n");
// 5.某人在銀行存入150萬，銀行利率為2%，如果每年利息都繼續存入銀行，請用程式計算10年後，本金加利息共有多少錢 (用複利計算)
	double principal = 150000000, rate = 1.02;
	System.out.println(principal * Math.pow(rate, 10)); // 等比級數 10年利率 = 利率n次方
// 6.請寫一個程式，利用Systemp.out.println()印出以下三個運算式結果:
//	5 + 5
//	5 + '5'
//	5 + "5"
	System.out.println( "5" + " + " + "5");
	System.out.println( 5 + " + " + "\'5\'");
	System.out.println( 5 + " + " + "\"5\"");
	}
}