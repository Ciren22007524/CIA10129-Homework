package hw9;

public class Hw9EatingTest {
	// 執行緒的創建為透過呼叫執行緒的star()方法(開始該執行緒)，
	// JVM會呼叫執行緒Thread物件內的run()方法(定義該執行緒要執行的內容)，
	// 而開始執行緒
	// 因此欲創建執行緒可 :
	//	1. 實作Runnable介面並以建構子Thread(Runnable target)
	//	   的方式建立執行緒
	//	2. 繼承Thread(xxx is a thread)
	// 補充: 方法1.實作Runnable比較具有彈性(因類別可再繼承其他物件)
//	• 開啓2個執行緒模擬饅頭人與詹姆士參加快胃王比賽所做的
//	競賽過程。
//	• 每個動作都以Thread.sleep()暫停一下,以達到顯示效果。
//	Sleep時間由亂數產生500～3000之間的毫秒數，如圖所示
//	• 參考範例：CounterRunnable.java
//	• 需留意主執行緒執行順序
	// 創建饅頭人與詹姆士的執行緒(採用方法2的方式)
	public static void main(String[] args) {
		System.out.println("-----大胃王快食比賽開始!-----");
		BreadMan threadBM = new BreadMan();
		James threadJM = new James();
		threadBM.start();
		threadJM.start();
		// 目前有三個執行緒:
		// 1. main thread
		// 2. threadBM
		// 3. threadJM
		// 使用join()將2. 3.執行緒加入主執行緒，待其完成後結束主執行緒
		try {
			// 等待執行緒執行結束
			threadBM.join();
			threadJM.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----大胃王快食比賽結束!-----");
	}
}
class BreadMan extends Thread {
	public BreadMan() {
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 0;
		do {
			n++;
			try {
				System.out.println("饅頭人吃第" + n + "碗飯");
				Thread.sleep((int)(Math.random()*2501) + 500); // 0~2500 + 500
			} catch (Exception e){
				e.printStackTrace();
			}		
		} while (n < 10);
		System.out.println("饅頭人吃完了!");

	}

}

class James extends Thread {
	public James() {
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int n = 0;
		do {
			n++;
			try {
				System.out.println("詹姆士吃第" + n + "碗飯");
				Thread.sleep((int)(Math.random()*2501) + 500); // 0~2500 + 500
			} catch (Exception e){
				e.printStackTrace();
			}		
		} while (n < 10);
		System.out.println("詹姆士吃完了!");
	}
}