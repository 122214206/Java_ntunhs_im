package h3;
import java.util.Scanner;
public class h3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("請輸入陣列大小：");
		
		int idx=0;
		int num= sc.nextInt();
		int arr[]=new int[100];
		System.out.printf("請輸入元素內容：");
		
		for(int i = 0; i<num; i++) {
			arr[i]=sc.nextInt();
		}
		
		idx= num -1;
		
		while(idx>=0) {
		System.out.printf("arr[%d]:%d ",idx,arr[idx]);
		idx --;
		
		// TODO Auto-generated method stub

}
}
}