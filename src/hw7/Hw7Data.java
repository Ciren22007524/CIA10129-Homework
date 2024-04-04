package hw7;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class Hw7Data {
	public static void main(String[] args) {
//		• 請寫一隻程式，能夠亂數產生10個1～1000的整數，並寫入一個名為Data.txt的檔案裡(請使用
//		  append功能讓每次執行結果都能被保存起來)
		int[] array = new int[10]; // 宣告array矩陣，用於放入隨機生成參數
		String src = "C:\\CIA101_Workspace\\CIA10129-Homework\\src\\hw7\\Data.txt";
		// try-with-resource
		try(FileOutputStream fos = new FileOutputStream(src, true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			PrintStream ps = new PrintStream(bos)) {
			for(int i = 0; i < 10; i++) {
				array[i] = (int) (Math.random() * 1000) + 1; // 產生1~1000隨機數字
				ps.println(array[i]); // 寫入
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 2. NIO
        // 要寫入的文件路徑
        Path path = Paths.get(src);
        
        // 創建隨機數生成器
        Random random = new Random();

        // 打開文件並寫入數據
        try {
            // 打開文件，如果不存在則創建，使用追加模式
            Files.createDirectories(path.getParent());
            // 追加模式
            Files.writeString(path, "", StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            // 生成隨機數
            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(1000) + 1; // 生成1到1000的隨機數
                // 寫入數據，每個數字佔一行
                Files.writeString(path, String.valueOf(randomNumber) + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. Stream
        // 要寫入的文件路徑
        Path path = Paths.get("C:\\CIA101_Workspace\\CIA10129-Homework\\src\\hw7\\Data.txt");

        // 建立Random物件生成隨機數
        Random random = new Random();

        // 生成隨機數並轉成字串
        String data = random.ints(10, 1, 1001) // 生成10個1到1000之間的隨機數
                .mapToObj(String::valueOf) // 將隨機數轉成字串
                .reduce("", (s1, s2) -> s1 + s2 + "\n"); // 拼接成一個字串拼，每個數字佔一行

        // 寫入數據到文件
        try {
            Files.write(path, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
// =========================舊答案=====================================
		// try-catch
//		try {
//			// append參數 true
//			FileOutputStream fos = new FileOutputStream("C:\\CIA101_Workspace\\CIA10129-Homework\\src\\hw7\\Data.txt", true);
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			PrintStream ps = new PrintStream(bos); 
//			
//			
//			for (int i = 0; i < 10; i++) {
//				array[i] = (int) (Math.random() * 1000) + 1; // 產生1~1000隨機數字
//				ps.println(array[i]); // 寫入
//			}
//			
//			ps.close();
//			bos.close();
//			fos.close();
//			
//		} catch (IOException e) {
//			
//		}
	}
}
