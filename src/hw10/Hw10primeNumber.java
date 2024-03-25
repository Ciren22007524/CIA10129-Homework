package hw10;

import java.util.HashSet;

public class Hw10primeNumber {
	public static void main(String[] args) {
// 請設計一隻程式，用亂數產生5個介於1～100之間的整數，而輸出結果可以判斷出這5個整數為是否
// 為質數 (提示：Math類別)
		// 隨機生成5個亂數
		var set = new HashSet<Integer>();
		do {
			set.add((int)(Math.random()*100) + 1);
		} while(set.size() < 5);
		// 判斷是否為質數
		for(var element : set) {
	        if (element <= 1) {
	        	System.out.println(element + "不是質數");
	            continue;
	        }
	        if (element <= 3) {
	        	System.out.println(element + "是質數");
	            continue;
	        }
	        if (element % 2 == 0 || element % 3 == 0) {
	        	System.out.println(element + "不是質數");
	            continue;
	        }
	        int i = 5;
	        while (i * i <= element) {
	            if (element % i == 0 || element % (i + 2) == 0) {
	            	System.out.println(element + "不是質數");
	                continue;
	            }
	            i += 6;
	        }
	        System.out.println(element + "是質數");
		}
	}
}

