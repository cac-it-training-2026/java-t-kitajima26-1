package advanced.question07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question07_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 登録済み商品（値は変更可）
		String[] itemNames = { "ノート", "ボールペン", "消しゴム", "はさみ", "のり" };
		// 単価（値は変更可）
		int[] prices = { 100, 200, 300, 400, 500 };
		// 購入数（変更不可）
		int[] amounts = new int[5];

		// TODO: 実装ここから

		int[] stocks = new int[5];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < itemNames.length; i++) {
			System.out.print(itemNames[i] + "の在庫数:>");
			stocks[i] = Integer.parseInt(br.readLine());
		}
		int buyNum;
		for (int i = 0; i < itemNames.length; i++) {
			System.out.print(itemNames[i] + "の購入数:>");
			buyNum = Integer.parseInt(br.readLine());
			if (buyNum <= stocks[i]) {
				amounts[i] = buyNum;
				stocks[i] -= buyNum;
			} else {
				System.out.println("在庫を超えています。もう一度入力してください。");
				i--;
			}
		}

		for (int i = 0; i < itemNames.length; i++) {
			System.out.println(itemNames[i] + "：購入" + amounts[i] + "個\n在庫" + stocks[i] + "個");
		}
		int total = 0;
		for (int i = 0; i < itemNames.length; i++) {
			total += amounts[i] * prices[i];
		}
		System.out.println("合計金額" + total + "円");

	}
}
