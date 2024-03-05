package hw2;

import java.util.Scanner;

import java.util.Random;

public class hw2_2 {

	public static void main(String[] args) {

		Random rand = new Random();

		int ans=rand.nextInt(100);
		int min=0;
		int max=100;
		int guess=0;

		Scanner sc=new Scanner(System.in);

		while(true) {

			System.out.println("目前範圍: " + min + " - " + max);
			System.out.print("請輸入一個數字");
			guess=sc.nextInt();

			if(guess>ans) {
				System.out.println("你猜的答案太大了");
				max=guess-1;
			}else if(guess<ans) {
				System.out.println("你猜的答案太小了");
				min=guess+1;
			}else{
				System.out.println("你猜對答案了");
				break;
			}

		}

		// TODO Auto-generated method stub



	}



}
