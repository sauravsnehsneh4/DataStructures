package array;

import java.util.ArrayList;
import java.util.List;

public class prac {
	 long arrayManipulation(int n, int[][] queries) {
        int m=queries.length;
        int[][] out=new int[m+1][n];
        int x=0;
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int k=queries[i][2];
            for(int t=1;t<m+1;t++) {
	            for(int j=a-1;j<b;j++){
	                out[t][j]+=k;
	                if(out[t][j]>x)
	                    x=out[t][j];
            }

            }
        }
        return x;


    }
	public static void main(String[] args) {
		int[][] arr=new int[3][3];
		arr[0][0]=1;
		arr[0][1]=2;
		arr[0][2]=100;
		arr[1][0]=2;
		arr[1][1]=5;
		arr[1][2]=100;
		arr[2][0]=3;
		arr[2][1]=4;
		arr[2][2]=100;
		
		prac p=new prac();
		System.out.println(p.arrayManipulation(5, arr));
	}
}
