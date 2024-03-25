package hw4;

import java.util.Arrays;
import java.util.stream.Stream;

public class Hw4 {
	public static void main(String[] args) {
//1.有個一維陣列如下：
//{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//(提示：陣列，length屬性)
		int[] arr = { 29, 100, 39, 41, 50, 8, 66, 77, 95, 15 };
		int sum = 0;
// ==========計算平均數==========
		// 1.for迴圈
//		for (int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
//		double avg = sum / arr.length;
		// 2.for-each
//		for(int i : arr) {
//			sum += i;
//		}
//		double avg = sum / arr.length;
		// 3.Stream
		// 使用Arrays.stream(array)方法取得Stream實例後操作
		double avg = Arrays.stream(arr)
						   // average()會返回Optional double(避免空值的機制)，因此需要銜接orElse
						   .average()
						   // 將Optional double值轉成double(直接返回Optional實例的值，若為空值則返回小括弧內的值)
						   .orElse(0);
		System.out.println("平均值=" + avg);
// ==========列印大於平均數的元素==========
		System.out.println("大於平均值的元素為");
		// for迴圈
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] > avg) {
//				System.out.print(arr[i] + " ");
//			}
//		}
//		 for-each
//		for(int i : arr) {
//			if(i > avg) {
//				System.out.print(i + " ");
//			}
//		}
		// Stream
		Arrays.stream(arr)
			  // 過濾大於平均值的元素
			  .filter(n -> (n > avg))
			  .forEach(n -> System.out.print(n + " "));
		System.out.println();
		System.out.println("================================");
//2.請建立一個字串，經過程式執行後，輸入結果是反過來的
//例如String s = “Hello World”，執行結果即為dlroW olleH
//(提示：String方法，陣列)
		String str = "Hello World";
		System.out.println("字串反轉前 " + str);
		System.out.print("字串反轉後 ");
		// 使用toCharArray()方法獲得字元陣列
		char[] charArray = str.toCharArray();
		// 倒序列印
		for(int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[charArray.length - (1 + i)]);
		}
		// 2.StringBuffer的reverse()方法
//		String str = "Hello World";
//		System.out.println("字串反轉前 " + str);
//		String reverse = new StringBuffer(str).reverse().toString();
//		System.out.println("字串反轉後 " + reverse);
// ==========舊方法==========
//		char[] arr2 = new char[str.length()]; // 宣告一陣列，用來放反轉後陣列
//		for (int i = 0; i < str.length(); i++) {
//			arr2[i] = str.charAt((str.length() - 1) - i);
//		}
//		for (int i = 0; i < str.length(); i++) {
//		System.out.print(arr2[i]);
//	}
		System.out.println();
		System.out.println("================================");
//3.有個字串陣列如下 (八大行星)：
//{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u) 
//(提示：字元比對，String方法
		String[] words = { "mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune" };
		// 1.for + switch case
//		int sum1 = 0; // 計算共多少母音
//		for (int i = 0; i < words.length; i++) {
//			                  // 各單字長度
//			for (int j = 0; j < words[i].length(); j++) {
//				      // 比對各單字字母
//				switch (words[i].charAt(j)) {
//				case 'a':
//					sum1++;
//					break;
//				case 'e':
//					sum1++;
//					break;
//				case 'i':
//					sum1++;
//					break;
//				case 'o':
//					sum1++;
//					break;
//				case 'u':
//					sum1++;
//					break;
//				}
//			}
//
//		}
//		System.out.println("總共有" + sum1 + "個母音");
//		System.out.println("================================");
		// 2.Stream
		int vowelCount = Arrays.stream(words)
							   .mapToInt(word -> (int) word.chars().filter(c -> "aeiou".indexOf(c) >= 0).count())
							   .sum();
		System.out.println("總共有" + vowelCount + "個母音");
//==========舊方法==========
		// 字元比對
//		String sp = " "; // 空白值做字串比較
//		int sum1 = 0; // 計算共多少母音
		// 使用陣列，將c1各項字串放入t1矩陣(char)，強制轉換為t2對每個字元做比對
//		for (int i = 0; i < words.length; i++) {
//			
//			                 // 各項字串長度
//			for (int j = 0; j < words[i].length(); j++) {
//				char[] t1 = new char[words[i].length()];
//				t1[j] = words[i].charAt(j);
//				String[] t2 = new String[words[i].length()];
//				t2[j] = String.valueOf(t1[j]); // 強制轉換為String
//				int a = t2[j].compareTo(sp); // 比對結果
//				// ASCII值 " "= 32, a = 97, e = 101, i = 105, o = 111, u = 117
//				// 字串比對結果: a = 65, e = 69, i = 73, o = 79, u = 85
//				if (a == 65 || a == 69 || a == 73 || a == 79 || a == 85) {
//					sum1++;
//				}
//			}
//		}
//		System.out.println("總共有" + sum1 + "個母音");
//		System.out.println("================================");
	}
}
