package hw1;

public class TestNineNine {
	public static void main(String[] args) {
//		for (int i = 1; i <= 9; i++) {
//			for(int j = 1; j<=9; j++) {
//				System.out.println(i + " * " + j + " = " + i*j);
//			}
//		}
//	
// 一 : 使用for迴圈 + while迴圈
		for (int i = 1; i <= 9; i++) {
			int j = 0;
			while(j <= 8) {
				j++;
				System.out.print(i + "*" + j + "=" + i*j + "\t");
			}
			System.out.println();
		}
// 二 : 使用for迴圈 + do while迴圈
		for (int i = 1; i <=9; i++) {
			int j = 0;
			do {
				j++;
				System.out.print(i + "*" + j + "=" + i*j + "\t");
			} while (j <=8);
			System.out.println();
		}
// 三 : 使用while迴圈 + do while迴圈
		int i = 0;
		while(i <= 8) {
			i++;
			int j = 0;
			do {
				j++;
				System.out.print(i + "*" + j + "=" + i*j + "\t");
			} while (j <=8);
			System.out.println();
		}
	}
}
