package hw7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Sample {
	public static void main(String[] args) {
//		• 請自行建立一個文字檔Sample.txt，內容如下：
//		請寫一個程式讀取這個Sample.txt檔案，並輸出以下訊息：
//		Sample.txt檔案共有xxx個位元組，yyy個字元，zzz列資料

		// 建立File物件
		String src = "C:\\CIA101_Workspace\\CIA10129-Homework\\src\\hw7\\Sample.txt";
		File file = new File(src);

		int bytesLength = 0; // 計算xxx位元組
		int charLength = 0; // 計算yyy個字元
		int countLines = 0; // 計算zzz列資料
		// 1. 傳統IO
		System.out.println("1. 傳統IO");
		// try-with-resource
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				bytesLength += line.getBytes().length;
				charLength += line.length();
				// 剔除空白行
				if (!line.isEmpty()) {
					countLines++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Sample.txt檔案共有" + bytesLength + "個位元組，" + charLength + "個字元，" + countLines + "列資料");
		System.out.println("=================");
		// 2. NIO : 使用channel、buffer傳送
		// 歸零充新記數
		bytesLength = 0;
		charLength = 0;
		countLines = 0;
		// 建立ByteBuffer緩存
		var buffer = ByteBuffer.allocate(1024);
		try(FileChannel readChannel = FileChannel.open(Paths.get(src), StandardOpenOption.READ)){
			// 讀取檔案內容到Buffer中
			while(readChannel.read(buffer) != -1) {
				// 設定Buffer為讀取模式
				buffer.flip();
				// 讀取Buffer中的資料
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    // 更新統計數據
                    bytesLength++;
                    if (b == '\n') {
                        countLines++;
                    }
                }
                // 清空Buffer，準備下一次讀取
                buffer.clear();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sample.txt檔案共有" + bytesLength + "個位元組，" + charLength + "個字元，" + countLines + "列資料");
		System.out.println("=================");
		// 3. NIO2 : 使用files、paths類別
		// 用Files類別的readAllLines方法將資料全部讀取後計算
		System.out.println("2. NIO");
		// 歸零充新記數
		bytesLength = 0;
		charLength = 0;
		countLines = 0;
		// NIO2的files類別會自動關閉資源，因此直接try-catch即可
		try {
			// Files類別方法: lines(Path path), readAllLines(Path path)
			// Paths類別方法: Paths.get(String),Paths.get(URI uri)
			// 在NIO2中，取得路徑Path實例為操作的起點
			List<String> lines = Files.readAllLines(Paths.get(src));
			for (var line : lines) {
				bytesLength += line.getBytes().length;
				charLength += line.length();
				// 剔除空白行
				if (!line.isEmpty()) {
					countLines++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sample.txt檔案共有" + bytesLength + "個位元組，" + charLength + "個字元，" + countLines + "列資料");
		System.out.println("=================");
		// 4. 可用files.newBufferedReader()方法，取得Reader物件後與方法1操作相同
		// BufferReader br = Files.newBufferedReader(Paths.get(src));
		// 5. Stream 管線操作
		System.out.println("3. Stream惰性求值");
		// 歸零充新記數
		bytesLength = 0;
		charLength = 0;
		countLines = 0;
		List<String> linesList = new ArrayList<>();
		// try-with-resource
		// lines()內部會開啟檔案，需要呼叫close()釋放資源
        try (Stream<String> lines = Files.lines(Paths.get(src))) {
        	// Stream只能迭代一次，已下編譯會導致IllegalStateException
//            bytesLength = lines.mapToInt(line -> line.getBytes().length).sum();
//            charLength = lines.mapToInt(String::length).sum();
//            countLines = (int) lines.filter(line -> !line.isEmpty()).count();
        	// 改用將Stream放到Buffer後使用調用
        	lines.forEach(linesList::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        bytesLength = linesList.stream().mapToInt(line -> line.getBytes().length).sum();
        charLength = linesList.stream().mapToInt(String::length).sum();
        countLines = (int)linesList.stream().filter(line -> !line.isEmpty()).count();
        
		System.out.println("Sample.txt檔案共有" + bytesLength + "個位元組，" + charLength + "個字元，" + countLines + "列資料");
// =========================舊答案=====================================
		// try-catch
//		try {
//			// 建立Reader資料流，並使用高階資料流Buffer
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
//			
//			// 宣告字串line
//			String line;
//			// 呼叫Reader內Method : .readLine()，讀取文件的下一行並將其返回為字串
//			// 使用while迴圈，每次呼叫.readLine() Method會從第一行開始讀取，當資料
//			// 讀到末端回傳null即停止迴圈
//			while ((line = br.readLine()) != null) {
////				System.out.println(line);
////				System.out.println(line.getBytes().length); // 確認空白行為0
//				bytesLength += line.getBytes().length;
//				charLength += line.length();
//				// .isEmpty()如字串長度為0，回傳true -- 用!反轉符號剔除空白行
//				if (!line.isEmpty()) {
//					countLines ++;
//				}
//			}
//			System.out.println("Sample.txt檔案共有" + bytesLength + "個位元組，" + charLength + "個字元，" + countLines + "列資料");
//			br.close();
//			fr.close();
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		}

// ==================================================================================
//		測試區
		// 測試getBytes().length
		// 空白、Tab、\t、\n皆為1 bytes(但用4個空白取代Tab為 4 bytes)
		// 標點符號,.{[-_+為 1 bytes;中文標點符號、，。為 3 bytes;·為 2 bytes
		// 數字、英文字母 1 bytes，中文為 3 bytes
//		String s1 = "-_-";
//		System.out.println(s1.getBytes().length);
		// 測試Java內建String是否為UTF-8格式
//		byte[] utf8Bytes = s1.getBytes("UTF-8");
//		System.out.println(utf8Bytes.length);
	}
}
