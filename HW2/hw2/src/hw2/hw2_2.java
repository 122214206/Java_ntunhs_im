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

			System.out.print("請輸入一個數字");

			guess=sc.nextInt();

			

			int validate_num=ans-guess;

			if(guess>0) {

				System.out.println("你猜的答案太小了");

			}else if(validate_num<0) {

				System.out.println("你猜的答案太大了");

			}else{

				System.out.println("你猜對答案了");

				break;

			}

		}

		// TODO Auto-generated method stub



	}



}