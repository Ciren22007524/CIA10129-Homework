package hw4;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Hw4Test {
	public static void main(String[] args) {
		// 題目所提供成績單
		int[][] arr1 = {
				{ 10, 35, 40, 100, 90, 85, 75, 70 },
				{ 37, 75, 77, 89, 64, 75, 70, 95 },
				{ 100, 70, 79, 90, 75, 70, 79, 90 },
				{ 77, 95, 70, 89, 60, 75, 85, 89 },
				{ 98, 70, 89, 90, 75, 90, 89, 90 },
				{ 90, 80, 100, 75, 50, 20, 99, 75 },
		};
		// 新增一相同陣列做比較
		int[][] arr2 = new int[arr1.length][];
		for (int i = 0; i < arr1.length; i++) {
		    arr2[i] = Arrays.copyOf(arr1[i], arr1[i].length);
		}
		int[] arr3 = new int[8]; // 計算考最高分次數
		for (int i = 0; i < arr1.length; i++) {
			Arrays.sort(arr1[i]); // 對arr1排序，最高分位於最後一項
			for (int j = 0; j < arr1[i].length; j++) {
				// 比對兩陣列(比對排序後最後一項，即最高分項次)
				if(arr1[i][(arr1[i].length-1)] == arr2[i][j]) {
					arr3[j]++;
					break;
				}
			}
		}
		for (int i = 0; i < arr3.length; i ++) {
			System.out.println("第" + (i+1) + "號考最高分" + arr3[i] + "次");
		}
		// Stream
		System.out.println("==========lambda==========");
		int[] arr4 = new int[8]; // 計算考最高分次數
		// 比對arr2(arr1操作過了)
		for(int i = 0; i < arr2.length; i++) {
			// 使用max()方法找到最大值(返回OptionalInt)，
			// 再使用OptionalInt類別的getAsInt()方法取值
			int Maxgrade = Arrays.stream(arr2[i]).max().getAsInt();
			for(int j = 0; j < arr2[i].length; j++) {
				if(arr2[i][j] == Maxgrade) {
					arr4[j]++; // 對應號碼的同學++
					break;
				}
			}
		}
		for (int i = 0; i < arr4.length; i ++) {
			System.out.println("第" + (i+1) + "號考最高分" + arr4[i] + "次");
		}

	}
}
