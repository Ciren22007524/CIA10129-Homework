package hw3;

// 請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰三角形、其它三角形或不是三角形,如圖示結果:

import java.util.Scanner;

public class Hw3Triangle {
	public static void main(String args[]) {
		System.out.println("請輸入三個正整數 : ");
		Scanner sc = new Scanner(System.in);
		int data1 = sc.nextInt();
		int data2 = sc.nextInt();
		int data3 = sc.nextInt();
		
		if ( (data1 + data2) > data3 && (data2 + data3) > data1 && (data1 + data3) > data2){
			if ( data1 == data2 && data2 == data3) {
				System.out.println("正三角形");
			} else if ( data1 == data2 || data2 == data3 || data3 == data1) {
				System.out.println("等腰三角形");
			} else {
				System.out.println("其它三角形");
			}
		} else { 
			System.out.println("不是三角形");
		}
	}
}