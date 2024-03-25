package hw5;

import java.util.Arrays;

public class Hw5Overloading {
	public static void main(String[] args) {
		int[][] intArray = {
				{1, 6, 3},
				{9, 5, 2}
		};
		double[][] doubleArray = {
				{1.2, 3.5, 2.2},
				{7.4, 2.1, 8.2}
		};
		Hw5Overloading w = new Hw5Overloading();
		System.out.println(w.maxElement(intArray));
		System.out.println(w.maxElement(doubleArray));
	}
	public int maxElement(int x[][]) {
		for (int i = 0; i < x.length; i++) {
			Arrays.sort(x[i]);
		}
		int array[] = new int[x.length];
		for (int j = 0; j < x.length; j++) {
			array[j] = x[j][(x[j].length-1)];
		}
		Arrays.sort(array);
		return array[(array.length)-1];
	}
	public double maxElement(double x[][]) {
		for (int i = 0; i < x.length; i++) {
			Arrays.sort(x[i]);
		}
		double array[] = new double[x.length];
		for (int j = 0; j < x.length; j++) {
			array[j] = x[j][(x[j].length-1)];
		}
		Arrays.sort(array);
		return array[(array.length)-1];
	}
}
