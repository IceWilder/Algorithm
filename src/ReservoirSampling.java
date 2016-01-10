/*
 * 蓄水池抽样问题
 * 题目：给定一个数据流，其中包含无穷尽的搜索关键字（比如，人们在谷歌搜索时不断输入的关键字）。 
 * 如何才能从这无尽的流中输出1000个关键字  并且每个关键字留下的概率都一样
 * 假设流的长度为N，已经读到的数据长度为i
 * 思路：假设现在只需要留下一个数据  那么给每个新进来的数据概率为1/i(i<=N) ,第一个数字概率为1,则第二个就为1/2（两个中只能留下了一个),第三个数据
 * 读取到的时候给它1/3的概率留下,那么它留下来的概率为1/3,前一个留下来的概率为为2/3×1/2=1/3;所以第k个元素留下来的概率为1/k*(k/k+1*k+1/k+2*...i-1/i)=1/i;
 * 同理，对于N个数，当要求留下来K个数据时，首先随机抽取K个数，元素a被抽到的概率为K/N,那么给每个新进来的元素的概率为K/i(K<i<=N);
 * 第a个元素被留下的概率为它被选中的概率k/a*(他后面的元素没有被选中的概率a+1-k/a+1+他后面的元素被选中但是他没有被选中的概率k/a+1*k-1/k)=k/N;
*/
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;
public class ReservoirSampling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=10;
		Scanner sc = new Scanner(System.in); 
        
        int j=0;
        int N=0;
        while (j<3) {
        	System.out.println("请输入数据长度N："); 
			N=sc.nextInt();
			j++;
			int[] data=new int[N];
			for (int i = 0; i < N; i++) {
				data[i]=i;
			}
			int[] a=reservoirSampling(k, data);
			System.out.println(a.toString());
		}
		
		

	}
	public static int[] reservoirSampling(int k,int[] data) {
		if (data==null) {
			return data;
		}
		if (data.length<=k) {
			return data;
		}
		int[] sample=new int[k];
		int n=data.length;
			for (int i = 0; i < n; i++) {
				if (i<k) {
					sample[i]=data[i];
				}else {
					int random=new Random().nextInt(i);
					if (random<k) {
						sample[random]=data[i];
					}
				}
			}
			return sample;
		}
	

}
