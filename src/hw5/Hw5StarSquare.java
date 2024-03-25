package hw5;

import java.util.Scanner;

public class Hw5StarSquare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int array[] = new int[2];
		System.out.println("請輸入寬與高 : ");
		int n = 0;
		while(n < 2){
			array[n] = sc.nextInt();
			if (array[n] == 0) {
				System.out.println("輸入數字不可為0");
				continue;
			} else if (array[n] < 0){
				System.out.println("輸入數字不可為負數");
				continue;
			}
			n++;
		}
		Hw5StarSquare h = new Hw5StarSquare();
		h.starSquare(array[0], array[1]);
	}
	public void starSquare(int width, int height){
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
