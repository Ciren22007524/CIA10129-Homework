package hw7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Hw7copyFile {
//	 • 請從無到有試著完成一個方法名為copyFile，這個方法有兩個參數。呼叫此方法時，第一個參數所
//     代表的檔案會複製到第二個參數代表的檔案
	public static void main(String[] args) {
		Hw7copyFile cf = new Hw7copyFile();
		cf.copyFile1("C://CIA101_Workspace//CIA10129-Homework//src//hw7//sourceFile.txt", "C://CIA101_Workspace//CIA10129-Homework//src//hw7//copyFile.txt");
	}
	public void copyFile1(String src, String dst) {
		// try-with-resource語法
		// 小括號內放入需要執行close的Resource，當執行完後自動關閉
		try(FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos= new FileOutputStream(dst)){
			// read()方法返回int
			int fileRead;
			while ((fileRead = fis.read()) != -1) {
				fos.write(fileRead);
				fos.flush();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//try-catch
//		try{
//			FileInputStream fis = new FileInputStream(src);
//			FileOutputStream fos = new FileOutputStream(dst);
//			
			// read()方法返回int
//			int c;
//			while ((c = fis.read()) != -1) {
//				fos.write(c);
//				fos.flush();
//			}
//		
//			fis.close();
//			fos.close();
//		} catch (IOException e) {
//			System.err.println(e)
//		}
	}
	// 使用NIO2 files類別的files.copy()方法
	public void copyFile2(String src, String dst) {
		try {
			Path srcPath = Paths.get(src);
			Path dstPath = Paths.get(dst);
			Files.copy(srcPath, dstPath, StandardCopyOption.REPLACE_EXISTING);
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
