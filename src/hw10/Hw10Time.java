package hw10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hw10Time {
//	請設計一隻程式，讓使用者輸入日期(年月日，例如:20110131)後，可以轉成想要的輸出格式化成(1)
//	年/月/日(2)月/日/年(3)日/月/年三選一，而輸入非指定日期數字格式會顯示出提示訊息如圖
//	(提示：TestFormatter.java, Java API文件，判斷格式可用正規表示法)
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("請輸入日期（年月日，例如:20110131）：");
        String inputDate = sc.nextLine();

        // 使用正規表達式檢查輸入日期格式是否正確
        Pattern pattern = Pattern.compile("^\\d{8}$");
        Matcher matcher = pattern.matcher(inputDate);

        if (!matcher.matches()) {
            System.out.println("輸入日期格式錯誤！");
            return;
        }

        // 提示用戶選擇輸出格式
        System.out.println("請選擇輸出格式：");
        System.out.println("1. 年/月/日");
        System.out.println("2. 月/日/年");
        System.out.println("3. 日/月/年");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                formatOutput(inputDate, "年", "月", "日");
                break;
            case 2:
                formatOutput(inputDate, "月", "日", "年");
                break;
            case 3:
                formatOutput(inputDate, "日", "月", "年");
                break;
            default:
                System.out.println("輸入選項無效！");
        }
    }

    private static void formatOutput(String inputDate, String first, String second, String third) {
        String year = inputDate.substring(0, 4);
        String month = inputDate.substring(4, 6);
        String day = inputDate.substring(6, 8);
        System.out.println(year + first + "/" + month + second + "/" + day + third);
    }
}
