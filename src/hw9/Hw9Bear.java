package hw9;


public class Hw9Bear {
//	熊大在念大學,生活費倚靠媽媽。媽媽怕熊大一天到晚領錢亂花,不好好唸書,
//	所以只要看到熊大帳戶的餘額超過3000元,就會停止匯款給熊大;但要是帳戶
//	餘額在2000元以下,熊大就會要求媽媽匯款給他。如果帳戶餘額低於熊大要提
//	款的金額,熊大就會暫停提款,直到媽媽告知他錢已經入帳戶。假設媽媽一次匯
//	款2000 元,熊大一次提款1000元,寫一個Java程式模擬匯款10次與提款10次
//	的情形。
	public static void main(String[] args) {
		CashFlow cashflow = new CashFlow(); // 建立金流物件
		Bear bear = new Bear(cashflow); // 建立熊大執行緒
		BearMom bearMom = new BearMom(cashflow); // 建立熊媽執行緒
		// 因匯入金額與領出金額不同，當熊大都領完之後JVM會繼續執行(熊媽無法匯10次以上)
		bearMom.setDaemon(true); // 設定為Daemon，當熊大領完以後讓熊媽休息
		bearMom.start();
		bear.start();
	}
}

class CashFlow {
	private int savings = 0;
	private int n, m; //計次用
	synchronized public void withdraw(int money) {
		while(savings == 0) {
			System.out.println("熊大看到帳戶沒錢，暫停提款");
			System.out.println("媽媽被熊大要求匯款!");
			try {
				notify();
				wait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		savings -= money;
		n++;
		System.out.println("熊大領了1000，帳戶共有:" + savings + " (熊大領了" + n + "次)");
		if(savings <= 2000) {
			System.out.println("熊大看到餘額在2000以下，要求匯款");
			notify();
		}
	}
	synchronized public void save(int money) {
		while(savings > 3000) {
			System.out.println("媽媽看到餘額在3000以上，暫停匯款");
			System.out.println("熊大被老媽告知帳戶已經有錢!");
			try{
				notify();
				wait();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		savings += money;
		m++;
		System.out.println("媽媽存了2000，帳戶共有:" + savings + " (熊媽匯了" + m + "次)");
	}
}
class Bear extends Thread {
	CashFlow cashflow;
	public Bear(CashFlow cashflow) {
		this.cashflow = cashflow;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 提款10次
		for(int i = 1; i <= 10; i++) {
			cashflow.withdraw(1000); // 每次領1000
		}
	}
}

class BearMom extends Thread {
	CashFlow cashflow;
	public BearMom(CashFlow cashflow) {
		this.cashflow = cashflow;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 匯款10次
		for(int i = 1; i <= 10; i++) {
			cashflow.save(2000); // 每次存2000
		}
	}
}