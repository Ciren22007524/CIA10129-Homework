package hw7;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Hw7ObjectSerSpeak {
	public static void main(String[] args) {
//    • 承上題，請寫一個程式，能讀取Object.ser這四個物件，並執行speak()方法觀察結果如何(請利用多
//      型簡化本題的程式設計)
		File objectSer = new File("C://data//Object.ser");
		readObjectSer(objectSer);
	}
	static void readObjectSer(File file) {
		// try-with-resources
		try (FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis)){
            // 從檔案中讀取物件，並利用多型將其視為 Animal 類型
            Object obj;
            while ((obj = ois.readObject()) != null) {
                // 如果該物件是 Animal 或其子類的實例，則呼叫 speak() 方法
                if (obj instanceof Animal) {
                    Animal animal = (Animal) obj;
                    animal.speak();
                }
            }
            System.out.println("讀取資料失敗");
		} catch (EOFException e) {
			// 到達檔案結尾，不需要處理
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
}
