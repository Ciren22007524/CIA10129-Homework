package hw6;

import java.util.Scanner;

public class CalTest {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				System.out.println("請輸入x的值:");
				int x = sc.nextInt();
				System.out.println("請輸入y的值:");
				int y = sc.nextInt();
				
				if (x == 0 && y == 0) {
					throw new CalException("0的0次方沒有意義!");
				} else if (y < 0) {
					throw new CalException("次方為負值，結果回傳不為整數!");
				}
				System.out.println(x + "的" + y + "次方等於" + c.powerXY(x, y));
				break;
			} catch (CalException ce) {
				System.out.println(ce.getMessage());
			} catch (Exception e) {
				System.out.println("輸入格式不正確");
				sc.next(); // 清除輸入字元(當Scanner中輸入字元非預期Type，
				           // 系統讀取輸入流會停留在相同位置，因此需要做清除)
			}
//			if (x == 0 && y == 0) {
//				System.out.println("0的0次方沒有意義!");
//			} else if (y < 0) {
//				System.out.println("次方為負值，結果回傳不為整數!");
//			} else {
//				System.out.println(x + "的" + y + "次方等於" + c.powerXY(x, y));		
//				break;
//			}
		}		
	}
}
