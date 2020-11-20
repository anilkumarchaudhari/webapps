package com;

public class SolutionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*String S="abccbd";
		int []C= {0,1,2,3,4,5};
		int sum=0;
		char ft=S.charAt(0);
		for (int i = 1; i < S.length(); i++) {
			System.out.println(ft +" "+S.charAt(i));
			char next=S.charAt(i);
			 if(ft==next) {
				sum +=Integer.valueOf(C[i-1]) ;
			 }
			 ft=next;
		}
		System.out.println("Sum "+sum);*/
		
		int A[]= {3,2,4,3};
		int F=2;
		int M=4;
		int mean=0;
		int sum=0;
		for (int i = 0; i < A.length; i++) {
			sum +=A[i];
		}
		int []A1= {1,2,3,4,5,6};
		sum=M*6-sum;
		//int sumofe1lements=(A.length+F)*M-sum;
		int f=0;
		int l=A1.length;
		int FI[]=new int[F];
		/*
		 * int j=0; System.out.println(" 1 "+sum); while(f<l) {
		 * System.out.println("2 "+f+" "+l); if(A1[f]+A1[l] == sum) {
		 * System.out.println(A1[f]+" "+A1[l]); } else if(A1[f]+A1[l] < sum) { f++; }
		 * else l--; }
		 */
		System.out.println("sum is "+sum);
		int res = 0;
		int sum1 = 0;
        // calculate all subarrays
        for (int i = 0; i < l; i++) {
             
            sum1 = A1[i];
            int count=0;
            for (int j = i+1; j <=l; j++) {
                 
            	if (sum1 == sum && count==F) { 
                    int p = j - 1; 
                    System.out.println( 
                        "Sum found between indexes " + i 
                        + " and " + p); 
                    System.out.println("count is "+count);
                   // return 1; 
                } 
                if (sum1 > sum || j == l) 
                    break; 
                sum1 = sum1 + A1[j]; 
                count++;  
            }
        }
        
        System.out.println(res );
		
	}

}
