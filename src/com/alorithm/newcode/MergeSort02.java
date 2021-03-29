package com.alorithm.newcode;

public class MergeSort02 {

	/**
	 * 小和问题 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组 的小和。 
	 *  例子： [1,3,4,2,5]
	 * 1左边比1小的数， 没有； 3左边比3小的数， 1； 4左边比4小的数， 1、 3； 2左边比2小的数， 1； 5左边比5小的数， 1、 3、 4、 2；
	 * 所以小和为1+1+3+1+1+3+4+2=16
	 */
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		int smallSum = smallSum(arr);
		System.out.println(smallSum);
	}
	
	public static int smallSum(int[] arr) {
		int smallSum = 0;
		
		if(arr ==null || arr.length < 2){
			return smallSum;
		}
		
		 int n = arr.length -1;
		smallSum = mergeSort(arr,0,n);
		
		return smallSum;
	}

	private static int mergeSort(int[] arr, int i, int n) {
		if(i>= n) {
			return 0;
		}
		int mid = i+((n-i) >> 1);
		
		
		return mergeSort(arr, i, mid) + mergeSort(arr, mid+1, n) + merge(arr,i, mid, n);
	}

	private static int merge(int[] arr, int i, int mid, int n) {
		int [] help = new int[n-i+1];
		int k = 0;
		int p1 = i;
		int p2 = mid+1;
		int res = 0;
		while(p1 <= mid && p2<=n){
			res += arr[p1] <arr[p2] ?(n-p2+1)* arr[p1]:0;
			help[k++] = arr[p1] < arr[p2] ?arr[p1++]:arr[p2++];
		}
		while(p1 <= mid) {
			help[k++] = arr[p1++];
		}
		while(p2<= n) {
			help[k++] = arr[p2++];
		}
		for (k = 0; k < help.length; k++) {
			arr[i+k] = help[k];
		}
		return res;
	}

	
}
