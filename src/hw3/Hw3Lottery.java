package hw3;

// 阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
// 厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇
// 的號碼與總數
	
import java.util.Scanner;

public class Hw3Lottery {
	public static void main(String[] args) {
		System.out.println("阿文...請輸入你討厭哪個數字 ?");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int sum1 = 0;
		for (int n = 1; n <= 49; n++) {
			if ( n % 10 == number ){
				
			}
			else if ( n / (number * 10) == 1){

			}
			else {
				System.out.print(n + " ");
				sum1++;
			}
		}
		System.out.println();
		System.out.println("總共有 " + sum1 + " 個數字可選");
	}
}