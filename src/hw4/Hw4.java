package hw4;

public class Hw4 {
	public static void main(String[] args) {
//1.有個一維陣列如下：
//{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//(提示：陣列，length屬性)
		int[] arr1 = { 29, 100, 39, 41, 50, 8, 66, 77, 95, 15 };
		int sum = 0;

		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i];
		}
		double avg = sum / arr1.length;
		System.out.println("平均值=" + avg);
		System.out.println("大於平均值的元素為");
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] > avg) {
				System.out.print(arr1[i] + " ");
			}
		}
		System.out.println();
		System.out.println("================================");
//2.請建立一個字串，經過程式執行後，輸入結果是反過來的
//例如String s = “Hello World”，執行結果即為dlroW olleH
//(提示：String方法，陣列)
		String s1 = "Hello World";
		System.out.println("字串反轉前 " + s1);
		char[] arr2 = new char[s1.length()];
		for (int i = 0; i < s1.length(); i++) {
			arr2[i] = s1.charAt((s1.length() - 1) - i);
		}
		System.out.print("字串反轉後 ");
		for (int i = 0; i < s1.length(); i++) {
			System.out.print(arr2[i]);
		}
		System.out.println();
		System.out.println("================================");
//		法二:		
//		String reverse = new StringBuffer(s1).reverse().toString();
//		System.out.println("字串反轉前 " + s1);
//		System.out.println("字串反轉後 " + reverse);

//3.有個字串陣列如下 (八大行星)：
//{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u) 
//(提示：字元比對，String方法
		String[] c1 = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		String sp = " "; // 空白值做字串比較
		int sum1 = 0; // 計算共多少母音
		// 使用陣列，將c1各項字串放入t1矩陣(char)，強制轉換為t2對每個字元做比對
		for (int i = 0; i < c1.length; i++) {
			
			                 // 各項字串長度
			for (int j = 0; j < c1[i].length(); j++) {
				char[] t1 = new char[c1[i].length()];
				t1[j] = c1[i].charAt(j);
				String[] t2 = new String[c1[i].length()];
				t2[j] = String.valueOf(t1[j]); // 強制轉換為String
				int a = t2[j].compareTo(sp); // 比對結果
				// ASCII值 " "= 32, a = 97, e = 101, i = 105, o = 111, u = 117
				// 字串比對結果: a = 65, e = 69, i = 73, o = 79, u = 85
				if (a == 65 || a == 69 || a == 73 || a == 79 || a == 85) {
					sum1++;
				}
			}
		}
		System.out.println("總共有" + sum1 + "個母音");
		System.out.println("================================");
	}

}
