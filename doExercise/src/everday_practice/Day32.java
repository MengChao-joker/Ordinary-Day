import java.util.Scanner;

public class Main {


	

	//用的是单步最优的考虑想法，从最后一步开始考虑。

	//为了方便理解，假设有5个人ABCDE，原来只有4个人ABCD。则多出来的一个人E，

	//多出来的邮件E必定发错给ABCD中一个，共四种方法。假设给E的邮件发给了D，则

	//  人 ：   A  B  C  D  E

	// 邮件：            E

	//则发给D的邮件D有两种情况：一是正好发给了人E，二是发给了E以外的人（ABC）

	//若情况一：变成了3人各自错收了邮件。

	//若情况二：由于D不能发给E，我们可以假象D就是E（和原来等价），则此时变成了ABCE错发给ABCE，就等价于4人错收邮件。

	//这样就很明白了，f（n）=（n-1）*[f（n-2）+f（n-1）]

	

	 public static void main(String[] args) {

	  Scanner in= new Scanner(System.in);

	  

	  long c[]=new long[22];

	  c[2]=1;

	  c[3]=2;

	  for(int i=4;i<22;i++){

	   c[i]=(i-1)*(c[i-1]+c[i-2]);

	  }

	  while(in.hasNext()){

	   int n=in.nextInt();

	   System.out.println(c[n]);

	  }

	  

	 


	
	
	public static int findLongest2(int[] A, int n){
		int[] dp = new int[n];
		dp[0] = 1;
		
		int[] ends = new int[n];
		
		ends[0] = A[0];
		//右哨兵
		int right = 1;
		
		int maxLength = dp[0];
		for(int i = 1;i<n;i++){
			//二分查找第一个比自己大的数，替代之，如果没找到，写在后边
			int start = 0;
			int end = right-1;
			int resultPos = right;
			while(start <= end ){
				int mid = start + (end - start)/2;   //重要
				if(ends[mid]>=A[i]){
					resultPos = mid;
					end = mid - 1;
				}else
					start = mid + 1;
			}
			ends[resultPos] = A[i];
			if(resultPos == right)
				right++;
			dp[i] = resultPos + 1;
			maxLength = Math.max(maxLength, dp[i]);
		}
		return maxLength;
	}
	
	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int[] data = new int[n];
			for(int i = 0;i<n;i++){
				data[i] = sc.nextInt();
			}
			System.out.println(findLongest2(data, n));
		}
	}
}
