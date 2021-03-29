package com.alorithm.newcode;

/**
 * 归并排序
 * @author zplan
 *
 */
public class MergeSort01 {

	/**
	 * 小和问题 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和。 求一个数组 的小和。 
	 *  例子： [1,3,4,2,5]
	 * 1左边比1小的数， 没有； 3左边比3小的数， 1； 4左边比4小的数， 1、 3； 2左边比2小的数， 1； 5左边比5小的数， 1、 3、 4、 2；
	 * 所以小和为1+1+3+1+1+3+4+2=16
	 */
	
	public static void main(String[] args) {
		int[] arr = {1,3,4,2,5};
		mergeSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	

	/**
	 * 递归函数
	 * @param arr 1,3
	 * @param p 0， 1
	 * @param r
	 * @return
	 */
	public static void mergeSort(int[] arr, int p, int r) {
		//退出条件
		if( p >= r) {
			return ;
		}
		int q = p + ((r - p) >>1) ;
		
		 mergeSort(arr, p, q);
		 
		 mergeSort(arr, q+1, r);
		 
		 merge(arr,p,q,r);
	}
	/*
	 * @param arr 1，3, 6
	 * @param p 0
	 * @param q  1
	 * @param r 2
	 * @return
	 */
	private static void merge(int[] arr, int p, int q, int r) {
		int[] help = new int[r-p +1];
		int k = 0;
		int i = p;
		int j = q + 1;
		
		while (i<=q && j<=r) {
			help[k++] = arr[i]<= arr[j]? arr[i++]:arr[j++];
		}
		while(i <= q) {
			help[k++] = arr[i++];
		}
		
		while(j <= r) {
			help[k++] = arr[j++];
		}
		for (k = 0; k < help.length; k++) {
			arr[p +k] = help[k];
		}
		
	}
	
	
}
