package hw3;

// 阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
// 厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字 (1~9)後,直接亂數印出6個號
// 碼且不得重複

import java.util.Scanner;

public class Hw3LotteryProgress {
    public static void main(String[] args) {
        System.out.println("阿文...請輸入你討厭哪個數字 ?");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] arr = new int[6]; // 宣告矩陣，用來存放生成數字(矩陣內數字不重複)
        int n = 0; // 計數用
        
        // 使用while迴圈，迴圈內:(生成亂數 -> if過濾不喜歡數字 -> 檢查是否重複(使用矩陣) -> 列印)
        while (n < 6) {
            int a = (int) (Math.random() * 49) + 1; // 產生 1~49 的亂數

            // 確認數字是否為不喜歡數字，若符合則重新生成數字
            // 個位數為除以10餘數相同，十位數為除以數字*10等於1.X者 
            if (a % 10 == number || a / (number * 10) == 1 ) {
                continue; 
            }
            
            // 用for迴圈與矩陣內數字做比較，使用布林值，出現相同數字改變布林值，於下式被剔除
            boolean b = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == a) {
                    b = true;
                    break;
                }
            }
            
            // 將數字放入矩陣
            if (!b) {
                arr[n++] = a;
            }
            // 列印矩陣內數字，上式n++因此列印(n-1)
            System.out.print(arr[(n-1)] + " ");
        }
        System.out.println();
    }
}