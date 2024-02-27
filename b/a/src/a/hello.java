package a;
import java.util.Scanner;
import java.lang.Math;
public class hello {
	static int pv;
	static int fv;
	static final double interest=0.05;
	static int interval;
	
	public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	System.out.print("請輸入pv");
	pv =scn.nextInt();
	System.out.print("interval");
	interval=scn.nextInt();
	fv=(int)(pv*Math.pow((1+interest),interval));

	System.out.println("My pv is"+pv+"and after"+interval+"year it would be "+fv);
	
		// TODO Auto-generated method stub

	}

}
