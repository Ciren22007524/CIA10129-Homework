=package hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Hw8Collection {
	public static void main(String[] args) {
//	• 請建立一個Collection物件並將以下資料加入：
//	  Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
//	  Object物件、“Snoopy”、BigInteger(“1000”)
		// 使用雙括號初始化
		Collection<Object> collection = new ArrayList<>() {{
			add(Integer.valueOf(100));
			add(Double.valueOf(3.14));
			add(Long.valueOf(21L));
			// add(Short.valueOf(100));編譯錯誤!!!因short小於int
			// constructor:1.Short(short value)
			// 			   2.Short(String s)
			add(Short.valueOf("100"));
			add(Double.valueOf(5.1));
			add("Kitty");
			add(Integer.valueOf(100));
			add(new Object());
			add("Snoopy");
			add(new BigInteger("1000"));
		}};
//	• 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
		System.out.println("1.使用Iterator :");
		// 1. Iterator
		Iterator it = collection.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("===================");
		System.out.println("2.使用傳統for :");
		// 2. 傳統for
		// Collection介面無走訪其他元素的方法
		// 使用ArrayList (因ArrayList有索引值)，並使用裡面的get方法
		for(int i = 0; i < collection.size(); i++) {
			// Collection cast to ArrayList
			System.out.println(((ArrayList<Object>)collection).get(i));
		}
		System.out.println("===================");
		System.out.println("3.使用for-each :");
		// 3. for-each
		for(Object o : collection) {
			System.out.println(o);
		}
		// 4. 良葛格寫法
		System.out.println("===================");
		System.out.println("4. 良葛格寫法 :");
		for(var element : collection) {
			System.out.println(element);
		}
		// 5. lambda 
		System.out.println("===================");
		System.out.println("5. lambda :");
		collection.forEach(element -> System.out.println(element));
		// 6. lambda 參考特定物件的實例方法
		System.out.println("===================");
		System.out.println("6. lambda 參考特定物件的實例方法 :");
		collection.forEach(System.out::println);
		
//	• 移除不是java.lang.Number相關的物件
		// 使用instanceof檢查Object是否為Number類別
		// 因上次宣告使用iterator以遍歷到末端，重置iterator
		it = collection.iterator();
		while(it.hasNext()) {
			if (!(it.next() instanceof Number)) {
				it.remove();
			}
		}
		System.out.println("===================");
		System.out.println("移除不是java.lang.Number相關的物件後");
//	• 再次印出這個集合物件的所有元素，觀察是否已將非Number相關的物件移除成功
		for(Object o : collection) {
			System.out.println(o);
		}
	}
}
