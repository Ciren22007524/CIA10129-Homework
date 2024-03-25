package hw8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Hw8TrainTest {
	public static void main(String[] args) {
		// 將題目所給Train對象放入trainList集合中
//		List<Train> trainList = new ArrayList<>();
		var trainList = new ArrayList<Train>();
		trainList.add(new Train(202, "普悠瑪", "樹林", "花蓮", 400));
		trainList.add(new Train(1254, "區間", "屏東", "基隆", 700));
		trainList.add(new Train(118, "自強", "高雄", "台北", 500));
		trainList.add(new Train(1288, "區間", "新竹", "基隆", 400));
		trainList.add(new Train(122, "自強", "台中", "花蓮", 600));
		trainList.add(new Train(1222, "區間", "樹林", "七堵", 300));
		trainList.add(new Train(1254, "區間", "屏東", "基隆", 700));
		Hw8TrainTest TrainTest = new Hw8TrainTest();
		System.out.println("1.不重複的Train物件");
		TrainTest.schedule(trainList);
		System.out.println("2.班次編號由大到小");
		TrainTest.reversedOrder(trainList);
		System.out.println("3.班次編號由大到小，不重複的Train物件");
		TrainTest.sortedSchedule(trainList);
	}
	
//	請寫一隻程式，能印出不重複的Train物件
	public void schedule(List<Train> trainList) {
		Set<Train> trains = new HashSet<>(trainList);
		// 1.迭代器
//		Iterator it = trains.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		// 2.for-each
//		for(Train t : trains) {
//			System.out.println(t);
//		}
		for(var element : trains) {
			System.out.println(element);
		}
	}
	
//	請寫一隻程式，讓Train物件印出時，能以班次編號由大到小印出
	// 使用Collections內的sort()方法排序
	//     1.Collections.sort(List<T> list);<T extends Comparable>
	//     2.Collections.sort(List<T> list, Comparator<? super T> c)
	// 補充 : 使用Collections內的sort()方法，物件本身可以
	//       1.實作Comparable(告訴sort()要依哪個規則排序)
	//       2.實作Comparator指定排序方式
	// 本次使用指定Comparator的方式
	// 並利用Comparator物件內的方法comparingInt()、reversed()將排序顛倒(這兩個方法皆返回Comparator)
	// comparingInt(ToIntFunction<? super T> keyExtractor)
	// ToIntFunction使用Lambda Train::getNumber取班次值
	public void reversedOrder(List<Train> trainList) {
		Collections.sort(trainList, Comparator.comparingInt(Train::getNumber).reversed());
		// 1.迭代器
//		Iterator it = trainList.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		// 2.for迴圈
//		for(int i = 0; i < trainList.size(); i++) {
//			System.out.println(trainList.get(i));
//		}
		// 3.for-each
//		for(Train t : trainList) {
//			System.out.println(t);
//			System.out.println(t.getNumber());
//		}
		for(var element : trainList) {
			System.out.println(element);
		}
	}
	
//	承上，不僅能讓班次編號由大排到小印出，還可以不重複印出Train物件
	public void sortedSchedule(List<Train> trainList) {
		// 使用TreeSet條件
		// 1.物件必須是Comparable
		// 2.需指定Comparator物件
		Set<Train> trains = new TreeSet<>(Comparator.comparingInt(Train::getNumber));
		trains.addAll(trainList);
		// 1.迭代器
//		Iterator it = trains.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		// 2.for-each
//		for(Train t : trains) {
//			System.out.println(t.getNumber());
//			System.out.println(t);
//		}
		for(var element : trains) {
			System.out.println(element);
		}
	}
}
