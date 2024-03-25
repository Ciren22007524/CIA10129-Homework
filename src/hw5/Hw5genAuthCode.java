package hw5;

public class Hw5genAuthCode {
	public static void main(String[] args) {
		Hw5genAuthCode g = new Hw5genAuthCode();
		g.genAuthCode();
	}
	public void genAuthCode() {
		System.out.println("本次隨機產生驗證碼為 :");
		for (int i = 0; i < 8; i++) {
//			ASCII 數字48~57、英文大寫65~90、英文小寫97~122
			int random = (int)(Math.random()*62);
			if (random < 10) {
				random += 48;
			} else if (random >= 10 && random < 36) {
				random += 55;
			} else {
				random += 61;
			}
			char c = (char) random;
			System.out.print(c);
		}

	}

	
}
