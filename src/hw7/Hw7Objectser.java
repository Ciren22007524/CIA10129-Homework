package hw7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Hw7Objectser {
//	• 請寫一支程式，利用老師提供的Dog與Cat類別分別產生兩個物件，寫到C:\data\Object.ser裡。注
//	  意物件寫入需注意的事項，若C:\內沒有data資料夾，請用程式新增這個資料夾
	public static void main(String[] args) {
		// 建立Data directory
		File datadir = new File("C://data");
		if (!datadir.exists()) {
			datadir.mkdir();
		}
		
		// 建立file物件，並使用ObjectOutputStream將物件寫入
		File objectSer = new File("C://data//Object.ser");
		
		// 實體化cat、dog物件，用於將檔案寫入
		Animal cat = new Cat("kitty");
		Animal dog = new Dog("watchDog");
		
		// try-with-resource
		// 建立OutputStream並接上ObjectOutputStream，使用此資料流物件
		// 的方法writeObject(Object);將物件寫入
		try (FileOutputStream fos = new FileOutputStream(objectSer);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(cat);
			oos.writeObject(dog);
			
			System.out.println("成功寫入檔案!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// try-catch
//		try {
//			FileOutputStream fos = new FileOutputStream(objectSer);
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			
//			oos.writeObject(cat);
//			oos.writeObject(dog);
//			
//			oos.close();
//			fos.close();
		
//			System.out.println("寫入檔案完成!!!");
		
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
}
