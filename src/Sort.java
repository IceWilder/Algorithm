import java.util.Arrays;


public class Sort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={1,3,4,5,7,6,2,8,0,9};
		bubbleSort(a);
		int[] b={2,4,6,5,7,0,9,8,3,1};
		searchSort(b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
	public static int[] bubbleSort (int[] a) {
		for (int i = a.length-1; i >0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j]>a[j+1]) {
					swap(a,j,j+1);     
				
				}
			}
		}
		return a;
	}
	public static int[] searchSort(int[] b) {
		
		for (int i = 0; i < b.length; i++) {
			for (int j = i+1; j < b.length; j++) {
				int k=i;
				if (b[k]>b[j]) {
					k=j;	
				}
				swap(b, i, k);
			}
		
		}
		return b;
	}
	public static  void swap(int[] a,int i,int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
