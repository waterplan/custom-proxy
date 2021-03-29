package com.alorithm.sorts02;

import com.alorithm.sorts01.LogartihmicUtil;

public class MergeSort {
	
	
	public static void main(String[] args) {
//		int[] array = LogartihmicUtil.generateRandomArray(20, 20);
		int[] array = {1,3};

		LogartihmicUtil.printArray(array);

		mergeSort(array, array.length);
		
		LogartihmicUtil.printArray(array);
	}
	public static void mergeSort(int[] a, int n) {
		mergeSortInternally(a, 0,n-1);
	}
	//归并排序算法
	public static void mergeSortInternally(int[] a, int p, int r) {
		//递归终止条件
		if(p >= r) return;
		
		int q = p + (r - p)/2;
		//分治递归
		mergeSortInternally(a, p, q);
		mergeSortInternally(a, q+1, r);
		//将A[p..q]和A[q+1..r] 合并为A[p..r]
		merge(a,p,q,r);
	}

	private static void merge(int[] a, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int k = 0;//初始化变量 i,jk
		int[] tmp = new int[r-p+1];//申请一个大小跟a[p...r]一样的的临时数组
		while(i<=q && j <=r) {
			if(a[i] <= a[j]) {
				tmp[k++] = a[i++];
			} else {
				tmp[k++] = a[j++];
			}
		}
		
		int start = i;
		int end = q;
		if(j <= r) {
			start = j;
			end = r;
		}
		//将剩余的数据拷贝到临时数组tmp
		while(start <= end) {
			tmp[k++] = a[start++];
		}
		
		for (int l = 0; l <= r-p; ++l) {
			a[p+l] = tmp[l];
		}
	}
	
	/**
	 * 合并(哨兵)
	 * @param arr
	 * @param p
	 * @param q
	 * @param r
	 */
	public static void mergeBySentry(int[] arr, int p, int q, int r) {
		int [] leftArr = new int[q - p + 2];
		int [] rightArr = new int[r - q + 1];
		
		for (int i = 0; i <= q - p; i++) {
			leftArr[i] = arr [p + i];
		}
		leftArr[ q -p +1] = Integer.MAX_VALUE;
		
		for (int i = 0; i < r - q; i++) {
			rightArr[i] = arr[q+1+i];
		}
		leftArr[r - q] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		int k = p;
		
		while(k <= r) {
			if(leftArr[i] <= rightArr[j]) {
				arr[k++] = leftArr[i++];
			}else {
				arr[k++] = rightArr[j++];
			}
		}
	}

}
